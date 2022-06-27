package restapi.app.Controllers;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restapi.app.DataTransferObjects.LoginDTO;
import restapi.app.DataTransferObjects.ResponseDTO;
import restapi.app.DataTransferObjects.UserDTO;
import restapi.app.Services.UserServiceImpl;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class SignupController {
  @Autowired
  private UserServiceImpl userServiceImpl;
  
  @GetMapping("/home")
  public String welcome(){
    return "welcome to movieplus database";
  }

  @PostMapping("/signup")
  public ResponseEntity<?> Signup(@RequestBody UserDTO user) throws MessagingException{
    String response = userServiceImpl.saveUser(user);
    return ResponseEntity.ok(response);
  }
  
  @GetMapping("/verifyRegistration")
  public ResponseDTO verifyRegistration(@RequestParam("token") String token){
    return userServiceImpl.validateToken(token);
    
  }
  @PostMapping("/login")
  public ResponseEntity<?> userLogin(@RequestBody LoginDTO loginDTO){
    
    return ResponseEntity.ok(userServiceImpl.userLogin(loginDTO));
  }
}
