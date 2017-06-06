package com.kxaxsx.uitsTest;

public interface BankAccounts {

    /**
     * Returns owner of an account.
     *
     * @return owner
     */

    public Customer getAccountHolder();

    /**
     * Returns name of the bank, where this account stores.
     *
     * @return name of bank
     */
    public String getBankName();

    /**
     * Returns a card number.
     *
     * @return card number
     */
    public String getCardNumber();

    /**
     * Returns type of an account.
     *
     * @return account type
     */
    public AccountType getAccountType();

}
