package service;

import java.util.List;

import util.MemberDAO;
import vo.MemberVO;

public class MemberService {
	
	MemberDAO dao = new MemberDAO();
	public List<MemberVO> selecList() {
		return dao.selectList();
	}//selectList()
	
	public MemberVO selectOne(MemberVO vo) {
		return dao.selectOne(vo);
	}
	
	public int insert(MemberVO vo) {
		return dao.insert(vo);
	}
	public int update(MemberVO vo) {
		return dao.update(vo);
	}
	public int delete(MemberVO vo) {
		return dao.delete(vo);
	}

}//class
