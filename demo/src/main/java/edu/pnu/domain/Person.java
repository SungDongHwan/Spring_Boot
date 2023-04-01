package edu.pnu.domain;

public class Person {
	
	private String name;
	private int age;
	private String job;
	private String hobby;
	public Person(String name, int age, String job, String hobby) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.hobby = hobby;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + ", hobby=" + hobby + "]";
	}
	
}
