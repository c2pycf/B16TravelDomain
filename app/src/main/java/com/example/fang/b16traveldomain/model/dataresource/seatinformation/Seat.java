package com.example.fang.b16traveldomain.model.dataresource.seatinformation;

import com.google.gson.annotations.SerializedName;

public class Seat {
    @SerializedName("id")
    String seatId;

    @SerializedName("totalseat")
    String totalSeat;

    @SerializedName("s1")
    String seat1;

    @SerializedName("s2")
    String seat2;

    @SerializedName("s3")
    String seat3;

    @SerializedName("s4")
    String seat4;

    @SerializedName("s5")
    String seat5;

    @SerializedName("s6")
    String seat6;

    @SerializedName("s7")
    String seat7;

    @SerializedName("s8")
    String seat8;

    @SerializedName("s9")
    String seat9;

    @SerializedName("s10")
    String seat10;

    public Seat(String seatId, String totalSeat, String seat1, String seat2, String seat3,
                String seat4, String seat5, String seat6, String seat7, String seat8,
                String seat9, String seat10) {
        this.seatId = seatId;
        this.totalSeat = totalSeat;
        this.seat1 = seat1;
        this.seat2 = seat2;
        this.seat3 = seat3;
        this.seat4 = seat4;
        this.seat5 = seat5;
        this.seat6 = seat6;
        this.seat7 = seat7;
        this.seat8 = seat8;
        this.seat9 = seat9;
        this.seat10 = seat10;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(String totalSeat) {
        this.totalSeat = totalSeat;
    }

    public String getSeat1() {
        return seat1;
    }

    public void setSeat1(String seat1) {
        this.seat1 = seat1;
    }

    public String getSeat2() {
        return seat2;
    }

    public void setSeat2(String seat2) {
        this.seat2 = seat2;
    }

    public String getSeat3() {
        return seat3;
    }

    public void setSeat3(String seat3) {
        this.seat3 = seat3;
    }

    public String getSeat4() {
        return seat4;
    }

    public void setSeat4(String seat4) {
        this.seat4 = seat4;
    }

    public String getSeat5() {
        return seat5;
    }

    public void setSeat5(String seat5) {
        this.seat5 = seat5;
    }

    public String getSeat6() {
        return seat6;
    }

    public void setSeat6(String seat6) {
        this.seat6 = seat6;
    }

    public String getSeat7() {
        return seat7;
    }

    public void setSeat7(String seat7) {
        this.seat7 = seat7;
    }

    public String getSeat8() {
        return seat8;
    }

    public void setSeat8(String seat8) {
        this.seat8 = seat8;
    }

    public String getSeat9() {
        return seat9;
    }

    public void setSeat9(String seat9) {
        this.seat9 = seat9;
    }

    public String getSeat10() {
        return seat10;
    }

    public void setSeat10(String seat10) {
        this.seat10 = seat10;
    }
}
