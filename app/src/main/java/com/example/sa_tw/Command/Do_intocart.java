package com.example.sa_tw.Command;

import com.example.sa_tw.Mediator.Mediator;

import org.json.JSONException;
import org.json.JSONObject;

public class Do_intocart extends Command {
    public Do_intocart(Mediator mediator){
        super(mediator);
    }
    protected void process(JSONObject result){

        try {
            mediator.make_toast(result.get("Successful").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
