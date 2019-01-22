package com.example.fang.b16traveldomain.ticketConfirmation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.model.TicketInformation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TicketDetailActivity extends AppCompatActivity implements TicketDetailContract.TicketDetailView{
    static private String TAG = TicketDetailActivity.class.getSimpleName();
    static private String TICKET_INFORMATION_TAG = "ticket_information";
    @BindView(R.id.ticket_detail_toolbar)
    Toolbar ticketDetailToolbar;
    @BindView(R.id.tv_date_date_card)
    TextView tvDateDateCard;
    @BindView(R.id.tv_week_date_card)
    TextView tvWeekDateCard;
    @BindView(R.id.tv_month_date_card)
    TextView tvMonthDateCard;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tv_dep_date_card)
    TextView tvDepDateCard;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.tv_arr_date_card)
    TextView tvArrDateCard;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.tv_duration_date_card)
    TextView tvDurationDateCard;
    @BindView(R.id.tx_base_fare)
    TextView txBaseFare;
    @BindView(R.id.tx_app_discount)
    TextView txAppDiscount;
    @BindView(R.id.tx_service_tax)
    TextView txServiceTax;
    @BindView(R.id.tx_total)
    TextView txTotal;
    @BindView(R.id.tv_base_fare)
    TextView tvBaseFare;
    @BindView(R.id.tv_app_discount)
    TextView tvAppDiscount;
    @BindView(R.id.tv_service_tax)
    TextView tvServiceTax;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.cb_coupon)
    CheckBox cbCoupon;
    @BindView(R.id.et_coupon)
    EditText etCoupon;
    @BindView(R.id.cb_credit)
    CheckBox cbCredit;
    @BindView(R.id.bt_proceed_for_payment)
    Button btProceedForPayment;
    @BindView(R.id.tv_save_reservation)
    TextView tvSaveReservation;

    private TicketInformation ticketInformation;

    private TicketDetailPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);
        ButterKnife.bind(this);

        //get ticket information from previous activity
        if(getTicketInformation()!=null) {
            ticketInformation = getTicketInformation();
        }
        else{
            showToast("No ticket information");
        }




    }

    private TicketInformation getTicketInformation() {
        if(getIntent()!=null) {
            return (TicketInformation) getIntent().getSerializableExtra(TICKET_INFORMATION_TAG);
        }
        else{
            return null;
        }
    }

    @OnClick({R.id.bt_proceed_for_payment, R.id.tv_save_reservation})
    public void onViewClicked(View view) {
        if(getTicketInformation()!=null) {
            switch (view.getId()) {
                case R.id.bt_proceed_for_payment:
                    if (cbCoupon.isChecked()) {
                        if (!etCoupon.getText().toString().isEmpty()) {
                            String coupon = etCoupon.getText().toString();
                            mPresenter.checkCoupon(coupon, ticketInformation);
                        } else {
                            this.showToast("Empty coupon!");
                        }
                    }
                    break;
                case R.id.tv_save_reservation:
                    break;
            }
        }
    }

    @Override
    public void showToast(String msg) {
        Snackbar.make(btProceedForPayment,""+msg,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showPaymentActivity(TicketInformation ticketInformation) {
        //Start payment activity
        Intent intent = new Intent();
        intent.putExtra(TICKET_INFORMATION_TAG,ticketInformation);
        startActivity(intent);
    }
}
