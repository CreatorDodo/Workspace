<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="market.vo.*, java.util.*"%>



<!DOCTYPE html>

<html>


<head>

<meta charset="UTF-8">

<title>productList.jsp</title>

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

			<h1 class="display-4">상품 목록</h1>

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
					<a href="productInfo.jsp?pid=<%=pvo.getPid()%>"
						class="btn btn-secondary">상세정보 &raquo;</a>
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

</body>

</html>