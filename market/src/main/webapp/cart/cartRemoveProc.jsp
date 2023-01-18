<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="market.vo.ProductVO"%>
<jsp:useBean id="pdao" class="market.dao.ProductDAO" />
<%
//cartRemoveProc.jsp--------------------------------------
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");

//1.요청객체에서 pid를 가져오기
String pid = request.getParameter("pid");

if (pid.equals(null) || pid.equals("")) { //2.pid가 없으면 상품 목록으로 돌아가기
	response.sendRedirect("../product/productList.jsp");
}
List<ProductVO> cartList = (ArrayList<ProductVO>) session.getAttribute("cartList");//3.세션에서 장바구니 목록 속성 cartList 꺼내기

for (int i=0; i<cartList.size(); i++) {
	ProductVO cartPvo = cartList.get(i);
	if (cartPvo.getPid().equals(pid)) {//4.pid가 장바구니 목록에 존재하는 경우 장바구니에서 지우기
		cartList.remove(cartPvo);
	}
}

//5.장바구니 목록으로 돌아가기
response.sendRedirect("cart.jsp");
%>


