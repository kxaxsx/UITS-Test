package com.kxaxsx.uitsTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Bank {

    private String bankName;
    private long authorizedCapital;
    private Set<BankAccounts> accounts; //bank can hold an account where its cardNumber is unique

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

        for (BankAccounts c : accounts)
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
    public Set<BankAccounts> getAccounts() {
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

    private class BankAccount implements BankAccounts {
        private String cardNumber;
        private String bankName;
        private AccountType accountType;
        private Customer accountHolder;

        /**
         * Constructs new bank account that contains card number,
         * account type (debet or credit) at the specified bank.
         *
         * @param cardNumber    card number
         * @param bankName      bank where account stores
         * @param accountType   type of an account
         * @param accountHolder who owns the account
         */
        public BankAccount(String cardNumber, String bankName, AccountType accountType, Customer accountHolder) {
            this.cardNumber = cardNumber;
            this.bankName = bankName;
            this.accountType = accountType;
            this.accountHolder = accountHolder;
        }

        /**
         * Returns owner of an account.
         *
         * @return owner
         */
        public Customer getAccountHolder() {
            return accountHolder;
        }

        /**
         * Returns name of the bank, where this account stores.
         *
         * @return name of bank
         */
        public String getBankName() {
            return bankName;
        }

        /**
         * Returns a card number.
         *
         * @return card number
         */
        public String getCardNumber() {
            return cardNumber;
        }

        /**
         * Returns type of an account.
         *
         * @return account type
         */
        public AccountType getAccountType() {
            return accountType;
        }

        /**
         * Returns a string representation of an account.
         *
         * @return a string representation of an account
         */
        @Override
        public String toString() {
            return "BankAccount{" +
                    "cardNumber=" + cardNumber +
                    ", bankName='" + bankName + '\'' +
                    ", accountType=" + accountType +
                    ", accountHolder=" + accountHolder +
                    '}';
        }

        /**
         * Indicates whether some other account is "equal to" this one.
         *
         * @param o other account
         * @return {@code true} if this account is the same as the other
         * argument; {@code false} otherwise.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BankAccount that = (BankAccount) o;

            if (cardNumber != that.cardNumber) return false;

            return true;
        }

        /**
         * Returns a hash code value for an account.
         *
         * @return a hash code value for this account.
         */
        @Override
        public int hashCode() {
            return cardNumber.hashCode();
        }
    }

}
