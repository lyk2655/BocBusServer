/**
 * 
 */
package com.bocbus.project.util;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author chenw
 *
 * RSA算法加解密
 */
public class RSACypher {
	public static final String PUBLIC_KEY="public key";
	public static final String PRIVATE_KEY="private key";
	public static final String ALGORITHM="RSA";
	
	/** 
	 * 加密计算
	 * @param key 密钥
	 * @param data 待加密的数据
	 * @return 加密后的数据
	 */
	public static byte[] encrypt(Key key, byte[] data) 
			throws NoSuchPaddingException, 
					NoSuchAlgorithmException, 
					InvalidKeyException, 
					IllegalBlockSizeException, 
					BadPaddingException
	{
		Cipher cipher=Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(data);
	}
	/**
	 * 解密计算
	 * @param key 密钥
	 * @param data 待解密的数据
	 * @return 解密后的数据
	 */
	public static byte[] decrypt(Key key, byte[] data) 
			throws NoSuchPaddingException, 
					NoSuchAlgorithmException, 
					InvalidKeyException, 
					IllegalBlockSizeException, 
					BadPaddingException
	{
		Cipher cipher=Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(data);
	}
	
	public static byte[] encryptByPrivateKey(byte[] key, byte[] data)
			throws NoSuchPaddingException, 
					NoSuchAlgorithmException, 
					InvalidKeyException, 
					IllegalBlockSizeException, 
					BadPaddingException, 
					InvalidKeySpecException
	{
		PKCS8EncodedKeySpec pkcs8KeySpec=new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory=KeyFactory.getInstance(ALGORITHM);
		Key privateKey=keyFactory.generatePrivate(pkcs8KeySpec);
		return encrypt(privateKey, data);
	}
	
	public static byte[] decryptByPublicKey(byte[] key, byte[] data)
			throws NoSuchPaddingException, 
					NoSuchAlgorithmException, 
					InvalidKeyException, 
					IllegalBlockSizeException, 
					BadPaddingException, 
					InvalidKeySpecException
	{
		X509EncodedKeySpec x509KeySpec=new X509EncodedKeySpec(key);
		KeyFactory keyFactory=KeyFactory.getInstance(ALGORITHM);
		Key publicKey=keyFactory.generatePublic(x509KeySpec);
		return decrypt(publicKey, data);
	}
	
	/**
	 * 获取密钥对
	 * @param size		密钥长度
	 * @param exponent	公钥指数
	 * @return	密钥对，公钥键值为常量PUBLIC_KEY，私钥键值为常量PRIVATE_KEY
	 * @throws InvalidAlgorithmParameterException
	 * @throws NoSuchAlgorithmException
	 */
	public static HashMap<String, Key> genKey(int size, int exponent) 
			throws InvalidAlgorithmParameterException, NoSuchAlgorithmException
	{
		KeyPairGenerator keyPairGen=KeyPairGenerator.getInstance(ALGORITHM);
		keyPairGen.initialize(new RSAKeyGenParameterSpec(1024, new BigInteger("3")));
		KeyPair keyPair=keyPairGen.generateKeyPair();
		RSAPublicKey pubKey=(RSAPublicKey)keyPair.getPublic();
		RSAPrivateKey priKey=(RSAPrivateKey)keyPair.getPrivate();
		HashMap<String, Key> keyMap=new HashMap<String, Key>(2);
		keyMap.put(PUBLIC_KEY, pubKey);
		keyMap.put(PRIVATE_KEY, priKey);
		return keyMap;
	}
}
