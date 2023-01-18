<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mdao" class="market.dao.MemberDAO"/>
<jsp:useBean id="mvo" class="market.vo.MemberVO"/>
<jsp:setProperty property="*" name="mvo"/>
<jsp:setProperty property="con" value="${con }" name="mdao"/>

<%//memberProc.jsp---------------------------
	String cmd = request.getParameter("cmd");
	//파라미터의 cmd의 값에 따라
	
	String sid = (String)session.getAttribute("sid");
	
	if(cmd.equals("modFrm")) {	// modFrm : 회원정보 표시 화면
		mvo = mdao.selectMember(sid);
		request.setAttribute("mvo", mvo);
		pageContext.forward("memberModify.jsp");//   		memberModify.jsp로 이동
	}
	
// 	if(cmd.equals("mod")) {	// mod : 회원정보 수정 처리
// 		if(mdao.updateMember(mvo) == true) {
// 			response.sendRedirect("../common/messages.jsp?msg=modOk");
// 		}else {
// 			response.sendRedirect("../common/messages.jsp?msg=modFail");
// 		}
// 	}
	
	
// 	if(cmd.equals("rem")) {	// rem : 회원탈퇴 처리
// 		if(mdao.deleteMember(sid) == true) {
// 			response.sendRedirect("../common/messages.jsp?msg=remOk");
// 		}else {
// 			response.sendRedirect("../common/messages.jsp?msg=remFail");
// 		}
// 	}
	
%>