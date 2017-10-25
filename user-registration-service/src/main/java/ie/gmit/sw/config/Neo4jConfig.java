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



}
