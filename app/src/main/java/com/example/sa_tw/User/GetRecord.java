package com.example.sa_tw.User;

import java.util.ArrayList;

public class GetRecord {
    private GetRecord(){}
    private static GetRecord getrecord = new GetRecord();
    private ArrayList<String> item_All = new ArrayList<String>();
    private ArrayList<String> address = new ArrayList<String>();
    private ArrayList<String> state = new ArrayList<String>();
    private ArrayList<String> date = new ArrayList<String>();



    public void setItem_All(ArrayList array){
        this.item_All = array;
    }
    public void setAddress(ArrayList array){
        this.address = array;
    }
    public void setState(ArrayList array){
        this.state = array;
    }
    public void setDate(ArrayList array){
        this.date = array;
    }


    public ArrayList getItem_All(){
        return item_All;
    }
    public ArrayList getAddress(){
        return address;
    }
    public ArrayList getState(){
        return state;
    }
    public ArrayList getDate(){
        return date;
    }

    public static GetRecord getInstance(){
        return getrecord;
    }
}
