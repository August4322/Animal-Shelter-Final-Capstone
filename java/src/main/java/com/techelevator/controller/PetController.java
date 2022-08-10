package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PetController {

    private PetDao dao;

    public PetController(PetDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value="/pets", method = RequestMethod.GET)
    public List<Pet> showAll() {
        return dao.listAllPets();
    }

    @RequestMapping(path="/pets/{id}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable int id) {
        return dao.getPetById(id);
    }


}
