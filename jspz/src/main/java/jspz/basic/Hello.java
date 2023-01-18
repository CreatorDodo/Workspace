package jspz.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello.do")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");						//수신 데이터 한글 처리
		response.setContentType("text/html; charset=UTF-8");		//송신 데이터 한글 처리
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter(("age"))); 
		
		System.out.println(name);		
		System.out.println(age);		
				
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello world!~</title><head>");
		out.println("<body>");
		out.printf("<h1>Hello world!~</h1>");
		out.println("이름 : " + name);
		out.println("<br>나이 : " + age);
		out.print("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		doGet(request, response);
	}

}
