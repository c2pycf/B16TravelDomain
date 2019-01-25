package com.example.fang.b16traveldomain.orderconfirmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.model.TicketInformation;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderConfirmedActivity extends AppCompatActivity implements OrderConfirmedContract.OrderConfirmedView {

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
    @BindView(R.id.order_payment_status)
    TextView orderPaymentStatus;
    @BindView(R.id.order_time)
    TextView orderTime;
    @BindView(R.id.bt_order_confirm_home)
    Button btOrderConfirmHome;

    static private String TICKET_INFORMATION_TAG = "ticket_information";

    private TicketInformation ticketInformation;

    NumberFormat format;

    OrderConfirmedPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmed);
        format = NumberFormat.getCurrencyInstance();
        ButterKnife.bind(this);
        mPresenter = new OrderConfirmedPresenter(this);
        getTicketInformation();
        setUpViews();
        setUpTime();

    }

    private void setUpTime() {
        Date currentTime = Calendar.getInstance().getTime();
        orderTime.setText(currentTime.toString());
    }

    private void setUpViews() {
        tvDepDateCard.setText(ticketInformation.getBoardingtime());
        tvArrDateCard.setText(ticketInformation.getDroppingtime());
        tvDurationDateCard.setText(ticketInformation.getDuration());

        //Fare UI date
        tvBaseFare.setText(format.format(Double.parseDouble(ticketInformation.getFare())));
        double appDiscount = 0.05;
        double tax = 0.08;
        double fareDouble = Double.parseDouble(ticketInformation.getFare());
        String appDiscount_calculated = format.format(fareDouble * appDiscount);
        String fare_taxed = format.format(fareDouble * tax);
        tvAppDiscount.setText(appDiscount_calculated);
        tvServiceTax.setText(fare_taxed);
        String totalFare = format.format(fareDouble * (1+ tax - appDiscount));
        ticketInformation.setFare(totalFare);
        tvTotal.setText(totalFare);
    }

    private void getTicketInformation() {
        Intent intent = getIntent();
        ticketInformation = (TicketInformation) intent.getSerializableExtra(TICKET_INFORMATION_TAG);
    }

    @OnClick(R.id.bt_order_confirm_home)
    public void onViewClicked() {
        mPresenter.onHomePageClicked();
    }

    @Override
    public void showHomePage() {

    }
}
