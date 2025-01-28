package org.ies.bank.components.readers.random;

import org.ies.bank.components.readers.BankReader;
import org.ies.bank.model.Bank;

import java.util.Random;

public class RandomBankReader implements BankReader {
    private final String [] NAMES ={
            "Santander", "Caixa", "BBVA", "Bankia", "Sabadell", "Bank2" , "Bank3", "Bank4"
    };
    private final int[] ACCOUNTS = {

    };

    private final Random random;

    public RandomBankReader(Random random) {
        this.random = random;
    }

    @Override
    public Bank read(){

        String name = NAMES[random.nextInt(NAMES.length)];
        String account = ACCOUNTS[random.nextInt(ACCOUNTS.length)];

        return new Bank(
                name,
                account
        );

    }

}
