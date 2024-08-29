package com.patika;

import java.util.TreeSet;

public class AccountManager {
    private final TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account login(String email, String password) {
        for (Account account : accounts) {
            try {
                account.login(email, password);
                return account;
            } catch (InvalidAuthenticationException e) {
                // Handle invalid authentication
            }
        }
        return null;
    }
}
