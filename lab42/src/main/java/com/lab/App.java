package com.lab;

public class App {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        manager.openAccount(100.00);
        manager.openAccount(200.00);
        manager.openAccount(300.00);
        manager.openAccount(400.00);
        manager.openAccount(500.00);

        System.out.println("Newly created accounts:");
        Account[] accounts = manager.listAccounts();
        for (int i = 0; i < accounts.length; i++) {
            System.out.printf("Account Number: %s, Balance: %,.2f Baht\n",
                              accounts[i].getAccountNumber(), accounts[i].getBalance());
        }

        // Close account 1234-0002 and suspend 1234-0004
        accounts[1].close();
        manager.getAccount(accounts[3].getAccountNumber()).suspend();

        accounts[0].withdraw(100.);
        Account acc = manager.getAccount("1234-0003");
        acc.withdraw(150.);
        try {
            manager.getAccount("1234-0005").deposit(200.).transferTo(accounts[3], 100.);
        } catch (IllegalStateException e) {
            System.out.printf("Exception caught: %s\n", e.getMessage());
        }

        System.out.println("Active accounts:");
        accounts = manager.listAccounts(Account.Status.ACTIVE);
        for (Account account: accounts) {
            System.out.printf("Account Number: %s, Balance: %,.2f Baht\n",
                              account.getAccountNumber(), account.getBalance());
        }

        System.out.println("Suspended accounts:");
        accounts = manager.listAccounts(Account.Status.SUSPENDED);
        for (Account account: accounts) {
            System.out.printf("Account Number: %s, Balance: %,.2f Baht\n",
                              account.getAccountNumber(), account.getBalance());
        }

        System.out.println("Closed accounts:");
        accounts = manager.listAccounts(Account.Status.CLOSED);
        for (Account account: accounts) {
            System.out.printf("Account Number: %s, Balance: %,.2f Baht\n",
                              account.getAccountNumber(), account.getBalance());
        }
    }
}
