package com.example.fang.b16traveldomain;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fang.b16traveldomain.model.TicketInformation;

import java.text.Format;
import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedReservationAdapter extends RecyclerView.Adapter {
    private List<TicketInformation> ticketInformations;
    private onItemClickedListener  mListener;


    public interface onItemClickedListener{
        void onItemClicked(TicketInformation ticketInformation);
    }

    public SavedReservationAdapter(List<TicketInformation> ticketInformations, onItemClickedListener listener) {
        this.ticketInformations = ticketInformations;
        mListener = listener;
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
        NumberFormat format = NumberFormat.getIntegerInstance();
        viewHolder1.tvPassengerNo.setText(format.format(ticketInformation.getPassangerSize()));
        viewHolder1.setItemListener(ticketInformation,mListener);
    }

    public TicketInformation getTicketPosition(int position){
        return ticketInformations.get(position);
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

        void setItemListener(final TicketInformation ticketInformation, final onItemClickedListener itemClickedListener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickedListener.onItemClicked(ticketInformation);
                }
            });

        }
    }
}
