package reqres.models;

public class ListUsersResponse {
    private String last_name;
    private Integer id;
    private String avatar;
    private String first_name;
    private String email;


    public ListUsersResponse(String last_name, Integer id, String avatar, String first_name, String email) {
        this.last_name = last_name;
        this.id = id;
        this.avatar = avatar;
        this.first_name = first_name;
        this.email = email;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
