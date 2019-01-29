package com.example.fang.b16traveldomain.singleSignOn;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.homePage.HomePageFragment;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class SingleSignOnFragment extends Fragment {
    CallbackManager callbackManager;
    LoginButton loginButton;

    String TAG = " SingleSignOn_Activity";

    private static final String EMAIL = "email";

    //HomePageFragment homePageFragment;


    public SingleSignOnFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_single_sign_on,container,false);
        callbackManager = CallbackManager.Factory.create();


        loginButton = view.findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.e(TAG, "onSuccess: "+loginResult.getAccessToken().toString() );

                Toast.makeText(getContext(), "Welcome to SRS Travels", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(SingleSignOnFragment.this, HomePageFragment.class);
//
//                startActivity(intent);


//                HomePageFragment homePageFragment = new HomePageFragment();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.home_page_fragment_container, homePageFragment);
//                transaction.commit();




            }

            @Override
            public void onCancel() {
                // App code
                Log.e(TAG, "onCancel  : single sign on cancelled" );
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(TAG, "onError: "+ error.toString() );
                Toast.makeText(getContext(), "Login Failed..Please try again", Toast.LENGTH_SHORT).show();

            }


        });



        return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
