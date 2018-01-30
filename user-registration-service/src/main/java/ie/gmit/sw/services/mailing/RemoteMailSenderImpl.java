package ie.gmit.sw.services.mailing;

import ie.gmit.sw.services.mailing.exceptions.RemoteMailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@Service
public class RemoteMailSenderImpl implements RemoteMailSender {

    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("executor")
    private Executor executor;

    @Value("${gateway.email-path}")
    private String emailUrl;

    //private String testEmailUrl = "http://localhost:8093/sendemail";


    @Autowired
    public RemoteMailSenderImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendMail(RemoteMailMessage rmm) throws RemoteMailException {

        System.out.println("SEND MAIL METHOD CALLED BY - " + Thread.currentThread().getName());
        executor.execute(() -> {
            String resp = restTemplate.postForObject(emailUrl, rmm, String.class);

            // do something based on response status code

            //System.out.println("STATUS CODE FROM EMAIL SERVICE: " + resp.getStatusCode());
        });
    }
}
