package restapi.app.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restapi.app.DataTransferObjects.UserMoviesDTO;
import restapi.app.Entities.User;
import restapi.app.Services.UserMoviesService;



@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class UserMoviesController {
  @Autowired
  UserMoviesService userMoviesService;

  @GetMapping("/usermovies")
  public String hello(@AuthenticationPrincipal User user){
    
    return "hie there " + user.getFirstName();
  }

  @PostMapping("/savemovies")
  public ResponseEntity<String> saveMovie (@RequestBody UserMoviesDTO userMoviesDTO,Authentication user){
    if (user == null) {
      return ResponseEntity.ok("no user");
    }
    
    return ResponseEntity.ok(userMoviesService.saveMovie(userMoviesDTO,user));
  }

  @GetMapping("/movies")
  public ResponseEntity<?> getMovies(Authentication user){
    return ResponseEntity.ok(userMoviesService.getMovies(user));
  }

  @DeleteMapping("/movie/{id}")
  public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id,@AuthenticationPrincipal User user){
    
    return ResponseEntity.ok(userMoviesService.deleteMovie(id));
  }
}
