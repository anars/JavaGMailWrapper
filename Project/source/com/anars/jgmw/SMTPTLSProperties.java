package com.anars.jgmw;

import java.util.Properties;

public class SMTPTLSProperties
  extends Properties
{
  public SMTPTLSProperties()
  {
    super();
    put("mail.smtp.auth", "true");
    put("mail.smtp.starttls.enable", "true");
    put("mail.smtp.host", "smtp.gmail.com");
    put("mail.smtp.port", "587");
  }
}
