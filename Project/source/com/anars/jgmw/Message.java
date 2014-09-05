package com.anars.jgmw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Message
{
  private Header[] _headers;
  private Address _from;
  private Address _replyTo;
  final private List<Recipient> _tos = new ArrayList<Recipient>();
  final private List<Recipient> _ccs = new ArrayList<Recipient>();
  final private List<Recipient> _bccs = new ArrayList<Recipient>();
  private String _subject;
  private String _textBody;
  private String _htmlBody;
  final private List<Attachment> _attachments = new ArrayList<Attachment>();
  final private List<Attachment> _embeddedMedia = new ArrayList<Attachment>();
  //

  public boolean addRecipient(Recipient recipient)
  {
    if (recipient.getType() == RecipientType.TO)
      return (addToRecipient(recipient));
    else if (recipient.getType() == RecipientType.CC)
      return (addCCRecipient(recipient));
    else if (recipient.getType() == RecipientType.BCC)
      return (addBCCRecipient(recipient));
    return (false);
  }


  public List<Recipient> getRecipients()
  {
    List<Recipient> recipients = new ArrayList<Recipient>(_tos);
    recipients.addAll(_ccs);
    recipients.addAll(_bccs);
    return (Collections.unmodifiableList(recipients));
  }


  public boolean addToRecipient(Recipient recipient)
  {
    if (_tos.indexOf(recipient) == -1)
    {
      Recipient newRecipient = new Recipient(recipient);
      newRecipient.setType(RecipientType.TO);
      return (_tos.add(newRecipient));
    }
    return (false);
  }

  public List<Recipient> getToRecipients()
  {
    return (Collections.unmodifiableList(_tos));
  }

  public boolean removeToRecipient(Recipient recipient)
  {
    return (_tos.remove(recipient));
  }

  public boolean addCCRecipient(Recipient recipient)
  {
    if (_ccs.indexOf(recipient) == -1)
    {
      Recipient newRecipient = new Recipient(recipient);
      newRecipient.setType(RecipientType.CC);
      return (_ccs.add(newRecipient));
    }
    return (false);
  }

  public List<Recipient> getCCRecipients()
  {
    return (Collections.unmodifiableList(_ccs));
  }

  public boolean addBCCRecipient(Recipient recipient)
  {
    if (_bccs.indexOf(recipient) == -1)
    {
      Recipient newRecipient = new Recipient(recipient);
      newRecipient.setType(RecipientType.BCC);
      return (_bccs.add(newRecipient));
    }
    return (false);
  }

  public List<Recipient> getBCCRecipients()
  {
    return (Collections.unmodifiableList(_bccs));
  }

  public boolean addAttachment(Attachment attachment)
  {
    return (_attachments.add(attachment));
  }

  public Attachment removeAttachment(int index)
  {
    return (_attachments.remove(index));
  }

  public void removeAllAttachments()
  {
    _attachments.clear();
  }

  public List<Attachment> getAttachments()
  {
    return (Collections.unmodifiableList(_attachments));
  }

  public boolean addEmbeddedMedia(Attachment attachment)
  {
    return (_embeddedMedia.add(attachment));
  }

  public Attachment removeEmbeddedMedia(int index)
  {
    return (_embeddedMedia.remove(index));
  }

  public void removeAllEmbeddedMedia()
  {
    _embeddedMedia.clear();
  }
  
  public List<Attachment> getEmbeddedMedia()
  {
    return (Collections.unmodifiableList(_embeddedMedia));
  }


  public void setFrom(Address from)
  {
    _from = from;
  }

  public Address getFrom()
  {
    return (_from);
  }

  public void setReplyTo(Address replyTo)
  {
    _replyTo = replyTo;
  }

  public Address getReplyTo()
  {
    return (_replyTo);
  }

  public void setSubject(String subject)
  {
    _subject = subject;
  }

  public String getSubject()
  {
    return (_subject);
  }

  public void setTextBody(String textBody)
  {
    _textBody = textBody;
  }

  public String getTextBody()
  {
    return (_textBody);
  }

  public void setHtmlBody(String htmlBody)
  {
    _htmlBody = htmlBody;
  }

  public String getHtmlBody()
  {
    return (_htmlBody);
  }

  public Message()
  {
    super();
  }
}
