<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="market.vo.*, java.util.*"
	errorPage="/error/noPidException.jsp"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>productModify.jsp</title>
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
			<h3 class="display-4">상품 수정</h3>
		</div>
	</div>

	<!-- 메인 ------------------------------------------------- -->
	<div class="container">

		<div class="row" align="center">

			<jsp:useBean id="pdao" class="market.dao.ProductDAO" />

			<%
			String pid = request.getParameter("pid");

			ProductVO pvo = pdao.selectProduct(pid);
			%>

			<div class="col-md-4">


				<img src="../resources/imgs/<%=pvo.getPimage()%>"
					style="width: 100%;">
			</div>



			<div class="col-md-8" align="left">
				<form action="productModifyProc.jsp" method="post" id="prodRegFrm"
					class="form-horizontal" enctype="multipart/form-data">
					<div class="form-group row">
						<label class="col-sm-2">상품 코드 </label>
						<div class="col-sm-3">
							<input type="text" name="pid" id="pid" value="<%=pvo.getPid()%>"
								class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">상품명</label>
						<div class="col-sm-3">
							<input type="text" name="pname" id="pname"
								value="<%=pvo.getPname()%>" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">가격</label>
						<div class="col-sm-3">
							<input type="number" name="price" id="price" min="0"
								value="<%=pvo.getPrice()%>" step="1000" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">상세 정보</label>
						<div class="col-sm-5">
							<textarea rows="2" name="description" cols="50"><%=pvo.getDescription()%></textarea>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">제조사</label>
						<div class="col-sm-3">
							<input type="text" name="maker" value="<%=pvo.getMaker()%>"
								id="maker" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">분류</label>
						<div class="col-sm-3">
							<select name="category" id="category" class="form-control">
								<%
								request.setAttribute("cat", pvo.getCategory());
								%>

								<option <c:if test="${cat == 'Notebook'}">
	selected
	</c:if>>Notebook</option>
								<option <c:if test="${cat == 'Tablet'}">
	selected
	</c:if>>Tablet</option>
								<option <c:if test="${cat == 'Smart Phone'}">
	selected
	</c:if>>Smart Phone</option>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">재고 수</label>
						<div class="col-sm-3">
							<input type="number" name="stock" id="stock" min="0"
								value="<%=pvo.getStock()%>" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">상태</label>
						<div class="col-sm-5">
							<%
							request.setAttribute("con", pvo.getCondition());
							%>
							<label><input type="radio" name="condition" value="신규"
								<c:if test="${con=='신규'}">
	checked
	</c:if>>신규</label>
							<label><input type="radio" name="condition" value="중고"
								<c:if test="${con=='중고'}">
	checked
	</c:if>>
								중고</label> <label><input type="radio" name="condition"
								value="재생"
								<c:if test="${con=='재생'}">
	checked
	</c:if>>
								재생</label>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2">이미지</label>
						<div class="col-sm-5">
							<input type="file" name="pimage" class="form-control">
						</div>
					</div>




					<div class="form-group row">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="button" onclick="history.back()" value="이전으로"
								class="btn btn-secondary backBtn"> <input type="button"
								onclick="checkProduct()" value="수정" class="btn btn-info">


						</div>
					</div>
					<input type="hidden" name="pidBefore" value="<%=pvo.getPid()%>">

				</form>
			</div>




		</div>








	</div>


	<br>
	<br>
	<br>
	<br>
	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>

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




</body>
</html>
