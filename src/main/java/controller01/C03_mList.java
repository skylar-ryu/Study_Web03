package controller01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.MemberVO;

@WebServlet("/mlist")
public class C03_mList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C03_mList() {
        super();
    }

    // ** MemberList
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.준비 
		MemberService service = new MemberService();
		List<MemberVO> list = new ArrayList<>();
		String uri ="/member/memberList.jsp";
		String message = null;
		// 2. Service
		list = service.selecList();
		if (list != null) {
			request.setAttribute("Banana", list);
			}else {
				message = "조회 결과 출력할 자료가 없습니다";
			}		
		// 3. View 처리 :forwoard
		if (message != null) request.setAttribute("message", message);
		request.getRequestDispatcher(uri).forward(request, response);
	}//doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
