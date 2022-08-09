package com.techelevator.dao;

import com.techelevator.model.Volunteer;

import java.util.List;

public interface VolunteerDao {


    List<Volunteer> findAll();

    Volunteer getVolunteerById(int volunteerId);

    Volunteer findByUsername(String username);

    int findIdByUsername(String username);

    int createVolunteer(Volunteer volunteer);
}



