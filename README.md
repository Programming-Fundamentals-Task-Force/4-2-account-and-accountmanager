# Assignment 4-2: Enhance the Account and AccountManager Classes

## Important

We will now work with Maven project layout. All the Java source will be in the `src/main/java` directory, which itself is in the `lab42` project directory. There will be some adjustments you will need to follow:

1. Start your IDE (VS Code) in the root (home) directory of the project (the same directory as the `README.md` file), not in `src/main/java`.

2. You can compile the source files by changing into the project directory (`lab42`), and issue the command:

```
mvn compile
```

3. To run the program, execute:

```
java -cp target/classes com.lab.App
```

The `-cp` option specifies the _classpath_ where the class files are.

## Instructions

This problem is similar to the previous `Account` assignment, but now includes `AccountManager` with the use of enums and `ArrayList`.

Using the provided `Account.java` file as the starting point, enhance the `Account` class to support money transfers between accounts and account suspension. Accounts that are suspended cannot deposit or withdraw money until reactivated.

Add the following methods to the `Account` class:

- `public void suspend()`:
  Suspends the account by setting its status to suspended.

- `public void reactivate()`:
  Reactivates the account by setting its status back to active.

- `public boolean isActive()`:
  Checks if the account is in the active state. Returns true if active, otherwise returns false for accounts that are suspended or closed.

- `public Account transferTo(Account destAcc, double amount)`:
  Transfers money from the current account to the specified destination account (`destAcc`) for the given amount. Returns the current account itself.

The account status is represented using an enum. Extend the enum to include a suspended status alongside active and closed.

## Enhance the following methods in the Account class:

- `public Account deposit(double amount)`:
  Modify to return the account itself.

- `public Account withdraw(double amount)`:
  Modify to return the account itself.

## Design the methods following the fluent API pattern, allowing method chaining, such as:

```
acc.deposit(100.00).withdraw(50.00).deposit(250.00);
```

## Add the following checks:

If the account is suspended or closed, deposits, withdrawals, and transfers should not be allowed. If any of these operations are attempted, throw an `IllegalStateException` with the message:

"Account is unavailable."

Note: Use `IllegalStateException` when an operation is performed in an invalid state.

Using the provided `AccountManager.java` file as a starting point, enhance the `AccountManager` class to filter accounts based on their status. Extend the existing functionality to allow listing accounts by specific statuses, not just active ones.

## Add the following method to the AccountManager class:

- `public Account[] listAccounts(Account.Status status)`:
  An overloaded method that filters and returns only accounts with the specified status as an array.

## Enhance the following method in the AccountManager class:

- `public Account[] listAccounts()`:
  Modify this method to delegate filtering to the `listAccounts(status)` method, selecting only accounts with the active status.

The problem includes the `App` class with `main()` method that demonstrates the usage of the `Account` class. The output when running the program should be:

```
Newly created accounts:
Account Number: 1234-0001, Balance: 100.00 Baht
Account Number: 1234-0002, Balance: 200.00 Baht
Account Number: 1234-0003, Balance: 300.00 Baht
Account Number: 1234-0004, Balance: 400.00 Baht
Account Number: 1234-0005, Balance: 500.00 Baht
Exception caught: Account is unavailable.
Active accounts:
Account Number: 1234-0001, Balance: 0.00 Baht
Account Number: 1234-0003, Balance: 150.00 Baht
Account Number: 1234-0005, Balance: 700.00 Baht
Suspended accounts:
Account Number: 1234-0004, Balance: 400.00 Baht
Closed accounts:
Account Number: 1234-0002, Balance: 200.00 Baht
```