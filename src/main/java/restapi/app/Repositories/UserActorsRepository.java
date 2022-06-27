package restapi.app.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restapi.app.Entities.User;
import restapi.app.Entities.UserActors;

public interface UserActorsRepository extends JpaRepository<UserActors,Long>{
  List<UserActors> findByUser(User user);
}
