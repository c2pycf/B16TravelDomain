package com.example.fang.b16traveldomain.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "ticket_information")
public class TicketInformation implements Serializable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "order_time")
    String order_time;
    @ColumnInfo(name = "route_name")
    String route_name;
    @ColumnInfo(name = "busid")
    String busid;
    @ColumnInfo(name = "fare")
    String fare;
    @ColumnInfo(name = "coupondiscount")
    String coupondiscount;
    @ColumnInfo(name = "servicetax")
    String servicetax;
    @ColumnInfo(name = "journydate")
    String journydate;
    @ColumnInfo(name = "boardingtime")
    String boardingtime;
    @ColumnInfo(name = "droppingtime")
    String droppingtime;
    @ColumnInfo(name = "duration")
    String duration;
    @ColumnInfo(name = "passengerid")
    String passengerid;
    @ColumnInfo(name = "passengeremail")
    String passengeremail;
    @ColumnInfo(name = "passengermobile")
    String passengermobile;
    @Ignore
    List<Passenger> passengers;


    public TicketInformation() {
        List<Passenger> passengers = new ArrayList<>();
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
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
