package nl.blitz.cleancode.account;

public class Account {
    String username;
    String password;
    double balance;
    boolean active;
    long lastLogin;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.active = true;
        this.lastLogin = 0;
    }

}
