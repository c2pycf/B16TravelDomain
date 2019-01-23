package com.example.fang.b16traveldomain.model.dataresource.busInformation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BusInformationResponse {

    @SerializedName("busInformationList")
   private List<BusInformation> busInformationList;

    public BusInformationResponse(List<BusInformation> busInformationList) {
        this.busInformationList = busInformationList;
    }

    public List<BusInformation> getBusInformationList() {
        return busInformationList;
    }

    public void setBusInformationList(List<BusInformation> busInformationList) {
        this.busInformationList = busInformationList;
    }
}
