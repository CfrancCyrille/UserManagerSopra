package com.ferrap.model;

public class User 
{

	private String Email;
	private String mdp;
	private String Pseudo;
	private String Salt;
	
	public String getSalt() {
		return Salt;
	}

	public void setSalt(String salt) {
		Salt = salt;
	}

	public User(String email, String mdp, String pseudo, String Salt) 
	{
		this.Email = email;
		this.mdp = mdp;
		this.Pseudo = pseudo;
		this.Salt = Salt;
	}
	
	public String getEmail() 
	{
		return Email;
	}
	public void setEmail(String email) 
	{
		Email = email;
	}
	public String getMdp() 
	{
		return mdp;
	}
	public void setMdp(String mdp) 
	{
		this.mdp = mdp;
	}
	public String getPseudo() 
	{
		return Pseudo;
	}
	public void setPseudo(String pseudo) 
	{
		Pseudo = pseudo;
	}
	

	
}
