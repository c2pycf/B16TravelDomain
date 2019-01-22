package com.example.fang.b16traveldomain.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class TicketInformation implements Serializable {
    String route_name;
    String busid;
    String fare;
    String coupondiscount;
    String servicetax;
    String journydate;
    String boardingtime;
    String droppingtime;
    String duration;
    String passengerid;
    String passengeremail;
    String passengermobile;
    String selectedseat;
    String passengername;
    String passengerage;
    String passengergender;

    public TicketInformation(String route_name, String busid, String fare, String coupondiscount, String servicetax, String journydate, String boardingtime, String droppingtime, String duration, String passengerid, String passengeremail, String passengermobile, String selectedseat, String passengername, String passengerage, String passengergender) {
        this.route_name = route_name;
        this.busid = busid;
        this.fare = fare;
        this.coupondiscount = coupondiscount;
        this.servicetax = servicetax;
        this.journydate = journydate;
        this.boardingtime = boardingtime;
        this.droppingtime = droppingtime;
        this.duration = duration;
        this.passengerid = passengerid;
        this.passengeremail = passengeremail;
        this.passengermobile = passengermobile;
        this.selectedseat = selectedseat;
        this.passengername = passengername;
        this.passengerage = passengerage;
        this.passengergender = passengergender;
    }

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public String getBusid() {
        return busid;
    }

    public void setBusid(String busid) {
        this.busid = busid;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getCoupondiscount() {
        return coupondiscount;
    }

    public void setCoupondiscount(String coupondiscount) {
        this.coupondiscount = coupondiscount;
    }

    public String getServicetax() {
        return servicetax;
    }

    public void setServicetax(String servicetax) {
        this.servicetax = servicetax;
    }

    public String getJournydate() {
        return journydate;
    }

    public void setJournydate(String journydate) {
        this.journydate = journydate;
    }

    public String getBoardingtime() {
        return boardingtime;
    }

    public void setBoardingtime(String boardingtime) {
        this.boardingtime = boardingtime;
    }

    public String getDroppingtime() {
        return droppingtime;
    }

    public void setDroppingtime(String droppingtime) {
        this.droppingtime = droppingtime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(String passengerid) {
        this.passengerid = passengerid;
    }

    public String getPassengeremail() {
        return passengeremail;
    }

    public void setPassengeremail(String passengeremail) {
        this.passengeremail = passengeremail;
    }

    public String getPassengermobile() {
        return passengermobile;
    }

    public void setPassengermobile(String passengermobile) {
        this.passengermobile = passengermobile;
    }

    public String getSelectedseat() {
        return selectedseat;
    }

    public void setSelectedseat(String selectedseat) {
        this.selectedseat = selectedseat;
    }

    public String getPassengername() {
        return passengername;
    }

    public void setPassengername(String passengername) {
        this.passengername = passengername;
    }

    public String getPassengerage() {
        return passengerage;
    }

    public void setPassengerage(String passengerage) {
        this.passengerage = passengerage;
    }

    public String getPassengergender() {
        return passengergender;
    }

    public void setPassengergender(String passengergender) {
        this.passengergender = passengergender;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
