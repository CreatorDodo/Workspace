<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="market.vo.ProductVO"%>
<%@page import="market.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<%@page import="com.oreilly.servlet.MultipartRequest,
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

<%	//productAddProc.jsp

	//0.한글 인코딩 처리
	request.setCharacterEncoding("UTF-8");						
	response.setContentType("text/html; charset=UTF-8");

// 	ProductDAO pdao = new ProductDAO();
	
	
// 	String userFileName = multiReq.getFilesystemName("pimage");
	
// 	System.out.println(userFileName);
	
	//1.요청 객체를 이용하여 전달 받은 상품 등록 파라미터 데이터들을 ProductVO 객체 p에 저장
	ProductVO p = new ProductVO();
// 	p.setPid( request.getParameter("pid") );
// 	p.setPname( request.getParameter("pname") );
// 	p.setPrice( Integer.parseInt( request.getParameter("price") ) );
// 	p.setDescription( request.getParameter("description") );
// 	p.setMaker( request.getParameter("maker") );
// 	p.setCategory( request.getParameter("category") );
// 	p.setStock( Integer.parseInt( request.getParameter("stock") ) );
// 	p.setCondition( request.getParameter("condition") );
// 	p.setPimage( request.getParameter("pimage") );
	
	p.setPid( multiReq.getParameter("pid") );
	p.setPname( multiReq.getParameter("pname") );
	p.setPrice( Integer.parseInt( multiReq.getParameter("price") ) );
	p.setDescription( multiReq.getParameter("description") );
	p.setMaker( multiReq.getParameter("maker") );
	p.setCategory( multiReq.getParameter("category") );
	p.setStock( Integer.parseInt( multiReq.getParameter("stock") ) );
	p.setCondition( multiReq.getParameter("condition") );
	p.setPimage( multiReq.getFilesystemName("pimage") );
	
	
%>
	
<!-- 	2.액션 태그를 이용하여 전달 받은 상품 등록 파라미터 데이터들을 ProductVO 객체 pvo에 저장 -->
	<jsp:useBean id="pdao" class="market.dao.ProductDAO"/>
<%-- 	<jsp:useBean id="pvo" class="market.vo.ProductVO"/> --%>
<%-- 	<jsp:setProperty property="*" name="pvo"/> --%>

<%
	//상품 등록 성공 시
	if( pdao.insertProduct(p) == true ) {
		//응답 객체를 이용하여 상품 목록 페이지로 리다이렉트
		response.sendRedirect("productList.jsp");
	}else { //그렇지 않으면
	
%>		<script>
			alert('이미 존재하는 상품코드입니다.');	//Unique constraint 위반인 경우
			history.back();	//이전 페이지로 돌아가기
		</script>
		
<% } %>	

 %>





    