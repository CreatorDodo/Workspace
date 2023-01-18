<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="market.vo.*, java.util.*"
	errorPage="/error/noPidException.jsp"%>
<%!String greetingUpper = "상품 정보";%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>productInfo.jsp</title>
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
			<h3 class="display-4"><%=greetingUpper%></h3>
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

				<!-- 이미지 -->

				<img src="../resources/imgs/<%=pvo.getPimage()%>"
					style="width: 100%;">
			</div>



			<!-- 이름 -->
			<div class="col-md-5" align="left">
				<h3><%=pvo.getPname()%></h3>
				<p><%=pvo.getDescription()%>
				</p>
				<p>
					<span class="font-weight-bold">상품 코드 : </span><span
						class="badge badge-danger"><%=pvo.getPid()%></span>
				</p>
				<p>
					<span class="font-weight-bold">제조사 : </span><%=pvo.getMaker()%></p>
				<p>
					<span class="font-weight-bold">분류 : </span><%=pvo.getCategory()%></p>
				<p>
					<span class="font-weight-bold">상품 상태 : </span><%=pvo.getCondition()%></p>
				<p>
					<span class="font-weight-bold">재고 수량 : </span><fmt:formatNumber value="<%=pvo.getStock()%>"/> 개</p>
				<h4>
					<span class="font-weight-bold"><fmt:formatNumber value="<%=pvo.getPrice()%>"/></span> 원
				</h4>
				<form action="/market/cart/cartAddProc.jsp" method="post">
				<p>
				<input type="button" class="btn btn-info cartAddBtn" value="장바구니 담기 &raquo;">
				<a href="/market/cart/cart.jsp"><input type="button" class="btn btn-warning" value="장바구니 보기 &raquo;"></a>
				<a href="productList.jsp"><input type="button" class="btn btn-secondary" value="상품목록 &raquo;"></a>
				</p>
				<input type="hidden" name="pid" value="<%=pvo.getPid()%>">
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
$('.cartAddBtn').click(function() {
	if(confirm("상품을 장바구니에 추가하시겠습니까?")){
		$('form').submit();
		
	}else	{
		return false;
	}
});

</script>
	
	
	
	
</body>
</html>

