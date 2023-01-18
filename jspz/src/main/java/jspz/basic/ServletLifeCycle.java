package jspz.basic;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle.do")
public class ServletLifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int initCnt;
	int serviceCnt;
	int destroyCnt;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletLifeCycle init() : " + ++initCnt);
	}

	public void destroy() {
		System.out.println("ServletLifeCycle destroy() : " + ++destroyCnt);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletLifeCycle service() : " + ++serviceCnt);
	}

}
