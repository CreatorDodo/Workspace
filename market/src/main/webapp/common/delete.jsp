<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>delete.jsp</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="../survey/jquery-3.6.1.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>


</head>
<body>
	<!-- 화면 상단 header -------------------------------------------- -->
<%@ include file="/includes/header.jsp"%>
	<!-- 메인 타이틀 ----------------------------------------- -->
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-4">회원탈퇴</h1>
		</div>
	</div>

	<!-- 메인 ------------------------------------------------- -->
	<div class="container">
		<form action="surveyList.html" method="post">
			<h3>탈퇴 안내</h3>
			<br>
			<h5 class="text-danger">※회원을 탈퇴하실 경우 사용하고 계신 아이디는 재사용 및 복구가
				불가능합니다!</h5>
			<br> <br>

			<h5>※탈퇴 후 회원정보 및 서비스 이용기록은 모두 삭제됩니다.</h5>
			<br>
			<table class="table">
				<tbody>
					<tr>
						<th scope="row">SNS</th>
						<td>SNS 팔로우, 팔로워 기록 및 게시물 삭제</td>
					</tr>
					<tr>
						<th scope="row">설문조사</th>
						<td>설문조사 기록 및 게시물 삭제</td>
					</tr>
					<tr>
						<th scope="row">포스트</th>
						<td>포스트 기록 및 게시물 삭제</td>
					</tr>
				</tbody>

			</table>
			<br> <br>
			<h6>탈퇴아이디 확인</h6>
			<table class="table" style="width: 300px;">
				<thead>
					<tr>
						<th scope="col">아이디</th>
						<td scope="col">${param.userid }</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">이름</th>
						<td>${param.usernm }</td>
					</tr>
				</tbody>
			</table>
			<br> <br>



			<!-- 등록 취소 버튼 -->
			<div class="text-right">
				<a href="deleteProc.jsp"><input type="button" value="탈퇴하기"
					class="btn btn-danger removeBtn"></a>
					<input type="button" value="이전으로"
					onclick="history.back()" class="btn btn-secondary">


			</div>


		</form>
	</div>


	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>

	<script>
	$('.removeBtn').click(function() {
		if(!confirm("정말 탈퇴하시겠습니까?")){
			return false;
		}
	});
	</script>


</body>
</html>