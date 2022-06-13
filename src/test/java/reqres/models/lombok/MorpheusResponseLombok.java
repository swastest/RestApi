package reqres.models.lombok;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MorpheusResponseLombok {
    private String name;
    private String job;
    private String id;
    private String createdAt;
    private String updatedAt;

}
