package controller01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.MemberVO;


@WebServlet("/mdetail")
public class C05_mDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C05_mDetail() {
        super();
    }

// ** Detail : MyInfo
// => My :Login member
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 준비
		// => vo.setId(누구) : session에서 가져옴
		MemberService service = new MemberService();
		MemberVO vo = new MemberVO();
		String uri = null;
		String message =null;
	
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("loginID") != null) {
			// 내정보 수정하기 가능
			// => service, memberDetail.jsp
			// 2. Service
			vo.setId((String)session.getAttribute("loginID"));
			vo=service.selectOne(vo);
			if (vo != null) {
				request.setAttribute("Apple", vo);
				
				// if(request.getParameter("jcode").equals("U"))
				// "jcode"가 없는 경우 NullPointeExcepiton 발생
				// =>예방차원에서 아래처럼 비교
				
				if ("U".equals(request.getParameter("jcode")))
					 uri = "/member/updateForm.jsp";
				else uri = "/member/memberDetail.jsp";
			}else {
				message = "Detail NotFound 재로그인 후 이용하세요";
			}	
		}else {
			//로그인 후 이용하세요 
			// => loginForm.jsp
			message ="Session NotFound 로그인 후 이용하세요"	;
		}
		// 3. View
		if ( message != null) request.setAttribute("message", message);
		request.getRequestDispatcher(uri).forward(request, response);
		
		
		
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
