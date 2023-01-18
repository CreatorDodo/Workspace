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
	<fmt:setLocale value="${param.language}" />
	<!-- 메인 타이틀 ----------------------------------------- -->
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-4">
				<fmt:bundle basename="market.bundle.message">
					<fmt:message key="title" />
				</fmt:bundle>
			</h1>
		</div>
	</div>

	<!-- 메인 ------------------------------------------------- -->
	<label class="col-sm-10 text-right"><a
		href="productAdd.jsp?language=kr">한국어</a>|<a
		href="productAdd.jsp?language=jp">日本語</a>|<a
		href="productAdd.jsp?language=en">English</a>
		<a class="btn btn-sm btn-success logoutBtn"
		href="/market/common/logoutProc.jsp">로그아웃</a></label>
		
	<div class="container">
		<form action="productAddProc.jsp" method="post" id="prodRegFrm"
			class="form-horizontal" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2"> <fmt:bundle
						basename="market.bundle.message">
						<fmt:message key="pid" />
					</fmt:bundle>
				</label>
				<div class="col-sm-3">
					<input type="text" name="pid" id="pid" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:bundle
						basename="market.bundle.message">
						<fmt:message key="pname" />
					</fmt:bundle></label>
				<div class="col-sm-3">
					<input type="text" name="pname" id="pname" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:bundle
						basename="market.bundle.message">
						<fmt:message key="price" />
					</fmt:bundle></label>
				<div class="col-sm-3">
					<input type="number" name="price" id="price" value="0" min="0"
						step="1000" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:bundle
						basename="market.bundle.message">
						<fmt:message key="description" />
					</fmt:bundle></label>
				<div class="col-sm-5">
					<textarea rows="2" name="description" cols="50"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:bundle
						basename="market.bundle.message">
						<fmt:message key="maker" />
					</fmt:bundle></label>
				<div class="col-sm-3">
					<input type="text" name="maker" id="maker" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:bundle
						basename="market.bundle.message">
						<fmt:message key="category" />
					</fmt:bundle></label>
				<div class="col-sm-3">
					<select name="category" id="category" class="form-control">
						<option><fmt:bundle basename="market.bundle.message">
								<fmt:message key="category_notebook" />
							</fmt:bundle></option>
						<option><fmt:bundle basename="market.bundle.message">
								<fmt:message key="category_tablet" />
							</fmt:bundle></option>
						<option><fmt:bundle basename="market.bundle.message">
								<fmt:message key="category_smartPhone" />
							</fmt:bundle></option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:bundle
						basename="market.bundle.message">
						<fmt:message key="stock" />
					</fmt:bundle></label>
				<div class="col-sm-3">
					<input type="number" name="stock" id="stock" value="0" min="0"
						class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:bundle
						basename="market.bundle.message">
						<fmt:message key="condition" />
					</fmt:bundle></label>
				<div class="col-sm-5">
					<label><input type="radio" name="condition" value="신규">
						<fmt:bundle basename="market.bundle.message">
							<fmt:message key="condition_new" />
						</fmt:bundle></label> <label><input type="radio" name="condition" value="중고">
						<fmt:bundle basename="market.bundle.message">
							<fmt:message key="condition_old" />
						</fmt:bundle></label> <label><input type="radio" name="condition" value="재생">
						<fmt:bundle basename="market.bundle.message">
							<fmt:message key="condition_re" />
						</fmt:bundle></label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2"><fmt:bundle
						basename="market.bundle.message">
						<fmt:message key="pimage" />
					</fmt:bundle></label>
				<div class="col-sm-5">
					<input type="file" name="pimage" class="form-control">
				</div>
			</div>

			<!-- 등록 취소 버튼 -->

			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" onclick="history.back()"
						class="btn btn-secondary backBtn">
						<fmt:bundle basename="market.bundle.message">
							<fmt:message key="backBtn" />
						</fmt:bundle>
					</button>
					<button type="button" onclick="checkProduct()" class="btn btn-info">
						<fmt:bundle basename="market.bundle.message">
				<fmt:message key="addBtn"/></fmt:bundle></button>
						

				</div>
			</div>

		</form>
		
	
	</div>

	<script>
		//상품 입력 폼 확인 -------------------------
		function checkProduct() {
			var pidPtn = /^P\d{4,9}$/; //상품코드 : 대문자 P로 시작, 숫자 포함 5~10자
			var numPtn = /\d/; //상품 가격, 재고 : 숫자만 가능

			if (!pidPtn.test($('#pid').val())) {
				alert('[상품 코드] \nP와 숫자를 조합하여 5~10자로 입력해주세요.\n첫 글자는 반드시 P로 시작');
				$('#pid').focus();
			} else if ($('#pname').val().trim().length < 1
					|| $('#pname').val().trim().length > 20) { //상품명 : 1 ~ 20자 이내
				alert('[상품명] \n20자 이내로 입력해주세요.');
				$('#pname').focus();
			} else if (!numPtn.test($('#price').val())) {
				alert('[상품가격] \n숫자로 입력해주세요.');
				$('#price').focus();
			} else if (!numPtn.test($('#stock').val())) {
				alert('[상품재고] \n숫자로 입력해주세요.');
				$('#stock').focus();
			} else { //그 이외의 경우에만 폼 전송
				$('#prodRegFrm').submit();
			}
		}

		//END 상품 입력 폼 확인 -------------------------
	</script>


	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>
</body>
</html>

