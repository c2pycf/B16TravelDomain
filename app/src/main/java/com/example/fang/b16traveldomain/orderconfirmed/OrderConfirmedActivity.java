package com.example.fang.b16traveldomain.orderconfirmed;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fang.b16traveldomain.MainActivity;
import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.homePage.HomePageActivitywithNavigation;
import com.example.fang.b16traveldomain.model.TicketInformation;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Order confirmed page, show user the order time and with the reservation information
 * Also sent a email to user with the ticket information
 */
public class OrderConfirmedActivity extends AppCompatActivity implements OrderConfirmedContract.OrderConfirmedView {

    @BindView(R.id.order_confirm_toolbar)
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

    static private String TAG = OrderConfirmedActivity.class.getSimpleName();

    static private String TICKET_INFORMATION_TAG = "ticket_information";

    private TicketInformation ticketInformation;

    NumberFormat format;

    OrderConfirmedPresenter mPresenter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmed);
        format = NumberFormat.getCurrencyInstance();
        ButterKnife.bind(this);
        mPresenter = new OrderConfirmedPresenter(this);
        toolbar = findViewById(R.id.order_confirm_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_order_confirmed);
        getTicketInformation();
        setUpViews();
        setUpTime();

    }

    @Override
    protected void onStart() {
        super.onStart();
        sentEmail();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //sentEmail();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    /**
     * The method set up order date
     */
    private void setUpTime() {
        Log.i(TAG, "Setting up order time");
        Date currentTime = Calendar.getInstance().getTime();
        orderTime.setText(currentTime.toString());
    }

    /**
     * Setting up the all the text on the UI using ticketInformation data model
     */
    private void setUpViews() {
        Log.i(TAG, "setUpViews");
        Log.i(TAG, "Setting up date card");
        String date = ticketInformation.getJournydate();
//        String dates[] = date.split("/s");
//        tvWeekDateCard.setText(dates[0]);
//        tvDateDateCard.setText(dates[1]);
//        tvMonthDateCard.setText(dates[2]);
//        Log.d(TAG,"Journy date" + dates[0]+" "+dates[1]+" "+dates[2]+" ");
        tvDepDateCard.setText(ticketInformation.getBoardingtime());
        tvArrDateCard.setText(ticketInformation.getDroppingtime());
        tvDurationDateCard.setText(ticketInformation.getDuration());

        //Fare UI date
        Log.i(TAG, "Setting up fare card");
        tvBaseFare.setText(format.format(Double.parseDouble(ticketInformation.getFare())));
        double appDiscount = 0.05;
        double tax = 0.08;
        double fareDouble = Double.parseDouble(ticketInformation.getFare());
        String appDiscount_calculated = format.format(fareDouble * appDiscount);
        String fare_taxed = format.format(fareDouble * tax);
        tvAppDiscount.setText(appDiscount_calculated);
        tvServiceTax.setText(fare_taxed);
        String totalFare = format.format(fareDouble * (1 + tax - appDiscount));
        ticketInformation.setFare(totalFare);
        tvTotal.setText(totalFare);
        Log.d(TAG, "Fare : " + tvBaseFare.getText() + "App discount:  " + tvAppDiscount.getText() + "Tax : " + tvServiceTax.getText() + "Total Fare : " + tvTotal.getText());
    }

    /**
     * Get intent with ticket information from previous activity
     */
    private void getTicketInformation() {
        Log.i(TAG, "Get ticket information..");
        Intent intent = getIntent();
        ticketInformation = (TicketInformation) intent.getSerializableExtra(TICKET_INFORMATION_TAG);
    }

    @OnClick(R.id.bt_order_confirm_home)
    public void onViewClicked() {
        mPresenter.onHomePageClicked();
    }

    @Override
    public void showHomePage() {
        Intent intent = new Intent(OrderConfirmedActivity.this, HomePageActivitywithNavigation.class);
        startActivity(intent);
    }

    @Override
    public void sentEmail() {
        Log.i("Send email", "");
        String[] TO = {ticketInformation.getPassengeremail()};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your ticket information");

        String emailBody = convertTicketInformation();
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            //finish();
            Log.i(TAG, "Finished sending email...");
        } catch (android.content.ActivityNotFoundException ex) {
            Snackbar.make(toolbar, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private String convertTicketInformation() {
        String msg = "";

        msg = msg.concat("Dear Customer: \n");
        msg = msg.concat("Your ticket reservation is just confirmed at ");
        msg = msg.concat(orderTime.getText().toString());
        msg = msg.concat("\nPlease check your ticket information below: \n");
        msg = msg.concat("\nBus Id: ");
        msg = msg.concat(ticketInformation.getBusid());
        msg = msg.concat("\nBoarding time: ");
        msg = msg.concat(ticketInformation.getBoardingtime());
        msg = msg.concat("\nDropping time: ");
        msg = msg.concat(ticketInformation.getDroppingtime());
        msg = msg.concat("\nDuration: ");
        msg = msg.concat(ticketInformation.getDuration());
        msg = msg.concat("\nWith total passenger(s):  ");
        msg = msg = msg.concat(Integer.toString(ticketInformation.getPassangerSize()));
        for (int i = 0; i < ticketInformation.getPassangerSize(); i++) {
            msg = msg.concat("\nPassenger name: ");
            msg = msg.concat(ticketInformation.getPassanger(i).getPassengername());
        }

        return msg;
    }

    @Override
    public boolean onSupportNavigateUp() {
        //change mainactivity to nav one after merge
        Intent intent = new Intent(OrderConfirmedActivity.this, HomePageActivitywithNavigation.class);
        startActivity(intent);
        return false;
    }
}
