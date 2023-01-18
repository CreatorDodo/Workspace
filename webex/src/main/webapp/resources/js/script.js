$(function() {
	//이전으로 가기 버튼 ----------------
	$('backBtn').click(function() {
		history.back();
	});

	//비밀번호 일치 확인 ----------------
	$('#pwChke').keyup(function(){
		var pw = $('#pwe').val();
		var pw2 = $(this).val();
		var pwChkMsg = $('#pwChk');
	
	console.log('w');
	
	if (pw.length >= 5 && 10 >= pw.length) {	//비밀번호 입력 길이 확인
		pwChkMsg.text('비밀번호를 5 ~ 10자로 입력해주세요.');
		} else {	//비밀번호 일치 확인 처리
			pwChkMsg.text('');
			if(pw != pw2) {
				pwChkMsg.text('비밀번호가 일치하지 않습니다.');
				pwChk = false;
			} else {
				pwChkMsg.text('');
				pwChk = true;
			}
		}
	});	
	//END 비밀번호 일치 확인 ----------------
	
	//이메일 도메인 선택 처리 ----------------
	$('#email3').change(function(){
		var email3 = $(this).find(':selected').val();
		
		if(email3 == 'direct') {
			$('#email2').val('').focus().attr('readOnly', false);
		} else {
			$('#email2').val(email3).focus().attr('readOnly', true);
		}
		
	});
	//END 이메일 도메인 선택 처리 ----------------
	});//END $
	
//이메일 확인 -------------------------
function emailCheck() {
	var email1 = $('#email1').val().trim();
	var email2 = $('#email2').val().trim();

	if(email1 == '' || email2 == ''){
		return false;
//		alert('이메일을 입력해주세요.');
//		emailChk = false;
	} else {
//		emailChk = true;
		$('#email').val(email1 + '@' + email2); //이메일 합치기
		return true;
	}
}
//END 이메일 확인 -------------------------