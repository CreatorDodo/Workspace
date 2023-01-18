/** 자바 스크립트를 하나의 모듈처럼 구성
 * 
 	모듈 패턴
 	관련 함수들을 하나의 모듈처럼 묶음으로 구성
 	자바스크립트의 즉시 실행 함수와 { }을 이용하여 객체 구성
 	- ( ) 안에 함수를 선언하고
 	  바깥 쪽에서 실행
 	  >> 실행 결과가 바깥 쪽에 선언된 변수에 할당됨
 */
 
 console.log('reply.js..........')
 
 var replyService = ( function(){ 
 	//즉시 실행 함수
 	
 	function register(rvo, callback){
 		console.log('reply register()');
 		$.ajax({
 			type : 'post',
 			url  : '/replies/register',
 			data : JSON.stringify(rvo),
 			contentType : 'application/json; charset=UTF-8',
 			success : function(result){
 				if(callback){
 					callback(result);
 				}
 			
 			},
 			error : function(err){
 				if(error){
 					error(err);
 				}
 			
 			}
 		});//END ajax()
 		
 		}//END register()
 	
 	function list(param, callback, error) {
 		console.log('reply list()');
 		
 		$.getJSON('/replies/list/' + param.bno + '/' + param.pageNum + '.json',
 				function(result) {
 				if(callback) {
 					callback(result.totalReply, result.list);
 				}				//전체 댓글 수		 댓글 목록
 			}
 			).fail(function(err) {
 				if(error) {
 					error(err);
 				}
 			});//END getJSON
 	}//END list()
 	
 	function modify(rvo, callback, error){
 		console.log('reply modify()');
 		$.ajax({
 			type : 'put',
 			url  : '/replies/' + rvo.rno,
 			data : JSON.stringify(rvo),
 			contentType : 'application/json; charset=UTF-8',
 			success : function(result){
 				if(callback){
 					callback(result);
 				}
 			
 			},
 			error : function(err){
 				if(error){
 					error(err);
 				}
 			
 			}
 		});//END ajax()
 		
 		}//END modify()
 	
 	function remove(rno, callback, error){
 		console.log('reply remove()');
 		$.ajax({
 			type : 'delete',
 			url  : '/replies/' + rno,
 			success : function(result){
 				if(callback){
 					callback(result);
 				}
 			
 			},
 			error : function(err){
 				if(error){
 					error(err);
 				}
 			
 			}
 		});//END ajax()
 		
 		}//END remove()
 	
 		 	function view(rno, callback, error) {
 		console.log('reply view()');
 		
 		$.get('/replies/' + rno + '.json',
 				function(result) {
 				if(callback) {
 					callback(result);
 				}
 			}
 			).fail(function(err) {
 				if(error) {
 					error(err);
 				}
 			});//END get
 	}//END view()
 	
 	//댓글 작성일시 표시
 	
 	
 	function display(regDate){
 		console.log('display()');
 		
 		var rDate = new Date(regDate);
 		var yy = rDate.getFullYear();
 		var mm = rDate.getMonth();
 		var dd = rDate.getDate();
 		
 		var today = new Date();
 		
 		if(today.getFullYear() == yy &&
 			today.getMonth() == mm &&
 			today.getDate() == dd){
 		//- 당일 작성한 댓글은 '시:분:초' 반환
 		 return rDate.getHours() + ":" +
	       rDate.getMinutes() + ":" +	
	       rDate.getSeconds();
	     //- 이전 작성한 댓글은 '연/월/일' 반환
	     }else{
		return yy + "/" + (mm+1) + "/" + dd;
		}
 		
 		}//END display()
 	
 	
 	return { display : display, register : register, list : list, modify : modify, remove : remove, view : view };
 	})();
 
 //외부에서는
 //replyService.add(객체, 콜백함수) 형태로 호출
 
 
 
 
 
 
 
 
 
 
 