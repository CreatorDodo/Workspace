<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>messages.jsp</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<!-- 화면 상단 header -------------------------------------------- -->
	<%@ include file="/includes/header.jsp"%>

	<!-- 메인 타이틀 ----------------------------------------- -->
	<div class="jumbotron">
		<div class="container">
			<!-- 			<h1 class="display-4">Messages</h1> -->
			<c:if test="${param.msg == 'login'}">

				<h1 class="display-4">LOGIN</h1>
			</c:if>
			<c:if test="${param.msg == 'logout'}">
				<h1 class="display-4">LOGOUT</h1>
			</c:if>
			<c:if test="${param.msg == 'joinOK'}">
				<h1 class="display-4">회원가입</h1>
			</c:if>
			<c:if test="${param.msg == 'joinFail'}">
				<h1 class="display-4">회원가입</h1>
			</c:if>
		</div>
	</div>

	<!-- 메인 ------------------------------------------------- -->
	<div class="container">
		<div class="container">
			<p class="alert alert-danger text-center p-3">
				<c:if test="${param.msg == 'modOk'}">
			회원 정보가 수정되었습니다.

		</c:if>
				<c:if test="${param.msg == 'modFail'}">
				회원 정보 수정에 실패했습니다.

		</c:if>
				<c:if test="${param.msg == 'login'}">
			${sid }님어서오세요~

		</c:if>
				<c:if test="${param.msg == 'logout'}">
				로그아웃이 완료되었습니다.

		</c:if>
				<c:if test="${param.msg == 'joinOK'}">
			회원가입이 완료되었습니다.

		</c:if>
				<c:if test="${param.msg == 'joinFail'}">
			회원가입이 처리되지 않았습니다.

		</c:if>

			</p>
		</div>
	</div>


	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
