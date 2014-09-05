package com.anars.jgmw;

import java.util.Comparator;

import javax.activation.DataSource;

public class Attachment
  implements Comparator
{
  private String _name;
  private DataSource _dataSource;

  public Attachment(final String name, final DataSource dataSource)
  {
    _name = name;
    _dataSource = dataSource;
  }

  public DataSource getDataSource()
  {
    return (_dataSource);
  }

  public String getName()
  {
    return (_name);
  }

  @Override
  public int compare(Object attachment1, Object attachment2)
  {
    return (((Attachment) attachment1).getName().compareToIgnoreCase(((Attachment) attachment2).getName()));
  }

  @Override
  public boolean equals(Object attachment)
  {
    return (getName().equalsIgnoreCase(((Attachment) attachment).getName()));
  }

}
