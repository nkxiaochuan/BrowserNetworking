<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>hello world!</p>
<script type="text/javascript">
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/js/jquery-2.2.3.min.js');
	xhr.onload = function(){
	//	var responseText = xhr.responseText;
	//	alert(responseText);
		alert('same-origin ok');
	};
	xhr.send();
	
	var cors_xhr = new XMLHttpRequest();
	cors_xhr.withCredentials = true;
	cors_xhr.open('GET','http://stackoverflow.com/questions/19661157/how-to-add-header-data-in-xmlhttprequest-when-using-formdata');
	cors_xhr.setRequestHeader("Access-Control-Allow-Origin","*");
	cors_xhr.onload=function(){
		var responseText = xhr.responseText;
		alert(responseText);
		alert('cross-origin ok');
	};
	cors_xhr.onerror = function() {
		  alert('There was an error!');
		};
	cors_xhr.send();
</script>
</body>
</html>