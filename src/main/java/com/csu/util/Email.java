package com.csu.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

/**
 * JavaMail邮件发送功能
 * 
 * @author kayzhao
 *
 */
public class Email {
	private final Logger logger = Logger.getLogger(Email.class);
	private static Properties prop = new Properties();
	private String mailSubject;

	public Email(String mailSubject) {
		prop.setProperty("mail.host", Variables.HOST);
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		this.mailSubject = mailSubject;
		logger.info("初始化邮箱发送设置");
	}

	/**
	 * 执行邮件发送 创建一封只包含文本的邮件
	 * 
	 * @param sendto
	 *            收件地址
	 * @param mailContent
	 *            邮件内容
	 * @throws NoSuchProviderException
	 * @throws MessagingException
	 * @throws Exception
	 */
	public void sendEmail(String sendto, String mailContent)
			throws NoSuchProviderException, MessagingException, Exception {

		// 1、创建session
		Session session = Session.getInstance(prop);
		session.setDebug(true);

		// 2、通过session得到transport对象
		Transport ts = session.getTransport();

		// 3、链接
		ts.connect(Variables.HOST, Variables.USER,
				Variables.PASSWORD);

		// 4、创建邮件
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(Variables.USER));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(
				sendto));
		message.setSubject(this.mailSubject);
		message.setContent(mailContent, "text/html;charset=UTF-8");
		message.setSentDate(new Date());

		// 5、发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();

		logger.info("send email success!!!!");
		System.out.println("send success!");
	}

	/**
	 * 发送邮件带附件
	 * 
	 * @param email
	 *            收件地址
	 * @param mailContent
	 *            邮件内容
	 * @param attachment
	 *            附件
	 * @throws IOException
	 * @throws MessagingException
	 */
	public void sendEmailWithAttachment(String email, String mailContent,
			File attachment) throws IOException, MessagingException {
		Session session = Session.getInstance(prop);
		session.setDebug(true);

		Message message = new MimeMessage(session);
		// 发件人
		InternetAddress from = new InternetAddress(Variables.USER);
		message.setFrom(from);

		// 收件人
		InternetAddress to = new InternetAddress(email);
		message.setRecipient(Message.RecipientType.TO, to);

		// 邮件主题
		message.setSubject(this.mailSubject);

		// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
		Multipart multipart = new MimeMultipart();

		// 添加邮件正文
		BodyPart contentPart = new MimeBodyPart();
		contentPart.setContent(mailContent, "text/html;charset=UTF-8");
		multipart.addBodyPart(contentPart);

		// 添加附件的内容
		if (attachment != null) {
			BodyPart attachmentBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(attachment);
			attachmentBodyPart.setDataHandler(new DataHandler(source));

			// MimeUtility.encodeWord可以避免文件名乱码
			attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment
					.getName()));
			multipart.addBodyPart(attachmentBodyPart);
		}

		// 将multipart对象放到message中
		message.setContent(multipart);
		message.saveChanges();

		Transport transport = session.getTransport();
		transport.connect(Variables.HOST, Variables.USER,
				Variables.PASSWORD);

		// 发送
		transport.sendMessage(message, message.getAllRecipients());

		logger.info("send email success!!!!");
		System.out.println("send success!");
	}
}