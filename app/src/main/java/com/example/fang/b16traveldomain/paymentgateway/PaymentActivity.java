package com.example.fang.b16traveldomain.paymentgateway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fang.b16traveldomain.R;
import com.stripe.android.view.CardInputWidget;

public class PaymentActivity extends AppCompatActivity {
    CardInputWidget cardInputWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        cardInputWidget = findViewById(R.id.card_input);

    }

}
