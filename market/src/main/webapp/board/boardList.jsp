<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="market.vo.BoardVO"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%
//boardList.jsp
//세션에 msg 속성이 있는 경우 경고창으로 표시하고
//세션의 속성에서 삭제

//게시물이 있는 경우에 목록 표시
//없는 경우에는 '등록된 게시물이 없습니다' 표시
%>

<c:if test="${!empty msg || msg != null }">
	<script>
		alert("${msg}");
	</script>
</c:if>
<%
session.removeAttribute("msg");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<style>
td:not(:first-child), th:not(:first-child) {
	text-align: center;
}
</style>
<body>
	<%-- 화면 상단 header -------------------------------------------- --%>
	<%@ include file="/includes/header.jsp"%>
	<%-- 메인 타이틀 ----------------------------------------- --%>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-4">게시판</h1>
		</div>
	</div>
	<%-- 메인 ------------------------------------------------- --%>

	<%
	List<BoardVO> bvoList = (ArrayList<BoardVO>) request.getAttribute("bvoList");
	%>

	<c:choose>
		<c:when test="${empty bvoList }">

			<div class="container">
				<%-- 게시판이 비었을 때 --%>
				<p class="alert alert-danger"
					style="text-align: center; height: 100px; padding: 40px;">등록된
					게시물이 없습니다.</p>
				<div class="text-right">
					<a href="/market/BoardWriteForm.do" class="btn btn-primary">&raquo;글쓰기</a>
				</div>
			</div>

		</c:when>



		<c:otherwise>
			<div class="container">
				<%-- 그렇지 않을 때 --%>
				<div class="row">
					<div class="col-8">
						<select name="type">
							<option selected value="title">제목</option>
							<option value="manyVote">인기</option>
							<option value="oneTwo">선택 항목</option>
						</select> <input type="text" name="keyword"> <input type="submit"
							value="검색" class="btn btn-primary">
					</div>
					<div class="col-4 text-right">
						<span class="badge badge-success" style="float: right;">전체
							게시물 ${total }건</span>
					</div>
					<br> <br>
				</div>


				<div>
					<%-- 장바구니 리스트 테이블 --%>


					<br> <br>
					<table class="table">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성일</th>
								<th>조회</th>
								<th>글쓴이</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${bvoList }" var="bvo">
								<tr
									onClick="location.href='/market/BoardView.do?num=${bvo.num }'"
									style="cursor: pointer;">
									<td>${bvo.num }</td>
									<td>${bvo.subject }</td>
									<td>${bvo.userid }</td>
									<td>${bvo.hit }</td>
									<td>${bvo.regDate }</td>
								</tr>
							</c:forEach>
							<%-- END 상품 하나씩 출력하기 --%>
						</tbody>
					</table>


					<%-- END 설문 목록 표시 테이블 --%>

					<%-- 페이징 --%>
					<nav aria-label="...">
						<ul class="pagination justify-content-center">
							<li id="pre" class="page-item"><a class="page-link preBtn"
								href="#">&laquo; Previous</a></li>
							<li id="one" class="page-item  active"><a
								class="page-link one" href="#">1</a></li>
							<li id="two" class="page-item" aria-current="page"><a
								class="page-link two" href="#">2</a></li>
							<li id="thr" class="page-item"><a class="page-link thr"
								href="#">3</a></li>
							<li class="page-item"><a class="page-link nextBtn" href="#">Next
									&raquo;</a></li>

						</ul>
					</nav>
					<%-- END 페이징 --%>
					<a href="/market/BoardWriteForm.do" class="btn btn-primary"
						style="float: right;">&raquo;글쓰기</a>


				</div>
				<br> <br>
			</div>

		</c:otherwise>
	</c:choose>


	<script>
// 	페이징
		if(<%= request.getParameter("page")%> == 1 || <%= request.getParameter("page")%>%3 == 1) {
			$('#one').attr("class", "page-item active");
			$('#two').attr("class", "page-item");
			$('#thr').attr("class", "page-item");
		
		}
		
		if(<%= request.getParameter("page")%> == 2 || <%= request.getParameter("page")%>%3 == 2) {
			$('#two').attr("class", "page-item active");
			$('#one').attr("class", "page-item");
			$('#thr').attr("class", "page-item");

		}
		
		if(<%= request.getParameter("page")%> == 0 || <%= request.getParameter("page")%>%3 == 0) {
			$('#thr').attr("class", "page-item active");
			$('#one').attr("class", "page-item");
			$('#two').attr("class", "page-item");

		}
	
		if (Number($('.one').text()) == 1) {
			$('#pre').attr("class", "page-item disabled");
		}

		$('.preBtn').click(function() {
			if (Number($('.one').text()) == 4) {
				$('#pre').attr("class", "page-item disabled");
			}

			$('.one').text(Number($('.one').text()) - 3);
			$('.two').text(Number($('.two').text()) - 3);
			$('.thr').text(Number($('.thr').text()) - 3);

		});

		$('.nextBtn').click(function() {
			if (Number($('.one').text()) == 1) {
				$('#pre').attr("class", "page-item");
			}

			$('.one').text(Number($('.one').text()) + 3);
			$('.two').text(Number($('.two').text()) + 3);
			$('.thr').text(Number($('.thr').text()) + 3);
		});

		$('#one').click(
				function() {
					location.href = "/market/BoardList.do?page="
							+ Number($('.one').text());
					$(this).attr("class", "page-item active");
					$('#two').attr("class", "page-item");
					$('#thr').attr("class", "page-item");
				});

		$('#two').click(
				function() {
					location.href = "/market/BoardList.do?page="
							+ Number($('.two').text());
					$(this).attr("class", "page-item active");
					$('#one').attr("class", "page-item");
					$('#thr').attr("class", "page-item");

				});

		$('#thr').click(
				function() {
					location.href = "/market/BoardList.do?page="
							+ Number($('.thr').text());
					$(this).attr("class", "page-item active");
					$('#one').attr("class", "page-item");
					$('#two').attr("class", "page-item");

				});
//	 	END 페이징
	</script>

	<%-- 화면 하단 footer --------------------------------------- --%>
	<%@ include file="../includes/footer.jsp"%>
</body>
</html>


