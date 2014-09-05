package com.anars.jgmw;


public class Sender
  extends Address
{
  private String _password;

  public Sender(Sender sender)
  {
    super((Address) sender);
    setPassword(sender.getPassword());
  }

  public Sender(String name, String address, String password)
  {
    super(name, address);
    setPassword(password);
  }

  public Sender(String address, String password)
  {
    super(address);
    setPassword(password);
  }

  public void setPassword(String password)
  {
    _password = password;
  }

  public String getPassword()
  {
    return (_password);
  }

}
