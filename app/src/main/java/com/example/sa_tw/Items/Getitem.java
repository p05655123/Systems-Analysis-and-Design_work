package com.example.sa_tw.Items;


public class Getitem {
    private Getitem(){}
    private static Getitem item = new Getitem();
    public String inventory;

    public void set_Inventory(String inventory){
        this.inventory=inventory;
        System.out.println(inventory);
    }

    public String  get_Inventory(){
        return inventory;
    }
    public static Getitem getInstance(){
        return item;
    }
}
