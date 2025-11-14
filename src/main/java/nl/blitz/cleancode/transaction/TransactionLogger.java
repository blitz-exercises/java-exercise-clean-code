package nl.blitz.cleancode.transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TransactionLogger {
    private List<String> transactions = new ArrayList<>();
    private File logFile = new File("transactions.log");

    // log transaction
    public void log(String transaction) {
        transactions.add(transaction);
        try {
            FileWriter writer = new FileWriter(logFile, true);
            writer.write(transaction + "\n");
            writer.close();
        } catch (IOException e) {
            // error occurred
        }
    }

    // get all transactions
    public List<String> getAllTransactions() {
        return transactions;
    }

    // clear transactions
    public void clear() {
        transactions.clear();
        if (logFile.exists()) {
            logFile.delete();
        }
    }

    // save transactions to file
    public void save() {
        try {
            FileWriter writer = new FileWriter(logFile);
            for (String transaction : transactions) {
                writer.write(transaction + "\n");
            }
            writer.close();
        } catch (IOException e) {
            // handle error
        }
    }

    // load transactions from file
    public void load() {
        // TODO: implement file loading
        // this will read from the log file and populate transactions list
    }

    // format transaction
    public String format(String type, double amount, String account) {
        return type + ":" + amount + ":" + account;
    }
}

