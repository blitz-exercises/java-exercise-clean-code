package nl.blitz.cleancode.payment;

class PaymentHandler {
    private double balance = 0;

    public boolean processPayment(double amount, String cardNumber, String cvv, String expiryDate, String cardholderName) {
        if (amount <= 0) {
            return false;
        }
        if (cardNumber == null || cardNumber.length() != 16) {
            return false;
        }
        if (cvv == null || cvv.length() != 3) {
            return false;
        }
        if (expiryDate == null) {
            return false;
        }
        if (cardholderName == null) {
            return false;
        }

        // charge the card
        balance += amount;
        logTransaction(amount, cardNumber);
        sendReceipt(cardholderName, amount);
        updateAccountBalance(amount);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public boolean setBalance(double newBalance) {
        if (newBalance < 0) {
            return false;
        }
        balance = newBalance;
        return true;
    }

    private void logTransaction(double amount, String cardNumber) {
        // logging
    }

    private void sendReceipt(String name, double amount) {
        // send receipt
    }

    private void updateAccountBalance(double amount) {
        // update balance
    }
}

