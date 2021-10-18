package com.example.sa_tw.Command.Stationery;

import com.example.sa_tw.Command.Command;
import com.example.sa_tw.Mediator.Mediator;
import com.example.sa_tw.Shop.Stationery;

import org.json.JSONException;
import org.json.JSONObject;
public class Stationery1 extends Command {
    String name;
    int price;
    int inventory;
    public Stationery1(Mediator mediator){
        super(mediator);
    }

    protected void process(JSONObject result){
        try {
            name = result.get("NAME").toString();
            price = Integer.parseInt(result.get("PRICE").toString());
            inventory = Integer.parseInt(result.get("INVENTORY").toString());
            mediator.setstationeryInfo1(name,price,inventory);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
