package ie.gmit.sw.repository;

import ie.gmit.sw.domain.VerificationToken;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface VerificationTokenRepository extends GraphRepository<VerificationToken> {

    VerificationToken findByToken(String token);

}
