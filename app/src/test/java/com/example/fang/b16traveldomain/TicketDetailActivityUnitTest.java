package com.example.fang.b16traveldomain;

import android.app.Activity;
import android.content.Context;

import com.example.fang.b16traveldomain.model.TicketInformation;
import com.example.fang.b16traveldomain.model.dataresource.UserDataSource;
import com.example.fang.b16traveldomain.model.dataresource.UserRepository;
import com.example.fang.b16traveldomain.model.dataresource.busInformation.BusInformation;
import com.example.fang.b16traveldomain.passengerinformation.PassengerInformationActivity;
import com.example.fang.b16traveldomain.passengerinformation.PassengerInformationPresenter;
import com.example.fang.b16traveldomain.ticketconfirmation.TicketDetailActivity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TicketDetailActivityUnitTest {

    private static final String FAKE_STRING = "HELLO WORLD";
    private static TicketInformation ticketInformation;
    private static ArrayList<String> seatsTest;
    private static BusInformation busInformationTest;

    @Mock
    PassengerInformationActivity mMockActivity;
    UserRepository userRepository;
    @BeforeClass
    public static void initializeInputData(){
        seatsTest = new ArrayList<>();
        seatsTest.add("s1");
        seatsTest.add("s2");
        busInformationTest = new BusInformation("101","bus","air","10:00AM","5h","200","9:00AM","15:00PM");

    }


    @Test
    public void setNewTicketInforTest() {
        // Given a mocked Context injected into the object under test...
//        when(mMockContext.getString(R.string.hello_world))
//                .thenReturn(FAKE_STRING);

        PassengerInformationPresenter passengerInformationPresenter = new PassengerInformationPresenter(mMockActivity);

        // ...when the string is returned from the object under test...
        passengerInformationPresenter.setNewTicketInfor(seatsTest,busInformationTest);



        // ...then the result should be the expected one.
        assertThat(ticketInformation.getBusid(), is(busInformationTest.getBusId()));
    }

    @Test
    public void showConfirmPageTest() {
        PassengerInformationPresenter passengerInformationPresenter = new PassengerInformationPresenter(mMockActivity);

        passengerInformationPresenter.showConfirmPage();
    }

    @BeforeClass
    public static void initializeSavedReservation(){
        ticketInformation = new TicketInformation();
        //add conponent for ticketInformation


    }

}
