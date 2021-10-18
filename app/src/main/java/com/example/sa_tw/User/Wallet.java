package com.example.sa_tw.User;

import com.example.sa_tw.Mediator.Mediator;

public class Wallet {
    private Mediator mediator = Mediator.getInstance();
    private int balance;
    private int discount;
    private static  Wallet wallet = new Wallet();
    private Wallet(){}

    public void setBalance(int balance){
        this.balance=balance;
    }
    public void setDiscount(int discount){
        this.discount=discount;
    }
    public int getBalance(){
        return balance;
    }
    public int getDiscount(){
        return discount;
    }
    public void deposit(int money){
        balance+=money;
        mediator.update_wallet();
    }
    public void withdraw(int money , int dis){
        balance-=money;
        discount = dis;
        mediator.update_wallet2();
    }
    public static Wallet getInstance(){
        return wallet;
    }
}
