package com.mustafaarslanMySQL.Util;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class VeritabaniUtil {

	static Connection conn=null;
	
	public static Connection Baglan() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/arac_otopark","root","mysql");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
			// TODO: handle exception
		}
	}
	public static String MD5(String icerik) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encryption =md.digest(icerik.getBytes());
            BigInteger no = new BigInteger(1,encryption);
            String hash = no.toString(16);
            while(hash.length()<32) {
                hash="0"+hash;
            }
            return hash;
        } catch (NoSuchAlgorithmException e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
        
    }
}
