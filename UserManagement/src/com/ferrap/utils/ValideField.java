package com.ferrap.utils;

public class ValideField 
{
	/*
	 * Valide the format of the Email
	 * @param Email value
	 * @return error message
	 */
	public static String ValidateEmail(String email) 
	{
		String response = "";
		if ( email != null && email.trim().length() != 0 ) 
		{
			if (!email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) 
			{    
				response = "Veuillez saisir une adresse mail valide"; 
			} 
		}
		else 
		{
			response = "L'adresse mail est obligatoire";
		}
		return response;
	}
	
	/*
	 * Valide if the two password is equals
	 * @param Password and confirm password
	 * @return error message
	 */
	public static String ValidatePassword(String pwd1, String pwd2)
	{
		String response = "";
		 if(pwd1 == null || pwd1.length() < 3) 
		 {
			 response = "mot de passe invalide";
		 }
		 else if(!pwd1.equals(pwd2))
		 {
			 response = "Les deux mot des passes ne sont pas identiques";
		 }
		return response;
	}
	
	public static String ValidatePseudo(String name)
	{
		return "";
	}
}
