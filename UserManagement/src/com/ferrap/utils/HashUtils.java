package com.ferrap.utils;

import java.security.MessageDigest;
import java.util.Random;

public class HashUtils {
	
	public static String salt = "MONSALT";
	private static int MaxSalt = 10000;
	
	/*
	 * Method to hash a string
	 * @param value to hash
	 * @return a hash string
	 */
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
	
	/*
	 * method to get a random number between 0 and the MaxSalt constant
	 * @return Random integer
	 */
	public static String RandomSalt()
	{
		Random rnd = new Random();
		return String.valueOf(rnd.nextInt(MaxSalt));
	}

}
