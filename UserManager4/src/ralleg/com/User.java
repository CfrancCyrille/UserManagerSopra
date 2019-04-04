package ralleg.com;

public class User {

	String name;
	String email;
	String pwd1;

	public User(String name, String email, String pwd1) {
		this.name = name;
		this.email = email;
		this.pwd1 = pwd1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}

}
