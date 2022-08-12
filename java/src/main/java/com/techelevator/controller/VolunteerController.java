package com.techelevator.controller;

import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.Volunteer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class VolunteerController {

    private VolunteerDao daoV;

    public VolunteerController(VolunteerDao daoV) {
        this.daoV = daoV;
    }

    @RequestMapping(value = "/volunteer", method = RequestMethod.GET)
    public List<Volunteer> findAll() {
        return daoV.findAll();
    }

    @RequestMapping(value = "/volunteer/{id}", method = RequestMethod.GET)
    public Volunteer getVolunteerById(@PathVariable int id) { return daoV.getVolunteerById(id);};

    //@PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/volunteer", method = RequestMethod.POST)
    public int createVolunteer(@RequestBody Volunteer volunteer) {
        //User user= userDao.update()
        //(update user set role=ROLE_ADMIN where username =?)
        return daoV.createVolunteer(volunteer);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/volunteer", method = RequestMethod.PUT)
    public void updateVolunteer(@RequestBody Volunteer volunteer) {
        daoV.updateVolunteer(volunteer);
    };

    //@PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/volunteer/{id}", method = RequestMethod.DELETE)
    public void deleteVolunteer(@PathVariable int id) {daoV.deleteVolunteer(id);};
    }



