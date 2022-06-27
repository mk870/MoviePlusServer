package restapi.app.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restapi.app.DataTransferObjects.UserActorsDTO;
import restapi.app.Entities.User;
import restapi.app.Entities.UserActors;
import restapi.app.Repositories.UserActorsRepository;
import restapi.app.Repositories.UserRepository;

import org.springframework.security.core.Authentication;

@Service
public class UserActorsService {
  @Autowired
  UserActorsRepository userActorsRepository;
  @Autowired
  UserRepository userRepository;

  public String saveActor(UserActorsDTO userActorsDTO,Authentication user){
    UserActors actorDetails = new UserActors();
    actorDetails.setName(userActorsDTO.getName());
    actorDetails.setGender(userActorsDTO.getGender());
    actorDetails.setBirth_place(userActorsDTO.getBirth_place());
    actorDetails.setTmdb_id(userActorsDTO.getTmdb_id());
    actorDetails.setBirthday(userActorsDTO.getBirthday());
    actorDetails.setAge(userActorsDTO.getAge());
    actorDetails.setUser(userRepository.findByEmail(user.getName()));
    UserActors savedActor = userActorsRepository.save(actorDetails);
    return savedActor.getName()+" added to your Actorslist successfully";
  }

  public List<UserActors> getActors(Authentication principal){
    User user = userRepository.findByEmail(principal.getName());
    List<UserActors> actors = userActorsRepository.findByUser(user);
    if (actors == null) {
      return null;
    }
    return actors;
  }

  public String deleteActor(Long id) {
    userActorsRepository.deleteById(id);
    return "Actor has been successfully deleted";
  }
}
