package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberDao {
	Connection con;
	PreparedStatement psmt;
	Statement st;
	ResultSet rs;
	public MemberDaoH2Impl() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot","sa","");
			System.out.println("DB 연결 성공");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<MemberVO> getMembers() {
		// TODO Auto-generated method stub
		List<MemberVO> list = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from member");
			while(rs.next()) {
			MemberVO mem = new MemberVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
			list.add(mem);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public MemberVO getMember(Integer id) {
		// TODO Auto-generated method stub
		try {
			String query = "select * from member where id = ?";
			psmt= con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			rs.next();
			MemberVO mem = new MemberVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4));
			return mem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
//	private int Maxid() {
//		int id =0;
//		
//		return id;
//	}
	@Override
	public MemberVO addMember(MemberVO member) {
		// TODO Auto-generated method stub	
		try {
			String query = "Insert into member(name,pass) values(?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getPass());
			psmt.executeUpdate();
			return member;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		try {
			String query = "UPDATE MEMBER SET PASS=? ,NAME=? , REGIDATE= Current_timestamp WHERE ID=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getPass());
			psmt.setString(2, member.getName());
			psmt.setInt(3, member.getId());
			psmt.executeUpdate();
			return getMember(member.getId()); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean deleteMember(Integer id) {
		// TODO Auto-generated method stub
		try {
			String query = "delete from member where id = ?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			psmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String err = e.getMessage();
		}
		return false;
	}

}
