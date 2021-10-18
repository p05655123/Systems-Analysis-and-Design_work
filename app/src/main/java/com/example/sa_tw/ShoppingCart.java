package com.example.sa_tw;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.sa_tw.Mediator.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONException;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class ShoppingCart extends AppCompatActivity {
    Mediator mediator =Mediator.getInstance();
    TextView datetxt;
    TextView orderhis;
    TextView t2;
    ArrayList<String> item = new ArrayList<String>();
    ArrayList<String> quantity = new ArrayList<String>();
    ScrollView scrollView;
    private Timer mTimer;
    Handler handler;
    int tp;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mTimer = new Timer();
        mediator.setShoppingCart_GUI(this);
        mediator.setDbMgr_activity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        scrollView = (ScrollView)findViewById(R.id.scrollView);
        t2 = (TextView)findViewById(R.id.text2);
        t2.setTextSize(20);
        Button order_btn = (Button)findViewById(R.id.Order);
        Button delete_btn = (Button)findViewById(R.id.delete);
        Button cancel_btn = (Button)findViewById(R.id.Cancel);


        datetxt = (TextView)findViewById(R.id.textView2);
        datetxt.setTextSize(23);

        orderhis = new TextView(this);
        orderhis.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        orderhis.setX(10);
        orderhis.setY(15);
        orderhis.setTextSize(18);

        order_btn.setOnClickListener(comfirmorder);
        cancel_btn.setOnClickListener(cancel);
        delete_btn.setOnClickListener(delete);
        try {
            mediator.getcart();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setTimerTask1();
        scrollView.addView(orderhis);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                tp = 0;
                if(item == null){
                    datetxt.setText("You have 0 orders");
                    orderhis.setText("");
                    t2.setText("Total Price：0" );
                }else{
                    datetxt.setText("You have "+item.size()+" orders");
                    for(int i = 0 ; i < item.size() ; i++){
                        int n = i+1;
                        orderhis.append("Order"+n+"：");
                        switch (item.get(i)){
                            case "1":
                                orderhis.append("pencil(15)");
                                tp += 15 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +15 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "2":
                                orderhis.append("eraser(10)");
                                tp += 10 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +10 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "3":
                                orderhis.append("chocolate cake(80)");
                                tp += 80 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " +"$" + 80 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "4":
                                orderhis.append("churro(60)");
                                tp += 60 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +60 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "5":
                                orderhis.append("white bread(40)");
                                tp += 40 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +40 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "6":
                                orderhis.append("bagel(25)");
                                tp += 25 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +25 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "7":
                                orderhis.append("crayon(200)");
                                tp += 200 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +200 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "8":
                                orderhis.append("ruler(15)");
                                tp += 15 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +15 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "9":
                                orderhis.append("pudding(25)");
                                tp += 25 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +25 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "10":
                                orderhis.append("pancake(60)");
                                tp += 60 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +60 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "11":
                                orderhis.append("dount(20)");
                                tp += 20 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " +"$" +20 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                            case "12":
                                orderhis.append("croissant(35)");
                                tp += 35 * Integer.parseInt(String.valueOf(quantity.get(i)));
                                orderhis.append(" X " + quantity.get(i));
                                orderhis.append(" = " + "$" +35 * Integer.parseInt(String.valueOf(quantity.get(i))));
                                break;
                        }
                        orderhis.append("\n");
                    }
                    t2.setText("Total Price：" + "$" +tp);
                }
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
                mediator.output_item_id();
                mediator.output_quantity();
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
    View.OnClickListener  cancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };
    private View.OnClickListener comfirmorder = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(tp != 0){
                mediator.show_order_info_GUI();
            }else{
                mediator.make_toast("You don't order anything.");
            }
        }
    };
    View.OnClickListener  delete = new View.OnClickListener() {
        Button btn;
        @Override
        public void onClick(View v) {
            new AlertDialog.Builder(ShoppingCart.this)
                    .setIcon(R.drawable.umm)
                    .setTitle("Confirm to delete the order?")
                    .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            tp = 0;
                            datetxt.setText("You have 0 orders");
                            orderhis.setText("");
                            t2.setText("Total Price：0" );
                            mediator.deletecart();
                        }
                    }).setNegativeButton("Cancel",null).create()
                    .show();
        }
    };
    public void onBackPressed(){
        this.finish();
    }
}
