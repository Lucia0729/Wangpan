package com.lxwp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	public final String MD5 = "MD5";

	public String MD5FromString(String mdStr) {
		// TODO Auto-generated catch block
		StringBuffer result = new StringBuffer();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(MD5);
			md.update(mdStr.getBytes());
			byte[] bytes = md.digest();
			for (byte aByte : bytes) {
				String s = Integer.toHexString(0xff & aByte);
				if (s.length() == 1) {
					result.append("0" + s);
				} else {
					result.append(s);
				}
			}
			return result.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}catch(NullPointerException e){
			e.printStackTrace();
			return null;
		}
	}

	// public static void main(String[] args) throws Exception {
	// // TODO Auto-generated method stub
	// MD5FromString("admin");
	// }

}
