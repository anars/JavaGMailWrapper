package com.anars.jgmw;


public class MailException
  extends Exception
{
  public MailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public MailException(Throwable cause)
  {
    super(cause);
  }

  public MailException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public MailException(String message)
  {
    super(message);
  }

  public MailException()
  {
    super();
  }
}
