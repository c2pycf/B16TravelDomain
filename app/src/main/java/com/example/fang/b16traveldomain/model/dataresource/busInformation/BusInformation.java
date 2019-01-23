package com.example.fang.b16traveldomain.model.dataresource.busInformation;

import com.google.gson.annotations.SerializedName;
/*
PoJO class (API 6 - find route by bus id)
 */

public class BusInformation {

    @SerializedName("busid")
    String busId;

    @SerializedName("busregistrationno")
    String busRegistrationNo;

    @SerializedName("bustype")
    String busType;

    @SerializedName("busdeparturetime")
    String busDepartureTime;

   @SerializedName("journyduration")
    String journeyDuration;

    @SerializedName("Fare")
    int fare;

    @SerializedName("boardingtime")
    String boardingTime;

    @SerializedName("dropingtime")
    String dropingTime;

    /*
    all args constructor
     */
    public BusInformation(String busId, String busRegistrationNo, String busType,
                          String busDepartureTime, String journeyDuration, int fare,
                          String boardingTime, String dropingTime) {
        this.busId = busId;
        this.busRegistrationNo = busRegistrationNo;
        this.busType = busType;
        this.busDepartureTime = busDepartureTime;
        this.journeyDuration = journeyDuration;
        this.fare = fare;
        this.boardingTime = boardingTime;
        this.dropingTime = dropingTime;
    }

    /*
    no args constructor
     */

    public BusInformation() {
    }

    /*
    Getters and Setters for all fields
     */

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusRegistrationNo() {
        return busRegistrationNo;
    }

    public void setBusRegistrationNo(String busRegistrationNo) {
        this.busRegistrationNo = busRegistrationNo;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getBusDepartureTime() {
        return busDepartureTime;
    }

    public void setBusDepartureTime(String busDepartureTime) {
        this.busDepartureTime = busDepartureTime;
    }

    public String getJourneyDuration() {
        return journeyDuration;
    }

    public void setJourneyDuration(String journeyDuration) {
        this.journeyDuration = journeyDuration;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getDropingTime() {
        return dropingTime;
    }

    public void setDropingTime(String dropingTime) {
        this.dropingTime = dropingTime;
    }
}
