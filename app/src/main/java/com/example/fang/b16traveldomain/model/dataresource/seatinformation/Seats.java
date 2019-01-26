package com.example.fang.b16traveldomain.model.dataresource.seatinformation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Seats {

    @SerializedName("seatinformation")
   private List<Seat> seats;

    public Seats(List<Seat> seatList) {
        super();
        this.seats = seatList;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats)
    {
        this.seats = seats;
    }


}
