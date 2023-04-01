package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberDao{
	Connection con;
	Statement st;
	PreparedStatement psmt;
	ResultSet rs;
	HashMap<String,Object> result = new HashMap<>();

	public MemberDaoH2Impl() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			System.out.println("DB 연결성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB연결중 에러");
		}
	}
	@Override
	public HashMap<String, Object> getMember(Integer id ) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
	
	
	public HashMap<String,Object> getMembers() {
		// TODO Auto-generated method stub
		String query = "slect * from member";
		try {
			List<MemberVO> list = new ArrayList<>();
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				MemberVO mem = new MemberVO();
				mem.setId(rs.getInt(1));
				mem.setName(rs.getString(2));
				mem.setPass(rs.getString(3));
				mem.setRegidate(rs.getDate(4));
				list.add(mem);
			}
			result.put("query",query);
			result.put("data", list);
			st.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String errMsg = (query+","+e.getMessage());
			int endIndex = Math.min(errMsg.length(), 255);
			errMsg = errMsg.substring(0, endIndex);
			result.put("errMsg", errMsg);
			e.printStackTrace();
			
		}
		return result;
		
	}

	@Override
	public HashMap<String, Object> addMember(MemberVO member) {
		// TODO Auto-generated method stub
		String query1 = "Insert into member (pass,name) values("+member.getPass()+member.getName()+");";
		try {
			String query = "Insert into member (pass,name) values( ?,?)";
			psmt= con.prepareStatement(query);
			psmt.setString(1, member.getPass());
			psmt.setString(2, member.getName());
			psmt.executeUpdate();
			
			result.put("query",query1 );
			result.put("data", member);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String errMsg = (query1+","+e.getMessage());
			int endIndex = Math.min(errMsg.length(), 255);
			errMsg = errMsg.substring(0, endIndex);
			result.put("errMsg", errMsg);
			e.printStackTrace();
			return result;

		}
	}

	@Override
	public HashMap<String, Object> updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> deleteMember(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
