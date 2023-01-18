<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="market.vo.*, java.util.*"
	%>

<!-- 자신이 작성한 글만 수정, 삭제 버튼 표시  -->

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
			<h3 class="display-4">게시판</h3>
		</div>
	</div>

	<!-- 메인 ------------------------------------------------- -->
	<div class="container">

		<div class="row" align="center">



	<%
	BoardVO bvo = (BoardVO) request.getAttribute("bvo");
	%>



			<div class="col-md-8" align="left">
				<form action="/market/BoardModify.do?num=${bvo.num }" method="post" id="frm" name="regFrm">
			<div class="form-group row">
				<label class="col-sm-2">아이디</label>
				<div class="col-sm-3">
					<input type="text" name="userid" id="userid" value="${bvo.userid }"
						class="form-control" readonly="readonly">
				</div>

			</div>
			<div class="form-group row">
				<label class="col-sm-2">제목</label>
				<div class="col-sm-5">
					<input type="text" name="subject" id="subject" value="${bvo.subject }"
						class="form-control" required>
				</div>

			</div>
			<div class="form-group row">
				<label class="col-sm-2">내용</label>
				<div class="col-sm-8">
				<textarea name="content"
						id="content" class="form-control" rows="5" cols="5" required>${bvo.content }</textarea>
					
				</div>

			</div>
			<div class="text-left">
					
						<c:if test="${ sid == bvo.userid }">
	<a href="/market/BoardRemove.do?num=${bvo.num }"><input type="button"
					value="삭제" class="btn btn-danger removeBtn"></a>
					<input type="submit"
					value="수정" class="btn btn-success">
	</c:if>
					
					
					
					
					<a href="/market/BoardList.do?page=1"><input type="button" value="목록"
					class="btn btn-primary"></a>
			</div>
			
				</form>
			</div>




		</div>



<script>

$('.removeBtn').click(function() {
	if(!confirm("게시물을 삭제하시겠습니까?")){
		return false;
	}
});

</script>




	</div>


	<br>
	<br>
	<br>
	<br>
	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>






</body>
</html>
