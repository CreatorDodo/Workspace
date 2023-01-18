<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.oreilly.servlet.MultipartRequest,
    		com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%
String uploadPath = application.getInitParameter("uploadPath"); //파일 업로드 폴더명
String savePath = application.getRealPath(uploadPath); //실제 업로드 폴더 경로
int maxSize = 1024 * 1024 * 5; //최대 업로드 크기 5MB
String encType = "UTF-8";

// 	System.out.println(uploadPath);
System.out.println(savePath);

MultipartRequest multiReq = new MultipartRequest(request, savePath, maxSize, encType, new DefaultFileRenamePolicy());
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadResult.jsp</title>
</head>
<body>
	<h3>FILE UPLOAD result</h3>


	<%
	String userFileName = multiReq.getFilesystemName("userfile");
	
	if (userFileName != null) {
	%>
	<br>파일 업로드 성공<br>
	
	이름 :<%=multiReq.getParameter("usernm")%><br>
	첨부 파일 :<%=userFileName%><br>
	원본 파일 :<%=multiReq.getOriginalFileName("userfile")%><br>
	파일 크기 :<%=multiReq.getFile("userfile").length()/1024 %>KB<br>
	<img src="..<%=uploadPath%><%=userFileName%>">

	
	
<%	} else { %>
		파일 업로드 실패
<%	}	%>

</body>
</html>