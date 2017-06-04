package com.kxaxsx.uitsTest;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends Person {

    private ArrayList<BankAccount> accounts;

    /**
     * Constructs a customer object.
     *
     * @param name       customers name
     * @param middleName customers middle name
     * @param lastName   customers last name
     * @param birthday   customers birthday
     */
    public Customer(String name, String middleName, String lastName, LocalDate birthday) {
        super(name, middleName, lastName, birthday);
        accounts = new ArrayList<>();
    }

    /**
     * Adds new bank account. One person can own more than one bank account.
     *
     * @param account new account
     */
    public void addBankAccount(BankAccount account) {
        accounts.add(account);
    }

    /**Returns all bank accounts of this customer.
     * @return all bank accounts of this customer
     */
    public ArrayList<BankAccount> getBankAccounts() {
        return accounts;
    }


}
