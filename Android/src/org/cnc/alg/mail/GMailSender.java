package org.cnc.alg.mail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class GMailSender extends javax.mail.Authenticator {
	private String mailhost = "smtp.gmail.com"; // for gmail if yahoo:
												// smtp.mail.yahoo.com
	private String mailImap = "imap.gmail.com";
	private String user = "";
	private String password = "";
	private Session session;
	private MimeMultipart multipart;
	private Properties props;
	private Store store;
	private Transport transport;

	static {
		Security.addProvider(new JSSEProvider());
	}

	public void disConnectImap() throws MessagingException {
		if (isConnectTed()) {
			store.close();
		}
	}

	/*
	 * TODO: check login in to gmail.
	 */
	public boolean getConnect() {
		try {
			store = session.getStore("imaps");
			store.connect(mailImap, user, password);
			return true;
		} catch (MessagingException e) {
		}
		return false;
	}

	public boolean isConnectTed() {
		return store.isConnected();
	}

	/*
	 * TODO: Method for attach file.
	 */
	public void addAttachment(String filename) throws Exception {
		BodyPart messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(filename);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);
	}

	/*
	 * Constructor. Send Email with SMTP
	 */
	public GMailSender(String user, String password) {
		this.user = user;
		this.password = password;

		// Configure JavaMail
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", mailhost);
		// props.setProperty("mail.imap.timeout", "5000");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");

		session = Session.getInstance(props, this);
		// session = Session.getDefaultInstance(props, this);
		try {
			transport = session.getTransport("smtp");
			transport.connect(mailhost, user, password);
		} catch (NoSuchProviderException e) {
		} catch (MessagingException e) {
		}
	}

	public void disConnectSMTP() {
		try {
			if (transport.isConnected()) {
				transport.close();
			}
		} catch (MessagingException e) {
		}
	}

	/*
	 * TODO: Check login with IMAP
	 */
	public GMailSender(String user, String password, boolean checkLogin) {
		this.user = user;
		this.password = password;

		props = new Properties();

		// props.setProperty("mail.host", mailhost);
		props.setProperty("mail.imap.host", mailImap);
		props.setProperty("mail.store.protocol", "imaps"); // check for login
		props.setProperty("mail.imap.port", "993");
		session = Session.getInstance(props);

	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password);
	}

	public void dicConnectSMTP() {
		try {
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/*
	 * TODO: Send email
	 */
	@SuppressWarnings("static-access")
	public synchronized String sendMail(String subject, String body,
			String sender, String recipients) throws Exception {
		String messagesError = "";
		try {
			MimeMessage message = new MimeMessage(session);
			DataHandler handler = new DataHandler(new ByteArrayDataSource(
					body.getBytes(), "text/plain"));
			message.setFrom(new InternetAddress(sender));
			message.setSubject(subject);
			message.setDataHandler(handler);
			if (recipients.indexOf(',') > 0)
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(recipients));
			else
				message.setRecipient(Message.RecipientType.TO,
						new InternetAddress(recipients));
			transport.send(message, message.getAllRecipients());
		} catch (Exception e) {
			messagesError = e.getMessage();
		}
		return messagesError;
	}

	public class ByteArrayDataSource implements DataSource {
		private byte[] data;
		private String type;

		public ByteArrayDataSource(byte[] data, String type) {
			super();
			this.data = data;
			this.type = type;
		}

		public ByteArrayDataSource(byte[] data) {
			super();
			this.data = data;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getContentType() {
			if (type == null)
				return "application/octet-stream";
			else
				return type;
		}

		public InputStream getInputStream() throws IOException {
			return new ByteArrayInputStream(data);
		}

		public String getName() {
			return "ByteArrayDataSource";
		}

		public OutputStream getOutputStream() throws IOException {
			throw new IOException("Not Supported");
		}
	}
}