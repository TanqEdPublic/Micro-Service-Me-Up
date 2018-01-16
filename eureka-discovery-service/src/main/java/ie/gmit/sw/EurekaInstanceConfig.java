package ie.gmit.sw;

import com.netflix.appinfo.AmazonInfo;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.UtilAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@Import(UtilAutoConfiguration.class)
public class EurekaInstanceConfig{

    @Bean
    @Profile("docker")
    public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
        final EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils) {
            @Scheduled(initialDelay = 30000L, fixedRate = 30000L)
            public void refreshInfo() {
                AmazonInfo newInfo = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
                if (!this.getDataCenterInfo().equals(newInfo)) {
                    ((AmazonInfo) this.getDataCenterInfo()).setMetadata(newInfo.getMetadata());
                }
            }
        };
        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
        config.setDataCenterInfo(info);
        info.getMetadata().put(AmazonInfo.MetaDataKey.publicHostname.getName(), info.get(AmazonInfo.MetaDataKey.publicIpv4));
        config.setHostname(info.get(AmazonInfo.MetaDataKey.publicHostname));
        config.setIpAddress(info.get(AmazonInfo.MetaDataKey.publicIpv4));
        config.setNonSecurePort(8085);
        return config;
    }
}
