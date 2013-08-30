package com.chronicweirdo.protection;

import java.security.Key;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.chronicweirdo.makeitso.ConsoleUtils;
import com.chronicweirdo.makeitso.FileUtils;

public class EncryptionTest {

	public static void listSecurityOptions() {
		for (Provider provider : Security.getProviders()) {
			System.out.println("Provider: " + provider.getName());
			for (Provider.Service service : provider.getServices()) {
				System.out.println("  Algorithm: " + service.getAlgorithm());
			}
		}
	}
	
	public static byte[] encrypt(Key key, byte[] data) throws Exception {
		Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		aes.init(Cipher.ENCRYPT_MODE, key);
		return aes.doFinal(data);
	}

	public static byte[] decrypt(Key key, byte[] data) throws Exception {
		Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		aes.init(Cipher.DECRYPT_MODE, key);
		return aes.doFinal(data);
	}

	public static Key key(String passphrase) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA");
		digest.update(passphrase.getBytes());
		SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");
		return key;
	}

	public static Key key2(String passphrase, byte[] salt) throws Exception {
		SecretKeyFactory factory = SecretKeyFactory
				.getInstance("PBKDF2WithHmacSHA1");
		KeySpec keySpec = new PBEKeySpec(passphrase.toCharArray(), salt, 1024,
				128);
		SecretKey secretKey = factory.generateSecret(keySpec);
		Key key = new SecretKeySpec(secretKey.getEncoded(), "AES");
		return key;
	}

	public static void testSimpleEncoding() throws Exception {
		String passphrase = "this is my password";
		Key key = key(passphrase);
		ConsoleUtils.print(key.getEncoded());
		String text = "this is my message";
		byte[] data = encrypt(key, text.getBytes());
		ConsoleUtils.print(data, true);
		String newText = new String(decrypt(key, data));
		System.out.println(newText);
	}

	public static void testFileEncoding() throws Exception {
		String path = "dataFile";
		String passphrase = "this is my password";
		Key key = key(passphrase);
		ConsoleUtils.print(key.getEncoded());
		String text = "this is my message\nit is long and convoluted\nbut you understand";
		byte[] data = encrypt(key, text.getBytes());
		FileUtils.writeFile(path, data);
		ConsoleUtils.print(data, true);
		byte[] newData = FileUtils.readFile(path);
		String newText = new String(decrypt(key, newData));
		System.out.println(newText);
	}

	public static void testFileEncoding2() throws Exception {
		String path = "dataFile";
		String passphrase = "this is my password";
		String salt = "savory";

		// encode
		Key key = key2(passphrase, salt.getBytes());
		ConsoleUtils.print(key.getEncoded());
		String text = "this is my message\nit is long and convoluted\nbut you understand";
		byte[] data = encrypt(key, text.getBytes());
		ConsoleUtils.print(data, true);
		FileUtils.writeFile(path, data);

		// decode
		Key newKey = key2(passphrase, salt.getBytes());
		byte[] newData = FileUtils.readFile(path);
		String newText = new String(decrypt(key, newData));
		System.out.println(newText);
	}

	public static void main(String[] args) throws Exception {
		//listSecurityOptions();
		// testSimpleEncoding();
		testFileEncoding2();
	}

}
