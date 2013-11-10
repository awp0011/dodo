//datagrid初始化  
function initDataGrid() {
	
	    
    $('#datagridTable').datagrid({  
        title:'人员列表',  
        iconCls:'icon-edit',//图标  
        width: 700,  
        pageSize:23,
        pageList: [23,50,100],
        height: 'auto',  
        nowrap: false,  
        striped: true,  
        border: true,  
        collapsible:false,//是否可折叠的  
        fit: true,//自动大小  
        url:'/dodo/springMVC/getdatagrid.action',  
        sortName: 'name',  
        sortOrder: 'desc',  
        remoteSort:false,   
        idField:'id',  
        singleSelect:false,//是否单选  
        pagination:true,//分页控件  
        rownumbers:true,//行号  
        frozenColumns:[[  
                        {   field : 'ck', 
   					 checkbox : true
   					 }, {
   						 field : 'id',title : '编号',width : 10,align : 'center',hidden:true} ] ],
        columns:[[    
                  {field:'loginname'  ,title: '登录名' , width:160 ,align:'left' , halign: 'center'},
                  {field:'name',title:'姓名',width:60,align:'left' , halign: 'center'},    
                  {field:'age',title:'年龄', width:40 ,align:'center' , halign: 'center'},    
                  {field:'gender',title:'性别',width:40,align:'center' , halign: 'center',formatter: function(value,row,index){
                      if (value==1){
                          return '男';
                         } else {
                          return '女';
                         }}},   
                  {field:'educational',title:'学历',width:60,align:'center' , halign: 'center',formatter: function(value,row,index){
                	  if (value.name){
                          return value.name;
                         } else {
                          return value;
                         }}}, 
                  {field:'position',title:'职位',width:100,align:'left' , halign: 'center',formatter: function(value,row,index){
                      if (value.name){
                          return value.name;
                         } else {
                          return value;
                         }}}, 
                  {field:'department',title:'部门',width:100,align:'left' , halign: 'center',formatter: function(value,row,index){
                      if (value.name){
                          return value.name;
                         } else {
                          return value;
                         }}}, 
                  {field:'salary',title:'月薪',width:60,align:'right' , halign: 'center',formatter: function(value,row,index){
                	  return convertToMoney(addCommas(value));
                  }}, 
                  {field:'married',title:'婚姻',width:40,align:'center' , halign: 'center',formatter: function(value,row,index){
                      if (value==1){
                          return '已婚';
                         } else {
                          return '未婚';
                         }}},    
                  {field:'email',title:'邮件',width:180,align:'left' , halign: 'center'},    
                  {field:'school',title:'毕业院校',width:120,align:'left' , halign: 'center'} ,
                  {field:'remarks',title:'爱好',width:100,align:'left' , halign: 'center'}
              ]],    
        toolbar: [{  
            text: '添加',  
            iconCls: 'icon-add',  
            handler: function() {  
                openDialog("add_dialog","add");  
            }  
        }, '-', {  
            text: '修改',  
            iconCls: 'icon-edit',  
            handler: function() {  
                openDialog("add_dialog","edit");  
            }  
        }, '-',{  
            text: '删除',  
            iconCls: 'icon-remove',  
            handler: function(){  
                delAppInfo();  
            }  
        }],  
        onBeforeRefresh:function(param){
        	
        }
    });  
    //设置分页控件  
    var p = $('#datagridTable').datagrid('getPager');  
    $(p).pagination({  
        //pageSize: 30,//每页显示的记录条数，默认为20  
        //pageList: [23,50,100],//可以设置每页记录条数的列表  
        beforePageText: '第',//页数文本框前显示的汉字  
        afterPageText: '页    共 {pages} 页',  
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',  
        /*onBeforeRefresh:function(){ 
            $(this).pagination('loading'); 
            alert('before refresh'); 
            $(this).pagination('loaded'); 
        }*/ 
    });  
}