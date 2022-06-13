package reqres.models.lombokModels;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestAuthLombok {
    private String password;
    private String role;
    private String phone;

}
