package com.example.sa_tw.Mediator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.example.sa_tw.Command.*;
import com.example.sa_tw.Command.Bread.Bread1;
import com.example.sa_tw.Command.Bread.Bread2;
import com.example.sa_tw.Command.Bread.Bread3;
import com.example.sa_tw.Command.Bread.Bread4;
import com.example.sa_tw.Command.Dessert.Dessert1;
import com.example.sa_tw.Command.Dessert.Dessert2;
import com.example.sa_tw.Command.Dessert.Dessert3;
import com.example.sa_tw.Command.Dessert.Dessert4;
import com.example.sa_tw.Command.Stationery.Stationery1;
import com.example.sa_tw.Command.Stationery.Stationery2;
import com.example.sa_tw.Command.Stationery.Stationery3;
import com.example.sa_tw.Command.Stationery.Stationery4;
import com.example.sa_tw.Home;
import com.example.sa_tw.Introduction;
import com.example.sa_tw.INFO;
import com.example.sa_tw.Items.Getbread;
import com.example.sa_tw.Items.Getdessert;
import com.example.sa_tw.Items.Getstationery;
import com.example.sa_tw.MainActivity;
import com.example.sa_tw.Deposit;
import com.example.sa_tw.OTP.*;
import com.example.sa_tw.OTPinput;
import com.example.sa_tw.Order_info;
import com.example.sa_tw.Recordlist;
import com.example.sa_tw.Shop.Bread;
import com.example.sa_tw.Shop.Bread_1;
import com.example.sa_tw.Shop.Bread_2;
import com.example.sa_tw.Shop.Bread_3;
import com.example.sa_tw.Shop.Dessert;
import com.example.sa_tw.Shop.Dessert_1;
import com.example.sa_tw.Shop.Dessert_2;
import com.example.sa_tw.Shop.Dessert_3;
import com.example.sa_tw.Shop.Shop;
import com.example.sa_tw.Shop.Stationery;
import com.example.sa_tw.Shop.Stationery_1;
import com.example.sa_tw.Shop.Stationery_2;
import com.example.sa_tw.Shop.Stationery_3;
import com.example.sa_tw.SignUp_GUI;
import com.example.sa_tw.ShoppingCart;
import com.example.sa_tw.User.*;
import com.example.sa_tw.DBMgr;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class Mediator<Sting> {
    private Deposit deposit_GUI;
    private Recordlist recordlist_GUI;
    private INFO info_GUI;
    private SignUp_GUI signUp_GUI;
    private static Mediator mediator = new Mediator();
    private DBMgr dbMgr = DBMgr.getInstance();
    private MainActivity mainActivity;
    private Home home_GUI;
    private OTPinput otp_GUI ;
    protected OTP otp ;
    private Mailsever mailsever=new Mailsever();
    private Person person;
    private Wallet wallet;
    private GetCart getcart;
    private GetRecord getrecord;
    private OTP_successful_command otp_command;
    protected Command command;
    private String temp_acc;
    private Shop shop_GUI;
    private Getbread getbread;
    private Getdessert getdessert;
    private Getstationery getstationery;
    private Bread bread_GUI;
    private Bread_1 bread_1_GUI;
    private Bread_2 bread_2_GUI;
    private Bread_3 bread_3_GUI;
    private Dessert dessert_GUI;
    private Dessert_1 dessert_1_GUI;
    private Dessert_2 dessert_2_GUI;
    private Dessert_3 dessert_3_GUI;
    private Stationery stationery_GUI;
    private Stationery_1 stationery_1_GUI;
    private Stationery_2 stationery_2_GUI;
    private Stationery_3 stationery_3_GUI;
    private Introduction introduction_GUI;
    private ShoppingCart shoppingcart_GUI;
    private Order_info order_info_GUI;
    String address;
    String discount;
    int tm;
    ArrayList<String> a = new ArrayList<String>();
    ArrayList<String> b = new ArrayList<String>();
    ArrayList<String> item_All = new ArrayList<String>();
    ArrayList<String> Address = new ArrayList<String>();
    ArrayList<String> State = new ArrayList<String>();
    ArrayList<String> Date = new ArrayList<String>();
    JSONObject temp;
    JSONObject temp2;

    public Mediator() {
    }

    public static Mediator getInstance(){
        return mediator;
    }
    public void setup(){
        dbMgr.setMediator(this);
        person=Person.getInstance();
        getcart=GetCart.getInstance();
        getrecord=GetRecord.getInstance();
        wallet=Wallet.getInstance();
        getbread=Getbread.getInstance();
        getdessert=Getdessert.getInstance();
        getstationery=Getstationery.getInstance();
        otp_GUI = OTPinput.getInstance();
        otp = OTP.getInstance();
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        dbMgr.setActivity(mainActivity);
    }

    public void setOtp_GUI(OTPinput otp_GUI){
        this.otp_GUI=otp_GUI;
    }
    public void setDeposit_GUI(Deposit deposit_GUI){
        this.deposit_GUI=deposit_GUI;
    }
    public void setRecordlist_GUI(Recordlist recordlist_GUI){
        this.recordlist_GUI=recordlist_GUI;
    }
    public void setInfo_GUI(INFO info_GUI){
        this.info_GUI=info_GUI;
    }
    public void setSignUp_GUI(SignUp_GUI signUp_GUI){
        this.signUp_GUI=signUp_GUI;
    }
    public void setShop_GUI(Shop shop_GUI){
        this.shop_GUI=shop_GUI;
    }
    public void setBread_GUI(Bread bread_GUI){
        this.bread_GUI=bread_GUI;
    }
    public void setBread_1_GUI(Bread_1 bread_1_GUI){
        this.bread_1_GUI=bread_1_GUI;
    }
    public void setBread_2_GUI(Bread_2 bread_2_GUI){
        this.bread_2_GUI=bread_2_GUI;
    }
    public void setBread_3_GUI(Bread_3 bread_3_GUI){
        this.bread_3_GUI=bread_3_GUI;
    }
    public void setDessert_GUI(Dessert dessert_GUI){
        this.dessert_GUI=dessert_GUI;
    }
    public void setDessert_1_GUI(Dessert_1 dessert_1_GUI){
        this.dessert_1_GUI=dessert_1_GUI;
    }
    public void setDessert_2_GUI(Dessert_2 dessert_2_GUI){
        this.dessert_2_GUI=dessert_2_GUI;
    }
    public void setDessert_3_GUI(Dessert_3 dessert_3_GUI){
        this.dessert_3_GUI=dessert_3_GUI;
    }
    public void setStationery_GUI(Stationery stationery_GUI){
        this.stationery_GUI=stationery_GUI;
    }
    public void setStationery_1_GUI(Stationery_1 stationery_1_GUI){
        this.stationery_1_GUI=stationery_1_GUI;
    }
    public void setStationery_2_GUI(Stationery_2 stationery_2_GUI){
        this.stationery_2_GUI=stationery_2_GUI;
    }
    public void setStationery_3_GUI(Stationery_3 stationery_3_GUI){
        this.stationery_3_GUI=stationery_3_GUI;
    }
    public void setShoppingCart_GUI(ShoppingCart shoppingcart_GUI){ this.shoppingcart_GUI=shoppingcart_GUI; }
    public void setOrder_info_GUI(Order_info order_info_GUI){ this.order_info_GUI=order_info_GUI; }
    public void setHome_GUI(Home home_GUI) {
        this.home_GUI = home_GUI;
    }

    public void db_load_finish(JSONObject db_result) {
        //  ProgressDialog_finish();
        command.execute(db_result);
    }

    public void make_toast(String msg){
        Toast.makeText(mainActivity,msg,Toast.LENGTH_SHORT).show();
    }
    public void setDbMgr_activity(Activity activity){
        dbMgr.setActivity(activity);
    }
    public String get_email(){
        return person.getEmail();
    }

    /** Deposit **/
    public void update_wallet(){
        dbMgr.update_wallet(person.getAcc(),wallet.getBalance());
    }
    public void depoist(String money){
        command = new Do_deposit(this);
        int temp = Integer.parseInt(money) ;
        wallet.deposit(temp);
        deposit_GUI.finish();
    }
    public void set_deposit(){
        deposit_GUI.set_balance(wallet.getBalance());
    }
    /**-------**/

    /** Withdraw **/
    public void update_wallet2(){
        dbMgr.update_wallet2(person.getAcc(),wallet.getBalance(),wallet.getDiscount());
    }
    public void withdraw(String money , String dis){
        command = new Do_withdraw(this);
        int temp = Integer.parseInt(money) ;
        int temp2 = Integer.parseInt(dis) ;
        wallet.withdraw(temp,temp2);
    }
    /**-------**/
    /** Cart **/
    public void intocart(int n , int q , int price){
        command = new Do_intocart(this);
        dbMgr.intocart(person.getName_id(),n,q);
    }
    public void deletecart(){
        command = new Do_deletecart(this);
        dbMgr.deletecart(person.getName_id());
    }
    public void getcart() throws JSONException {
        command = new Do_outcart(this);
        dbMgr.outcart(person.getName_id());
        setcartInfo(null);
    }
    public void setcartInfo(JSONArray array) throws JSONException {
        if(array != null){
            a.clear();
            b.clear();
            for(int i = 0 ; i < array.length() ; i++){
                temp = array.getJSONObject(i);
                String item_id = temp.getString("ITEM_ID");
                String quantity = temp.getString("QUANTITY");
                a.add(item_id);
                b.add(quantity);
            }
            getcart.setItem_id(a);
            getcart.setQuantity(b);
        }else{
            getcart.setItem_id(null);
            getcart.setQuantity(null);
        }

    }
    public void output_item_id(){
        shoppingcart_GUI.set_item_id(getcart.getItem_id());
    }
    public void output_quantity(){
        shoppingcart_GUI.set_quantity(getcart.getQuantity());
    }
    public void output2_item_id(){
        order_info_GUI.set_item_id(getcart.getItem_id());
    }
    public void output2_quantity(){
        order_info_GUI.set_quantity(getcart.getQuantity());
    }

    /**-------**/

    /**OTP**/
    public void creat_OTP(String address, int tm ,String discount){
        this.address = address;
        this.tm = tm;
        this.discount = discount;
        otp.creat_password();
    }
    public void send_OTP(String otp){
        mailsever.sendEmail(person.getEmail(),otp);
    }
    public void check_OTP(String enter_otp){
        otp.check_Password(enter_otp);
    }
    public void OTP_checked(){
        ConfirmOrder();
        update_inventory();
        if(tm >= 100){
            withdraw(String.valueOf(wallet.getBalance() - tm) , String.valueOf(Math.round(Double.valueOf(wallet.getBalance() - tm)*0.01) + Integer.valueOf(discount)));
        }else{
            withdraw(String.valueOf(wallet.getBalance() - tm) , discount);
        }

        deletecart();
        otp_GUI.finish();
        show_home_GUI();
    }
    public void update_inventory(){
        /*ArrayList<String> inventory = new ArrayList<>();
        for(int i = 0 ; i < a.size() ; i++){
            get_item(a.get(i));
            *//*System.out.println(getitem.get_Inventory());
            inventory.add(String.valueOf(Integer.valueOf(getitem.get_Inventory()) - Integer.valueOf(b.get(i))));*//*
        }*/
        for(int i = 0 ; i < a.size() ; i++){
            dbMgr.update_inventory(a.get(i),String.valueOf(100-Integer.valueOf(b.get(i))));
        }

    }
    public void ConfirmOrder(){
        command = new Get_item(this);
        String[][] d = new String[a.size()][3];
        for(int i = 0 ; i < a.size() ; i++){
            switch (a.get(i)) {
                case "1":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(15 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "2":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(10 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "3":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(80 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "4":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(60 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "5":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(40 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "6":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(25 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "7":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(200 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "8":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(15 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "9":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(25 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "10":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(60 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "11":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(20 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
                case "12":
                    d[i][0] = a.get(i);
                    d[i][1] = b.get(i);
                    d[i][2] = String.valueOf(35 * Integer.parseInt(String.valueOf(b.get(i))));
                    break;
            }
        }
        dbMgr.intoorder(person.getName_id(),Arrays.deepToString(d), address);
    }
    public int  CalFinalPay(int balance , int finalpay){
        return balance - finalpay;
    }

    /**-------**/

    /**Login**/
    public void login(String acc,String pwd){
        command=new Login(this);
        dbMgr.login(acc,pwd);
        temp_acc=acc;

    }
    public void login_success(){
        command= new Login_success(this);
        dbMgr.login_success(temp_acc);
    }
    public void setuserInfo(String name_id,String name,String email,int balance,int discount){
        person.setAcc(temp_acc);
        person.setEmail(email);
        person.setName(name);
        person.setName_id(name_id);
        wallet.setBalance(balance);
        wallet.setDiscount(discount);

    }

    /**Record**/
    public void load_record() throws JSONException {
        command=new Load_record(this);
        dbMgr.load_record(person.getName_id());
        set_recodlistGUI_records(null);
    }
    public void set_recodlistGUI_records(JSONArray records) throws JSONException {
        if(records != null){
            item_All.clear();
            Address.clear();
            State.clear();
            Date.clear();
            for(int i = 0 ; i < records.length() ; i++){
                temp2 = records.getJSONObject(i);
                String a1 = temp2.getString("ITEM");
                String b1 = temp2.getString("ADDRESS");
                String c1 = temp2.getString("STATE");
                String d1 = temp2.getString("DATE");
                item_All.add(a1);
                Address.add(b1);
                State.add(c1);
                Date.add(d1);
            }
            getrecord.setItem_All(item_All);
            getrecord.setAddress(Address);
            getrecord.setState(State);
            getrecord.setDate(Date);
        }else{
            getrecord.setItem_All(null);
            getrecord.setAddress(null);
            getrecord.setState(null);
            getrecord.setDate(null);
        }
    }
    public void output_item_All(){
        recordlist_GUI.set_item_All(getrecord.getItem_All());
    }
    public void output_Address(){
        recordlist_GUI.set_Address(getrecord.getAddress());
    }
    public void output_State(){
        recordlist_GUI.set_State(getrecord.getState());
    }
    public void output_Date(){
        recordlist_GUI.set_Date(getrecord.getDate());
    }
    /**-------**/

    /**Bread**/
    public void get_bitem1(String n , String name){
        command= new Bread1(this);
        dbMgr.loadbitem(n,name);
    }
    public void get_bitem2(String n , String name){
        command= new Bread2(this);
        dbMgr.loadbitem(n,name);
    }
    public void get_bitem3(String n , String name){
        command= new Bread3(this);
        dbMgr.loadbitem(n,name);
    }
    public void get_bitem4(String n , String name){
        command= new Bread4(this);
        dbMgr.loadbitem(n,name);
    }

    public void setbreadInfo1(String name,int price,int inventory){
        getbread.setName(name);
        getbread.setPrice(price);
        getbread.setInventory(inventory);
    }
    public void setbreadInfo2(String name,int price,int inventory){
        getbread.setName(name);
        getbread.setPrice(price);
        getbread.setInventory(inventory);

    }
    public void setbreadInfo3(String name,int price,int inventory){
        getbread.setName(name);
        getbread.setPrice(price);
        getbread.setInventory(inventory);
    }
    public void setbreadInfo4(String name,int price,int inventory){
        getbread.setName(name);
        getbread.setPrice(price);
        getbread.setInventory(inventory);
    }

    public void output_bname1(){
        bread_GUI.set_name1(getbread.getName());
    }
    public void output_bprice1(){
        bread_GUI.set_price1(getbread.getPrice());
    }
    public void output_binventory1(){
        bread_GUI.set_inventory1(getbread.getInventory());
    }

    public void output_bname2(){
        bread_1_GUI.set_name2(getbread.getName());
    }
    public void output_bprice2(){
        bread_1_GUI.set_price2(getbread.getPrice());
    }
    public void output_binventory2(){
        bread_1_GUI.set_inventory2(getbread.getInventory());
    }

    public void output_bname3(){
        bread_2_GUI.set_name3(getbread.getName());
    }
    public void output_bprice3(){
        bread_2_GUI.set_price3(getbread.getPrice());
    }
    public void output_binventory3(){
        bread_2_GUI.set_inventory3(getbread.getInventory());
    }

    public void output_bname4(){
        bread_3_GUI.set_name4(getbread.getName());
    }
    public void output_bprice4(){
        bread_3_GUI.set_price4(getbread.getPrice());
    }
    public void output_binventory4(){
        bread_3_GUI.set_inventory4(getbread.getInventory());
    }

    /**-------**/
    /**Stationery**/
    public void get_sitem1(String n , String name){
        command= new Stationery1(this);
        dbMgr.loadsitem(n,name);
    }
    public void get_sitem2(String n , String name){
        command= new Stationery2(this);
        dbMgr.loadsitem(n,name);
    }
    public void get_sitem3(String n , String name){
        command= new Stationery3(this);
        dbMgr.loadsitem(n,name);
    }
    public void get_sitem4(String n , String name){
        command= new Stationery4(this);
        dbMgr.loadsitem(n,name);
    }

    public void setstationeryInfo1(String name,int price,int inventory){
        getstationery.setName(name);
        getstationery.setPrice(price);
        getstationery.setInventory(inventory);
    }
    public void setstationeryInfo2(String name,int price,int inventory){
        getstationery.setName(name);
        getstationery.setPrice(price);
        getstationery.setInventory(inventory);

    }
    public void setstationeryInfo3(String name,int price,int inventory){
        getstationery.setName(name);
        getstationery.setPrice(price);
        getstationery.setInventory(inventory);
    }
    public void setstationeryInfo4(String name,int price,int inventory){
        getstationery.setName(name);
        getstationery.setPrice(price);
        getstationery.setInventory(inventory);
    }

    public void output_sname1(){
        stationery_GUI.set_name1(getstationery.getName());
    }
    public void output_sprice1(){
        stationery_GUI.set_price1(getstationery.getPrice());
    }
    public void output_sinventory1(){
        stationery_GUI.set_inventory1(getstationery.getInventory());
    }

    public void output_sname2(){
        stationery_1_GUI.set_name2(getstationery.getName());
    }
    public void output_sprice2(){
        stationery_1_GUI.set_price2(getstationery.getPrice());
    }
    public void output_sinventory2(){
        stationery_1_GUI.set_inventory2(getstationery.getInventory());
    }

    public void output_sname3(){
        stationery_2_GUI.set_name3(getstationery.getName());
    }
    public void output_sprice3(){
        stationery_2_GUI.set_price3(getstationery.getPrice());
    }
    public void output_sinventory3(){
        stationery_2_GUI.set_inventory3(getstationery.getInventory());
    }

    public void output_sname4(){
        stationery_3_GUI.set_name4(getstationery.getName());
    }
    public void output_sprice4(){
        stationery_3_GUI.set_price4(getstationery.getPrice());
    }
    public void output_sinventory4(){
        stationery_3_GUI.set_inventory4(getstationery.getInventory());
    }

    /**-------**/

    /**Dessert**/
    public void get_ditem1(String n , String name){
        command= new Dessert1(this);
        dbMgr.loadditem(n,name);
    }
    public void get_ditem2(String n , String name){
        command= new Dessert2(this);
        dbMgr.loadditem(n,name);
    }
    public void get_ditem3(String n , String name){
        command= new Dessert3(this);
        dbMgr.loadditem(n,name);
    }
    public void get_ditem4(String n , String name){
        command= new Dessert4(this);
        dbMgr.loadditem(n,name);
    }

    public void setdessertInfo1(String name,int price,int inventory){
        getdessert.setName(name);
        getdessert.setPrice(price);
        getdessert.setInventory(inventory);
    }
    public void setdessertInfo2(String name,int price,int inventory){
        getdessert.setName(name);
        getdessert.setPrice(price);
        getdessert.setInventory(inventory);

    }
    public void setdessertInfo3(String name,int price,int inventory){
        getdessert.setName(name);
        getdessert.setPrice(price);
        getdessert.setInventory(inventory);
    }
    public void setdessertInfo4(String name,int price,int inventory){
        getdessert.setName(name);
        getdessert.setPrice(price);
        getdessert.setInventory(inventory);
    }

    public void output_dname1(){
        dessert_GUI.set_name1(getdessert.getName());
    }
    public void output_dprice1(){
        dessert_GUI.set_price1(getdessert.getPrice());
    }
    public void output_dinventory1(){
        dessert_GUI.set_inventory1(getdessert.getInventory());
    }

    public void output_dname2(){
        dessert_1_GUI.set_name2(getdessert.getName());
    }
    public void output_dprice2(){
        dessert_1_GUI.set_price2(getdessert.getPrice());
    }
    public void output_dinventory2(){
        dessert_1_GUI.set_inventory2(getdessert.getInventory());
    }

    public void output_dname3(){
        dessert_2_GUI.set_name3(getdessert.getName());
    }
    public void output_dprice3(){
        dessert_2_GUI.set_price3(getdessert.getPrice());
    }
    public void output_dinventory3(){
        dessert_2_GUI.set_inventory3(getdessert.getInventory());
    }

    public void output_dname4(){
        dessert_3_GUI.set_name4(getdessert.getName());
    }
    public void output_dprice4(){
        dessert_3_GUI.set_price4(getdessert.getPrice());
    }
    public void output_dinventory4(){
        dessert_3_GUI.set_inventory4(getdessert.getInventory());
    }

    /**-------**/

    /**Info**/
    public void reload_balance(){
        command = new reload_balance(this);
        dbMgr.reload_balance(person.getAcc());
    }
    public void reset_balance(int balance){
        wallet.setBalance(balance);
    }
    public void output_acc(){
        info_GUI.set_acc(person.getAcc());
    }
    public void output_name(){
        info_GUI.set_name(person.getName());
    }
    public void output_email(){
        info_GUI.set_email(person.getEmail());
    }
    public void output_balance(){
        command=new Login(this);
        info_GUI.set_balance(wallet.getBalance());
    }
    public void output2_balance(){
        order_info_GUI.set_balance(wallet.getBalance());
    }
    public void output_discount(){
        info_GUI.set_discount(wallet.getDiscount());
    }
    public void output2_discount(){
        command=new Login(this);
        order_info_GUI.set_discount(wallet.getDiscount());
    }
    /**-------**/

    /**SignUp**/
    public void check_signup_data(String acc,String email){
        command = new canregister(this);
        dbMgr.check_register_data(acc,email);
    }
    public void register(){
        command=new Creat_account(this);
        dbMgr.creat_account(signUp_GUI.get_name(),signUp_GUI.get_email(),signUp_GUI.get_acc(),signUp_GUI.get_pwd());
        signUp_GUI.finish();

    }
    /**-------**/

    /**-------**/

    /**Show GUI**/
    public void show_home_GUI(){
        Intent intent = new Intent();
        intent.setClass(mainActivity , Home.class);
        mainActivity.startActivity(intent);
    }
    public void show_record_GUI(){
        Intent intent = new Intent();
        intent.setClass(home_GUI , Recordlist.class);
        home_GUI.startActivity(intent);
    }
    public void show_bread_GUI(){
        Intent intent = new Intent();
        intent.setClass(shop_GUI , Bread.class);
        shop_GUI.startActivity(intent);
    }
    public void show_bread_1_GUI(){
        Intent intent = new Intent();
        intent.setClass(bread_GUI , Bread_1.class);
        bread_GUI.startActivity(intent);
    }
    public void show_bread_2_GUI(){
        Intent intent = new Intent();
        intent.setClass(bread_1_GUI , Bread_2.class);
        bread_1_GUI.startActivity(intent);
    }
    public void show_bread_3_GUI(){
        Intent intent = new Intent();
        intent.setClass(bread_2_GUI , Bread_3.class);
        bread_2_GUI.startActivity(intent);
    }
    public void show_dessert_GUI(){
        Intent intent = new Intent();
        intent.setClass(shop_GUI , Dessert.class);
        shop_GUI.startActivity(intent);
    }
    public void show_dessert_1_GUI(){
        Intent intent = new Intent();
        intent.setClass(dessert_GUI , Dessert_1.class);
        shop_GUI.startActivity(intent);
    }
    public void show_dessert_2_GUI(){
        Intent intent = new Intent();
        intent.setClass(dessert_1_GUI , Dessert_2.class);
        dessert_1_GUI.startActivity(intent);
    }
    public void show_dessert_3_GUI(){
        Intent intent = new Intent();
        intent.setClass(dessert_2_GUI , Dessert_3.class);
        dessert_2_GUI.startActivity(intent);
    }
    public void show_stationery_GUI(){
        Intent intent = new Intent();
        intent.setClass(shop_GUI , Stationery.class);
        shop_GUI.startActivity(intent);
    }
    public void show_stationery_1_GUI(){
        Intent intent = new Intent();
        intent.setClass(stationery_GUI , Stationery_1.class);
        stationery_GUI.startActivity(intent);
    }
    public void show_stationery_2_GUI(){
        Intent intent = new Intent();
        intent.setClass(stationery_1_GUI , Stationery_2.class);
        stationery_1_GUI.startActivity(intent);
    }
    public void show_stationery_3_GUI(){
        Intent intent = new Intent();
        intent.setClass(stationery_2_GUI , Stationery_3.class);
        stationery_2_GUI.startActivity(intent);
    }
    public void show_deposit_GUI() {
        Intent intent = new Intent();
        intent.setClass(home_GUI, Deposit.class);
        home_GUI.startActivity(intent);
    }
    public void show_shop_GUI(){
        Intent intent = new Intent();
        intent.setClass(home_GUI , Shop.class);
        home_GUI.startActivity(intent);
    }
    public void show_order_info_GUI(){
        Intent intent = new Intent();
        intent.setClass(shoppingcart_GUI, Order_info.class);
        shoppingcart_GUI.startActivity(intent);
    }
    public void show_otp_GUI(){
        Intent intent = new Intent();
        intent.setClass(order_info_GUI , OTPinput.class);
        order_info_GUI.startActivity(intent);
    }
    public void show_info_GUI(){
        Intent intent = new Intent();
        intent.setClass(home_GUI, INFO.class);
        home_GUI.startActivity(intent);
    }
    public void show_signup_GUI(){
        Intent intent = new Intent();
        intent.setClass(mainActivity, SignUp_GUI.class);
        mainActivity.startActivity(intent);
    }
    public void show_introduction_GUI(){
        Intent intent = new Intent();
        intent.setClass(home_GUI , Introduction.class);
        home_GUI.startActivity(intent);
    }
    public void show_shoppingcart_GUI(){
        Intent intent = new Intent();
        intent.setClass(home_GUI , ShoppingCart.class);
        home_GUI.startActivity(intent);
    }
    public void show_chatBox(){
        Uri uri = Uri.parse("https://line.me/R/ti/p/%40251fkdas");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        home_GUI.startActivity(intent);
    }
}
