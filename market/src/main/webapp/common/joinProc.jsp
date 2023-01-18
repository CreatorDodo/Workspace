<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	//joinProc.jsp

	//액션태그를 이용하여 MemberDAO 및 MemberVO 객체 mdao, mvo 생성
	//파라미터로 전달된 데이터(photo 제외)를 mvo에 저장한 후
	//회원 추가 메소드 호출하여 가입 처리를 하고
	//messages.jsp 페이지로 이동
	//단, 회원 등록에 성공한 경우 msg 파라미터에 joinOK를 저장
	//단, 회원 등록에 실패한 경우 msg 파라미터에 joinFail를 저장하여
	//	messages.jsp 페이지에서 적절한 메시지가 표시되도록 처리
	
%>

<jsp:useBean id="mdao" class="market.dao.MemberDAO"/>
<jsp:useBean id="mvo" class="market.vo.MemberVO"/>
<jsp:setProperty property="*" name="mvo"/>
<jsp:setProperty property="con" value="${con }" name="mdao"/>

<%	
	if( mdao.insertMember(mvo) == true ) {	
		response.sendRedirect("messages.jsp?msg=joinOK");	
	}else { //그렇지 않으면
		
		response.sendRedirect("messages.jsp?msg=joinFail");	
	}
	
%>

