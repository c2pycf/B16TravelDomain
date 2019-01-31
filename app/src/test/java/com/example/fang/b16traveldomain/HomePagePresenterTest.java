package com.example.fang.b16traveldomain;

import com.example.fang.b16traveldomain.homePage.HomePageFragment;
import com.example.fang.b16traveldomain.homePage.HomePagePresenter;
import com.example.fang.b16traveldomain.passengerinformation.PassengerInformationPresenter;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class HomePagePresenterTest {

    @Mock
    HomePageFragment mMockFragment;

    @BeforeClass
    public static void initializeInputData() {


    }


    @Test
    public void convertLocalDateTest() {
        // Given a mocked Context injected into the object under test...
//        when(mMockContext.getString(R.string.hello_world))
//                .thenReturn(FAKE_STRING);

        HomePagePresenter pagePresenter = new HomePagePresenter(mMockFragment);

        // ...when the string is returned from the object under test...
        String date = pagePresenter.converLocalDate(2018, 2, 2);
        String test = "JANURARY 31 THURSDAY";
        assertThat (date,is(test));


        // ...then the result should be the expected one.

    }
}
