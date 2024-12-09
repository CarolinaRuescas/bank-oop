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
    public void showAccountCustomer(String iban){
        var account = findAccount(iban);
        if (account == null){
            System.out.println("La cuenta no existe");
        }else{
            account.getCustomer().showInfo();
        }

    }

    public int countCustomerAccount(String nif){
        int count = 0;
        for (var account: accounts){
            if (account.getCustomer().getNif().equals(nif)){
                count++;
            }
        }
        return count;
    }

    // Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)
    // CUANDO EN EL ENUNCIADO PONE "MOSTRAR" ES UN VOID PORQUE NO DEVUELVE NADA

    public void showAccount(){
        for(Account account: accounts){
            account.showInfo();
        }
    }
    // Este método lo hemos creado para ver si con un IBAN existe una cuenta o no ( no lo piden
    // en el ejercicio pero viene bien para ayudar a relaizr otros métodos, como por ejemplo el último)

    public Account findAccount(String iban){
        for(Account account : accounts){
            if (account.getIban().equals(iban)){
                return account;
            }
        }
        return null;
    }

    // Dado un IBAN, mostrar la información de la cuenta con ese IBAN.

    public void showInfo(String iban){
        for(Account account : accounts){
            if (account.getIban().equals(iban)){
                account.showInfo();
            }
        }
    }

    // Dado un NIF, mostrar todas las cuentas del cliente con ese NIF

    public void showAccountNif(String nif){
        for(Account account : accounts){
            if (account.getCustomer().getNif().equals(nif)){
                account.showInfo();
            }
        }
    }

    // Dado un IBAN y una cantidad de dinero, ingresar esa cantidad en la cuenta con ese IBAN.
    // Si no se encuentra la cuenta con ese IBAN muestra el mensaje "No se encuentra la cuenta"
    // en este utilizamos el métood creado por cuenta propia de "findAccount"
    // en este métedo hemos utilizado dos creados anteriormente

    public void deposit(String iban, double amount){
        Account account = findAccount(iban);
        if (account != null){
            account.deposit(amount);
            account.showInfo();
        }else{
            System.out.println("Cuenta no encontrada");
        }
    }

    // Dado un NIF, devuelve el número de cuentas de ese cliente

    public int totalAccount(String nif){
        int cont = 0;
        for(Account account : accounts){
            if (account.getCustomer().getNif().equals(nif)){
                cont++;
            }
        }
        return cont;
    }


    //Dado un IBAN, devuelve los datos del cliente al que pertenece la cuenta. Si no existe la cuenta devuelve null.

    public Customer findAccountCustomer(String iban){
        Account account = findAccount(iban);
        if (account != null){
            return account.getCustomer();
        }else {
            return null;
        }
    }

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
