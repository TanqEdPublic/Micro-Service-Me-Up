package ie.gmit.sw.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Controller
@SessionAttributes("authorizationRequest")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{

    @Value("${server.port}")
    private int port;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/oauth/confirm_access").setViewName("authorize");
    }

}
