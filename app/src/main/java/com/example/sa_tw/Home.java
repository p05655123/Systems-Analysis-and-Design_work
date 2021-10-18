package com.example.sa_tw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sa_tw.Mediator.*;

import java.util.Random;

public class Home extends AppCompatActivity {
    private Mediator mediator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Random rnd = new Random();

        TextView t1 = (TextView)findViewById(R.id.text);
        Button purchase_btn = (Button)findViewById(R.id.Purchase);
        Button deposit_btn = (Button)findViewById(R.id.Deposit);
        Button record_btn = (Button)findViewById(R.id.Record);
        Button info_btn = (Button)findViewById(R.id.Info);
        Button introduction_btn = (Button)findViewById(R.id.Introduction);
        Button chatBox_btn = (Button)findViewById(R.id.ChatBox);
        Button shoppingcart_btn = (Button)findViewById(R.id.shoppingcart);

        purchase_btn.setOnClickListener(show_shop_gui);
        deposit_btn.setOnClickListener(show_despoist_gui);
        record_btn.setOnClickListener(show_recordlist_gui);
        info_btn.setOnClickListener(show_info_gui);
        introduction_btn.setOnClickListener(show_introduction_gui);
        shoppingcart_btn.setOnClickListener(show_shoppingcart_gui);
        chatBox_btn.setOnClickListener(show_chatBox);
        mediator= Mediator.getInstance();
        mediator.setup();
        mediator.setHome_GUI(this);
        mediator.setDbMgr_activity(this);

    }

    private View.OnClickListener show_despoist_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_deposit_GUI();
        }
    };
    private View.OnClickListener show_shop_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_shop_GUI();
        }
    };

    private View.OnClickListener show_recordlist_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_record_GUI();
        }
    };
    private View.OnClickListener show_introduction_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_introduction_GUI();
        }
    };
    private View.OnClickListener show_shoppingcart_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_shoppingcart_GUI();
        }
    };
    private View.OnClickListener show_info_gui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_info_GUI();
        }
    };

    private View.OnClickListener show_chatBox = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediator.show_chatBox();
        }
    };

    public void onBackPressed(){
        this.finish();

    }
}
