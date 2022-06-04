package reqres.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListResponse {
    private String color;
    private Integer year;
    private String name;
    private Integer id;
    private String pantone_value;

    public ListResponse(String color, Integer year, String name, Integer id, String pantoneValue) {
        this.color = color;
        this.year = year;
        this.name = name;
        this.id = id;
        this.pantone_value = pantoneValue;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setPantoneValue(String pantoneValue) {
        this.pantone_value = pantoneValue;
    }

    public String getPantoneValue() {
        return pantone_value;
    }
}
