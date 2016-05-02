<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>download</title>
</head>
<body>

<script type="text/javascript">
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/../images/download.jpg');
	xhr.responseType='blob';
	xhr.onload=function(){
		
		if (this.status == 200){
			var img = document.createElement('img');
			img.src = window.URL.createObjectURL(this.response);
			
			img.onload = function(){
				window.URL.revokeObjectURL(this.src);
			}
			document.body.appendChild(img);
		}
	};
	xhr.send();
</script>
</body>
</html>