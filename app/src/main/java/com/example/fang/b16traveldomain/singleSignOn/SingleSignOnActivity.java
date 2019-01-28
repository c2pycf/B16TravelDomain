package com.example.fang.b16traveldomain.singleSignOn;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class SingleSignOnActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    LoginButton loginButton;

    String TAG = " SingleSignOn_Activity";

    private static final String EMAIL = "email";

    //HomePageFragment homePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_sign_on);
        callbackManager = CallbackManager.Factory.create();


        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));


        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Log.e(TAG, "onSuccess: "+loginResult.getAccessToken().toString() );

                Toast.makeText(SingleSignOnActivity.this, "Welcome to SRS Travels", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(SingleSignOnActivity.this, HomePageFragment.class);
//
//                startActivity(intent);


                HomePageFragment homePageFragment = new HomePageFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_page_fragment_container, homePageFragment);
                transaction.commit();




            }

            @Override
            public void onCancel() {
                // App code
                Log.e(TAG, "onCancel  : single sign on cancelled" );
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(TAG, "onError: "+ error.toString() );
                Toast.makeText(SingleSignOnActivity.this, "Login Failed..Please try again", Toast.LENGTH_SHORT).show();

            }


        });

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        AccessToken accessToken = AccessToken.getCurrentAccessToken();
                        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
