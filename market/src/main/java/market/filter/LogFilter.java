package market.filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class LogFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private PrintWriter pw;
	private SimpleDateFormat dateFormat;
	
	public void init(FilterConfig fConfig) throws ServletException {
		//application.getRealPath()		↓
		//fConfig.getServletContext().getRealPath()
		
	
		dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss"); //날짜 시간 포맷 객체 생성
		String logPath = fConfig.getServletContext().getRealPath("/resources/log/"); //로그 파일 실제 저장 경로
		String logFile = getDateTime().substring(0, 10); //로그파일명(연도.월.일.log)
		
		try {
			FileWriter fw = new FileWriter(logPath + logFile + ".log", true); //로그파일을 추가 모드로 생성
			pw = new PrintWriter(fw, true); //fw를 auto flush 모드로 생성
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		
		
		
	}
	
	public void destroy() {
		//pw가 null이 아니라면 닫기
		if(pw != null) {
			pw.close();
			
		}
		System.out.println("- MARKET ACCESS LOGGING end - ");
	
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		//클라이언트의 접속 정보를 pw 파일에 기록
		long start = System.currentTimeMillis();
		pw.println("접속시간 : " + getDateTime());
		pw.println("클라이언트IP : " + req.getRemoteAddr());
		pw.println("요청 URL : " + req.getRequestURI());
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		pw.println("처리완료 : " + getDateTime());
		pw.println("소요시간 : " + (end-start)/1000.0 + "초");
		pw.println("--------------------------------------------");
	}

	public String getDateTime() {	//날짜와 시간을 반환
		return dateFormat.format(new Date());
	}

}
