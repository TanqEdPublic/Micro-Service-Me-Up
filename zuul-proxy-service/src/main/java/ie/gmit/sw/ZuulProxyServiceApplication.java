package ie.gmit.sw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulProxyServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZuulProxyServiceApplication.class, args);
	}
}
