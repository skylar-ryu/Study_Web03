package controller01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Message;

import service.MemberService;
import vo.MemberVO;

@WebServlet("/mupdate")
public class C06_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C06_Update() {
        super();
    }
// ** Member Join 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. request 처리
		// => parameter -> vo에 set
		// => 한글처리 (utf-8인 경우 get 방식에서는 안해도 되지만, post에서는 반드시 해야함)
		MemberService service = new MemberService();
		MemberVO vo = new MemberVO();
		String uri = "";
		String message = null;
		
		request.setCharacterEncoding("utf-8");		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		vo.setBirthd(request.getParameter("birthd"));
		vo.setPoint(Integer.parseInt(request.getParameter("point")));
		vo.setWeight(Double.parseDouble(request.getParameter("weight")));
		System.out.println("Update Test => "+vo);
		
		// 2. service
		if (service.update(vo) > 0) {
			// 수정성공 => List 출력
			message = "내 정보 수정이 완료되었습니다.";
			uri="/mlist";
			}else {
			// 수정실패 => message, 다시수정 (수정가능한 폼 출력/mdetail)
				message = "내정보 수정이 실패하였습니다. 다시 시도해주세요";
				uri="/mdetail";
		}
		
		// 3. View => forward
		request.setAttribute("message", message);
		request.getRequestDispatcher(uri).forward(request, response);
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
