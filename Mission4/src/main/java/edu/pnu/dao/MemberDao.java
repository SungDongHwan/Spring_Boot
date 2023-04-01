package edu.pnu.dao;

import java.util.HashMap;
import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberDao{

	HashMap<String, Object> getMembers();

	HashMap<String, Object> getMember(Integer id);

	HashMap<String, Object> addMember(MemberVO member);

	HashMap<String, Object> updateMember(MemberVO member);

	HashMap<String, Object> deleteMember(Integer id);

}