package jspz.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/member/*")
public class MemberFilter extends HttpFilter implements Filter {


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		//로그인 하지 않은 경우
		if(session.getAttribute("sid") == null || session == null) {
		//요청 객체의 msg 속성에 '회원전용메뉴입니다.'를 저장하고
		request.setAttribute("msg", "회원전용메뉴입니다.");
			//로그인 페이지로 포워딩
			RequestDispatcher disp = req.getRequestDispatcher("/common/login.jsp");
			disp.forward(req, res);
		}else {//그렇지 않은 경우
		chain.doFilter(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
