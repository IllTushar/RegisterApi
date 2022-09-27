package com.example.registrationrestapi.Api;

import com.example.registrationrestapi.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {
    @FormUrlEncoded
    @POST("register")
    Call<ResponseModel>getData(
            @Field("email") String Email,
            @Field("password") String Password
    );
}
