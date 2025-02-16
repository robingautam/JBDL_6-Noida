package springmvc.controller;

public class User {
	String username;
	String password;
	String age;
	public User(){}
	public User(String username, String password, String age) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
