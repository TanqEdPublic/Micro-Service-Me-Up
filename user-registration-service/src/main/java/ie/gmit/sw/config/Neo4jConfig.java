package ie.gmit.sw.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@ComponentScan(basePackages = { "ie.gmit.sw.services" })
@Configuration
@EnableNeo4jRepositories(basePackages = { "ie.gmit.sw.repository" })
public class Neo4jConfig {

    // database URL http://52.16.139.0:7474/db/data/

    public static final String URL = "http://52.16.139.0:7474/db/data/";


    @Bean
    public org.neo4j.ogm.config.Configuration getConfiguration() {
        org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
        config.driverConfiguration().setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver").setURI(URL);
        return config;
    }

    // Connecting to database

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(getConfiguration(), "ie.gmit.sw.domain");
    }


}
