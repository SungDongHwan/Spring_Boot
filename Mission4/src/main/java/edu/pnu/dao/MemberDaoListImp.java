package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImp implements MemberDao{
	Date now =  new Date();
	public MemberDaoListImp() {
		// TODO Auto-generated constructor stub
		List<MemberVO> list = new ArrayList<>();
		for(int i = 0; i<10;i++) {
			MemberVO mem = new MemberVO(i,"name"+i,"pass"+i,now);
		}
	}
	@Override
	public HashMap<String, Object> getMembers() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public HashMap<String, Object> getMember(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
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