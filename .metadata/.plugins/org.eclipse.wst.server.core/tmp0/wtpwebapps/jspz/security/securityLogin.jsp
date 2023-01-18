<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>


</head>
<body>
	<!-- 화면 상단 header -------------------------------------------- -->
<%-- 	<%@ include file="/includes/header.jsp"%> --%>

	<!-- 메인 타이틀 ----------------------------------------- -->
<!-- 	<div class="jumbotron"> -->
<!-- 		<div class="container"> -->
<!-- 			<h1 class="display-4">로그인</h1> -->
<!-- 		</div> -->
<!-- 	</div> -->

	<!-- 메인 ------------------------------------------------- -->
	<div class="container">
		<div class="text-center">



			<script>
				//이메일 선택 처리 함수
				function setEmail(email3) {
					//직접입력을 선택한 경우 email2의 값을 입력받도록 처리
					//그외의 값을 선택한 경우, 선택한 도메인으로 email2의 값을 지정
					//email1과 email2의 값을 더해서 email의 값으로 지정
					var email2 = document.joinFrm.email2;
					if (email3.value == '직접입력') {
						//email2 읽기전용 해제
						//email2 포커스 맞추기
						//email2 입력되어 있는 값 지우기
						email2.readOnly = false;
						email2.focus();
						email2.value = '';
					} else {
						email2.value = email3.value;
						email2.readOnly = true;
					}
				}
			</script>
			<form action="j_security_check" method="post">
				<h3>LOGIN</h3>
				<br>
				<div style="padding-left: 250px;" >
					<label >아이디</label>

					<div >
						<input type="text" name="j_username" id="ide"
							placeholder="ID" required>
					</div>
				</div>
				<div style="padding-left: 250px;" >
					<label class="col-sm-2">비밀번호</label>
					<div >
						<input type="password" name="j_password" id="pwe" 
							placeholder="Password" required>
					</div>
				</div>


				<div class="text-center">
					<input type="submit" value="로그인" class="btn btn-info joinBtn">
				</div>
				<br>
				<div>
					<input type="button" value="이전으로" onclick="history.back()"
						class="btn btn-secondary">
				</div>

			</form>
			<br> <br>

		</div>
	</div>

	<!-- 화면 하단 footer --------------------------------------- -->
<%-- 	<%@ include file="../includes/footer.jsp"%> --%>
</body>
</html>