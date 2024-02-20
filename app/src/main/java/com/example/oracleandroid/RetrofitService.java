package com.example.oracleandroid;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitService {
    // 회원가입
    @POST("/user/signup")
    Call<SignUpResponse> userSignUp(@Body SignUpData data);

}