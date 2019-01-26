package com.example.fang.b16traveldomain.seatsavailable;

import com.example.fang.b16traveldomain.model.dataresource.seatinformation.Seats;

public interface SeatsAvailableContract {

    interface SeatsAvailableView{
        void setupSeatAvailableMVP();
        void showSeatAvailableActivity(Seats seats);
        void setupSeatsView();
        void getSeats();
    }

    interface SeatsAvailablePresenter{
        void findSeats(String busId);
    }
}
