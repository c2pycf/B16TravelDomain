package com.example.fang.b16traveldomain.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;


import java.util.List;

public class BusSearchAdapter extends RecyclerView.Adapter<BusSearchAdapter.BusViewHolder>{

    private List<BusInformation> busInformationList;

    public BusSearchAdapter(List<BusInformation> list) {
        this.busInformationList = list;

    }

    public class BusViewHolder extends RecyclerView.ViewHolder{
        TextView departureTimeTextView, dropingTimeTextView, busTypeTextView,busDurationTextView,
                busFareTextView, busBoardingTextView;

        public BusViewHolder(@NonNull View itemView) {
            super(itemView);
            departureTimeTextView = itemView.findViewById(R.id.tvBusDepartureTime);
            dropingTimeTextView = itemView.findViewById(R.id.tvBusDropingTime);
            busDurationTextView = itemView.findViewById(R.id.tvBusJourneyDuration);
            busTypeTextView = itemView.findViewById(R.id.tvBusType);
            busFareTextView = itemView.findViewById(R.id.tvbusFare);
            busBoardingTextView = itemView.findViewById(R.id.tvBusBoardingTime);

        }
    }


    @NonNull
    @Override
    public BusViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bus, viewGroup, false);
        return new BusViewHolder(view);
    }

    //add on click listener
    @Override
    public void onBindViewHolder(@NonNull BusViewHolder busViewHolder, int i) {
        BusInformation busInformation = busInformationList.get(i);
        busViewHolder.busDurationTextView.setText(busInformation.getBoardingTime());
        busViewHolder.dropingTimeTextView.setText(busInformation.getDropingTime());
        busViewHolder.busFareTextView.setText(busInformation.getFare());
        busViewHolder.busDurationTextView.setText(busInformation.getJourneyDuration());
        busViewHolder.busBoardingTextView.setText(busInformation.getBoardingTime());
        busViewHolder.busTypeTextView.setText(busInformation.getBusType());

    }

    @Override
    public int getItemCount() {
        return busInformationList.size();
    }
}
