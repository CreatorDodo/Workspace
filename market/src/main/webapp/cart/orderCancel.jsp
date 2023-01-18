<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderCancel.jsp</title>
</head>

<body>
	<!-- 화면 상단 header -------------------------------------------- -->
	<%@ include file="/includes/header.jsp"%>

	<!-- 메인 타이틀 ----------------------------------------- -->
	<div class="jumbotron">
		<div class="container">
			<h3 class="display-4">주문 취소</h3>
		</div>
	</div>
	<!-- 메인 ------------------------------------------------- -->

	<div class="container">
	<div class="row">
		<div class="col text-center">
		<p class="alert alert-danger p-3">주문이 취소되었습니다.</p></div></div>
		<div class="row">
		<div class="col">
			<a href="/market/product/productList.jsp" class="btn btn-info">상품목록
				&raquo;</a>
		</div>



	</div>

	</div>
	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>
</body>
</html>