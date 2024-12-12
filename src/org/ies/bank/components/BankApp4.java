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
        if (account != null){
            bank.showAccount();


            bank.withdraw("ES0001", );
            bank.transfer("ES0001", "ES0002",);

        }else{
            System.out.println("Cuenta no encontrada. ERROR");
        }





    }
}
