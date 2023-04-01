package edu.pnu.service;

import java.util.List;
import edu.pnu.dao.LogDaoH2;
import edu.pnu.dao.MemberDao;
import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.domain.MemberVO;

public class Mission4Service {
	MemberDao mem = new MemberDaoH2Impl();
	LogDaoH2 logDao = new LogDaoH2();


	public List<MemberVO> getmembers() {
		//return mem.getMembers();
		System.out.println("DAO생성");
		@SuppressWarnings("unchecked")
		List<MemberVO> list = (List<MemberVO>) mem.getMembers().get("data");

//		if (list != null)	logDao.addLog("GET", "/member", true);
//		else				logDao.addLog("GET", "/member", false);
		if (mem.getMembers().get("data")!=null) {
			logDao.addLog("GET",mem.getMembers().get("query").toString(),true);
		}else {
			logDao.addLog("Get", mem.getMembers().get("errMsg").toString(), false);
		}
		
		return list;
	}

	public MemberVO addMember(MemberVO mem) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
