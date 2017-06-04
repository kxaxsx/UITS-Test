package com.kxaxsx.uitsTest;

import java.util.*;

/**
 * Contains all utility methods for bank accounts generating, printing with specified parameters.
 */
public class BankOperations {

    /**
     * Generates in how many banks current person will have accounts.
     *
     * @param customer customer
     * @param banks    list of banks
     */
    public static void addBanksToCustomer(Customer customer, ArrayList<Bank> banks) {
        Random random = new Random();
        //generates how many accounts customer will own
        int numberOfBanks = random.nextInt(banks.size()) + 1;

        for (int i = 0; i < numberOfBanks; i++) {
            banks.get(i).setNewAccount(customer);
        }
    }

    /**
     * Prints all customers of a bank from the list.
     *
     * @param customers list of customers
     */
    public static void printCustomers(ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            System.out.print(customer.getLastName() + " " + customer.getName() + "'s cards: ");
            for (BankAccount account : customer.getBankAccounts())
                System.out.print("   " + account.getCardNumber());
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Prints all customers of the specified bank.
     *
     * @param bank bank to print
     */
    public static void printAllCustomersOfBank(Bank bank) {
        Set<BankAccount> customers = bank.getAccounts();
        System.out.println("All customers of " + bank.getBankName() + ":");
        int i = 1;
        for (BankAccount c : customers)
            System.out.println(i++ + ": " + c.getAccountHolder().getLastName() + " " + c.getAccountHolder().getName());

        System.out.println();
    }

    /**
     * Prints all cards that starts with specified range.
     *
     * @param banks banks that stores accounts with card number
     * @param range range to search
     */
    public static void printAllCustomersWithSpecifiedCardRange(ArrayList<Bank> banks, String range) {
        //не совсем понял что значит "у которых номера какрт находятся в указанном диапазоне"
        //предполагаю что это может быть "начинается с **** цифр и тп.
        ArrayList<Customer> customers = new ArrayList<>();

        for (int i = 0; i < banks.size(); i++) {

            Set<BankAccount> accounts = banks.get(i).getAccounts();

            for (BankAccount bankAccount : accounts) {
                if (bankAccount.getCardNumber().startsWith(range))
                    customers.add(bankAccount.getAccountHolder());
            }
        }
        //prints all customers with an appropriate card
        System.out.println("Range is: " + range + ". Customers with an appropriate cards: ");
        for (Customer customer : customers) {
            System.out.print(customer.getLastName() + " card(s) number:");
            for (BankAccount account : customer.getBankAccounts()) {
                if (account.getCardNumber().startsWith(range))
                    System.out.print("   " + account.getCardNumber());
            }
            System.out.println();
        }
    }

    /**
     * Prints all customers if they are clients more then one bank.
     *
     * @param customers list of all customers
     */
    public static void printAllCustomersWithMoreThanOneBank(ArrayList<Customer> customers) {
        ArrayList<Customer> customersWithMoteThanOneBankAccount = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getBankAccounts().size() > 1)
                customersWithMoteThanOneBankAccount.add(customer);
        }

        printCustomers(customersWithMoteThanOneBankAccount);
    }

    /**
     * Prints all customers of banks that older than specified age.
     *
     * @param banks list of banks
     * @param age   age over which should be
     */
    public static void printCustomersOlderThan(ArrayList<Bank> banks, int age) {
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);

        for (Bank bank : banks) {
            System.out.println(bank.getBankName() + " clients older than " + age + ":");
            for (Customer customer : bank.getCustomers()) {
                if (yearNow - customer.getBirthday().getYear() > age) {
                    System.out.println(customer.toString());
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints all customers of banks that younger than specified age.
     *
     * @param banks list of banks
     * @param age   age below which should be
     */
    public static void printCustomersYoungerThan(ArrayList<Bank> banks, int age) {
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);

        for (Bank bank : banks) {
            System.out.println(bank.getBankName() + " clients younger than " + age + ":");
            for (Customer customer : bank.getCustomers()) {
                if (yearNow - customer.getBirthday().getYear() < age) {
                    System.out.println(customer.toString());
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints all clients of the specified bank in alphabet order.
     *
     * @param bank bank which customers need to sort
     */
    public static void printBankClientsInAlphabetOrder(Bank bank) {
        ArrayList<Customer> sortedCustomers = new ArrayList<>();

        for (Customer customer : bank.getCustomers()) {
            sortedCustomers.add(customer);
        }
        //sort customers
        Collections.sort(sortedCustomers);
        System.out.println("Customers of " + bank.getBankName()+ " in alphabet order: ");
        printCustomers(sortedCustomers);

    }

}
