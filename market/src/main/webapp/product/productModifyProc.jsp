<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="market.vo.ProductVO"%>
<%@page import="market.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@page
	import="com.oreilly.servlet.MultipartRequest,
    		com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
String uploadPath = application.getInitParameter("uploadPath"); //파일 업로드 폴더명
String savePath = application.getRealPath(uploadPath); //실제 업로드 폴더 경로
int maxSize = 1024 * 1024 * 5; //최대 업로드 크기 5MB
String encType = "UTF-8";

// 	System.out.println(uploadPath);
System.out.println(savePath);

MultipartRequest multiReq = new MultipartRequest(request, savePath, maxSize, encType, new DefaultFileRenamePolicy());
%>

<%
//productModifyProc.jsp

//0.한글 인코딩 처리
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
%>
<jsp:useBean id="pdao" class="market.dao.ProductDAO" />

<sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:xe" user="madang" password="1111" />

<sql:update var="result" dataSource="${dataSource }">
	UPDATE product SET pid=?, pname=?, price=?, description=?, maker=?, category=?, stock=?, condition=?, pimage=NVL(?, 'default.png') where pid=?
		<sql:param value='<%=multiReq.getParameter("pid")%>' />
	<sql:param value='<%=multiReq.getParameter("pname")%>' />
	<sql:param value='<%=multiReq.getParameter("price")%>' />
	<sql:param value='<%=multiReq.getParameter("description")%>' />
	<sql:param value='<%=multiReq.getParameter("maker")%>' />
	<sql:param value='<%=multiReq.getParameter("category")%>' />
	<sql:param value='<%=multiReq.getParameter("stock")%>' />
	<sql:param value='<%=multiReq.getParameter("condition")%>' />
	<sql:param value='<%=multiReq.getFilesystemName("pimage")%>' />
	<sql:param value='<%=multiReq.getParameter("pidBefore")%>' />
</sql:update>
result : ${result }

<%
session.setAttribute("msg", "상품 수정 성공");
response.sendRedirect("productEdit.jsp?edit=modify");
%>

<%-- <% --%>
// //상품 등록 성공 시 // if( pdao.insertProduct(p) == true ) { // //응답 객체를
이용하여 상품 목록 페이지로 리다이렉트 //
response.sendRedirect("productEdit.jsp?edit=modify"); // }else { //그렇지
않으면

<%-- %>		<script> --%>
// alert('이미 존재하는 상품코드입니다.'); //Unique constraint 위반인 경우 //
history.back(); //이전 페이지로 돌아가기
<!-- 		</script> -->

<%-- <% } %>	 --%>

%>



