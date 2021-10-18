package com.example.sa_tw.Shop;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sa_tw.Mediator.Mediator;
import com.example.sa_tw.R;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.os.Message;

public class Bread_3 extends AppCompatActivity {
    Mediator mediator =Mediator.getInstance();
    TextView info1;
    TextView info2;
    EditText q;
    Button pre;
    Button order;
    Button cart;
    String name;
    int price;
    int inventory;
    private Timer mTimer;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread_3);
        mTimer = new Timer();

        this.mediator = Mediator.getInstance();
        mediator.setBread_3_GUI(this);
        mediator.setDbMgr_activity(this);

        info1 = (TextView) findViewById(R.id.info1);
        info1.setTextSize(35);
        info2 = (TextView) findViewById(R.id.info2);
        info2.setTextSize(20);

        q =(EditText)findViewById(R.id.q);
        pre = (Button)findViewById(R.id.pre);
        order = (Button)findViewById(R.id.order);
        cart = (Button)findViewById(R.id.cart);
        pre.setOnClickListener(pre_gui);
        order.setOnClickListener(intocart);
        cart.setOnClickListener(show_shoppingcart_gui);

        mediator.get_bitem4("3","white bread");
        setTimerTask1();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                info1.append(name);
                info2.append("\n" +"Price：" +price+"\n"+"Inventory：" + inventory);
            }
        };

    }
    protected void onDestroy() {
        super.onDestroy();
        // cancel timer
        mTimer.cancel();
    }

    private void setTimerTask1() {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mediator.output_bname4();
                mediator.output_bprice4();
                mediator.output_binventory4();
                handler.sendEmptyMessage(0);
            }
        }, 500);
    }

    public void set_name4(String n){
        this.name = n;
    }
    public void set_price4(int e){
        this.price = e;
    }
    public void set_inventory4(int e){
        this.inventory = e;
    }
    private View.OnClickListener show_shoppingcart_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_shoppingcart_GUI();
        }
    };
    View.OnClickListener  pre_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };
    public void onBackPressed(){
        this.finish();

    }
    private View.OnClickListener intocart = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(((Integer.valueOf(String.valueOf(q.getText())))<= 0) || (q.getText().toString().trim().isEmpty())){
                mediator.make_toast("You don't enter any quantity!");
            }else{
                if(Integer.valueOf(q.getText().toString()) > inventory){
                    mediator.make_toast("Out of stock!");
                }else{
                    mediator.intocart(5,Integer.valueOf(q.getText().toString()),Integer.valueOf(q.getText().toString())*price);
                    q.setText("");
                }
            }
        }
    };
}
