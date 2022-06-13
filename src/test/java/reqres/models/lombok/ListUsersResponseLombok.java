package reqres.models.lombok;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListUsersResponseLombok {
    private String last_name;
    private Integer id;
    private String avatar;
    private String first_name;
    private String email;

}
