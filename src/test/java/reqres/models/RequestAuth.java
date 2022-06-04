package reqres.models;

public class RequestAuth {
    private String password;
    private String role;
    private String phone;

    public RequestAuth(String password, String role, String phone) {
        this.password = password;
        this.role = role;
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
