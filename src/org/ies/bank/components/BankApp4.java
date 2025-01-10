package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp4 {
    private final BankReader bankReader;


    public BankApp4(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run(){
        Bank bank = bankReader.read();

        //Busca la cuenta con IBAN ES0001
        Account account = bank.findAccount("ES0001");
        if (account != null) {
            bank.showAccount();
        }else {
            System.out.println("No existe la cuenta");
        }

        Account account1 = bank.findAccount("ES0001");
        Account account2 = bank.findAccount("ES0002");

        if (account1 !=null && account2 != null) {
            double amount = account1.getBalance();
            bank.transfer("ES0001", "ES0002", amount);
        }else{
            System.out.println("Cuenta no encontrada. ERROR");
        }
        bank.showAccount();
    }
}
