package com.example.sa_tw.Items;

public class Getdessert {
    private Getdessert(){}
    private static Getdessert dessert = new Getdessert();
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
    public static Getdessert getInstance(){
        return dessert;
    }

}
