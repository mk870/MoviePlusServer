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

import restapi.app.DataTransferObjects.UserActorsDTO;
import restapi.app.Entities.User;
import restapi.app.Services.UserActorsService;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class UserActorsController {
  @Autowired
  UserActorsService userActorsService;

  @GetMapping("/useractors")
  public String hello(@AuthenticationPrincipal User user){
    
    return "hie there " + user.getFirstName();
  }

  @PostMapping("/saveactors")
  public ResponseEntity<String> saveActor (@RequestBody UserActorsDTO userActorsDTO,Authentication user){
    if (user == null) {
      return ResponseEntity.ok("no user");
    }
    
    return ResponseEntity.ok(userActorsService.saveActor(userActorsDTO,user));
  }

  @GetMapping("/actors")
  public ResponseEntity<?> getActors(Authentication user){
    return ResponseEntity.ok(userActorsService.getActors(user));
  }

  @DeleteMapping("/actor/{id}")
  public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id,@AuthenticationPrincipal User user){
    
    return ResponseEntity.ok(userActorsService.deleteActor(id));
  }
}
