package com.example.sa_tw.User;

import java.util.ArrayList;

public class GetCart {
    private GetCart(){}
    private static GetCart getcart = new GetCart();
    private ArrayList<String> item_id = new ArrayList<String>();
    private ArrayList<String> quantity = new ArrayList<String>();



    public void setItem_id(ArrayList array){
        this.item_id = array;
    }
    public void setQuantity(ArrayList array){
        this.quantity = array;
    }


    public ArrayList getItem_id(){
        return item_id;

    }
    public ArrayList getQuantity(){
        return quantity;
    }

    public static GetCart getInstance(){
        return getcart;
    }
}
