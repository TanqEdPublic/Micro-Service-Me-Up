package ie.gmit.sw.services.mailing;


import ie.gmit.sw.services.mailing.exceptions.RemoteMailException;

public interface RemoteMailSender {

    void sendMail(RemoteMailMessage rmm) throws RemoteMailException;

}
