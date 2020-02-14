package com.pms.utils;

import java.io.IOException;
/**
 * @author wangdonghui
 * 发送邮件类
 */
import java.io.UnsupportedEncodingException;
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

public class MailUtils {

	static int port = 25;
	static String name = "测试报告";

	public static void sendEmail(String email, String subject, String body, String filepath)
			throws UnsupportedEncodingException {
		String server = ReadProperties.getPropValue("server");

		String from = ReadProperties.getPropValue("from");
		String password = ReadProperties.getPropValue("password");

		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", server);
			props.put("mail.smtp.port", String.valueOf(port));
			props.put("mail.smtp.auth", "true");
			Transport transport = null;
			Session session = Session.getDefaultInstance(props, null);
			transport = session.getTransport("smtp");
			transport.connect(server, from, password);
			MimeMessage msg = new MimeMessage(session);
			msg.setSentDate(new Date());
			
			//设置可以发送给多个人
			InternetAddress fromAddress = new InternetAddress(from, name, "UTF-8");
			msg.setFrom(fromAddress);
			String emailList[] = email.split(",");
			InternetAddress[] toAddress = new InternetAddress[emailList.length];

			for (int i = 0; i < emailList.length; i++) {
				toAddress[i] = new InternetAddress(emailList[i]);
			}
			
			msg.addRecipients(Message.RecipientType.TO, toAddress);
			msg.setSubject(subject, "UTF-8");

			// 发送带附件的邮件
			// 如果有附件，先将邮件内容部分存起来
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			// 设定邮件的MIME类型(text/plain或text/html)
			mimeBodyPart.setContent("请下载后打开index.html进行浏览", "text/html;charset=GB2312");

			// 再对附件做处理
			MimeBodyPart mbp2 = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(filepath);
			mbp2.setDataHandler(new DataHandler(fds));
			mbp2.setFileName("测试报告.zip");
			// 最后将两部分集成，做为一个邮件送出
			// 邮件类型添加到一个MimeMultipart中
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart(mimeBodyPart);
			mimeMultipart.addBodyPart(mbp2);
			mimeMultipart.setSubType("mixed");

			// 设置邮件内容
			msg.setContent(mimeMultipart);

			// send message
			msg.setSentDate(new Date());
			transport.sendMessage(msg, msg.getAllRecipients());

			System.out.printf("邮件发送成功");

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String filepath = ReadProperties.getPropValue("filepath");
		String receive = ReadProperties.getPropValue("receive");

		try {
			MailUtils.sendEmail(receive, "测试报告", "测试", filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
