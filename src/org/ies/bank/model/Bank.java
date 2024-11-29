package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    // Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)
    // CUANDO EN EL ENUNCIADO PONE "MOSTRAR" ES UN VOID PORQUE NO DEVUELVE NADA

    public void showAccount(){
        for(Account account: accounts){
            System.out.println(account);
        }
    }

    public void showInfo(){
        for (Account account : accounts){
            System.out.println("IBAN: " + account.getIban() + "Saldo: " + account.getBalance() + "NIF: " + account.getCustomer().getNif());
        }
    }

    // Dado un IBAN, mostrar la información de la cuenta con ese IBAN.
    public void showAccountNif(String iban){
        for(Account account : accounts){
            if (account.getIban().equals(iban)){
            }
        }
    }

    // Dado un NIF, mostrar todas las cuentas del cliente con ese NIF





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
