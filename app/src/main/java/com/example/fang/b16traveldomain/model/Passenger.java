package com.example.fang.b16traveldomain.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

import java.io.Serializable;

/**
 * Using foreignKey to relate two tables
 */

@Entity(foreignKeys = @ForeignKey(entity = TicketInformation.class,
        parentColumns = "order_time",
        childColumns = "porder_time",
        onDelete = CASCADE),indices = {@Index("porder_time")})
public class Passenger implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    int pid;
    @ColumnInfo(name = "porder_time")
    String porderTime;
    @ColumnInfo(name = "selectedseat")
    String selectedseat;
    @ColumnInfo(name = "passengername")
    String passengername;
    @ColumnInfo(name = "passengerage")
    String passengerage;
    @ColumnInfo(name = "passengergender")
    String passengergender;

    public Passenger(String selectedseat, String passengername, String passengerage, String passengergender) {
        this.selectedseat = selectedseat;
        this.passengername = passengername;
        this.passengerage = passengerage;
        this.passengergender = passengergender;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPorderTime() {
        return porderTime;
    }

    public void setPorderTime(String porderTime) {
        this.porderTime = porderTime;
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
}
