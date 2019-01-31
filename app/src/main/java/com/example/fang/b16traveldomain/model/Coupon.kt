package com.example.fang.b16traveldomain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coupon(@SerializedName("msg")
                       @Expose
                       var msg : String,
                       @SerializedName("discount")
                       @Expose
                       var discount :String)