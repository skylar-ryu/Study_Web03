package controller01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxNotice.SessionStateChangedOrBuilder;

@WebServlet("/logout")
public class C02_Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C02_Logout() {
        super();
    }

    // ** Login
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ** session 인스턴스 정의 후 삭제하기 
		// => 매개변수 : 없거나, True , false
		// => false : session 이 없을 때 null을 return 
		HttpSession session = request.getSession();
		if (session != null) session.invalidate();		
		String uri = "/index.jsp";		
		request.getRequestDispatcher(uri).forward(request, response);
	}//doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
