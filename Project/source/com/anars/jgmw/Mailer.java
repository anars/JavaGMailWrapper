package com.anars.jgmw;


import java.io.UnsupportedEncodingException;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;

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

public class Mailer
{
  private Properties _smtpProperties = new SMTPSSLProperties();
  private Properties _imapProperties = new Properties();
  private String _username;
  private String _password;

  public Mailer()
  {
    super();
  }

  public void setSmtpProperties(Properties smtpProperties)
  {
    _smtpProperties = smtpProperties;
  }

  public Properties getSmtpProperties()
  {
    return _smtpProperties;
  }

  public void setImapProperties(Properties imapProperties)
  {
    _imapProperties = imapProperties;
  }

  public Properties getImapProperties()
  {
    return (_imapProperties);
  }

  public void setUsername(String username)
  {
    _username = username;
  }

  public String getUsername()
  {
    return (_username);
  }

  public void setPassword(String password)
  {
    _password = password;
  }

  public String getPassword()
  {
    return (_password);
  }

  public boolean send(Message mail)
    throws MailException
  {
    Session session = Session.getInstance(_smtpProperties, new javax.mail.Authenticator()
    {
      protected PasswordAuthentication getPasswordAuthentication()
      {
        return new PasswordAuthentication(_username, _password);
      }
    });

    try
    {
      javax.mail.Message message = new MimeMessage(session);
      if (mail.getFrom() == null)
        throw new MailException();
      message.setFrom(new InternetAddress(mail.getFrom().toString()));
      if (mail.getReplyTo() != null)
        message.setReplyTo(new InternetAddress[]
        {
          new InternetAddress(mail.getReplyTo().getAddress(), mail.getReplyTo().getName())
        });
      List<Recipient> recipients = mail.getToRecipients();
      InternetAddress[] addresses = new InternetAddress[recipients.size()];
      for (int index = 0; index < recipients.size(); index++)
        addresses[index] = new InternetAddress(recipients.get(index).getAddress(), recipients.get(index).getName());
      message.setRecipients(javax.mail.Message.RecipientType.TO, addresses);
      recipients = mail.getCCRecipients();
      addresses = new InternetAddress[recipients.size()];
      for (int index = 0; index < recipients.size(); index++)
        addresses[index] = new InternetAddress(recipients.get(index).getAddress(), recipients.get(index).getName());
      message.setRecipients(javax.mail.Message.RecipientType.CC, addresses);
      recipients = mail.getBCCRecipients();
      addresses = new InternetAddress[recipients.size()];
      for (int index = 0; index < recipients.size(); index++)
        addresses[index] = new InternetAddress(recipients.get(index).getAddress(), recipients.get(index).getName());
      message.setRecipients(javax.mail.Message.RecipientType.BCC, addresses);
      message.setSubject(mail.getSubject() != null? mail.getSubject(): "");

      Multipart multipart = null;
      if (mail.getHtmlBody() != null)
      {
        multipart = new MimeMultipart();
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(mail.getHtmlBody(), "text/html; charset=UTF-8");
        multipart.addBodyPart(mimeBodyPart);
      }

      List<Attachment> attachments = mail.getAttachments();
      List<Attachment> inlinemedia = mail.getEmbeddedMedia();
      if (attachments.size() != 0 || inlinemedia.size() != 0)
      {
        if (multipart == null)
          multipart = new MimeMultipart();

        for (Attachment attachment: attachments)
        {
          MimeBodyPart mimeBodyPart = new MimeBodyPart();
          mimeBodyPart.setDataHandler(new DataHandler(attachment.getDataSource()));
          mimeBodyPart.setFileName(attachment.getName());
          mimeBodyPart.setDisposition(MimeBodyPart.ATTACHMENT);
          multipart.addBodyPart(mimeBodyPart);
        }

        for (Attachment attachment: inlinemedia)
        {
          MimeBodyPart mimeBodyPart = new MimeBodyPart();
          mimeBodyPart.setDataHandler(new DataHandler(attachment.getDataSource()));
          mimeBodyPart.setFileName(attachment.getName());
          mimeBodyPart.setDisposition(MimeBodyPart.INLINE);
          multipart.addBodyPart(mimeBodyPart);
        }

      }

      if (multipart != null)
      {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(mail.getTextBody() != null? mail.getTextBody(): "", "text/plain; charset=UTF-8");
        multipart.addBodyPart(mimeBodyPart);
        message.setContent(multipart);
      }
      else
      {
        message.setText(mail.getTextBody() != null? mail.getTextBody(): "");
      }

      Transport transport = session.getTransport();
      transport.send(message);
      transport.close();
    }
    catch (UnsupportedEncodingException uee)
    {
      // TODO: Add catch code
      uee.printStackTrace();
    }
    catch (AddressException ae)
    {
      // TODO: Add catch code
      ae.printStackTrace();
    }
    catch (MessagingException me)
    {
      // TODO: Add catch code
      me.printStackTrace();
    }
    catch (MailException me)
    {
      // TODO: Add catch code
      me.printStackTrace();
    }
    return (false);
  }
}
