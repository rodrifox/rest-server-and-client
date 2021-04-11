package ar.edu.utn.frsf.dswba.restservices.samplePetStore;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PetService {

    @GET("pet/{petId}")
    Call<Pet> getPet(@Path("petId") String id);


}
