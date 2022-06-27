package restapi.app.Services;
import javax.mail.MessagingException;

import restapi.app.DataTransferObjects.LoginDTO;
import restapi.app.DataTransferObjects.ResponseDTO;
import restapi.app.DataTransferObjects.UserDTO;
import restapi.app.Entities.VerificationToken;

public interface UserService {
  public String saveUser(UserDTO user) throws MessagingException;
  public VerificationToken saveVerificationToken(VerificationToken verificationToken);
  public ResponseDTO validateToken(String token);
  public ResponseDTO userLogin(LoginDTO loginDTO);
}
