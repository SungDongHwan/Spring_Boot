package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.Mission3Service;

@RestController
public class Mission3Controller {
	Mission3Service mission3service = new Mission3Service(); 
	public Mission3Controller() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/member/{id}")
	public MemberVO getmember( @PathVariable Integer id){
		return mission3service.getmember(id);
	}
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return mission3service.getmembers();
	}
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		System.out.println(member);
		return mission3service.addmember(member);
	}

	@PutMapping("/member")
	public MemberVO updatemember(MemberVO member) {
		return mission3service.updatemember(member);
	}
	@DeleteMapping("/member/{id}")
	public boolean deletemember(@PathVariable Integer id) {
		return mission3service.deletemember(id);
	}
	
}
