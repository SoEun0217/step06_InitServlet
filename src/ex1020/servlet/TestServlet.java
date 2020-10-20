package ex1020.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 * 
 * web.xml������
 * <servlet></servlet>
 * <servlet-mapping></servlet-mapping>
 * 
 */
@WebServlet(
		urlPatterns = { "/test" }, 
		initParams = { 
				@WebInitParam(name = "message", value = "������������")
		})
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message, id;
	String fileName,driverName;
	public void init(ServletConfig config) throws ServletException {
		message=config.getInitParameter("message");
		id=config.getInitParameter("id");
		
		//context-param���� ��������
			ServletContext application=config.getServletContext();
			fileName=application.getInitParameter("fileName");
			driverName=application.getInitParameter("driverName");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("message");
		PrintWriter out=response.getWriter();
		out.println("message : "+message);
		out.println("id : "+id);
		out.println(fileName +" , "+driverName);
	}

}
