package com.kxaxsx.uitsTest;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Three different bank for this example
        ArrayList<Bank> bankList = new ArrayList<>();
        bankList.add(new Bank("Ukrainian Bank", 1_000_000_000));
        bankList.add(new Bank("European Bank", 2_000_000_000));
        bankList.add(new Bank("Kharkiv Bank", 50_000_000));

        ArrayList<Customer> customersList = new ArrayList<>();

        //assume that the bank customer is older than 18 years and its maximum age is 100 years
        RandomDate randomDate = new RandomDate(IsoChronology.INSTANCE.date(1917, 1, 1)
                , IsoChronology.INSTANCE.date(1999, 1, 1));
        //generates 100 different customers
        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer(NameGenerator.generateName(),
                    NameGenerator.generateName(),
                    NameGenerator.generateName(),
                    randomDate.nextDate());

            //generates how many accounts customer will own
            BankOperations.addBanksToCustomer(customer, bankList);
            customersList.add(customer);

        }
        /*
        }*/
        //TASK #1 - Print all customers of the specified bank
        BankOperations.printAllCustomersOfBank(bankList.get(2));

        //TASK #2 Print all customers with cards in specified range
        BankOperations.printAllCustomersWithSpecifiedCardRange(bankList, "12");

        //TASK #3  Print all customers if they are clients more then one bank.
        BankOperations.printAllCustomersWithMoreThanOneBank(customersList);

        //TASK #4 Print all customers of banks that older\younger than specified age
        BankOperations.printCustomersOlderThan(bankList, 45);
        BankOperations.printCustomersYoungerThan(bankList, 20);

        //TASK #5 Print all clients of the specified bank in alphabet order
        BankOperations.printBankClientsInAlphabetOrder(bankList.get(1));

    }


}
