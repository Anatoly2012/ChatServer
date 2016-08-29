
public class User {
    private String username;
    private String password;
    private boolean status = false;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User name = ").append(username).append(", status = ").append(status)
                .append(".").toString();
    }
}
