package com.example.sa_tw.Items;

public class Getstationery {
    private Getstationery(){}
    private static Getstationery stationery = new Getstationery();
    public String name;
    public int price;
    public int inventory;

    public void setName(String name){
        this.name=name;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setInventory(int inventory){
        this.inventory=inventory;
    }


    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public int getInventory(){
        return inventory;
    }
    public static Getstationery getInstance(){
        return stationery;
    }


}
