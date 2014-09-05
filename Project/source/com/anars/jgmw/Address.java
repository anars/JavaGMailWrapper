package com.anars.jgmw;

import java.util.Comparator;

public class Address
  implements Comparator

{
  private String _name = "";
  private String _address = "";

  public Address(Address person)
  {
    super();
    setName(person.getName());
    setAddress(person.getAddress());
  }

  public Address(String address)
  {
    super();
    setAddress(address);
  }

  public Address(String name, String address)
  {
    super();
    setName(name);
    setAddress(address);
  }


  public void setName(String name)
  {
    if (name == null)
      name = "";
    _name = name.trim();
  }

  public String getName()
  {
    return (_name);
  }

  public void setAddress(String address)
  {
    if (address == null)
      address = "";
    _address = address.trim();
  }

  public String getAddress()
  {
    return (_address);
  }

  @Override
  public int compare(Object person1, Object person2)
  {
    return (((Address) person1).getAddress().compareToIgnoreCase(((Address) person2).getAddress()));
  }

  @Override
  public boolean equals(Object person)
  {
    return (getAddress().equalsIgnoreCase(((Address) person).getAddress()));
  }


  @Override
  public String toString()
  {
    return ((!_name.equals("")? "\"" + _name + "\" <": "") + _address + (!_name.equals("")? ">": ""));
  }
}
