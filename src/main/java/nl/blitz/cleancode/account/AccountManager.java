package nl.blitz.cleancode.account;

class AccountManager {
    private Account account;

    public AccountManager() {
        account = new Account("account_name", "supersecretpassword");
    }

    public void updateBalance(double amount) {
        account.balance += amount;
    }

    public boolean isActive() {
        return account.active;
    }

    public double getBalance() {
        return account.balance;
    }

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

    public void process() {
        if (account.active) {
            account.lastLogin = System.currentTimeMillis();
        }
    }

}

