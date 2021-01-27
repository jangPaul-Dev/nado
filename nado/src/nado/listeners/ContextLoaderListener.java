package nado.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import nado.context.ApplicationContext;



public class ContextLoaderListener {

static ApplicationContext applicationContext;
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void contextDestroyed(ServletContextEvent sce) {
		try {
			System.out.println("contextDestroyed");
			// 우리가 DataSource 객체를 해제하지 않아도
			// tomcat 서버가 알아서 해제한다
		}catch(Exception e) {
			e.printStackTrace();
		}		

	}

	public void contextInitialized(ServletContextEvent sce) {
		try {
			System.out.println("contextInitialized");
			ServletContext sc = sce.getServletContext();

			String propertiesPath = sc.getRealPath(
					sc.getInitParameter("contextConfigLocation"));

			applicationContext = new ApplicationContext(propertiesPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
