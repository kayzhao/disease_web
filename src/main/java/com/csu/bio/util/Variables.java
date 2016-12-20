package com.csu.bio.util;

/**
 * 一些常用的系统变量
 * 
 * @author kayzhao
 *
 */
public class Variables {

	/**
	 * 邮箱参数
	 */
	// 注意HOST使用IP，避免使用域名
	public static final String HOST = "";
	public static final String USER = "";
	public static final String PASSWORD = "";

	/**
	 * 系统符号
	 */
	public static final String FILE_SEPARATOR = System
			.getProperty("file.separator");
	public static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	/**
	 * 序列长度的cutoff
	 */
	public static final Integer SEQ_LENGTH_CUTOFF = 15000;

	/**
	 * 运行计算流程反馈结果
	 */

	/**
	 * 发送邮件的内容
	 * 
	 * @param email
	 * @return
	 */
	public static String MailContent(String email) {
		String mailContent = "<html><body><p>Dear User,<br>"
				+ "<p>School of Information Science and Engineering"
				+ "<p>Central South University" + "</body></html>";

		return mailContent;
	}
	
	/**
	 * umls properties
	 */
}
