package controller01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Message;

import service.MemberService;
import vo.MemberVO;

@WebServlet("/mdelete")
public class C07_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C07_Delete() {
        super();
    }
// ** Member Join 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 준비
		MemberService service = new MemberService();
		MemberVO vo = new MemberVO();
		String uri = "";
		String message = null;
		
		// => 삭제 대상 -> vo 에 set
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("loginID") !=null) {
			// 삭제 가능 => message 출력, index.jsp
			vo.setId((String)session.getAttribute("loginID"));
			
			if (service.delete(vo) > 0) {
				// 삭제성공
				message="회원탈퇴가 성공적으로 진행되었습니다. 한달후 재가입 가능합니다.";
				session.invalidate(); //세션삭제
			}else { // 삭제 실패
				message = "회원탈퇴에 실패하였습니다. 다시 시도해주세요";
			}
			uri="/index.jsp";
		}else {
			// 삭제불가능 => message, loginForm.jsp
		}
		
		// 3. View => forward
		request.setAttribute("message", message);
		request.getRequestDispatcher(uri).forward(request, response);
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
