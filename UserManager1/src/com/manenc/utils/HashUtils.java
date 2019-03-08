package com.manenc.utils;

import java.security.MessageDigest;
import java.util.Random;

public class HashUtils {
	
	public static String salt = "MONSALT";
	private static int MaxSalt = 10000;
	
	public static String HashString(String value)
	{
		try 
		{
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(value.getBytes());
			String encryptedString = new String(messageDigest.digest());
			
			return encryptedString;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "";	
	}
	
	public static String RandomSalt()
	{
		Random rnd = new Random();
		return String.valueOf(rnd.nextInt(MaxSalt));
	}

}
