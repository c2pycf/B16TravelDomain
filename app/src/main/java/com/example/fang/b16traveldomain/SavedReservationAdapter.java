package com.example.fang.b16traveldomain;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fang.b16traveldomain.model.TicketInformation;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedReservationAdapter extends RecyclerView.Adapter {
    List<TicketInformation> ticketInformations;

    public SavedReservationAdapter(List<TicketInformation> ticketInformations) {
        this.ticketInformations = ticketInformations;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_saved_reservation, viewGroup, false);
        return new SavedReservationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        SavedReservationViewHolder viewHolder1 = (SavedReservationViewHolder) viewHolder;
        TicketInformation ticketInformation = ticketInformations.get(i);
        viewHolder1.tvReserveTime.setText(ticketInformation.getJournydate());
        viewHolder1.tvStartTime.setText(ticketInformation.getBoardingtime());
        viewHolder1.tvEndTime.setText(ticketInformation.getDroppingtime());
        viewHolder1.tvSaveAt.setText(ticketInformation.getOrder_time());
//        viewHolder1.tvPassengerNo.setText(ticketInformation.getPassangerSize());
    }

    @Override
    public int getItemCount() {
        return ticketInformations.size();
    }

    public class SavedReservationViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_reserveTime)
        TextView tvReserveTime;
        @BindView(R.id.tv_start_time)
        TextView tvStartTime;
        @BindView(R.id.tv_end_time)
        TextView tvEndTime;
        @BindView(R.id.tv_passenger_no)
        TextView tvPassengerNo;
        @BindView(R.id.tv_save_at)
        TextView tvSaveAt;

        public SavedReservationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvReserveTime = itemView.findViewById(R.id.tv_reserveTime);

             tvStartTime  = itemView.findViewById(R.id.tv_start_time);

             tvEndTime = itemView.findViewById(R.id.tv_end_time);

             tvPassengerNo = itemView.findViewById(R.id.tv_passenger_no);

            tvSaveAt = itemView.findViewById(R.id.tv_save_at);

        }
    }
}
