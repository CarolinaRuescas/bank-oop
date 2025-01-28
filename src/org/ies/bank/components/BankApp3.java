package org.ies.bank.components;

import org.ies.bank.components.readers.scanner.ScannerBankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;


public class BankApp3 {

    private final ScannerBankReader scannerBankReader;

    public BankApp3(ScannerBankReader scannerBankReader) {

        this.scannerBankReader = scannerBankReader;
    }

    public void run() {
        Bank bank = scannerBankReader.read();

        //Muestra todas la cuentas del banoc
        bank.showAccount();

        //Sca 50€ de la cuenta ES0003
        Account account = bank.findAccount("ES0003");
        if (account != null) {
            account.deposit(-50);
        } else {
            System.out.println(" Cuenta no encontrada");
        }

        //Muestra las cuentas del cliente con NIF 000X
        bank.totalAccount("000X");

        //Mete 300 en la cuenta ES0004
        Account account2 = bank.findAccount("ES0004");
        if (account2 != null) {
            account2.deposit(300);
        } else {
            System.out.println("Cuenta no encontrada");
        }

        //Muestra los datos del titular de la cuenta ES0001
        Customer customer = bank.findAccountCustomer("ES0001");
        if (customer != null) {
            customer.showInfo();
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }
}
