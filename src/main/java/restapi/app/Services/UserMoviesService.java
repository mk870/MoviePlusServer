package restapi.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import restapi.app.DataTransferObjects.UserMoviesDTO;
import restapi.app.Entities.User;
import restapi.app.Entities.UserMovies;
import restapi.app.Repositories.UserMoviesRepository;
import restapi.app.Repositories.UserRepository;

@Service
public class UserMoviesService {
  @Autowired
  UserMoviesRepository userMoviesRepository;
  @Autowired
  UserRepository userRepository;

  public String saveMovie(UserMoviesDTO userMoviesDTO,Authentication user){
    UserMovies movieDetails = new UserMovies();
    movieDetails.setTitle(userMoviesDTO.getTitle());
    movieDetails.setRelease_date(userMoviesDTO.getRelease_date());
    movieDetails.setRuntime(userMoviesDTO.getRuntime());
    movieDetails.setTmdb_id(userMoviesDTO.getTmdb_id());
    movieDetails.setUser(userRepository.findByEmail(user.getName()));
    UserMovies savedMovie = userMoviesRepository.save(movieDetails);
    return savedMovie.getTitle()+" was added to your movielist successfully";
  }

  public List<UserMovies> getMovies(Authentication principal){
    User user = userRepository.findByEmail(principal.getName());
    List<UserMovies> movies = userMoviesRepository.findByUser(user);
    if (movies == null) {
      return null;
    }
    return movies;
  }

  public String deleteMovie(Long id) {
    userMoviesRepository.deleteById(id);
    return "Movie has been successfully deleted";
  }
}
