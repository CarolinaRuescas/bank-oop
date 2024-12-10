package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp3 {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp3(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run(){
        Bank bank = bankReader.read();

        //Muestra todas la cuentas del banoc
        bank.showAccount();

        //Sca 50€ de la cuenta ES0003
        Account account = bank.findAccount("ES0003")
        if (account != null){
            account.deposit(-50);
        }else{
            System.out.println(" Cuenta no encontrada");
        }

        //Muestra las cuentas del cliente con NIF 000X
        bank.totalAccount("000X");





    }

}
