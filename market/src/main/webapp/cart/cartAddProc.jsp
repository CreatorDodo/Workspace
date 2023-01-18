<%@page import="javax.websocket.Session"%>
<%@page import="java.util.*"%>
<%@page import="market.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="pdao" class="market.dao.ProductDAO" />
<%
//cartAddProc.jsp--------------------------------------
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");

//1.요청객체에서 pid를 가져오기
String pid = request.getParameter("pid");
// String sessionCart = session.getAttribute("cartList");
if (pid.equals(null) || pid.equals("")) { //2.pid가 없으면 상품 목록으로 돌아가기
	response.sendRedirect("../product/productList.jsp");
	return;
}
ProductVO pvo = pdao.selectProduct(pid);//3.product 테이블에서 해당 상품 하나 가져오기
if (pvo == null) {
	response.sendRedirect("../error/noPidException.jsp");//4.가져온 상품이 없다면 오류 페이지로 보내기
}

List<ProductVO> cartList = (ArrayList<ProductVO>) session.getAttribute("cartList");//5.세션에서 장바구니 목록 속성 cartList 꺼내기

boolean newPvo = true;
if (cartList == null) { //6.장바구니 목록 cartList이 없거나
	cartList = new ArrayList<ProductVO>(); //List타입의 새 장바구니 목록을 생성하여 세션에 담기
	session.setAttribute("cartList", cartList);
} else { //7.그렇지 않으면
	for (ProductVO cartPvo : cartList) {
		if (cartPvo.getPid().equals(pid)) {//		pid가 장바구니 목록에 존재하면 수량 1 증가
				cartPvo.setQuantity(cartPvo.getQuantity() + 1);
				newPvo = false;
		}
		
	}
}

if(newPvo){	//존재하지 않는 경우에는 장바구니에 추가
	pvo.setQuantity(1);
	cartList.add(pvo);
}

//8.상품상세 페이지로 이동
response.sendRedirect("../product/productInfo.jsp?pid=" + pid);

%>

