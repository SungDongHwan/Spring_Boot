package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Person;
import edu.pnu.service.BoardService;
import lombok.extern.slf4j.Slf4j;
@RestController
public class BoardController {
	public BoardController() {
		System.out.println("==>BoardController 생성");
		
	BoardService boardService;// = new BoardService();
	}
	@PostMapping("/hello")
	public String hello1(String name) {
		return "Hello Post: " +name;
	}
	@GetMapping("/getPerson")
	public Person getPerson() {
		return new Person("홍길동",20,"백수","도둑질하기");
	}

	@GetMapping("/getPersons")
	public BoardService getPersons() {
		return boardService;
	}
}
