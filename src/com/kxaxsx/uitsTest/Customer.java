package com.kxaxsx.uitsTest;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends Person {

    private ArrayList<BankAccounts> accounts;

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
//        accounts.get(0);
    }

    /**
     * Adds new bank account. One person can own more than one bank account.
     *
     * @param account new account
     */
    public void addBankAccount(BankAccounts account) {
        accounts.add(account);
    }

    /**Returns all bank accounts of this customer.
     * @return all bank accounts of this customer
     */
    public ArrayList<BankAccounts> getBankAccounts() {
        return accounts;
    }


}
