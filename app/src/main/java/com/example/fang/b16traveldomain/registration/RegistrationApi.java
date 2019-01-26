package com.example.fang.b16traveldomain.registration;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegistrationApi {

    @FormUrlEncoded
    @POST("registration.php?")

    Call<ResponseBody> createUser(
     @Field("firstname") String firstname,
      @Field("lastname") String lastname,
      @Field("address")  String  address,
      @Field("email")     String  email,
      @Field("mobile")    String   mobile,
       @Field("password") String  password

    );
}
