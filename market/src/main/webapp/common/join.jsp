<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>join.jsp</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<!-- <script src="../survey/jquery-3.6.1.js"></script> -->
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<!-- <script src="../resources/js/script.js"></script> -->




</head>
<body>
	<!-- 화면 상단 header -------------------------------------------- -->
	<%@ include file="/includes/header.jsp"%>

	<!-- 메인 타이틀 ----------------------------------------- -->
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-4">회원가입</h1>
		</div>
	</div>

	<!-- 메인 ------------------------------------------------- -->
	<div class="container">





		<form action="joinProc.jsp" method="post" id="frm" name="joinFrm">
			<div class="form-group row">
				<label class="col-sm-2">아이디</label>
				<div class="col-sm-3">
					<input type="text" onkeyup="idChkr(this)" name="userid" id="ide"
						class="form-control" required>
				</div>
				<span style="color: red;" id="idChk"></span>

			</div>
			<div class="form-group row">
				<label class="col-sm-2">비밀번호</label>
				<div class="col-sm-3">
					<input type="password" onkeyup="pwChkr(this)" name="userpw" id="pwe"
						class="form-control" required>
				</div>
				<span style="color: red;" id="pwChk"></span>

			</div>
			<div class="form-group row">
				<label class="col-sm-2">비밀번호 확인</label>
				<div class="col-sm-3">
					<input type="password" onkeyup="pwcChkr(this)"
						id="pwChke" class="form-control" required>
				</div>
				<span style="color: red;" id="pwcChk"></span>

			</div>
			<div class="form-group row">
				<label class="col-sm-2">이름</label>
				<div class="col-sm-3">
					<input type="text" name="usernm" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">이메일</label>
				<div class="col-sm-8">
					<input type="hidden" name="email" id="email"> <input
						type="text" name="email1" id="email1" size="10" required>@<input
						type="text" name="email2" id="email2" size="10" required> <select
						 onchange="setEmail(this)" required>
						<option value="direct" selected>직접입력</option>
						<option value="gmail.com">gmail.com</option>
						<option value="naver.com">naver.com</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">사진</label>
				<div class="col-sm-4">
					<input type="file" name="photo" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">성별</label>
				<div class="col-sm-3">
					<label><input type="radio" name="gender" value="m">남성</label>
				<label><input  type="radio" name="gender" value="w">여성</label>
				</div>
			</div>

			<!-- 등록 취소 버튼 -->
			<div class="text-right">
				<input type="button" value="이전으로" onclick="history.back()"
					class="btn btn-secondary backBtn"> <input type="submit"
					value="가입" class="btn btn-info joinBtn regBtn">

			</div>
		</form>
	</div>





	<!-- 화면 하단 footer --------------------------------------- -->
<%@ include file="../includes/footer.jsp"%>

	<script>
	
	//아이디와 비밀번호 확인 여부
	idChk = pwChk = false;
	
	//아이디 중복 확인 -------------------------------------
// 	$('#ide').keyup(function() {
// 		var id = $(this).val();
// 		var idChkMsg = $('#idChk');
		
// 		if(id.length < 5 || id.length > 10) {	//아이디 입력 길이 확인
// 			idChkMsg.text('아이디는 5 ~ 10자로 입력해주세요.');
// 		} else {	//아이디 중복 확인 처리
// 			idChkMsg.text('');

// $.post('idChkProc.jsp', //요청 url
// 			{"id" : id }, //전송 데이터
// 			function(result) { //callback 함수
// 				if(result.trim() == 'O'){
// 				idChkMsg.text('사용 가능한 아이디입니다.');
// 				idChk = true;
// 				} else {
// 					idChkMsg.text('이미 사용 중인 아이디입니다.');
// 					idChk = false;
// 				}
			
				
		
// 	});
	//END 아이디 중복 확인 -----------------------------------------------
	
// 	//회원가입 버튼 클릭 이벤트 처리-------------------------
// 	$('.regBtn').click(function(event) {
// 		event.preventDefault();
		
// 		if(idChk == false){ //아이디 중복 확인 X
// 			alert('아이디를 확인해주세요.');
// 		} else if( pwChk == false){	//비밀번호 일치 X
// 			alert('비밀번호를 확인해주세요.');
// 		} else if( $('name').val().trim() == '') {	//이름 입력 확인
// 			alert('이름을 입력해주세요.');
// 		}  else if( emailCheck() == false ) {	//이름 입력 확인 및 합치기
// 			alert('이메일을 입력해주세요.');
// 		} else{	//그렇지 않으면 폼 전송
// 			$('#joinFrm').submit();
// 		}
// 	});
// 	//END 회원가입 버튼 클릭 이벤트 처리-------------------------
	
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

		// 아이디, 비밀번호 체크
		var txtPtn = /[\w|가-힣|`~@!#%<>\*\$]{5,10}/;
		//영문자, 숫자, _, 한글, 특수문자 5~10
		var numPtn = /[0-9]/; //숫자
		var engPtn = /[a-zA-Z]/; //영문자		
		var korPtn = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; //한글	
		var spPtn = /[`~@!#%<>\*\$]/; //특수 문자
		
		
		$('.regBtn').click(function() {
			var email1 = $('#email1').val().trim();
			var email2 = $('#email2').val().trim();
			$('#email').val(email1 + '@' + email2);
			console.log($('#email').val());
		});

		


		
		function idChkr(obj) {
			if (obj.value.length >= 5 && 10 >= obj.value.length) {
				$.ajax({
					url : 'idChkProc.jsp',
					type : 'post',
					data : 'id=' + $('#ide').val(),
					dataType : 'text',
					success : function(result) {
						$('#idChk').text(result);
						if (obj.value == 'admin') {
							$('#frm').attr('onSubmit', 'return false');
						} else {
							
							$('#frm').attr('onSubmit', 'return true');
						}

					},
					error : function(error) {
						console.log(error); //요청 실패 시 처리
					}

				});
			} else {
				$('#idChk').text('5 ~ 10자 이내로 입력해 주세요.');
				$('#frm').attr('onSubmit', 'return false');
			}
		}

		function pwChkr(obj) {
			var txt = $(obj).val();
			if (obj.value.length >= 5 && 10 >= obj.value.length) {
				if (!numPtn.test(txt)) {
					$('#pwChk').text('숫자가 포함되지 않았습니다.');
					$('#frm').attr('onSubmit', 'return false');
				} else if (!engPtn.exec(txt)) {
					$('#pwChk').text('알파벳이 포함되지 않았습니다.');
					$('#frm').attr('onSubmit', 'return false');
				} else if (txt.match(korPtn)) {
					$('#pwChk').text('한글은 포함하실 수 없습니다.');
					$('#frm').attr('onSubmit', 'return false');
				} else {
					$('#pwChk').text('');
					$('#frm').attr('onSubmit', 'return true');
				}
			} else {
				$('#pwChk').text('5 ~ 10자 이내로 입력해 주세요.');
				$('#frm').attr('onSubmit', 'return false');
			}
		}

		function pwcChkr(obj) {
			var txt1 = $(obj).val();
			var txt2 = $('#pwe').val();
			if (txt1 != txt2) {
				$('#pwcChk').text('비밀번호가 일치하지 않습니다.');
				$('#frm').attr('onSubmit', 'return false');
			} else {
				$('#pwcChk').text('');
				$('#frm').attr('onSubmit', 'return true');
			}
		}
	</script>
</body>
</html>