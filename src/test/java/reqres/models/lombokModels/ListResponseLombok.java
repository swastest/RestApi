package reqres.models.lombokModels;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResponseLombok {
    private String color;
    private Integer year;
    private String name;
    private Integer id;
    private String pantone_value;
    }
