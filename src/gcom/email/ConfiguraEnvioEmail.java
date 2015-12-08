package gcom.email;

import gcom.util.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Classe responsavel em realizar o envio de email contento as contas em anexo.
 * 
 * @author Marcos Bahiense
 * @data 01/05/2015
 * @version 1.0
 * */
public class ConfiguraEnvioEmail {
	
	public static boolean enviar(String email, byte[] contas) throws IOException{
		
		boolean isSucesso = true;
		String host="smtp.gmail.com";
		String to="administrador-gsan@gmail.com";
		if(email != null && !"".equals(email)){
			to = email;
		}
		
		//TODO : Adicione as credenciais da conta de e-mail que utilizará para enviar.
		final String user="MEU_EMAIL_TESTE@gmail.com";
		final String password="PASSWORD_TESTE";
		  
		 
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");
		   
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

		    try {
		    
		    	MimeMessage message = configurarConteudo(session, user, to, contas);
		    	Transport.send(message);
		 
		     } catch (MessagingException e) {
		    	 e.printStackTrace();
		    	 isSucesso = false;
		     }
		    return isSucesso;
	}
		
	
	private static MimeMessage configurarConteudo(Session session, String user, String to, byte[] contas ) throws AddressException, MessagingException, IOException{
	    MimeMessage message = new MimeMessage(session);
	     message.setFrom(new InternetAddress(user));
	     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	     message.setSubject("Solicitação - 2ª via de Conta.");
	     message.setText("Olá, \n segue em anexo a 2ª via de conta. \n Obrigado.");
		 
	     List<String> pathAnexos = new ArrayList<String>();
	     pathAnexos.add(FileUtils.writeContas( contas ));
	     
	     Multipart multipart = new MimeMultipart("mixed");
	     for (String str : pathAnexos) {
	         MimeBodyPart messageBodyPart = new MimeBodyPart();
	         DataSource source = new FileDataSource(str);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(source.getName());
	         multipart.addBodyPart(messageBodyPart);
	     }
	    
	     message.setContent(multipart);
	     return message;
	}
}
