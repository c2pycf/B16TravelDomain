package com.example.fang.b16traveldomain.savereservation;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.SavedReservationAdapter;
import com.example.fang.b16traveldomain.model.TicketInformation;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class SaveReservationFragment extends Fragment {

    SaveReservationViewHolder saveReservationViewHolder;
    RecyclerView recyclerView;

    public SaveReservationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save_reservation,container,false);
        saveReservationViewHolder = ViewModelProviders.of(this).get(SaveReservationViewHolder.class);
        recyclerView = view.findViewById(R.id.save_reservation_recycle);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        saveReservationViewHolder.getTicketLists().observe(this, new Observer<List<TicketInformation>>() {
            @Override
            public void onChanged(@Nullable List<TicketInformation> ticketInformations) {
                try {
                if(ticketInformations!=null) {
                    for (int i = 0; i < ticketInformations.size(); i++) {
                        ticketInformations.get(i).setPassengers(saveReservationViewHolder.getPassengers(ticketInformations.get(i).getOrder_time()));

                    }
                }
                } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SavedReservationAdapter adapter = new SavedReservationAdapter(ticketInformations);
                    recyclerView.setAdapter(adapter);
            }
        });
        getActivity().setTitle("Save");
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
