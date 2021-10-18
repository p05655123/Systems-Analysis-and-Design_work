package com.example.sa_tw.Command.Bread;

import com.example.sa_tw.Command.Command;
import com.example.sa_tw.Mediator.Mediator;

import org.json.JSONException;
import org.json.JSONObject;

public class Bread2 extends Command {
    public Bread2(Mediator mediator){
        super(mediator);
    }

    protected void process(JSONObject result){
        try {
            String name= result.get("NAME").toString();
            int price=Integer.parseInt(result.get("PRICE").toString());
            int inventory=Integer.parseInt(result.get("INVENTORY").toString());
            mediator.setbreadInfo2(name,price,inventory);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
