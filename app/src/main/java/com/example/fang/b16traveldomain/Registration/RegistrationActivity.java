package com.example.fang.b16traveldomain.Registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fang.b16traveldomain.R;
import com.example.fang.b16traveldomain.network.RetrofitClientInstance;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationActivity extends AppCompatActivity implements RegisterContract.RegisterView {

    EditText et_FirstName, et_LastName, et_email, et_address, et_mobile,et_password;
    Button buttonRegister;
    String fname,lname,address,mobile,email,password;
    RegistrationPresenter mPresenter;
    RegistrationApi registrationApi;

    String TAG = "RegistrationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);





        mPresenter = new RegistrationPresenter();

        et_FirstName = findViewById(R.id.et_firstname);
        et_LastName = findViewById(R.id.et_lastname);
        et_address = findViewById(R.id.et_address);
        et_email = findViewById(R.id.et_email);
        et_mobile = findViewById(R.id.et_mobile);
        et_password = findViewById(R.id.et_password);

        buttonRegister = findViewById(R.id.btn_register);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname =et_FirstName.getText().toString();
                lname = et_LastName.getText().toString();
                mobile = et_mobile.getText().toString();

                address = et_address.getText().toString();
                email =et_email.getText().toString();
                password = et_password.getText().toString();

                if(fname.isEmpty()||lname.isEmpty()||mobile.isEmpty()||email.isEmpty()||address.isEmpty()||password.isEmpty()){
                   showResponse("Please fill all the fields");
                }
                else{
                    mPresenter.onRegistrationReq(fname,lname,email,mobile,address,password);

                }

                registrationApi = RetrofitClientInstance.getInstance().create(RegistrationApi.class);

                 Call<ResponseBody> call = registrationApi.createUser(fname,lname,email,mobile,address,password);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.e(TAG, response.message().toString());
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e(TAG, t.getMessage() );

                    }
                });

            }
        });





    }

    @Override
    public void showResponse(String message) {
        Toast.makeText(RegistrationActivity.this, message, Toast.LENGTH_SHORT).show();

    }
}
