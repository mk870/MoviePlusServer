package restapi.app.DataTransferObjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserActorsDTO {
  private String name;
  private String gender;
  private String birthday;
  private String birth_place;
  private int age;
  private String tmdb_id;
}
