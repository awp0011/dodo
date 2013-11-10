$(document).ready(function() {
	$('#tab_div').tabs({ 
		onSelect:function(title){ 
		if(title=='Employee'){
			initDataGrid();
		}
		if(title=='Contacts'){
			// configuration combobox event: onSelect
			$("#dataType").combobox({
				onSelect : function(selected) {
					changeDatePicker(selected.value);
				}
			});

			setMonthlyDatePicker();
			$("#w_input").hide();
			
			$('#datagrid').datagrid({
				url : '/dodo/springMVC/whoDoesbirthByMonth.action',
				fit : true,
				fitColumns : true,
				nowrap : true,
				striped : true,
				
				collapsible : true,
				remoteSort : false,
				pagination : true,
				rownumbers : true,
				singleSelect : false,
				checkbox : true,
				queryParams:{},
				onLoadError : function(error) {
					// alert(JSON.stringify(error));
					// alert(error.responseText);
					$.messager.alert('提示', '加载数据失败');
				},
				
				 frozenColumns : [ [ { 
					 field : 'ck', 
					 checkbox : true
					 }, {
						 field : 'id',title : '编号',width : 10,align : 'center',hidden:true} ] ],
				 
				columns : [ [ {
					field : 'name',
					title : '姓名',
					width : 150,
					align : 'left'
				}, {
					field : 'age',
					title : '年龄',
					width : 100,
					align : 'left'
				}, {
					field : 'birthday',
					title : '生日',
					width : 200,
					align : 'center'
				}, {
					field : 'position_name',
					title : '职务',
					width : 200,
					align : 'left'
				}, {
					field : 'deprName',
					title : '部门',
					width : 150,
					align : 'left'
				} ] ]
			});
		}
		}});
	
	
	
});

//
function changeDatePicker(dataType) {
	if (dataType == '0') {
		setMonthlyDatePicker();
		$("#w_input").hide();
		$("#m_input").show();
	} else {
		setWeeklyDatePicker();
		$("#w_input").show();
		$("#m_input").hide();		
		
	}
}

function setMonthlyDatePicker() {
	$("#datepicker")
			.combobox(
					{
						valueField : 'id',
						textField : 'text',
						url : '/dodo/springMVC/getMonthData.action',
						onSelect : function(selected) {
							$('#datagrid')
									.datagrid(
											{
												url : '/dodo/springMVC/whoDoesbirthByMonth.action?month='
														+ selected.id,
											});
						}
					});
}

function setWeeklyDatePicker() {
	 showWeekPicker();
}
function showWeekPicker() {

	$("#week").datebox({
		 required:true,
		 onSelect : function(selected) {
			// alert(selected.WeekNumOfYear());
			 var weekNumber = getISOYearWeek(selected);
			 $('#datagrid')
				.datagrid(
						{
							url : '/dodo/springMVC/whoDoesbirthByWeek.action?week='+weekNumber
								
						});
			
			 var startDate = new Date(selected.getFullYear(), selected
						.getMonth(), selected.getDate() - selected.getDay());
			var	endDate = new Date(selected.getFullYear(), selected.getMonth(),
					selected.getDate() - selected.getDay() + 6);
			weekNumber +='W:';
			weekNumber +=dateFormat(startDate,"MMdd");
			weekNumber +=' ~ ';
			weekNumber +=dateFormat(endDate,"MMdd");
			$('#week').datebox('setValue', weekNumber);
			
			}
	});

}


function getISOYearWeek(date){  
    var commericalyear=getCommerialYear(date);  
    var date2=getYearFirstWeekDate(commericalyear);     
    var day1=date.getDay();     
    if(day1==0) day1=7;     
    var day2=date2.getDay();     
    if(day2==0) day2=7;     
    var d = Math.round((date.getTime() - date2.getTime()+(day2-day1)*(24*60*60*1000)) / 86400000);       
    return Math.ceil(d / 7)+1;   
}  
  
function getYearFirstWeekDate(commericalyear){  
    var yearfirstdaydate=new Date(commericalyear, 9, 2);     
    return new Date(yearfirstdaydate.getFullYear(),0,1) ; 
}  
  
function getCommerialYear(date){  
    var daynum=date.getDay();   
    var monthday=date.getDate();  
    if(daynum==0) daynum=7;  
    var thisthurdaydate=new Date(date.getFullYear(),date.getMonth(),monthday+4-daynum);  
    return thisthurdaydate.getFullYear();  
}  

function dateFormat(date,fmt){
	var o = {   
		    "M+" : date.getMonth()+1,                 //月份   
		    "d+" : date.getDate(),                    //日   
		    "h+" : date.getHours(),                   //小时   
		    "m+" : date.getMinutes(),                 //分   
		    "s+" : date.getSeconds(),                 //秒   
		    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
		    "S"  : date.getMilliseconds()             //毫秒   
		  };   
		  if(/(y+)/.test(fmt))   
		    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
		  for(var k in o)   
		    if(new RegExp("("+ k +")").test(fmt))   
		  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		  return fmt;   
		  
}