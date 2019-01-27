package com.example.fang.b16traveldomain.model;

import com.google.gson.annotations.SerializedName;

public class ApiResponseMsg {
    @SerializedName("msg")
    String[] msg;

    public ApiResponseMsg(String[] msg) {
        this.msg = msg;
    }

    public String[] getMsg() {
        return msg;
    }

    public void setMsg(String[] msg) {
        this.msg = msg;
    }
}
