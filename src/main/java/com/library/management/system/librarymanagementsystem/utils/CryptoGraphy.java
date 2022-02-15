package com.library.management.system.librarymanagementsystem.utils;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoGraphy {
    
    KeyStore keyStore=null;
	FileInputStream fileInputStream =null;
	Key key=null;
	
	// initalizing my key store file
	public CryptoGraphy() {
		try {
			keyStore=KeyStore.getInstance("JCEKS");
			fileInputStream=new FileInputStream("/media/suraj/HardDisk/spring/library-management-system/backend/src/main/resources/mykeystore.jks");
			keyStore.load(fileInputStream,"123456".toCharArray(	));
			key=keyStore.getKey("mykey","123456".toCharArray());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	// creating encryptionUsingAES
	private String encryptionUsingAES(String data,byte[] key) {
		String encryptionUsingAES=null;
		try {
			SecretKeySpec secKey=new SecretKeySpec(key, "AES");
			Cipher cipher=Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE,secKey);
			
			byte[] newBytes=cipher.doFinal(data.getBytes());
			
			encryptionUsingAES= Base64.getEncoder().encodeToString(newBytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return encryptionUsingAES;
	}
	
	// creating decryptionUsingAES
	private String decryptionUsingAES(String data,byte[] key) {
		String decryptionUsingAES=null;
		try {
			SecretKeySpec secKey=new SecretKeySpec(key, "AES");
			Cipher cipher=Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE,secKey);
			
			byte[] newBytes=cipher.doFinal(Base64.getDecoder().decode(data.getBytes()));
			
			decryptionUsingAES= new String(newBytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return decryptionUsingAES;
	}
	
	// encrypt data using AES
	public String setEncrpytedData (String password) {
		String getEncrpytedData=null;
		try {
			getEncrpytedData=encryptionUsingAES(password, key.getEncoded());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return getEncrpytedData;
	}
	// decrpt data using AES
	public String getDecrpytedData (String encryptedPassword) {
		String getDecrpytedData=null;
		try {
			getDecrpytedData=decryptionUsingAES(encryptedPassword, key.getEncoded());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return getDecrpytedData;
	}
}


