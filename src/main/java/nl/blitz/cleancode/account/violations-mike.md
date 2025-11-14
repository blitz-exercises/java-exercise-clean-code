# Vialations found.


## Meerdere onnodige comments die geen waarom toevoegen verwijderd en ook een deel oude code die niet gebruikt werd.

## er wordt een classes aangemaakt binnen een bestaande classes, deze afgesplits naar zijn eigen bestal Account.java met hierin een constructor
   // class Account {
    //     String username;
    //     String password;
    //     double balance;
    //     boolean active;
    //     long lastLogin;
    // }

## deze methode hoort niet in deze classes maar in de account classe als constructor
// public void createAccount(String username, String password) {
    //     account.username = username;
    //     account.password = password;
    //     account.balance = 0;
    //     account.active = true;
    // }