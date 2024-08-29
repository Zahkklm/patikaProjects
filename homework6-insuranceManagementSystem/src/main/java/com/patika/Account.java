package com.patika;

import java.util.ArrayList;
import java.util.Date;

enum AuthenticationStatus {
    SUCCESS, FAIL
}

abstract class Account implements Comparable<Account> {
    protected AuthenticationStatus authStatus;
    protected final User user;
    protected final ArrayList<Insurance> insurances;

    public Account(User user) {
        this.user = user;
        this.authStatus = AuthenticationStatus.FAIL;
        this.insurances = new ArrayList<>();
    }

    public void addInsurance(Insurance insurance) {
        insurances.add(insurance);
    }

    public void removeInsurance(Insurance insurance) {
        insurances.remove(insurance);
    }

    public AuthenticationStatus getAuthStatus() {
        return authStatus;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            authStatus = AuthenticationStatus.SUCCESS;
            user.setLastLoginDate(new Date());
        } else {
            throw new InvalidAuthenticationException("Invalid email or password.");
        }
    }

    public abstract void showUserInfo();

    @Override
    public int compareTo(Account other) {
        return this.user.getEmail().compareTo(other.user.getEmail());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return user.equals(account.user);
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }
}

class Individual extends Account {
    public Individual(User user) {
        super(user);
    }

    @Override
    public void showUserInfo() {
        System.out.println(user);
    }
}

class Enterprise extends Account {
    public Enterprise(User user) {
        super(user);
    }

    @Override
    public void showUserInfo() {
        System.out.println(user);
    }
}
