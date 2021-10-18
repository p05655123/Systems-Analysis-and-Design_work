package com.example.sa_tw;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.sa_tw.Mediator.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Order_info extends AppCompatActivity {
    Mediator mediator =Mediator.getInstance();
    TextView order_text;
    TextView totalmoney_text;
    Button usediscount;
    Button conform;
    EditText address;
    private Timer mTimer;
    Handler handler;
    int tp;
    ArrayList<String> item = new ArrayList<String>();
    ArrayList<String> quantity = new ArrayList<String>();
    String Sbalance;
    String Sdiscount;
    int tm;
    int newbalamce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mTimer = new Timer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);
        order_text = (TextView)findViewById(R.id.order_text);
        totalmoney_text = (TextView)findViewById(R.id.totalmoney_text);
        order_text.setTextSize(20);
        totalmoney_text.setTextSize(25);
        address = (EditText)findViewById(R.id.edit1);
        usediscount = (Button)findViewById(R.id.confirm2);
        conform = (Button)findViewById(R.id.confirm);
        mediator.setOrder_info_GUI(this);
        mediator.setDbMgr_activity(this);
        setTimerTask1();

        usediscount.setOnClickListener(use);
        conform.setOnClickListener(ok);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                order_text.append("Order amount");
                for (int i = 0; i < item.size(); i++) {
                    switch (item.get(i)) {
                        case "1":
                            ;
                            tp += 15 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "2":
                            tp += 10 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "3":
                            tp += 80 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "4":
                            tp += 60 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "5":
                            tp += 40 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "6":
                            tp += 25 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "7":
                            tp += 200 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "8":
                            tp += 15 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "9":
                            tp += 25 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "10":
                            tp += 60 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "11":
                            tp += 20 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                        case "12":
                            tp += 35 * Integer.parseInt(String.valueOf(quantity.get(i)));
                            break;
                    }
                }
                order_text.append("：" + "$" + tp);
                order_text.append("\n");
                order_text.append("Your Balance" + "：" + "$" + Sbalance);
                order_text.append("\n");
                order_text.append("Your Discount" + "：" + "$" + Sdiscount);
                tm = tp;
                totalmoney_text.setText("Total Price：$" + String.valueOf(tm));
            }
        };
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // cancel timer
        mTimer.cancel();
    }

    private void setTimerTask1() {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mediator.output2_item_id();
                mediator.output2_quantity();
                mediator.output2_balance();
                mediator.output2_discount();
                handler.sendEmptyMessage(0);
            }
        }, 500);
    }
    public void set_item_id(ArrayList a){
        this.item = a;
    }
    public void set_quantity(ArrayList a){
        this.quantity = a;
    }
    public void set_balance(int intbalance){
        Sbalance = String.valueOf(intbalance);
    }

    public void set_discount(int intdiscount){
        Sdiscount = String.valueOf(intdiscount);
    }

    View.OnClickListener  use = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Integer.parseInt(String.valueOf(Sdiscount)) != 0) {
                new AlertDialog.Builder(Order_info.this)
                        .setIcon(R.drawable.umm)
                        .setTitle("You have "+Sdiscount+" points\n"+"Confirm to use the discount?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(tp > Integer.valueOf(Sdiscount)){
                                    tm = tp - Integer.parseInt(String.valueOf(Sdiscount));
                                    order_text.setText("");
                                    order_text.append("Order amount：" + "$" + tp);
                                    order_text.append("\n");
                                    order_text.append("Your Balance" + "：" + "$" + Sbalance);
                                    order_text.append("\n");
                                    order_text.append("Your Discount" + "：" + "$" + "0");
                                    totalmoney_text.setText("Total Price：$" + String.valueOf(tm));
                                    Sdiscount = "0";
                                }else{
                                    Sdiscount = String.valueOf(Integer.valueOf(Sdiscount) - tp);
                                    tm = 0;
                                    order_text.setText("");
                                    order_text.append("Order amount：" + "$" + tp);
                                    order_text.append("\n");
                                    order_text.append("Your Balance" + "：" + "$" + Sbalance);
                                    order_text.append("\n");
                                    order_text.append("Your Discount" + "：" + "$" + String.valueOf(Integer.valueOf(Sdiscount)));
                                    totalmoney_text.setText("Total Price：$" + "0");
                                }
                            }
                        }).setNegativeButton("No",null).create()
                        .show();
            }else{
                mediator.make_toast("You don't have the discount.");
            }
        }
    };

    View.OnClickListener  ok = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            newbalamce = mediator.CalFinalPay(Integer.parseInt(String.valueOf(Sbalance)), tm);
            if(address.getText().toString().isEmpty()){
                mediator.make_toast("You don't enter the address.");
            }else{
                if (newbalamce >= 0) {
                    new AlertDialog.Builder(Order_info.this)
                            .setIcon(R.drawable.umm)
                            .setTitle("Confirm to Order?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Sbalance = String.valueOf(newbalamce);
                                    mediator.creat_OTP(address.getText().toString(),newbalamce,Sdiscount);
                                    mediator.show_otp_GUI();
                                }
                            }).setNegativeButton("No",null).create()
                            .show();
                }else{
                    mediator.make_toast("You don't have enough balance.");
                }
            }
        }
    };
}
