package restapi.app.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import restapi.app.Entities.User;
import restapi.app.Entities.UserMovies;

public interface UserMoviesRepository extends JpaRepository<UserMovies,Long>{
  List<UserMovies> findByUser(User user);
}
