<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="market.vo.*, java.util.*"%>



<!DOCTYPE html>

<html>


<head>

<meta charset="UTF-8">

<title>productEdit.jsp</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>

<body>

	<!-- 화면 상단 header -------------------------------------------- -->

<%@ include file="/includes/header.jsp" %>


	<!-- 메인 타이틀 ----------------------------------------- -->

	<div class="jumbotron">

		<div class="container">

			<h1 class="display-4">상품 편집</h1>

		</div>

	</div>


	<!-- 메인 ------------------------------------------------- -->

	<div class="container">

		<div class="row" align="center">

			<jsp:useBean id="pdao" class="market.dao.ProductDAO" />

			<%
			List<ProductVO> pvoList = pdao.selectAllProduct();

			if (pvoList == null || pvoList.size() < 1) {

				System.out.println(">> 등록된 상품이 없습니다.");

			} else {// 그렇지 않다면 

				for (ProductVO pvo : pvoList) {
			%>

			<div class="col-md-4">

				<!-- 이미지 -->

				<img src="../resources/imgs/<%=pvo.getPimage()%>"
					style="width: 100%;">



				<!-- 이름 -->

				<h3><%=pvo.getPname()%></h3>

				<!-- 설명 -->

				<p><%=pvo.getDescription()%></p>

				<!-- 가격 -->
				
				<p><fmt:formatNumber value="<%=pvo.getPrice()%>"/>
					원
				</p>

				<!-- 상세 정보 버튼 -->

				<p>
									<c:choose>
						<c:when test="${ param.edit == 'modify' }">
							<!-- 상품수정 -->
							<a href="productModify.jsp?pid=<%=pvo.getPid()%>"
						class="btn btn-info">수정 &raquo;</a>
						</c:when>

						<c:otherwise>
							<!-- 상품삭제 -->
							<a href="<%=pvo.getPid()%>" class="btn btn-danger removeBtn">삭제 &raquo;</a>
							
						</c:otherwise>
					</c:choose>
				</p>
			</div>

			<%
			} //END for

			}
			%>



		</div>

	</div>


	<!-- 화면 하단 footer --------------------------------------- -->

	<%@ include file="../includes/footer.jsp"%>

<script>
$('.removeBtn').click(function(event) {
	event.preventDefault();
	if(confirm("해당 상품을 삭제하시겠습니까?")){
		location.href="productRemoveProc.jsp?pid=" + $(this).attr('href');
	}else	{
		return false;
	}
});

</script>
		 <c:if test="${!empty msg || msg != null }">
		 <script>
		 	alert("${msg}");
		 </script>
		 </c:if>
		 <%session.removeAttribute("msg"); %>


</body>

</html>