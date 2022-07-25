package runner;

public class SignUpFreeDto {
    public SignUpFreeDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public SignUpFreeDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    private String fullName;

    public String getEmail() {
        return email;
    }

    public SignUpFreeDto setEmail(String email) {
        this.email = email;
        return this;
    }

    private String email;

    public String getPassword() {
        return password;
    }

    public SignUpFreeDto setPassword(String password) {
        this.password = password;
        return this;
    }

    private String password;

    public String getTimeZone() {
        return timeZone;
    }

    public SignUpFreeDto setTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    private String timeZone;
}
