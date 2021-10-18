package com.example.sa_tw.Command;

import com.example.sa_tw.Mediator.*;

import org.json.JSONException;
import org.json.JSONObject;

abstract public class Command { //command pattern
    protected Mediator mediator;
    public Command(Mediator mediator){
        this.mediator=mediator;
    }
    abstract protected void process(JSONObject result);
    protected boolean pre_process(JSONObject result){
        if(result.has("Error")){
            try {
                mediator.make_toast(result.get("Error").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }else if(result.has("Empty")){
            try {
                mediator.make_toast(result.get("Empty").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }
    public final void execute(JSONObject result){//Template method
        if (pre_process(result)){
            process(result);
        }
    }
}
