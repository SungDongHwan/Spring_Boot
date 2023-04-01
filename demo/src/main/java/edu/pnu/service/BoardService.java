package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Person;
@Service
public class BoardService {

	private List<Person> list = new ArrayList<>();
	
	public BoardService() {
		list.add(new Person("홍길동",20,"백수","도둑질하기"));
		list.add(new Person("홍이동",20,"백수","도둑질하기"));
		list.add(new Person("홍삼동",20,"백수","도둑질하기"));
	}
	public List<Person> getPersons(){
		return list;
	}
}
