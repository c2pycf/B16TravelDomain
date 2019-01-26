package com.example.fang.b16traveldomain.registration;

public interface RegisterContract {
    interface  RegisterView{
        void showResponse(String message);

    }


    interface Register{
        void onRegistrationReq(String fname, String lname, String email, String mobile, String address, String password );
        void onRegistrationResponse(String message);
    }
}
