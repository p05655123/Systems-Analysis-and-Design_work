package com.example.sa_tw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Introduction extends AppCompatActivity {
    TextView t1;
    TextView t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        t1 = (TextView)findViewById(R.id.text1);
        t2 = (TextView)findViewById(R.id.text2);
        t1.setTextSize(30);
        t2.setTextSize(18);
        t1.setText("Introduction");
        t2.setText("Copyright © 2020 Autistic shop All Rights Reserved." +
                "Autism is a widespread developmental delay disorder," +
                "People with autism may have difficulty understanding and expressing language since childhood" +
                "Difficult to establish interactive emotions with those around you," +
                "Different reactions to various sensory stimuli," +
                "So, it is not easy to make a living in the same environment as the average person\n" +
                "\n" +
                "This system was created to help autistic children," +
                "They work hard to make bread, desserts and stationery," +
                "By this trading platform, autistic people can protect their business.\n" +
                "\n" +
                "Therefore, with OTP security mechanism verification," +
                "Guarantee the transaction between the two parties and implement safe electronic payment" +
                "Every payment which over 100 dollars enjoys discount point reward." +
                "We use small profits but quick sales.You can buy what you need at a cheaper price." +
                "We are win-win.\n" +
                "\n" +
                "Finally, we invite you to care about autism" +
                "If you have any questions, please call 05-534 2601.");
    }
}
