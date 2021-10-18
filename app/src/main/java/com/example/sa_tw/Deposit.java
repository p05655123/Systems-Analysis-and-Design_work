package com.example.sa_tw;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.sa_tw.Mediator.*;


public class Deposit extends AppCompatActivity {
    Mediator mediator =Mediator.getInstance();
    EditText textmoney;
    EditText textpwd;
    TextView balance;
    TextView t1;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        ConstraintLayout constraintLayout = (ConstraintLayout)findViewById(R.id.menu);

        t1 = (TextView)findViewById(R.id.text);
        t2 = (TextView)findViewById(R.id.text2);
        balance = (TextView)findViewById(R.id.Balance);
        t2.setText("Your Balance：");
        t2.setTextSize(20);
        balance.setTextSize(20);
        Button confirm_btn = (Button)findViewById(R.id.confirm);
        textmoney = (EditText)findViewById(R.id.Amount);

        confirm_btn.setOnClickListener(deposit);


        mediator.setDeposit_GUI(this);
        mediator.setDbMgr_activity(this);
        mediator.reload_balance();
    }
    private View.OnClickListener deposit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (textmoney.getText().toString().isEmpty()){
                mediator.make_toast("Enter the money you wanna deposit");
            }else {
                mediator.depoist(textmoney.getText().toString());
            }
        }
    };

    public void set_balance(int intbalance){
        String Sbalance = String.valueOf(intbalance);
        balance.setText("$"+Sbalance);
    }

    public void onBackPressed(){
        this.finish();

    }
}
