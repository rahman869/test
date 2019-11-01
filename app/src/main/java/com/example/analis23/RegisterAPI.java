package com.example.analis23;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by sulistiyanto on 07/12/16.
 */

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("insert.php")
    Call<Value> sendBiodata(@Field("nama") String nama,
                                   @Field("usia") String usia,
                                   @Field("domisili") String domisili);


}
