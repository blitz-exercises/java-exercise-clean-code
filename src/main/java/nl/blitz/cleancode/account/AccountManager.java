package nl.blitz.cleancode.account;

class AccountManager {
    private Account account;

    public AccountManager() {
        account = new Account();
    }

    // create new account
    public void createAccount(String username, String password) {
        account.username = username;
        account.password = password;
        account.balance = 0;
        account.active = true;
    }

    // update account balance
    public void updateBalance(double amount) {
        account.balance += amount;
    }

    // check if account is active
    public boolean isActive() {
        return account.active;
    }

    // old method - not used anymore
    // public void oldMethod() {
    //     System.out.println("old code");
    // }

    // get account balance
    public double getBalance() {
        return account.balance;
    }

    // validate account
    public boolean validate() {
        if (account.username == null) {
            return false;
        }
        if (account.password == null) {
            return false;
        }
        if (account.password.length() < 8) {
            return false;
        }
        return true;
    }

    // this method processes the account
    public void process() {
        if (account.active) {
            account.lastLogin = System.currentTimeMillis();
        }
    }

    class Account {
        String username;
        String password;
        double balance;
        boolean active;
        long lastLogin;
    }
}

