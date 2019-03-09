package com.ala.servelet;

public class PUser {
	public PUser(String email, String nom, String pwd) {
		PUser.email = email;
		PUser.nom = nom;
		PUser.pwd = pwd;
	}
	public static String email;
	public static String nom;
	public static String pwd;
	
	public static String getPwd() {
		return pwd;
	}
	
	public static void setPwd(String pwd) {
		PUser.pwd = pwd;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		PUser.email = email;
	}
	public static String getNom() {
		return nom;
	}
	public static void setNom(String nom) {
		PUser.nom = nom;
	}
	
}
