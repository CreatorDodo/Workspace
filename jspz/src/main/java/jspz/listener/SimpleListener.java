package jspz.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
//웹어플리케이션 시작 또는 종료 시점에 수행할 작업 처리
//- 초기화 및 자원 반납 등
public class SimpleListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {


    public SimpleListener() {
    	System.out.println("SimpleListener SimpleListener()");
    }

    public void sessionCreated(HttpSessionEvent se)  {
    	System.out.println("SimpleListener sessionCreated()");
    }


    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("SimpleListener requestDestroyed()");
    }


    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("SimpleListener requestInitialized()");
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("SimpleListener sessionDestroyed()");
    }


    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("SimpleListener contextDestroyed()");
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("SimpleListener contextInitialized()");

    }
	
}
