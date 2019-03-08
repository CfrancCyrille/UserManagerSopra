package adel.com.servlet;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class User implements Serializable{
	private String name;
	private String email;
	private String password;
	private String salt;
	
	public User(String c_name, String c_mail, String c_password, String c_salt) {
		this.name = c_name;	
		this.email = c_mail;
		this.password = c_password;
		this.salt = c_salt;
	}
	
	public User() {
		super();
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String hash (String str) throws NoSuchAlgorithmException {
		MessageDigest mdp = MessageDigest.getInstance("MD5");
	    mdp.update(str.getBytes());
	    byte[] digest = mdp.digest();
	    str = DatatypeConverter.printHexBinary(digest).toUpperCase();
	    return str;
	}
}
