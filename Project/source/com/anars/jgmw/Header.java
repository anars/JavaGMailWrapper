package com.anars.jgmw;


public class Header
{
  private String _name;
  private String _value;

  public void setName(String name)
  {
    _name = name;
  }

  public String getName()
  {
    return (_name);
  }

  public void setValue(String value)
  {
    _value = value;
  }

  public String getValue()
  {
    return (_value);
  }

  public Header(String name, String value)
  {
    super();
    setName(name);
    setValue(value);
  }
}
