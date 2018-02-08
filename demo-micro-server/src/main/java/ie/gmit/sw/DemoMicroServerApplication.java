package ie.gmit.sw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableResourceServer
public class DemoMicroServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMicroServerApplication.class, args);
	}
}
