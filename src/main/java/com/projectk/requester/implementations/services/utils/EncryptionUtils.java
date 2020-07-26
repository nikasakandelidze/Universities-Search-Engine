package com.projectk.requester.implementations.services.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtils {

	public static String encodeSHA1(String pass) {
		String encodedPass = null;
		if (pass != null) {
			byte[] password = pass.getBytes();
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				password = md.digest(password);
			} catch (NoSuchAlgorithmException ex) {
				throw new IllegalStateException("NoSuchAlgorithmException: SHA-1");
			}

			StringBuilder str = new StringBuilder();
			for (byte p : password) {
				str.append(Integer.toHexString((p & 0xf0) >> 4));
				str.append(Integer.toHexString(p & 0x0f));
			}
			encodedPass = str.toString();
		}
		return encodedPass;
	}
}