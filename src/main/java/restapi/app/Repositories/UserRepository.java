package restapi.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import restapi.app.Entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
  User findByEmail(String email);
}
