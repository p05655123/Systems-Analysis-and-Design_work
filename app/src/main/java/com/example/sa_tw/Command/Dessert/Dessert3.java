package com.example.sa_tw.Command.Dessert;

import com.example.sa_tw.Command.Command;
import com.example.sa_tw.Mediator.Mediator;
import com.example.sa_tw.Shop.Bread;

import org.json.JSONException;
import org.json.JSONObject;
public class Dessert3 extends Command{
    String name;
    int price;
    int inventory;
    public Dessert3(Mediator mediator){
        super(mediator);
    }

    protected void process(JSONObject result){
        try {
            name = result.get("NAME").toString();
            price = Integer.parseInt(result.get("PRICE").toString());
            inventory = Integer.parseInt(result.get("INVENTORY").toString());
            mediator.setdessertInfo3(name,price,inventory);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
