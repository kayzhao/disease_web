package com.csu.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.core.util.Base64Encoder;

/**
 * MD5加密算法
 * 
 * @author kayzhao
 *
 */
public class MD5 {
	private static final Logger logger = Logger.getLogger(MD5.class);

	/**
	 * 利用MD5进行加密 　　
	 * 
	 * @param str
	 *            待加密的字符串 　　
	 * @return 加密后的字符串 　　
	 * @throws NoSuchAlgorithmException
	 *             没有这种产生消息摘要的算法
	 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String str) {
		// 确定计算方法
		MessageDigest md5;
		String newstr = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			Base64Encoder base64en = new Base64Encoder();
			// 加密后的字符串
			newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.error("没有这种产生消息摘要的算法" + e.getMessage());
		}
		return newstr;
	}
}
