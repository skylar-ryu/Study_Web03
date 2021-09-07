package controller01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.MemberVO;

@WebServlet("/login")
public class C01_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C01_Login() {
        super();
    }
 // ** Login
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ** 준비
		MemberService service = new MemberService();
		MemberVO vo = new MemberVO();
		String uri = "/member/loginForm.jsp";
		String message = "";
		// 1. Parameter 처리
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 2. Service
		// => id 가 맞는지 , password 가 맞는지
		// => 성공 : index
		//    실패 : loginForm 으로 재로그인 유도
		vo.setId(id);
		vo = service.selectOne(vo);
		if (vo!=null) {
			// password 확인
			// => password 와 vo.getPassword() 비교
			if ( vo.getPassword().equals(password)) {
				// 로그인 성공
				// => 로그인 정보 보관, index 로
				request.getSession().setAttribute("loginID",id);
				request.getSession().setAttribute("loginName",vo.getName());
				uri = "/index.jsp";
			}else {
				// password 오류 
				message = "비밀번호 오류입니다. 다시 시도하세요." ;
			}
		}else {
			// id 오류
			message = "아이디 오류입니다. 다시 시도하세요" ;
		}
		// 3. View 처리 : forward
		if (message != null) request.setAttribute("message", message);
		request.getRequestDispatcher(uri).forward(request, response);
	
	} //doGet
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
} //class
