package com.example.fang.b16traveldomain.model;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    List<Passenger> passengers;

    public TicketInformation() {
        List<Passenger> passengers = new ArrayList<>();
    }

    public TicketInformation(String route_name, String busid, String fare, String coupondiscount, String servicetax, String journydate, String boardingtime, String droppingtime, String duration, String passengerid, String passengeremail, String passengermobile) {
        this.route_name = route_name;
        this.busid = busid;
        this.fare = fare;
        this.coupondiscount = coupondiscount;
        this.servicetax = servicetax;
        //"25-11-2018-Wednesday"
        this.journydate = journydate;
        this.boardingtime = boardingtime;
        this.droppingtime = droppingtime;
        this.duration = duration;
        this.passengerid = passengerid;
        this.passengeremail = passengeremail;
        this.passengermobile = passengermobile;
        List<Passenger> passengers = new ArrayList<>();
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

    public void addPassanger(Passenger passenger){
        passengers.add(passenger);
    }

    public Passenger getPassanger(int i){
        return passengers.get(i);
    }

    public List<Passenger> getPassengers(){
        return passengers;
    }

    public int getPassangerSize(){
        return passengers.size();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
