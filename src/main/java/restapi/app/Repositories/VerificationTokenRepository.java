package restapi.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import restapi.app.Entities.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long>{
  VerificationToken findByToken(String token);
}
