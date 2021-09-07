package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.MemberVO;

// ** DAO (Data Access Object)
// => CRUD 구현
public class MemberDAO {
	// ** 전역변수 정의
	Connection cn = DBConnection.getConnection();
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	String sql;	
	
	// ** selectList
	public List<MemberVO> selectList() {
		sql = "select * from member";
		List<MemberVO> list = new ArrayList<>();
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			// 출력자료가 있는지 확인 
			if (rs.next()) {
				do {
					MemberVO vo = new MemberVO();
					vo.setId(rs.getString(1));
					vo.setPassword(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setLev(rs.getString(4));
					vo.setBirthd(rs.getString(5));
					vo.setPoint(rs.getInt(6));
					vo.setWeight(rs.getDouble(7));
					list.add(vo);				
				} while (rs.next());
			}else {
				System.out.println("** selectList() : 출력자료가 없습니다.");
				list=null;
			}			
		} catch (Exception e) {
			System.out.println("** selectList() Exception => "+e.toString());
			list=null;
		}
		return list;
	}
	
	// ** selectOne
	public MemberVO selectOne(MemberVO vo) {
		sql="select * from member where id=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			rs =pst.executeQuery();
			// 결과 확인
			if (rs.next()) {
				vo.setPassword(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setLev(rs.getString(4));
				vo.setBirthd(rs.getString(5));
				vo.setPoint(rs.getInt(6));
				vo.setWeight(rs.getDouble(7));
			}else {
				System.out.println("** 해당하는 자료가 없습니다.");
				vo = null;
			}
		} catch (Exception e) {
			System.out.println("** selectOne Exception => "+e.toString());
			vo = null;
		}
		return vo;
	}
	
	// ** Join : insert
	public int insert(MemberVO vo){
		sql="insert into member value(?,?,?,?,?,?,?)";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getId());
			pst.setString(2,vo.getPassword());
			pst.setString(3,vo.getName());
			pst.setString(4,vo.getLev());
			pst.setString(5,vo.getBirthd());
			pst.setInt(6,vo.getPoint());
			pst.setDouble(7,vo.getWeight());
			return pst.executeUpdate();			
		} catch (Exception e) {
			System.out.println("** Insert Exception => "+e.toString());
			return 0;
		}
	}//insert
	
	// ** update
	// => pkey 일반적으로 수정하지 않음
	public int update(MemberVO vo) {
		sql ="update member set password=?, name=?, lev=?, birthd=?, point=?, weight=? where id=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getPassword());
			pst.setString(2,vo.getName());
			pst.setString(3,vo.getLev());
			pst.setString(4,vo.getBirthd());
			pst.setInt(5,vo.getPoint());
			pst.setDouble(6,vo.getWeight());
			pst.setString(7,vo.getId());
			return pst.executeUpdate();			
		} catch (Exception e) {
			System.out.println("** Update Exception => "+e.toString());
			return 0;
		}
	}//update
	
	// ** delete
	public int delete(MemberVO vo) {
		sql="delete from member where id=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1,vo.getId());
			return pst.executeUpdate();		
		} catch (Exception e) {
			System.out.println("** Delete Exception => "+e.toString());
			return 0;
		}
	}//delete 
}//class
