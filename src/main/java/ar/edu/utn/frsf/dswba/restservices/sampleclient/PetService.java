package ar.edu.utn.frsf.dswba.restservices.sampleclient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface PetService {

    @GET("pet/{petId}")
    Call<Pet> getPet(@Path("petId") String id);

}
