package ru.urfu;

public class User {
    private String login;
    private String email;
    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            this.email = null;
        }
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        if (login != null && login.length() >= 5) {
            this.login = login;
        } else {
            this.login = null;
        }
    }
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}