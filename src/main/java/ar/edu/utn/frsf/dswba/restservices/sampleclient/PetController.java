package ar.edu.utn.frsf.dswba.restservices.sampleclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PetController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/pet")
    public Pet greeting(@RequestParam(value = "name", defaultValue = "MyPet") String name) {

        Pet p;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PetService service = retrofit.create(PetService.class);

        Call<Pet> petCall = service.getPet(name);

        Response<Pet> response = null;

        try {
            response = petCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body();

    }
}
