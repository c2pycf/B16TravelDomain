package com.example.fang.b16traveldomain.model.dataresource.seatinformation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Seats {

    @SerializedName("seatinformation")
    List<Seat> seats;

    public Seats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
