package cfranc.com.bean;

public class User {

	private String Email;
	private String Pwd;
	private String Name;
	
	public User(String name2, String email2, String pwd12) {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return this.Email;
	}

	public String getPwd() {
		return this.Pwd;
	}

	public String getName() {
		return this.Name;
	}

	public void setEmail( String Email ) {
		this.Email = Email;
	}
	
	public void setPwd (String Pwd ) {
		this.Pwd= Pwd;
	}
	
	public void setName( String Name ) {
		this.Name = Name;
	}
	
}
