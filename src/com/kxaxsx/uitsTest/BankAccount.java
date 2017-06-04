package com.kxaxsx.uitsTest;

public class BankAccount {

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

    /** Returns a card number.
     * @return card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**Returns type of an account.
     * @return account type
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /** Returns a string representation of an account.
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

    /**Indicates whether some other account is "equal to" this one.
     * @param o other account
     * @return {@code true} if this account is the same as the other
     *          argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        if (cardNumber != that.cardNumber) return false;

        return true;
    }

    /**Returns a hash code value for an account.
     * @return  a hash code value for this account.
     */
    @Override
    public int hashCode() {
        return cardNumber.hashCode();
    }
}
