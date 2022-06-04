package reqres.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MorpheusResponse {
    private String name;
    private String job;
    private String id;
    private String createdAt;

    public MorpheusResponse(String name, String job, String id, String createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }


    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }


    public String getJob() {
        return job;
    }
}
