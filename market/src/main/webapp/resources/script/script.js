
$(function() {
	//로그아웃 버튼 클릭 이벤트 처리

$('.logoutBtn').click(function() {
	if(!confirm("로그아웃을 하시겠습니까?")){
		return false;
	}
});
	//END 로그아웃 버튼 클릭 이벤트 처리
	
	

	
	
	
	//'이전으로' 버튼 클릭 이벤트 처리
	$('backBtn').click(function() {
		history.back();
	});

	//END '이전으로' 버튼 클릭 이벤트 처리

});//END $
