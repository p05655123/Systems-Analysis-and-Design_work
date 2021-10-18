package com.example.sa_tw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.sa_tw.Mediator.Mediator;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Recordlist extends AppCompatActivity {
    Mediator mediator ;
    TextView record;
    TextView t1;
    ListView records_list;
    ArrayAdapter listAdapter;
    ArrayList<String> list;
    Button cancel_btn;
    ScrollView scrollView;
    private Timer mTimer;
    Handler handler;
    ArrayList<String> item_All = new ArrayList<String>();
    ArrayList<String> Address = new ArrayList<String>();
    ArrayList<String> State = new ArrayList<String>();
    ArrayList<String> Date = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mTimer = new Timer();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordlist);


        mediator  = Mediator.getInstance();
        mediator.setRecordlist_GUI(this);
        mediator.setDbMgr_activity(this);

        t1 = (TextView)findViewById(R.id.text2);
        record = (TextView)findViewById(R.id.record);
        cancel_btn = (Button) findViewById(R.id.cancel);
        t1.setText("The following is your transaction record：");
        t1.setTextSize(18);
        record.setTextSize(18);
        try {
            mediator.load_record();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setTimerTask1();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(item_All == null){
                    record.setText("");
                }else{
                    for(int i = 0 ; i < item_All.size() ; i++){
                        int n = i+1;
                        record.append("Orderlist"+n+"：\n");
                        record.append("　　Your item：" + item_All.get(i) + "\n");
                        record.append("　　Your Address：" + Address.get(i) + "\n");
                        record.append("　　State：" + State.get(i) + "\n");
                        record.append("　　Date：" + Date.get(i) + "\n");
                        record.append("\n");
                    }
                }
            }
        };
        cancel_btn.setOnClickListener(cancel);

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
                mediator.output_item_All();
                mediator.output_Address();
                mediator.output_State();
                mediator.output_Date();
                handler.sendEmptyMessage(0);
            }
        }, 500);
    }
    public void set_item_All(ArrayList a){
        this.item_All = a;
    }
    public void set_Address(ArrayList a){
        this.Address = a;
    }
    public void set_State(ArrayList a){
        this.State = a;
    }
    public void set_Date(ArrayList a){
        this.Date = a;
    }



    View.OnClickListener  cancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    };
    public void onBackPressed(){
        this.finish();
    }
}
