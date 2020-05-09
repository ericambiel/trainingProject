package br.com.ericambiel.retrofit.rest;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://viacep.com.br/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    public static CEPService cepService = retrofit.create(CEPService.class);
}
