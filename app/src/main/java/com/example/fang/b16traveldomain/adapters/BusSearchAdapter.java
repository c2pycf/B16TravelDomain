package com.example.fang.b16traveldomain.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.bussearch.BusSearchListener;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;


import java.util.List;

public class BusSearchAdapter extends RecyclerView.Adapter<BusSearchAdapter.BusViewHolder>{
    private static final String TAG = BusSearchAdapter.class.getSimpleName();
    private Context context;
    private List<BusInformation> busInformationList;
    private BusSearchListener mListener;

   /* public BusSearchAdapter(List<BusInformation> list) {
        this.busInformationList = list;

    }*/

   /* public BusSearchAdapter(List<BusInformation> busInformationList, BusSearchListener mListener) {
        this.busInformationList = busInformationList;
        this.mListener = mListener;
    }*/

    public BusSearchAdapter(Context context, List<BusInformation> busInformationList, BusSearchListener mListener) {
        this.context = context;
        this.busInformationList = busInformationList;
        this.mListener = mListener;
    }

    public class BusViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            BusInformation mBus = busInformationList.get(pos);
            String busId = mBus.getBusId();
            Log.e(TAG, "onClick: " + mBus.getBusId() );
            mListener.onBusClicked(busId);
            //pass bus id in intent to select seat

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
