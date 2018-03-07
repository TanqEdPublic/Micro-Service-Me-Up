package ie.gmit.sw.config;

import com.netflix.appinfo.AmazonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAsync
@Import(InetUtils.class)
@EnableWebMvc
public class ZuulConfiguration extends WebMvcConfigurerAdapter {
    @Value("${server.port}")
    private int port;

    @Bean
    @Autowired
    public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
        config.setHostname(info.get(AmazonInfo.MetaDataKey.publicHostname));
        config.setIpAddress(info.get(AmazonInfo.MetaDataKey.publicIpv4));
        config.setNonSecurePort(port);
        config.setDataCenterInfo(info);
        return config;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
