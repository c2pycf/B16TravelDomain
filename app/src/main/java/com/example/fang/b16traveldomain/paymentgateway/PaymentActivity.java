package com.example.fang.b16traveldomain.paymentgateway;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.stripe.android.model.Card;
import com.stripe.android.view.CardMultilineWidget;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentActivity extends AppCompatActivity implements PaymentContract.PaymentView {
    private static final String TAG = PaymentActivity.class.getSimpleName();
    static private String TICKET_INFORMATION_TAG = "ticket_information";
    @BindView(R.id.card_input)
    CardMultilineWidget cardInput;
    @BindView(R.id.et_billing_address_1)
    EditText etBillingAddress1;
    @BindView(R.id.et_billing_address_2)
    EditText etBillingAddress2;
    @BindView(R.id.bt_check_out)
    Button btCheckOut;
    private CardMultilineWidget cardInputWidget;
    private Card card;

    private PaymentPresenter mPresenter;

    private TicketInformation ticketInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        mPresenter = new PaymentPresenter(this);
        getTicketInfor();

    }

    private void getTicketInfor() {
        if(getIntent().getSerializableExtra(TICKET_INFORMATION_TAG)!=null) {
            ticketInformation = (TicketInformation) getIntent().getSerializableExtra(TICKET_INFORMATION_TAG);
            Log.d(TAG,ticketInformation.getDuration());
        }
    }

    @Override
    public void createCard() {
        card = cardInput.getCard();
        if(card!=null) {

            if(!card.validateNumber()){
                this.showToast("Card number invalid!");
            }
            else if (!card.validateExpMonth()){
                this.showToast("Card month invalid!");
            }
            else if(!card.validateExpiryDate()){
                this.showToast("Card date invalid!");
            }
            else {
                mPresenter.proceedPayment(card,ticketInformation);
            }
        }
    }
    @Override
    public void showToast(String msg) {
        Snackbar.make(btCheckOut,msg,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showConfirmedActivity() {
        Intent intent = new Intent();
        intent.putExtra(TICKET_INFORMATION_TAG,ticketInformation);
        startActivity(intent);
    }

    @OnClick(R.id.bt_check_out)
    public void onViewClicked() {
        createCard();
    }
}
