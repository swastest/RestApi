package reqres.models.lombokModels;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MorpheusRequestLombok {
    private String name;
    private String job;

}
