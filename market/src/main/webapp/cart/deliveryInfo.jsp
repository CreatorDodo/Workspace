<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productAdd.jsp</title>
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
			<h1 class="display-4">배송 정보</h1>
		</div>
	</div>

	<!-- 메인 ------------------------------------------------- -->
	<div class="container">

		<form action="deliveryInfoProc.jsp" method="post"
			class="form-horizontal">
			<div class="form-group row">
				<label class="col-sm-2">수령인</label>
				<div class="col-sm-4">
					<input type="text" name="rname" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">배송희망일</label>
				<div class="col-sm-4">
					<input type="date" name="deliveryDate" id="deliveryDate"
						class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">우편번호</label>
				<div class="col-sm-3">
					<input type="text" name="zipNo" id="zipNo" class="form-control" required>
				</div>
				<input type="button" class="btn btn-outline-secondary" value="검색"
					onclick="goPopup()">

			</div>
			<div class="form-group row">
				<label class="col-sm-2">도로명 주소</label>
				<div class="col-sm-5">
					<input type="text" name="addr1" id="addr1" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상세 주소</label>
				<div class="col-sm-2">
					<input type="text" name="addr3" id="addr3" class="form-control" required>
				</div>
				<div class="col-sm-3">
					<input type="text" name="addr2" id="addr2" class="form-control" required>

				</div>
			</div>
			<div class="form-group row">
			
				<label class="col-sm-2">연락처</label>
				<div class="col-sm-2">
					<select name="phone1" id="phone1" class="form-control" required>
						<option>선택</option>
						<option>010</option>
						<option>02</option>
						<option>031</option>
						<option>033</option>
					</select>
				</div>
				<div class="col-sm-2">
					<input type="text" name="phone2" id="phone2" class="form-control" required>
				</div>
				<div class="col-sm-2">
					<input type="text" name="phone3" id="phone3" class="form-control" required>
					<input type="hidden" name="phone" id="phone">
				</div>
			</div>


			<!-- 등록 취소 버튼 -->
			<div class="form-group row text-right">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" value="이전으로" onclick="history.back()"
						class="btn btn-secondary backBtn">
						<input type="submit" value="등록" class="btn btn-info delRegBtn">

				</div>
			</div>

		</form>
	</div>

<script>

//	연락처 합치기

	
$('.delRegBtn').click(function() {
	var phone1 = $('#phone1').val().trim();
	var phone2 = $('#phone2').val().trim();
	var phone3 = $('#phone3').val().trim();
	$('#phone').val(phone1 + "-" + phone2 + "-" + phone3);
})
	


function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2, zipNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		$('#addr1').val(roadAddrPart1);
		$('#addr2').val(roadAddrPart2);
		$('#addr3').val(addrDetail);
		$('#zipNo').val(zipNo);

		
}


</script>


	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>
</body>
</html>
