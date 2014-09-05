package com.anars.jgmw;

import java.util.Properties;

public class SMTPSSLProperties
  extends Properties

{
  public SMTPSSLProperties()
  {
    super();
    put("mail.transport.protocol", "smtps");
    put("mail.smtp.host", "smtp.gmail.com");
    put("mail.smtp.socketFactory.port", "465");
    put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    put("mail.smtp.auth", "true");
    put("mail.smtp.port", "465");
  }
}
