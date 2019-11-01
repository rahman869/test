package com.example.analis23.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hakiki95 on 4/16/2017.
 */

public class Retroserver {


    //private  static  final String base_url = "http://bprdanamass.000webhostapp.com/";
    public   static  final String base_url = "http://36.91.39.47:8080/analisdp22/";
    //private  static  final String base_url = "http://192.168.43.9/analisdp22/";

    private static Retrofit retrofit;


    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
    public static ApiRequestBiodata getApiServices()
    {
        return  getClient().create(ApiRequestBiodata.class);
    }
}
