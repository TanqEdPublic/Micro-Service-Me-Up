package ie.gmit.sw.services.mailing;

import org.springframework.stereotype.Component;

@Component
public class RemoteMailMessageBuilder implements MailMessageBuilder {

    private RemoteMailMessage mailMessage;

    public RemoteMailMessageBuilder() {
        this.mailMessage = new RemoteMailMessage();
    }

    @Override
    public MailMessageBuilder setFrom(String from) {
        mailMessage.setFrom(from);
        return this;
    }

    @Override
    public MailMessageBuilder setReplyTo(String replyTo) {
        mailMessage.setReplyTo(replyTo);
        return this;
    }

    @Override
    public MailMessageBuilder setTo(String[] to) {
        mailMessage.setTo(to);
        return this;
    }

    @Override
    public MailMessageBuilder setCc(String[] cc) {
        mailMessage.setCc(cc);
        return this;
    }

    @Override
    public MailMessageBuilder setBcc(String[] bcc) {
        mailMessage.setBcc(bcc);
        return this;
    }

    @Override
    public MailMessageBuilder setSubject(String subject) {
        mailMessage.setSubject(subject);
        return this;
    }

    @Override
    public MailMessageBuilder setText(String text) {
        mailMessage.setText(text);
        return this;
    }

    @Override
    public RemoteMailMessage buildMessage() {
        return this.mailMessage;
    }
}
