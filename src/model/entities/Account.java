package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
    private int number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){}

    public Account(int number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double ammount) {
        this.balance += ammount;
    }

    public void withdraw(Double ammount) {
        if(ammount > this.withdrawLimit){
            throw new DomainExceptions("Limite de saque atingido");
        }

        if(ammount > this.balance) {
            throw new DomainExceptions("Saldo Insuficiente para o Saque");
        }
        this.balance -= ammount;
    }

    @Override
    public String toString(){
        return "Seu Saldo: "
                + String.format("%.2f", this.balance);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
