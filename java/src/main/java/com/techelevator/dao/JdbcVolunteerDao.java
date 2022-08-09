package com.techelevator.dao;

import com.techelevator.model.User;
import com.techelevator.model.UserNotFoundException;
import com.techelevator.model.Volunteer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVolunteerDao implements VolunteerDao {




    private final JdbcTemplate jdbcTemplate;

    public JdbcVolunteerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        int volunteerId;
        try {
            volunteerId = jdbcTemplate.queryForObject("select volunteer_id from volunteers where username = ?", int.class, username);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Volunteer" + username + " was not found.");
        }

        return volunteerId;
    }

    @Override
    public Volunteer getVolunteerById(int VolunteerId) {
        String sql = "SELECT * FROM volunteers WHERE volunteer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, VolunteerId);
        if (results.next()) {
            return mapRowToVolunteer(results);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<Volunteer> findAll() {
        List<Volunteer> volunteers = new ArrayList<>();
        String sql = "select * from volunteers";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Volunteer volunteer = mapRowToVolunteer(results);
            volunteers.add(volunteer);
        }

        return volunteers;
    }

    @Override
    public Volunteer findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        for (Volunteer volunteer : this.findAll()) {
            if (volunteer.getUsername().equalsIgnoreCase(username)) {
                return volunteer;
            }
        }
        throw new UsernameNotFoundException("Volunteer " + username + " was not found.");
    }

    @Override
    public int createVolunteer(Volunteer volunteer){

        String sql = "INSERT INTO volunteers(username, password, role, email, phone, name) " +
                "VALUES(?,?,?,?,?,?) RETURNING volunteer_id;";
        int newVolunteerId = jdbcTemplate.queryForObject(sql, Integer.class, volunteer.getUsername(), volunteer.getPassword(),
        volunteer.getRole(), volunteer.getEmail(), volunteer.getPhone(), volunteer.getName());

        return newVolunteerId;

    }

    private Volunteer mapRowToVolunteer(SqlRowSet rsVol){
        Volunteer volunteer = new Volunteer();
        volunteer.setId(rsVol.getInt("id"));
        volunteer.setUsername(rsVol.getString("username"));
        volunteer.setPassword(rsVol.getString("password"));
        volunteer.setRole(rsVol.getString("role"));
        volunteer.setEmail(rsVol.getString("email"));
        volunteer.setPhone(rsVol.getInt("phone"));
        volunteer.setName(rsVol.getString("name"));

        return volunteer;
    }







}
