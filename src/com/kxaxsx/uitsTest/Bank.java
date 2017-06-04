package com.kxaxsx.uitsTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Bank {

    private String bankName;
    private long authorizedCapital;
    private Set<BankAccount> accounts; //bank can hold an account where its cardNumber is unique

    /**
     * Constructs ea new Bank with specified name and an authorized capital.
     *
     * @param bankName          name of the bank
     * @param authorizedCapital amount of the authorized capital
     */
    public Bank(String bankName, long authorizedCapital) {
        this.bankName = bankName;
        this.authorizedCapital = authorizedCapital;
        this.accounts = new HashSet<>();
    }

    /**
     * Sets new bank account to the new customer and generates new card number.
     *
     * @param customer
     */
    public void setNewAccount(Customer customer) {
        //generates new card number
        CreditCardNumberGenerator cardNumberGenerator = new CreditCardNumberGenerator();
        String cardNumber = cardNumberGenerator.generate("", 16);
        //creates new bank account
        BankAccount newAccount = new BankAccount(cardNumber,
                bankName, generateAccountType(), customer);

        //adds new account to the customer account list
        customer.addBankAccount(newAccount);
        //adds new account to the bank list
        accounts.add(newAccount);
    }

    /**
     * Returns all customers of the bank.
     *
     * @return list of bank customers
     */
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        for (BankAccount c : accounts)
            customers.add(c.getAccountHolder());

        return customers;
    }

    /**
     * Returns the name of the bank.
     *
     * @return name of bank
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Returns list of accounts that stores in this bank.
     *
     * @return set of an accounts
     */
    public Set<BankAccount> getAccounts() {
        return accounts;
    }

    /**
     * Returns the number of an accounts that stores in this bank.
     *
     * @return number of the accounts
     */
    public int getAccountsSize() {
        return accounts.size();
    }

    /**
     * Returns an authorized capital of the bank.
     *
     * @return an authorized capital amount
     */
    public long getAuthorizedCapital() {
        return authorizedCapital;
    }

    /**
     * Generates an account type - Debet or Credit.
     *
     * @return account type
     */
    private AccountType generateAccountType() {
        Random random = new Random();
        int accType = random.nextInt(2);

        if (accType > 0)
            return AccountType.DEBET;
        else
            return AccountType.CREDIT;


    }

}
