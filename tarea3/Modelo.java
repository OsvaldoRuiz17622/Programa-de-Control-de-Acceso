package tarea3;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Modelo {
	
	Vista v = new Vista();
	
	public String convertirSHA256 (String password) {
		
		MessageDigest md = null;
		try {
			
			md = MessageDigest.getInstance("SHA-256");
			
		}catch(NoSuchAlgorithmException e) {
			System.out.print("error" + e.getMessage());
			return null;
		}
		
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		
		for (byte b : hash) {
			sb.append(String.format("%02x", b));
			
		}
		
		
		return sb.toString();
	}

	
}
