package com.example.sa_tw;
import android.app.Activity;

import com.example.sa_tw.Mediator.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class DBMgr {

    private Mediator mediator;
    private static DBMgr instance = new DBMgr();
    public static DBMgr getInstance(){
        return instance;
    }
    private DBconnection dBconnection;
    private String db_result="";
    private Activity activity;
    private DBMgr(){}
    public void setMediator (Mediator mediator){
        this.mediator=mediator;
    }
    private void reorganize_dbconnection(){
        dBconnection=new DBconnection();
    }//重整AsyncTask，因為一個AsyncTask只能execute一次

    /**SQL方法**/
    public void login(String acc,String pwd){
        reorganize_dbconnection();
        String url = "login.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8")).append("&");
            stringBuilder.append("password=").append(URLEncoder.encode(pwd,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void login_success(String acc){
        reorganize_dbconnection();
        String url = "get_user_info.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void loadbitem(String n , String name){
        reorganize_dbconnection();
        String url = "get_item.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("category_id=").append(URLEncoder.encode(n,"UTF-8")).append("&");
            stringBuilder.append("name=").append(URLEncoder.encode(name,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void loadditem(String n , String name){
        reorganize_dbconnection();
        String url = "get_item.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("category_id=").append(URLEncoder.encode(n,"UTF-8")).append("&");
            stringBuilder.append("name=").append(URLEncoder.encode(name,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }

    public void loadsitem(String n , String name){
        reorganize_dbconnection();
        String url = "get_item.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("category_id=").append(URLEncoder.encode(n,"UTF-8")).append("&");
            stringBuilder.append("name=").append(URLEncoder.encode(name,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }

    public void update_wallet(String acc,int balance_int){
        reorganize_dbconnection();
        String balance = String.valueOf(balance_int);
        String url = "update_wallet.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8")).append("&");
            stringBuilder.append("balance=").append(URLEncoder.encode(balance,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void update_wallet2(String acc,int balance_int,int discount_int){
        reorganize_dbconnection();
        String balance = String.valueOf(balance_int);
        String discount = String.valueOf(discount_int);
        String url = "update_walletanddiscount.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8")).append("&");
            stringBuilder.append("balance=").append(URLEncoder.encode(balance,"UTF-8")).append("&");
            stringBuilder.append("discount_point=").append(URLEncoder.encode(discount,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void intocart(String nid , int itemid , int q){
        reorganize_dbconnection();
        String a = String.valueOf(itemid);
        String b = String.valueOf(q);
        String url = "intocart.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("name_id=").append(URLEncoder.encode(nid,"UTF-8")).append("&");
            stringBuilder.append("item_id=").append(URLEncoder.encode(a,"UTF-8")).append("&");
            stringBuilder.append("quantity=").append(URLEncoder.encode(b,"UTF-8")).append("&");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void deletecart(String nid){
        reorganize_dbconnection();
        String url = "deletecart.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("user_id=").append(URLEncoder.encode(nid,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void outcart(String nid){
        reorganize_dbconnection();
        String url = "outcart.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("user_id=").append(URLEncoder.encode(nid,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void intoorder(String nid , String item , String address){
        reorganize_dbconnection();
        String url = "intoorder.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("name_id=").append(URLEncoder.encode(nid,"UTF-8")).append("&");
            stringBuilder.append("item=").append(URLEncoder.encode(String.valueOf(item),"UTF-8")).append("&");
            stringBuilder.append("address=").append(URLEncoder.encode(address,"UTF-8")).append("&");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void update_inventory(String n , String item){
        reorganize_dbconnection();
        String url = "update_inventory.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("id=").append(URLEncoder.encode(n,"UTF-8")).append("&");
            stringBuilder.append("inventory=").append(URLEncoder.encode(String.valueOf(item),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void get_item(String item_id){
        reorganize_dbconnection();
        String url = "get_inventory.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("id=").append(URLEncoder.encode(item_id,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void load_record(String acc){
        reorganize_dbconnection();
        String url = "get_record.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("user_id=").append(URLEncoder.encode(acc,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void check_register_data(String acc,String email){
        reorganize_dbconnection();
        String url = "check_register_data.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("email=").append(URLEncoder.encode(email,"UTF-8")).append("&");
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());

    }
    public void creat_account(String name,String email,String acc,String pwd){
        reorganize_dbconnection();
        String url = "create_account.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("name=").append(URLEncoder.encode(name,"UTF-8")).append("&");
            stringBuilder.append("email=").append(URLEncoder.encode(email,"UTF-8")).append("&");
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8")).append("&");
            stringBuilder.append("password=").append(URLEncoder.encode(pwd,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    public void reload_balance(String acc){
        reorganize_dbconnection();
        String url = "get_balance.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dBconnection.execute(url,stringBuilder.toString());
    }
    /**------------**/
    public void setActivity(Activity activity){
        this.activity=activity;
    }
    public Activity getActivity(){
        return activity;
    }
    public void set_result(String result){//接收DB傳回來的資訊
        this.db_result=result;
        try {
            mediator.db_load_finish(new JSONObject(result));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }





}
