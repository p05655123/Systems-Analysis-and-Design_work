package com.example.sa_tw.Shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sa_tw.Mediator.Mediator;
import com.example.sa_tw.R;

public class Shop extends AppCompatActivity {
    Mediator mediator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


        ConstraintLayout constraintLayout = (ConstraintLayout)findViewById(R.id.menu);

        TextView t1 = (TextView)findViewById(R.id.text);
        t1.setText("This shop sells the following types of goods：");
        t1.setTextSize(15);
        Button bread_btn = (Button)findViewById(R.id.bread);
        Button dessert_btn = (Button)findViewById(R.id.dessert);
        Button stationery_btn = (Button)findViewById(R.id.stationery);
        Button cart_btn = (Button)findViewById(R.id.cart);

        bread_btn.setOnClickListener(show_bread_gui);
        dessert_btn.setOnClickListener(show_dessert_gui);
        stationery_btn.setOnClickListener(show_stationery_gui);
        cart_btn.setOnClickListener(show_cart_gui);


        mediator= Mediator.getInstance();
        mediator.setup();
        mediator.setShop_GUI(this);
        mediator.setDbMgr_activity(this);

    }

    private View.OnClickListener show_bread_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_bread_GUI();
        }
    };
    private View.OnClickListener show_dessert_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_dessert_GUI();
        }
    };
    private View.OnClickListener show_stationery_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_stationery_GUI();
        }
    };
    private View.OnClickListener show_cart_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_shoppingcart_GUI();
        }
    };
}
