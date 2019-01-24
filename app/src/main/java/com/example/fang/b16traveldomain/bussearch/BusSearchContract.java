package com.example.fang.b16traveldomain.bussearch;

import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformationResponse;

public interface BusSearchContract {

     interface BusSearchView{
          void setupBusSearchMVP();  //setup presenter
          void showToast(String s);  //show response message
          void showBusSearchActivity(BusInformationResponse busInformationResponse); //display bus search
          void displayError(String s);  //show error
          void setupViews();       // setup layout

     }

     interface BusSearchPresenter{
         void searchBus(String id);
     }
}
