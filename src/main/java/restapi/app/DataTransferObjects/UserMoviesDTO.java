package restapi.app.DataTransferObjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMoviesDTO {
  private String title;
  private String release_date;
  private String runtime;
  private String tmdb_id;
  
}
