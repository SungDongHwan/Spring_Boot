package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberDao {
	Date now = Calendar.getInstance().getTime();
	private List<MemberVO> list = new ArrayList<>();

public MemberDaoListImpl() {
	// TODO Auto-generated constructor stub
	list.add(new MemberVO(1, "pass1", "김김김",now));
	list.add(new MemberVO(2, "pass2", "이이이",now));
	list.add(new MemberVO(3, "pass3", "삼삼삼",now));

}
	@Override
	public List<MemberVO> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO getMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id)
				return m;
		}
		System.out.println("검색하신 id가 없습니다.");
		return null;
	}

	@Override
	public MemberVO addMember(MemberVO member) {
		if (getMember(member.getId()) != null) {
			System.out.println("이미 있는 id 입니다.");
			return null;
		}
		list.add(member);
		return member;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		for (MemberVO m : list) {
			if (m.getId() == member.getId()) {
				m.setName(member.getName());
				m.setPass(member.getPass());
				m.setRegidate(now);
				return m;
			}
		}
		return null;
	}

	@Override
	public boolean deleteMember(Integer id) {
		for (int i = 0; i < list.size(); i++) {
			MemberVO m = list.get(i);
			if (m.getId() == id) {
				list.remove(i);
				return true;
			}
			System.out.println("삭제할 id 가 존재하지 않습니다.");
		}
		return false;
	}
}


	