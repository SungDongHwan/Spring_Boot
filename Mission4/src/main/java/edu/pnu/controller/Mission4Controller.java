package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.Mission4Service;

@RestController
public class Mission4Controller {
	
	Mission4Service mission4service = new Mission4Service();
	public Mission4Controller() {
		// TODO Auto-generated constructor stub
	}
	@GetMapping("/member")
	public List<MemberVO> getmembers(){
		System.out.println("컨트롤러 생성");
		return mission4service.getmembers();
	}
	@PostMapping("/member")
	public MemberVO addMember(MemberVO mem) {
		return mission4service.addMember(mem);
	}
	
}
