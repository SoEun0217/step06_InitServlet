package ex1020.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {
	
	String id,addr;
	String fileName,driverName;
	//init-param으로 들어오는 값들을 init메소드에서 받아준다. service에서 받아도 되지만 요청이들어올때마다 계속받아야함
	//한번만 받아도되므로 효율적으로 init을 쓰자
	@Override
	public void init() throws ServletException {
		//init-param 정보 받기
		id=super.getInitParameter("id");
		addr=super.getInitParameter("addr");
		
		//context-param정보 가져오기
		ServletContext application=super.getServletContext();
		fileName=application.getInitParameter("fileName");
		driverName=application.getInitParameter("driverName");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service....");
		System.out.println(id+" , "+addr);
		System.out.println(fileName+" , "+driverName);
		
	}
	
}
