package br.com.ericambiel.retrofit.rest;

import br.com.ericambiel.retrofit.model.ui.CEPResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

    @GET("ws/{cep}/json/")
    Call<CEPResponse> getCEP(@Path("cep") String cep);
}
