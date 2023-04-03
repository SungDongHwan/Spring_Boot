package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient {
	
	public static void insertboard (EntityManagerFactory emf , EntityManager em) {

		for(int i=0;i<11;i++) {
			Board board = new Board();
			board.setTitle("JPA제목" +i);
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요."+i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			em.persist(board);

		}
		
	}
	
	public static void main(String[] args) {
	//EntityManager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter4");
		EntityManager em = emf.createEntityManager();
		//Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();
//			board.setTitle("JPA 제목");
//			board.setWriter("관리자");
//			board.setContent("JPA 글 등록 잘 되네요.");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
			insertboard(emf, em);
			//글등록
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exceptions
			e.printStackTrace();
			// transaction rollback
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
}
