package com.anars.jgmw;


public class Recipient
  extends Address
{
  private RecipientType _type;

  public Recipient(Recipient recipient)
  {
    super((Address) recipient);
    setType(recipient.getType());
  }

  public Recipient(String name, String address, RecipientType type)
  {
    super(name, address);
    setType(type);
  }

  public Recipient(String address, RecipientType type)
  {
    super(address);
    setType(type);
  }


  public void setType(RecipientType type)
  {
    _type = type;
  }

  public RecipientType getType()
  {
    return (_type);
  }
}
