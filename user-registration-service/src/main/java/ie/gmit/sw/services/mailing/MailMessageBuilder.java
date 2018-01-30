package ie.gmit.sw.services.mailing;

public interface MailMessageBuilder {

    MailMessageBuilder setFrom(String from);

    MailMessageBuilder setReplyTo(String replyTo);

    MailMessageBuilder setTo(String[] to);

    MailMessageBuilder setCc(String[] cc);

    MailMessageBuilder setBcc(String[] bcc);

    MailMessageBuilder setSubject(String subject);

    MailMessageBuilder setText(String text);

    RemoteMailMessage buildMessage();
}
