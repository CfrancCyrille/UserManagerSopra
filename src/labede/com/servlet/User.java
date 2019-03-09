package labede.com.servlet;

public class User {
	
	private long id;
	private String name;
	private String email;
	private String password;
	
	public User(long id, String name, String email, String pwd) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = pwd;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password =  password;
	}
	
}
