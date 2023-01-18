<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noPidException.jsp</title>
</head>
<body>
	<!-- 화면 상단 header -------------------------------------------- -->
	<%@ include file="/includes/header.jsp"%>
	<!-- 메인 타이틀 ----------------------------------------- -->
	<div class="jumbotron">
		<div class="container">
			<h2 class="alert alert-danger">해당 상품이 존재하지 않습니다.</h2>
		</div>
	</div>
	<!-- 메인 ------------------------------------------------- -->

	<div class="container">
		<!-- 요청 URL과 쿼리스트링 및 상품목록 페이지 링크 버튼 표시 -->

			<p><%=request.getRequestURL()%>?<%=request.getQueryString()%></p>


		<p>
			<a href="productList.jsp" class="btn btn-info">상품목록
				&raquo;</a>
		</p>


	</div>

	</div>
	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>
</body>
</html>