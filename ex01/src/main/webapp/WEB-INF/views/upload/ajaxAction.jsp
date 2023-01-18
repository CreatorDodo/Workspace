<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/upload/ajaxAction.jsp</title>

<style>
.uploadResult {
	width: 100%;
	background: lightgray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
	text-align: center;
}

.uploadResult ul li img {
	width: 100px;
}

.originImgDiv {
	position: absolute;
	display: none;
	justify-content: center;
	align-items: center;
	top: 0%;
	z-index: 100;
	width: 100%;
	height: 100%;
	backgroud: gray;
}

.originImg {
	position: relative;
	display: flex;
	justify-content: center;
	align-items: center;
}

.originImg img {
	width: 500px;
}
</style>

</head>
<body>


	<h3>SPRING FILE UPLOAD WITH AJAX</h3>
	<div class="uploadDiv"></div>
	<input type="file" name="uploadFile" multiple>
	<hr>
	<button id="uploadBtn">upload</button>

	<!-- 업로드 결과 출력 -->
	<div class="uploadResult">
		<ul></ul>
	</div>
	<!-- END 업로드 결과 출력 -->

	<!-- 썸네일 이미지 원본 표시 -->
	<div class="originImgDiv">
		<div class="originImg">
		<!-- 이미지 태그 -->
		</div>
	</div>
	<!-- END 썸네일 이미지 원본 표시 -->


	<script src="http://code.jquery.com/jquery-3.6.3.min.js"></script>
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
	
	
	
	
	
	//업로드 버튼 클릭 이벤트 처리
	$('#uploadBtn').on('click', function(event) {
		var formData = new FormData();	//form처럼 key/value로 값 생성 가능
		var files = $("input[name='uploadFile']")[0].files;
		
		
		
		
		//formData 객체에 파일 추가
		for(var i=0 ; i<files.length ; i++) {
			
			//업로드 제한 확인
			if(uploadCheck(files[i].name, files[i].size)){
				formData.append("uploadFile", files[i]);
// 				return false; //업로드 중지
			}
			
			
// 			continue //제한 파일 제외
			
			
		}
		var file;
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
		
		
		
		
	});//END 업로드 버튼 클릭 이벤트 처리
	
	
	

	
	//업로드 결과 출력
	var resultUL = $('.uploadResult ul');
	function showUploadedFile(result) {
		var tag="";
		
		
			$(result).each(function (i, obj) {
				
				//이미지는 파일명 표시
				//이미지 파일이 아니면 attach.png 표시 및 다운로드
				if(obj.image){
// 					tag += "<li>" + obj.fileName + "</li>"
					
					
					//공백이나 한글 등 인코딩 처리
					var thumbImg = encodeURIComponent(obj.upFolder + "/s_" + obj.uuid + "_" + obj.fileName);
					
					
					//썸네일 이미지 클릭 시 원본 이미지 표시
					
					var originalImg = obj.upFolder + "\\" + obj.uuid + "_" + obj.fileName;
					originalImg = originalImg.replace(new RegExp(/\\/g), "/");
// 					showOriginal(originalImg);
					tag += "<li><img  class='original' src='/display?fileName=" + thumbImg + "'><br>" + obj.fileName + "<input type='button' data-file='" + thumbImg + "' data-type='image' value='X'></li>";		
// 					tag += "<li><a href=\"javascript:showOriginal('" + originalImg + "')\"><img  class='original' src='/display?fileName=" + thumbImg + "'></a><br>" + obj.fileName + "</li>";		
// 						onclick=\"showOriginal(\'" + originalImg + "\')\"
					
					$(document).on('click', '.original', function(event) {
						
						showOriginal(originalImg);
				});
					
				} else {
					
					var filePath = encodeURIComponent(obj.upFolder + "/" + obj.uuid + "_" + obj.fileName);
					tag += "<li><a href='/download?fileName="  + filePath + "'><img src='/resources/img/attach.png'></a><br>" + obj.fileName + "<input type='button' data-file='" + filePath + "' data-type='file' value='X'></li>";
				}
				
				
			});//END each()
			resultUL.html(tag);
	}//END showUploadedFile()
	//END 업로드 결과 출력
	


	
	
	//썸네일 이미지 원본 표시
	
	function showOriginal(originImg) {
		$('.originImgDiv').css({"display" : "flex"}).show();
	
		$('.originImg').html("<img src='/display?fileName=" + originImg + "'>").animate({width:'100%', height:'100%'}, 1000);
// 		alert(originImg);
		
		
	
		
	}//END showOriginal()
	
	//썸네일 이미지 원본 클릭 이벤트 처리
	
						$(document).on('click', '.originImg', function(event) {
							$('.originImg').animate({width:'100%', height:'100%'}, 1000);
							$(this).slideUp(1000);
				});
	
	//END 썸네일 이미지 원본 클릭 이벤트 처리
	
	//X 표시 클릭 이벤트 처리
	resultUL.on('click', 'input', function() {
	
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
			alert(result);
// 			//파일 선택 초기화
// 			$("input[type='file']").val('');
			
			
			$(this).unwrap();
// 			$(this).unwrap();
			
			
			}
		});//END ajax()
	
	});//END X 표시 클릭 이벤트 처리
	
	
	</script>


</body>
</html>