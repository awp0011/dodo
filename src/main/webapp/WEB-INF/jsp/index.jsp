<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" language="javascript">
	function ajaxInvoke(ver){

		var parms = $("#saywords").val();
		
		$.ajax({
			url : "/dodo/springMVC/ajaxsimple.action?sayWords="+parms,
			dataType : "json",
			type : "get",
			success : function(returnData) {
				//$("#saywords").innerHTML=html;
				var html ="My dad:"+returnData.father+"<br>";
				html +="My mom:"+returnData.mother+"<br>";
				html +="I'm :"+returnData.me+"<br>";
				html +="I just say :"+returnData.say+"<br>";
				//alert(html);
				//document.getElementById("showWords").innerHTML = html;
				$("#showWords").html(html);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
			}
		});
	}
</script>
<script type="text/javascript" src="/dodo/js/jquery-1.6.2.min.js"></script>
</head>
<body>
<h2>Greeting,This is Spring MVC!</h2>
<h2>I am dodo,welcome!</h2>
<br></br>
<h4>this is a simple for ajax invoke controller</h4>
my son say : <input id="saywords" name="saywords"type="text" size="20"/><input type="button" onclick="ajaxInvoke(1);" value="ajax"/>
<div id='showWords'>1234</div>
</body>
</html>
