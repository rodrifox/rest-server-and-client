package ar.edu.utn.frsf.dswba.restservices.samplePetStore;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PetController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/pet")
    public Pet getPet(@RequestParam(value = "name", defaultValue = "MyPet") String name) {

        Pet p;

        RestTemplate template = new RestTemplate();
        p = template.getForObject("https://petstore.swagger.io/v2/pet/{id}", Pet.class, name); // Deserialización (JSON --> Objeto)

        return p;





    }


    @PostMapping("/pet")
    public Pet savePet(@RequestBody Pet p) {

        // OBTENEMOS EL INPUT, ya transformado a objeto en Java:
        System.out.println("*** Pet received. Name/Code: " + p.getId() + ". Category: " + p.getCategory());

        // A su vez, invocamos otra API con estos datos: hacemos un POST para guardar una nueva mascota en esa API:
        RestTemplate template = new RestTemplate();
        Pet pet = template.postForObject("https://petstore.swagger.io/v2/pet", p,  Pet.class);

        System.out.println("*** Pet SAVED!! Name/Code: " + pet.getId() + ". Category: " + pet.getCategory());

        return p;
    }
}

