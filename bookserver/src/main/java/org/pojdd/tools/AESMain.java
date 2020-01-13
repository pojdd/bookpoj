package org.pojdd.tools;

public class AESMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String src = "Hello,CryptWorld";
		AESUtil.setKEY("1234");
		String encrypted = AESUtil.encrypt(src);
		AESUtil.setKEY("1234");//密钥错误时会返回error
		String decrypted = AESUtil.decrypt(encrypted);
		System.out.println("src: " + src);
		System.out.println("encrypted: " + encrypted);
		System.out.println("decrypted: " + decrypted);
	}

}
