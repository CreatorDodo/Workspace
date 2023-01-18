<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify page</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-11">
						<form action="modify" id="form" method="post" role="form">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							<div class="form-group">
								<label>No.</label> <input type="text" style="padding-left:20px; border: none; background-color: white;" name="bno" value="${bvo.bno}" readonly="readonly" >
								<label>작성일 :</label> <input type="text" style="padding-left:20px; border: none; background-color: white;" value="<fmt:formatDate value="${bvo.regDate }" type="date" pattern="yyyy-MM-dd"/>" readonly="readonly" >
							</div>
							<div class="form-group">
								<label>Writer</label> <input type="text" style="padding-left:20px; border: none; background-color: white;" name="writer" value="${bvo.writer}" readonly="readonly" >
							</div>
							<div class="form-group">
								<label>Title</label> <input type="text" name="title" value="${bvo.title}" class="form-control">
							</div>
							<div class="form-group">
								<label>Content</label>
								<textarea class="form-control" name="content" rows="3">${bvo.content}</textarea>
							</div>


							
							<button id="modBtn" type="submit" data-oper="modify" class="btn btn-primary">Modify</button>
							<button type="submit" data-oper="remove" formaction="remove?bno=${bvo.bno }" formmethod="post" class="btn btn-danger delBtn">Delete</button>
<!-- 							<button type="button" onclick="history.back()" class="btn btn-warning">Cancel</button> -->
							<button type="submit"  data-oper="list" formaction="list" formmethod="get" class="btn btn-info">list</button>
						
							<!-- 페이지 번호와 페이지 당 표시할 게시물 수를 파라미터로 추가 -->
								<input type="hidden" name="pageNum" value="${cri.pageNum }">
								<input type="hidden" name="amount" value="${cri.amount }">
								<input type="hidden" name="type" value="${cri.type }">
								<input type="hidden" name="keyword" value="${cri.keyword }">
							<!--END 페이지 번호와 페이지 당 표시할 게시물 수를 파라미터로 추가 -->
						
						
						</form>
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



<!-- 파일 첨부 -->
   <div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">File Attach</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-11">
	<div class="uploadDiv"></div>
	<input type="file" id="uploadFile" name="uploadFile" multiple>

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








</div>
<!-- /.row -->


<script>



//파일 종류(exe, sh, zip) 및 크기(5MB) 제한
var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
var maxSize = 5242880;

//업로드 제한 확인
function uploadCheck(fileName, fileSize) {
	if(regex.test(fileName)){	//확장자 확인
		alert("해당 형식의 파일은 업로드 하실 수 없습니다.");
		return false;
	}

	if(fileSize >= maxSize) {
		alert("업로드 허용 크기(5MB) 초과 - 업로드 불가")
		return false;
	}
	return true;

 
}
//END 업로드 제한 확인




//첨부 파일 선택 이벤트 처리
//	$('#uploadFile').change(function(event) {
$("input[type='file']").on('change', function(event) {

	var formData = new FormData();	//form처럼 key/value로 값 생성 가능
	var files = $("input[name='uploadFile']")[0].files;
	
	
	
	
	//formData 객체에 파일 추가
	for(var i=0 ; i<files.length ; i++) {
		
		//업로드 제한 확인
		if(uploadCheck(files[i].name, files[i].size)){
			formData.append("uploadFile", files[i]);
//				return false; //업로드 중지
		}
		
		
//			continue //제한 파일 제외
		
		
	}
//		var file;
	$.ajax({
		dataType : 'json',
		type : 'post',
		url : '/upload/ajaxAction',
		data : formData,
		contentType : false,
		processData : false,
		success : function(result){
			console.log('upload ok!');
			console.log(result);
			//파일 선택 초기화
			$("input[type='file']").val('');
			
			//업로드 결과 출력 함수 호출
			showUploadedFile(result);
			
		}
	});//END ajax()

});//END 첨부 파일 선택 이벤트 처리







$.getJSON('attachList?bno=' + ${bvo.bno},
			function(result) {
			
			showUploadedFile(result);
			
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

						tag += "<img  class='original' src='/display?fileName=" + thumbImg + "'><br>" + obj.fileName + " <span class='btn btn-warning btn-circle'  data-file='" + thumbImg + "' data-type='image'><i class='fa fa-times'></i></span></li>";		

						
						$(document).on('click', '.original', function(event) {
							
							showOriginal(originalImg);
					});
						
					} else {
						
						var filePath = encodeURIComponent(obj.upFolder + "/" + obj.uuid + "_" + obj.fileName);
						tag += "<img src='/resources/img/attach.png'><br>" + obj.fileName + " <span class='btn btn-warning btn-circle' data-file='" + filePath + "' data-type='file'><i class='fa fa-times'></i></span></li>";
					}
					
					
				});//END each()
				resultUL.append(tag);
		}//END showUploadedFile()

		



		

		
		//X 표시 클릭 이벤트 처리
		resultUL.on('click', 'span', function() {
			var x = $(this).closest('li');
		
		$.ajax({
			dataType : 'text',
			type : 'post',
			url : '/deleteFile',
			data : 
			{	
				   fileName : $(this).data('file'),
				   type : $(this).data('type')
				},
			success : function(result){
//	 			alert(result);
				console.log(result);
				x.remove();	//클릭된 li 삭제
				
				}
			});//END ajax()
		
		});//END X 표시 클릭 이벤트 처리		
		
		
		//modify 버튼 클릭 이벤트 처리
		$('#modBtn').on('click', function(event) {
			event.preventDefault(); //기본 이벤트 막기
			
			//생성된 li의 첨부파일 정보를 폼에 추가
			var tag = "";
			$('.uploadResult ul li').each(function (i, obj) {
				var o = $(obj);
				tag += " <input type='hidden' name='attachList[" + i + "].fileName' " +
					   "		 value='" + o.data('filename') + "'>";
				tag += " <input type='hidden' name='attachList[" + i + "].upFolder' " +
				   "		 value='" + o.data('folder') + "'>";
				tag += " <input type='hidden' name='attachList[" + i + "].uuid' " +
				   "		 value='" + o.data('uuid') + "'>";
				tag += " <input type='hidden' name='attachList[" + i + "].image' " +
				   "		 value='" + o.data('image') + "'>";
				   
			});//END each()
				
			$("form[role='form']").append(tag).submit(); //폼 전송

			
// 			if(oper === 'remove') {
// 				$("form[role='form']").attr('action', '/board/remove');
// 			}
			
// 			if(oper === 'list') {
// 				$("form[role='form']").attr('action', '/board/list');
// 				$("form[role='form']").attr('method', 'get');
// 			}
			
		
		});//END modify 버튼 클릭 이벤트 처리
		

</script>




<%@ include file="../includes/footer.jsp"%>