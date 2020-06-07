package ar.edu.utn.frsf.dswba.restservices.sampleclient;

import java.util.List;

/**
 * Mascota
 */
public class Pet {

    String id;
    Category category;
    String name;
    List<String> photoUrls;
    List<Tag> tags;
    String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
