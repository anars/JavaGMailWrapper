package com.anars.jgmw;

import java.util.Properties;

public class SendMail
{
  private Properties properties = new Properties();
  private Mail mail;
  
  public SendMail()
  {
    super();
    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
  }
}
