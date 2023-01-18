<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../includes/header.jsp"%>



<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board View</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board View page</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-11">
<!-- 						<form action="modify" id="form" method="get" role="form"> -->
							
							<div class="form-group">
								<label>No.</label> <input type="text" style="padding-left:20px; border: none; background-color: white;" name="bno" value="${bvo.bno}" readonly="readonly" >
								<label>작성일 :</label> <input type="text" style="padding-left:20px; border: none; background-color: white;" name="regDate" value="<fmt:formatDate value="${bvo.regDate }" type="date" pattern="yyyy-MM-dd (E)"/>" readonly="readonly" >
								<label>수정일 :</label> <input type="text" style="padding-left:20px; border: none; background-color: white;" name="updateDate" value="<fmt:formatDate value="${bvo.updateDate }" type="date" pattern="yyyy-MM-dd (E)"/>" readonly="readonly" >
							</div>
							<div class="form-group">
								<label>Writer</label> <input type="text" style="padding-left:20px; border: none; background-color: white;" name="writer" value="${bvo.writer}" readonly="readonly" >
							</div>
							<div class="form-group">
								<label>Title</label> <input type="text" style="padding-left:20px; border: none; background-color: white;" name="title" value="${bvo.title}" readonly="readonly" >
							</div>
							
							
							<div class="form-group">
								<label>Content</label>
								<textarea name="content" class="form-control" style="background-color: white;" readonly="readonly"  rows="3">${bvo.content}</textarea>
							</div>

							<form action="modify">
							<input type="hidden" name="bno" value="${bvo.bno}">
							<button data-oper="modify" type="submit" class="btn btn-warning">Modify</button>
							
							<button type="submit"  data-oper="list" formaction="/board/list" class="btn btn-primary">List</button>
<!-- 							<a href="list"><button type="button" class="btn btn-primary">List</button></a> -->
								
							<!-- 페이지 번호와 페이지 당 표시할 게시물 수를 파라미터로 추가 -->
							<input type="hidden" name="pageNum" value="${cri.pageNum }">
							<input type="hidden" name="amount" value="${cri.amount }">
							<input type="hidden" name="type" value="${cri.type }">
							<input type="hidden" name="keyword" value="${cri.keyword }">
							<!--END 페이지 번호와 페이지 당 표시할 게시물 수를 파라미터로 추가 -->
							
							</form>
<!-- 						</form> -->
						
					</div>





				</div>
				<!-- /.col-lg-6 (nested) -->
				

				
							</div>
			<!-- /.row (nested) -->
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-12 -->
			
			

<!-- END 게시물 -->


<!-- 파일 첨부 -->
   <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Attached File</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-11">
	<div class="uploadDiv"></div>

	<!-- 업로드 결과 출력 -->
	<div class="uploadResult">
		<ul></ul>
	</div>
	<!-- END 업로드 결과 출력 -->


						
					</div>


				</div>
				<!-- /.col-lg-6 (nested) -->
			</div>
			<!-- /.row (nested) -->
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
	
                 </div>   
<!--END 파일 첨부 -->    

				    


<div class="chat-panel panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-comments fa-fw"></i> Reply
                            <div class="btn-group pull-right">
<!-- 신규 댓글 작성 버튼 -->
<!-- <button id="newBtn" type="button" -->
<!-- 					class="btn btn-xs pull-right btn-info">New Reply</button> -->
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body"><!-- 댓글 목록 페이징 -->
							<ul class="chat ">
<!-- 								<li data-rno='11' class="left clearfix"> -->
<!-- 									<div class="left clearfix"> -->
<!-- 										<div class="header"> -->
<!-- 											<strong class="primary-font">User00</strong> <small -->
<!-- 												class="pull-right text-muted"> <i -->
<!-- 												class="fa fa-clock-o fa-fw"></i> 12 mins ago -->
<!-- 											</small> -->
<!-- 										</div> -->
<!-- 										<p>Good job!</p> -->
<!-- 									</div> -->
<!-- 								</li> -->
							</ul>
						</div>
                        <!-- /.panel-body -->
                        <div class="panel-footer">
                            <div class="input-group">
                                <input id="btn-input" type="text" value="" class="form-control input-sm" placeholder="Type your message here..." />
                                <span class="input-group-btn">
                                    <button class="btn btn-warning btn-sm" id="btn-chat">
                                        Send
                                    </button>
                                </span>
                            </div>
                        </div>
                        <!-- /.panel-footer -->
                    </div>
                    

                    
                    



<!-- /.row -->

<%-- 페이징 --%>
<nav aria-label="..." style="text-align: center;">
		<ul class="pagination justify-content-center">
			
		</ul>
	</nav>
<%-- END 페이징 --%>







				<!-- 댓글 작성 Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
       <div class="modal-content">
           <div class="modal-header">
               <button type="button" class="close" 
               			data-dismiss="modal" aria-hidden="true">&times;</button>
               <h4 class="modal-title" id="myModalLabel">
               		REPLY</h4>
           </div>
           <div class="modal-body">
				<div class="form-group">
					<label>Replyer</label> <input name="replyer" id="replyer"
						class="form-control">
				</div>
				<div class="form-group">
					<label>Reply</label> <input name="reply" id="reply"
						class="form-control">
				</div>

				<div class="form-group">
                   <label>Reply Date</label>
                   <input name="regDate" id="regDate" class="form-control" readonly>
               </div>
           </div>
           <div class="modal-footer">
               <button id="remBtn" type="button" class="btn btn-danger">
               		Remove</button>
               <button id="modBtn" type="button" class="btn btn-warning">
               		Modify</button>
               <button id="regBtn" type="button" class="btn btn-info">
               		Register</button>
               <button id="closeBtn" type="button" class="btn btn-default" 
               			data-dismiss="modal">Close</button>
           </div>
       </div>	<!-- /.modal-content -->
   </div>		<!-- /.modal-dialog -->
</div>			<!-- /.modal -->
				<!-- /.modal -->

	<!-- 썸네일 이미지 원본 표시 -->
	<div class="originImgDiv">
		<div class="originImg">
		<!-- 이미지 태그 -->
		</div>
	</div>
	<!-- END 썸네일 이미지 원본 표시 -->


<script src="/resources/js/reply.js"></script>

<script>
$(function() {
	
	var modal = $('#myModal');
	var replyTxt = $('#reply');
	var replyerTxt = $('#replyer');
	var regDateTxt = $('#regDate');
	
	var modBtn = $('#modBtn');
	var remBtn = $('#remBtn');
	var regBtn = $('#regBtn');
	
	var bnoVal = '${bvo.bno}';
	var replyUL = $('.chat');
	var pageUL = $('.pagination')
	

	
	
	$(document).on('click', "#modButton", function() {
		
		var rno = $(this).data('rno');
		
		console.log(rno);
		
	 	replyService.view(
		rno,
	 	function(result){
			replyTxt.val(result.reply);
			replyerTxt.val(result.replyer);
			regDateTxt.val(replyService.display(result.regDate));
			replyTxt.attr("readonly", false);
			replyerTxt.attr("readonly", false);
			
// 			replyUL.html('');
// 			pageUL.html('');
			regDateTxt.closest('div').show();
			modal.find("button[id != 'closeBtn']").hide();
			modBtn.show();
			modal.modal('show');		
	 	}
	);//END view()
		
	
// 	var mod;
modBtn.on('click', function(event){
	replyService.modify(
		{ rno : rno, 
		  reply : replyTxt.val()   },
		function(result){
			  
			  console.log(rno);
			alert('댓글이 수정되었습니다.');
			modal.find('input').val('');	//입력 값 지우기
			replyUL.html('');
			pageUL.html('');
			modal.modal('hide');			//모달 창 숨기기
			$('#modButton').removeAttr('rno');
			rno = '';
			makeList(pageNum);
// 			mod = result;
		}
			);//END modify()
		});
	
	
});
		
		
	$(document).on('click', "#remButton", function() {
		
		var rno = $(this).data('rno');
		
	 	replyService.remove(
	 			rno, 
		function(result){
			alert('댓글이 삭제되었습니다.');
			modal.find('input').val('');	//입력 값 지우기
			modal.modal('hide');			//모달 창 숨기기
			replyUL.html('');
			pageUL.html('');
			makeList(1);
		},
		function(err){
			alert('댓글을 삭제하지 못했습니다.');
		}
	);//END remove()
		});

	
	
// 	//댓글 클릭 이벤트 처리
	
	$(document).on('click', '#viewButton', function(event){
	
		
		var rno = $(this).data('rno');
		
			
		//댓글 조회 테스트
		replyService.view(
				rno,
				 function(result) {
					replyTxt.val(result.reply);
					replyerTxt.val(result.replyer);
					regDateTxt.val(replyService.display(result.regDate));
// 					modal.find("input[id = 'replyer']").val(result.replyer);
// 					modal.find("input[id = 'reply']").val(result.reply);
// 					modal.find("input[id = 'regDate']").val(replyService.display(result.regDate));
					replyTxt.attr("readonly", true);
					replyerTxt.attr("readonly", true);
					modal.find("button[id != 'closeBtn']").hide();
					
					
// 					modal.data('rno', result.rno);
					$('#myModal').modal('show');
					}
		);	//END view()		
		
		
	});
	
	//END 댓글 클릭 이벤트 처리
	
	
//댓글 클릭 이벤트 처리2
// replyUL.on('click', 'li', function(event){
// 	var rno = $(this).data('rno');

//댓글 번호를 매개변수로 replyService의 view 함수 호출
// 	replyService.view(
// 		rno,
// 	 	function(result){
// 			replyTxt.val(result.reply);
// 			replyerTxt.val(result.replyer);
// 			regDateTxt.val(replyService.display(result.regDate));

// 			regDateTxt.closest('div').show();	//regDate에 가까운 div 보이기
// 			modal.find("button[id != 'closeBtn']").hide(); //close가 아닌 버튼 숨기기
// 			modBtn.show();	//수정, 삭제 버튼은 보이게
// 			remBtn.show();
			
// 			modal.data('rno', result.rno);
// 			modal.modal('show');		
// 	 	}
// 	);//END view()
// });//END 댓글 클릭 이벤트 처리2

// //Modify 버튼 클릭 이벤트 처리2
// modBtn.on('click', function(event){	
// 	replyService.modify(
// 		{ rno : modal.data('rno'), 
// 		  reply : replyTxt.val()   },
// 		function(result){
// 			alert('댓글이 수정되었습니다.');
// 			modal.find('input').val('');	//입력 값 지우기
// 			modal.modal('hide');			//모달 창 숨기기
// 			replyUL.html('');
// 			makeList(${param.pageNum});		//댓글 목록 새로 표시
// 		}
// 	);//END modify()
	
// });//END Modify 버튼 클릭 이벤트 처리2

// //Remove 버튼 클릭 이벤트 처리2
// remBtn.on('click', function(event){
// 	replyService.remove(
// 		modal.data('rno'), 
// 		function(result){
// 			alert('댓글이 삭제되었습니다.');
// 			modal.find('input').val('');	//입력 값 지우기
// 			modal.modal('hide');			//모달 창 숨기기
// 			replyUL.html('');
// 			makeList(${param.pageNum});		//댓글 목록 새로 표시
// 		},
// 		function(err){
// 			alert('댓글을 삭제하지 못했습니다.');
// 		}
// 	);//END remove()
	
// });//END Remove 버튼 클릭 이벤트 처리2
	
	
	//댓글 모달창 처리-------------------


	$('#btn-chat').click(function() {
		//댓글 등록 테스트
		replyService.register(
		 		{
		 			  "bno": ${param.bno},
		 			  "reply": $('#btn-input').val(),
		 			  "replyer": "익명"
		 			}, function(result) {
		 				alert('댓글이 등록되었습니다.');
		 				//입력 값 지우기
		 				$('#btn-input').val('');
		 				//모달 창 숨기기
		 				//댓글 목록 새로 표시
		 				replyUL.html('');
		 				pageUL.html('');
// 		 				makeList(pages);
						makeList(-1);	//마지막 댓글 목록으로 이동 처리
		 				
		 				
// 		 				modal.find('input').val('');	//입력 값 지우기
// 		 				modal.modal('hide');			//모달 창 숨기기
// 		 				makeList(1);					//댓글 목록 새로 표시
		 			}
		 			
		);	//END register()
		
		
		
    });
	
	

	//모달창 표시
// 	$('#newBtn').click(function() {
		
// 		modal.find('input').val('');	//입력값 지우기
// 		regDateTxt.closest('div').hide();	//regDate에 가까운 숨기기
// // 			$('.modal-body').html('번 게시물이 등록되었습니다.');
// 		modal.find("button[id != 'closeBtn']").hide(); //close가 아닌 버튼 숨기기
// 		regBtn.show(); //등록 버튼은 보이게
// 		$('#myModal').modal('show');
//     });
	
	//END 댓글 모달창 처리-------------------	
	
	
	







//댓글 목록 출력
function makeList(pageNum){
	

		
	//댓글 목록 테스트
		replyService.list({bno : ${param.bno}, pageNum : pageNum}
		,
		 function(totalReply, result) {
			
			//댓글 추가 시 makeList(-1)
			//마지막 페이지 번호를 계산해서 이동 처리
			 if(pageNum == -1){
				 pageNum = Math.ceil( totalReply / 3.0); 
				 makeList(pageNum);	//마지막 페이지 번호를 계산해서 이동 처리
				 return;
				}
			
			
			//댓글이 없는 경우
			if(result == null || result.length == 0){
				replyUL.html('');
				return;
			}
			
			
			
			//댓글이 있는 경우 - replies ------------------
				for (var i = 0; i < result.length; i++) {
$('.chat').append("<li id='rnoData' data-rno='" + result[i].rno + "' class='left clearfix'>" + 
		"<div class='left clearfix'>" + 
		"<div class='header'>"
		+	"<strong class='primary-font'>" + result[i].replyer
				+ "</strong>" + "<small class='pull-right text-muted'>" + "<i class='fa fa-clock-o fa-fw'>" + "</i>" + replyService.display(result[i].regDate) +
			"</small>" +
		"</div>"
		+"<p>" +result[i].reply
				+ " <i id='remButton' data-rno='" + result[i].rno + "'  class='fa fa-times pull-right' ></i>"
				+ " <i id='modButton' data-rno='" + result[i].rno + "'  class='fa fa-gear pull-right' ></i> "
				+ " <i id='viewButton' data-rno='" + result[i].rno + "'  class='fa fa-info-circle pull-right' ></i> "
		+ "</p></div></li>");
		

		
				}
			//END 댓글이 있는 경우 - replies ------------------

			//페이지 번호 출력 함수 호출
				makePageNum(totalReply,pageNum);
			
			}
		
	
		); //END list()
		
		
	}//END makeList()
	
makeList(1);

	
//댓글 목록 페이지 번호 출력-----------------------
var pageNum = 1;

var pages;
function makePageNum(totalReply, pageNum){
	var numPerPage = 5.0;	//한 페이지에 표시할 페이지 번호 수
	var amount = 3.0;		//한 페이지에 표시할 댓글 수
// 	var pages;				//전체 페이지 번호 수
	var start;				//시작 페이지 번호
	var end;				//끝 페이지 번호
	var previous;			//이전
	var next;				
	
	pages = Math.ceil( totalReply / amount); 	//전체 페이지 번호 수
	end = Math.ceil(pageNum / numPerPage) * numPerPage;
	start = end - (numPerPage - 1);
	end = end >= pages ? pages : end;	//실제 끝 페이지 번호 확인
	
	previous = start > 1;
	next = end < pages;
	
	var tag = "";
	
	if(previous == true) {
		tag += "<li id='pre' class='paginate_button'>" +
		"<a href='" + (start-1) + "'>&laquo; Previous</a></li>";

	}
	
	for(var i=start ; i<=end ; i ++){
		tag += "<li class='paginate_button " + (i == pageNum ? 'active' : '') + "'>" +
		" <a href='" + i + "'>" + i + "</a></li>";
	}
	
	if(next == true) {
		tag += "<li class='paginate_button'>" +
		"<a href='" + (end+1) + "'>Next &raquo;</a></li>";
	}
	



	pageUL.html(tag);
	
}//END makePageNum()


//페이징 버튼 이벤트 처리
//클릭된 번호의 댓글 목록 표시

// var actionFrm = $('#actionFrm');


// 	pageUL.on('click', 'li a', function(event) {

	pageUL.on('click', 'a', function(event) {
	event.preventDefault();
	replyUL.html('');
	pageUL.html('');
	pageNum = $(this).attr('href')
	makeList(pageNum);
// 	$(this).submit();
});

//END 페이징 버튼 이벤트 처리

//END 댓글 목록 페이지 번호 출력-----------------------

//댓글 등록 테스트
// replyService.register(
// 		{
// 			  "bno": 23,
// 			  "reply": "Pon",
// 			  "replyer": "Kim"
// 			}, function(result) {
// 				alert('댓글이 등록되었습니다.');
// 			}
		
// );	//END register()

//댓글 수정 테스트
// replyService.modify(
// 		 		{
// 		 			"rno": 9,
// 		 			  "reply": "modify"
// 		 			}, function(result) {
// 		 				alert('댓글이 수정되었습니다.');
// 		 			}
				
// );	//END modify()		

//댓글 삭제 테스트
// replyService.remove(
// 					9,
// 		 			function(result) {
// 		 				alert('댓글이 삭제되었습니다.');
// 		 			},  function(result) {
// 		 				alert('정보를 정확히 입력해주세요.');
// 		 			}
// );	//END remove()	

//댓글 조회 테스트
// replyService.view(
// 		8,
// 		 function(result) {
// 				console.log(result);
// 			}
// );	//END view()		

$.getJSON('attachList?bno=' + ${bvo.bno},
 				function(result) {
 				if(!result || result.length == 0){
 					resultUL.html("첨부된 파일이 없습니다.");
 					return;
 				}else{
					showUploadedFile(result);
					
 				}
 			}
 			).fail(function(err) {
 				console.log(err);
 			
 			});//END getJSON
	
	//업로드 결과 출력
	var resultUL = $('.uploadResult ul');
	function showUploadedFile(result) {
		var tag="";
		
			$(result).each(function (i, obj) {
				
				//서버로 전송할 데이터들
				tag += "<li data-folder='" + obj.upFolder + "' " + 
				"data-uuid='" + obj.uuid + "' " + 
				"data-filename='" + obj.fileName + "' " + 
				"data-image='" + obj.image + "'> ";
				
				
				
				//이미지는 파일명 표시
				//이미지 파일이 아니면 attach.png 표시 및 다운로드
				if(obj.image){

					
					
					//공백이나 한글 등 인코딩 처리
					var thumbImg = encodeURIComponent(obj.upFolder + "/s_" + obj.uuid + "_" + obj.fileName);
					
					
					//썸네일 이미지 클릭 시 원본 이미지 표시
					
					var originalImg = obj.upFolder + "\\" + obj.uuid + "_" + obj.fileName;
					originalImg = originalImg.replace(new RegExp(/\\/g), "/");

					tag += "<li><img  class='original" + i + "' src='/display?fileName=" + thumbImg + "'><br>" + obj.fileName + "</li>";		

					
					$(document).on('click', '.original'+ i, function(event) {
						
						showOriginal(originalImg);
				});
					
				} else {
					
					var filePath = encodeURIComponent(obj.upFolder + "/" + obj.uuid + "_" + obj.fileName);
					tag += "<li><a href='/download?fileName="  + filePath + "'><img src='/resources/img/attach.png'></a><br>" + obj.fileName + "</li>";
				}
				
				
			});//END each()
			resultUL.append(tag);
	}//END showUploadedFile()


	//썸네일 이미지 원본 표시
	
	function showOriginal(originImg) {
// 		$('.originImgDiv').css({"display" : "flex"}).show();

		$('.originImg').html("<img src='/display?fileName=" + originImg + "'>");
		$('.originImgDiv').animate({ width:'100%', height:'100%'}, 1000);
		$('.originImgDiv').clearQueue().slideDown(1000);
// 		alert(originImg);
		
		
	
		
	}//END showOriginal()
	
	//썸네일 이미지 원본 클릭 이벤트 처리
	
						$(document).on('click', '.originImg', function(event) {
							$('.originImgDiv').animate({ width:'100%', height:'100%'}, 1000);
							$('.originImgDiv').clearQueue().slideUp(1000);
							
				});
	
	//END 썸네일 이미지 원본 클릭 이벤트 처리
	
	
});//END $

</script>


<%@ include file="../includes/footer.jsp"%>

