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
	//init-param���� ������ ������ init�޼ҵ忡�� �޾��ش�. service���� �޾Ƶ� ������ ��û�̵��ö����� ��ӹ޾ƾ���
	//�ѹ��� �޾Ƶ��ǹǷ� ȿ�������� init�� ����
	@Override
	public void init() throws ServletException {
		//init-param ���� �ޱ�
		id=super.getInitParameter("id");
		addr=super.getInitParameter("addr");
		
		//context-param���� ��������
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
