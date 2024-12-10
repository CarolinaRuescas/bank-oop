package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp2 {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp2(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run(){
        // Siemrpe empezamos pidiendo  los datos con el reader
        Bank bank = bankReader.read();

        // Cuando se invoca findAccount, se sustituye por un objeto de tipo Account
        Account account = bank.findAccount("Es0001");
        if(account != null){
            account.deposit(500);
        }else{
            System.out.println(" No existe la cuenta ");
        }

        Account account2 = bank.findAccount("ES0002");
        if(account2 != null){
            account2.deposit(-30);
        }else{
            System.out.println("No existe la cuenta");
        }
        account.showInfo();
        account2.showInfo();

        // hacer una transferencia de 500€ desde ES0001 a ES0002

        bank.transfer("ES0001", "ES0002", 500);

    }

}
