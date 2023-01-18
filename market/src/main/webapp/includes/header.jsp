<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/market/resources/script/script.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/market/index.jsp">Home</a>
			</div>
			<div>

				<ul class="navbar-nav mr-auto">
					<c:choose>
						<c:when test="${ sid == null || empty sessionScope.sid }">
							<!-- 로그인하지 않은 경우 -->
							<li class="nav-item"><a class="nav-link"
								href="/market/common/login.jsp">회원 로그인</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/market/common/join.jsp">회원 가입</a></li>
						</c:when>

						<c:otherwise>
							<!-- 로그인한 경우 -->
							<li><span class="nav-link text-white font-weight-bold"><a
									href="/market/member/memberProc.jsp?cmd=modFrm">[ ${sid }님
										]</a></span></li>
							<li class="nav-item"><a class="nav-link logoutBtn"
								href="/market/common/logoutProc.jsp">로그아웃</a></li>
						</c:otherwise>
					</c:choose>
					<li class="nav-item"><a class="nav-link"
						href="/market/product/productList.jsp">상품목록</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/market/product/productAdd.jsp?language=kr">상품등록</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/market/product/productEdit.jsp?edit=modify">상품수정</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/market/product/productEdit.jsp?edit=remove">상품삭제</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/market/BoardList.do?page=1">게시판</a></li>

				</ul>
			</div>
		</div>

		<!-- 로그아웃 팝업 다이얼로그 -->
		<div id="dialog-confirm" title="logout" style="display: none;">
			<p>
				<span class="ui-icon ui-icon-alert"
					style="float: left; margin: 12px 12px 20px 0;"></span> <span
					id="msg"></span>
			</p>
		</div>
	</nav>


</body>
</html>