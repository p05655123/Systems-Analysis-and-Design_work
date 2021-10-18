package com.example.sa_tw.Command;

import com.example.sa_tw.Mediator.Mediator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Do_outcart extends Command{
    public String[] item_id;
    public Do_outcart(Mediator mediator) {
        super(mediator);
    }

    protected void process(JSONObject result){
        try {
            JSONArray jsonArray = result.getJSONArray("records");
            mediator.setcartInfo(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
