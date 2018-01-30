package ie.gmit.sw.services.mailing;

import java.io.Serializable;
import java.util.Arrays;

public class RemoteMailMessage implements Serializable{

    private static final long serialVersionUID = 64857L;

    private String from;
    private String replyTo;
    private String[] to;
    private String[] cc;
    private String[] bcc;
    private String subject;
    private String text;

    public void setFrom(String from) {
        this.from = from;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getFrom() {
        return from;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public String[] getTo() {
        return to;
    }

    public String[] getCc() {
        return cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "RemoteMailMessage{" +
                "from='" + from + '\'' +
                ", replyTo='" + replyTo + '\'' +
                ", to=" + Arrays.toString(to) +
                ", cc=" + Arrays.toString(cc) +
                ", bcc=" + Arrays.toString(bcc) +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
