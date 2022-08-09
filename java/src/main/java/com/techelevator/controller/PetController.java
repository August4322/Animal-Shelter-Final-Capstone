package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
