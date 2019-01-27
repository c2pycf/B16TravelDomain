package com.example.fang.b16traveldomain.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.passengerinformation.PassengerInformationPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeatsDetailAdapter extends RecyclerView.Adapter{
    TicketInformation ticketInformation;
    PassengerInformationPresenter mPresenter;

    public SeatsDetailAdapter(TicketInformation ticketInformation, PassengerInformationPresenter presenter) {
        this.ticketInformation = ticketInformation;
        mPresenter = presenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i){
            case (0):
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_date_card,viewGroup,false);
                return new SeatsDetailDateViewHoder(view);
            case (1):
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_passenger_contact,viewGroup,false);
                return new SeatsDetailContactViewHolder(view);
            default:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_passenger_contact,viewGroup,false);
                return new SeatsDetailPassengerViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final int type = getItemViewType(i);
        switch (type){
            case (0):
                SeatsDetailDateViewHoder dateViewHolder = (SeatsDetailDateViewHoder) viewHolder;
                String date = ticketInformation.getJournydate();
                //dateViewHolder.tvWeekDateCard.setText();
                //dateViewHolder.tvDateDateCard.setText();
                //dateViewHolder.tvMonthDateCard.setText();
                dateViewHolder.tvArrDateCard.setText(ticketInformation.getBoardingtime());
                dateViewHolder.tvDepDateCard.setText(ticketInformation.getDroppingtime());
                dateViewHolder.tvDurationDateCard.setText(ticketInformation.getDuration());
                break;
            case (1):
                SeatsDetailContactViewHolder contactViewHolder = (SeatsDetailContactViewHolder) viewHolder;
                mPresenter.mail = contactViewHolder.etPassengerMail;
                mPresenter.phone = contactViewHolder.etPassengerMobile;
                if (ticketInformation.getPassengeremail()!=null){
                    contactViewHolder.etPassengerMail.setText(ticketInformation.getPassengeremail());
                }
                if (ticketInformation.getPassengermobile()!=null){
                    contactViewHolder.etPassengerMobile.setText(ticketInformation.getPassengermobile());
                }
                break;
            default:
                SeatsDetailPassengerViewHolder passengerViewHolder = (SeatsDetailPassengerViewHolder) viewHolder;
                passengerViewHolder.seatId.setText(ticketInformation.getPassanger(i-2).getSelectedseat());
                mPresenter.name[type - 2] = passengerViewHolder.etPassengerName;
                mPresenter.age[type - 2] = passengerViewHolder.etPassengerAge;
                if (ticketInformation.getPassanger(i-2)!=null) {
                    passengerViewHolder.etPassengerName.setText(ticketInformation.getPassanger(i-2).getPassengername());
                    passengerViewHolder.etPassengerAge.setText(ticketInformation.getPassanger(i-2).getPassengerage());
                    if (ticketInformation.getPassanger(i-2).getPassengergender().equals("Male")){
                        passengerViewHolder.rbPassengerMale.setSelected(true);
                    }else {
                        passengerViewHolder.rbPassengerFemale.setSelected(true);
                    }
                }
                passengerViewHolder.rbPassengerMale.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.gender[type -2] = "Male";
                    }
                });
                passengerViewHolder.rbPassengerFemale.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.gender[type -2] = "Female";
                    }
                });
        }
    }

    @Override
    public int getItemCount() {
        return ticketInformation.getPassangerSize()+2;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class SeatsDetailDateViewHoder extends RecyclerView.ViewHolder {

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

        public SeatsDetailDateViewHoder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }

    public class SeatsDetailContactViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.et_passenger_mail)
        EditText etPassengerMail;
        @BindView(R.id.et_passenger_mobile)
        EditText etPassengerMobile;

        public SeatsDetailContactViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }

    public class SeatsDetailPassengerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_passenger_detail_title)
        TextView tvPassengerDetailTitle;
        @BindView(R.id.seat_id)
        TextView seatId;
        @BindView(R.id.et_passenger_name)
        EditText etPassengerName;
        @BindView(R.id.rb_passenger_male)
        RadioButton rbPassengerMale;
        @BindView(R.id.rb_passenger_female)
        RadioButton rbPassengerFemale;
        @BindView(R.id.tv_passenger_age)
        EditText etPassengerAge;

        public SeatsDetailPassengerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
