package org.ies.bank.components.readers.random;

import org.ies.bank.components.readers.AccountReader;
import org.ies.bank.components.readers.BankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Random;

public class RandomBankReader implements BankReader {
    private final AccountReader accountReader;
    private final String [] NAMES ={
            "Santander", "Caixa", "BBVA", "Bankia", "Sabadell", "Bank2" , "Bank3", "Bank4"
    };
    private final int[] ACCOUNTS = {

    };

    private final Random random;

    public RandomBankReader(AccountReader accountReader, Random random) {
        this.accountReader = accountReader;
        this.random = random;
    }

    @Override
    public Bank read(){

        String name = NAMES[random.nextInt(NAMES.length)];
        int size = random.nextInt(20);
        Account[] accounts = new Account[size];
        for (int i = 0; i < size; i++) {
            accounts[i] = accountReader.read();
        }

        return new Bank(
                name,
                accounts
        );

    }

}
