<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup.jsp</title>
</head>
<body>
	<h3>POPUP WINDOW</h3>
	<br>
	<br>
	<br>
	<br>
	<hr>
	<input type="checkbox" onclick="setCookie1()">
	1분 동안 팝업 띄우지 않기
	<input type="button" onclick="window.close()" value="X">
	
	<script>
		console.log(document.cookie);
		
		  cookiedata = document.cookie;
		  if ( cookiedata.indexOf("code") < 0 ){ //쿠키 변경 여부 불러오기
			  window.open();
			   }
		
		function setCookie1() {
			window.close();
			}
		
	</script>
</body>
</html>