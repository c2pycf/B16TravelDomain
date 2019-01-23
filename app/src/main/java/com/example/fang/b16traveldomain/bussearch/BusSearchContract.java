package com.example.fang.b16traveldomain.bussearch;

import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformationResponse;

public class BusSearchContract {

     interface BusSearchView{
          void showToast(String s);
          void searchBusActivity(BusInformationResponse busInformationResponse);
          void displayError(String s);
     }

     interface BusSearchPresenter{
         void searchBus();

     }
}
