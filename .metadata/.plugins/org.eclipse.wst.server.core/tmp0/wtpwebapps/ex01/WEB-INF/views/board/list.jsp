<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<!-- del 1: DataTables Advanced Tables -->
				Board List page
				<!-- 게시물 등록 버튼 -->
				<button id="regBtn" type="button"
					class="btn btn-xs pull-right btn-info">Register new board</button>
			</div>
			<!-- /.panel-heading -->
			
<!-- 			<div class="row"> -->
<!-- 	<div class="col-lg-12"> -->
			<div class="panel-body">

				<div class="col-3">
					<form id="searchFrm" action="/board/list">
						<select name="type">
						<c:set value="${pageDTO.cri.type }" var="type"/>
							<option ${type == 'T' ? 'selected' : '' } value="T">제목</option>
							<option ${type == 'C' ? 'selected' : '' } value="C">내용</option>
							<option ${type == 'W' ? 'selected' : '' } value="W">작성자</option>
							<option ${type == 'TC' ? 'selected' : '' } value="TC">제목 or 내용</option>
							<option ${type == 'TW' ? 'selected' : '' } value="TW">제목 or 작성자</option>
							<option ${type == 'TCW' ? 'selected' : '' } value="TCW">제목 or 내용 or 작성자</option>
						</select> <input id="keyword" type="text" value="${pageDTO.cri.keyword}" name="keyword"> <input type="submit" id="searchBtn"
							value="검색" class="btn btn-primary"> <input id="pageNum" type="hidden"
							name="pageNum" value="${pageDTO.cri.pageNum }"> <input
							type="hidden" name="amount" value="${pageDTO.cri.amount }">

					</form>
					<span class="badge badge-success" style="float: right;">전체
						게시물 건</span>
				</div>

				<br> <br>

				<!--                           del 2:  <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example"> -->
				<table class="table table-hover">
					<thead>
						<tr>
							<th>No.</th>
							<th>제목[댓글 수]</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<tbody>
						<!-- Model의 list 출력 -->
						<c:forEach items="${list}" var="bvo">
							<tr>
								<%-- 							<tr onClick="location.href='view?bno=${bvo.bno }'" --%>
								<!-- 								style="cursor: pointer;"> -->
								<td>${bvo.bno}</td>
								<td><a class="move" href="${bvo.bno}">${bvo.title}
								<!-- 댓글 수 표시 -->
								<c:if test="${bvo.replyCnt > 0}">
								[ ${bvo.replyCnt} ]
								</c:if></a></td>
								<td>${bvo.writer}</td>
								<td><fmt:formatDate value="${bvo.regDate }" type="date"
										pattern="yyyy-MM-dd" /></td>
								<td><fmt:formatDate value="${bvo.updateDate }" type="date"
										pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</tbody>
					<!-- END Model의 list 출력 -->
				</table>

				<%-- 페이징 --%>
				<nav aria-label="..." style="text-align: center;">
					<ul class="pagination justify-content-center">
						<!-- 이전 버튼 -->
						<c:if test="${pageDTO.previous}">
							<li id="pre" class="paginate_button"><a
								href="${pageDTO.start-1}">&laquo;
									Previous</a></li>
						</c:if>
						<!-- 페이지 번호 -->
						<!-- <li class="paginate_button ${pageDTO.cri.pageNum == pNum ? 'active' : '' }">${pNum}</li> -->
						<c:forEach begin="${pageDTO.start}" end="${pageDTO.end}"
							var="pNum">
							<c:if test="${pageDTO.cri.pageNum == pNum}">
								<li id="one" class="paginate_button active"><a
									href="${pNum}">${pNum}</a></li>
							</c:if>
							<c:if test="${pageDTO.cri.pageNum != pNum}">
								<li id="one" class="paginate_button"><a href="${pNum}">${pNum}</a></li>
							</c:if>
						</c:forEach>

						<!-- 다음 버튼 -->
						<c:if test="${pageDTO.next}">
							<li class="paginate_button"><a
								href="${pageDTO.end+1}">Next &raquo;</a></li>
						</c:if>

					</ul>
				</nav>
				<%-- END 페이징 --%>

				<!-- 현재 페이지 번호 및 출력 게시물 수 전송 폼 -->
				<form id="actionFrm" action="/board/list">
					<input type="hidden" name="pageNum" value="${pageDTO.cri.pageNum }">
					<input type="hidden" name="amount" value="${pageDTO.cri.amount }">
					<input type="hidden" name="type" value="${pageDTO.cri.type }">
					<input type="hidden" name="keyword" value="${pageDTO.cri.keyword }">				
				</form>
				<!-- END 현재 페이지 번호 및 출력 게시물 수 전송 폼 -->

				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">INFORMATION</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>
<!-- /.row -->
<script>
	$(function() {
		//검색 버튼 이벤트 처리
		var searchFrm = $('#searchFrm');
		
				$('#searchBtn').on(
				'click',
				function(event) {
					
// 					if(searchFrm.find("input[name=keyword]").val() == "")) {
// 					alert('검색어를 입력해주세요.');
// 					return false;
// 				}
					
					if($('#keyword').val() == '') {//검색 키워드를 입력하지 않은 경우 경고창 표시
						alert('검색어를 입력해주세요.');
						return false;
					}
			
			
			//검색어를 입력하고 검색을 한 경우
			//페이지 번호가 1이 되도록 설정한 후 폼 전송



					searchFrm.find("input[name='pageNum']").val('1');
					actionFrm.submit();
					



				});
		
		//END 검색 버튼 이벤트 처리
		
		
		//페이징 버튼 이벤트 처리
		var actionFrm = $('#actionFrm');

		$('.paginate_button a').on('click', function(event) {

			event.preventDefault();

			actionFrm.find("input[name='pageNum']").val($(this).attr('href'));
			actionFrm.submit();
		});

		//END 페이징 버튼 이벤트 처리

		//게시물 제목 클릭 이벤트 처리

		$('.move').on(
				'click',
				function(event) {

					event.preventDefault();

					actionFrm.append("<input type='hidden' name='bno' value='"
							+ $(this).attr('href') + "'>");

					actionFrm.attr('action', '/board/view');

					actionFrm.submit();

				});

		//END 게시물 제목 클릭 이벤트 처리

		//등록 결과 알림 모달창 처리-------------------
		var result = '${result}';
		checkModal(result);

		//모달창 재출력 방지
		history.replaceState({}, null, null);

		//모달창 표시
		function checkModal(result) {
			//result가 없으면 표시 X
			if (result === '' || history.state) {
				return;
			}

			if (parseInt(result) > 0) {
				$('.modal-body').html(result + '번 게시물이 등록되었습니다.');
			}

			$('#myModal').modal('show');
		}

		//END 등록 결과 알림 모달창 처리-------------------

		//등록 버튼 클릭 이벤트 처리
		$('#regBtn').click(function() {
			// 			self.location = "/board/register";
			location.href = "register";
		});
		//END 등록 버튼 클릭 이벤트 처리
	});//END $
</script>


<%@ include file="../includes/footer.jsp"%>
