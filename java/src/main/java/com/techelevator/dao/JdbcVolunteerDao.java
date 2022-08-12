package com.techelevator.dao;

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
    public int findIdByName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");

        int volunteerId;
        try {
            volunteerId = jdbcTemplate.queryForObject("SELECT volunteer_id from volunteers where name = ?", int.class, name);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Volunteer" + name + " was not found.");
        }

        return volunteerId;
    }

    @Override
    public Volunteer getVolunteerById(int VolunteerId) {
        String sql = "SELECT * " +
                "FROM volunteers " +
                "WHERE volunteer_id = ?";
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
        String sql = "SELECT * " +
                "FROM volunteers";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Volunteer volunteer = mapRowToVolunteer(results);
            volunteers.add(volunteer);
        }

        return volunteers;
    }

    @Override
    public Volunteer findByName(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");

        for (Volunteer volunteer : this.findAll()) {
            if (volunteer.getName().equalsIgnoreCase(name)) {
                return volunteer;
            }
        }
        throw new UsernameNotFoundException("Volunteer " + name + " was not found.");
    }


    //Possible Fix for multiple tables-OUTPUT functionality in SQL:
    //INSERT INTO Table1 (param1, param2, param3)
    //OUTPUT inserted.param1, inserted.param2, inserted.param3
    //INTO Table2
    //VALUES(1,'Value1','Value2'), (2, 'Value1','Value2')

    @Override
    public int createVolunteer(Volunteer volunteer) {

        String sql = "INSERT INTO volunteers(name, email, phone) " +
                "VALUES(?,?,?) RETURNING volunteer_id;";
        int newVolunteerId = jdbcTemplate.queryForObject(sql, Integer.class, volunteer.getName(),
                 volunteer.getEmail(), volunteer.getPhone());

        return newVolunteerId;
    }

    @Override
    public void updateVolunteer(Volunteer volunteer) {

        String sql = "UPDATE volunteers " +
                "SET name = ?, email = ?, phone = ?, application_status_id = ?  " +
                "WHERE volunteer_id = ? ;";
        jdbcTemplate.update(sql, volunteer.getName(), volunteer.getEmail(),
                volunteer.getPhone(), volunteer.getApplicationStatusId(), volunteer.getId());
    }

    @Override
    public void deleteVolunteer(int id) {
        String sql = "DELETE FROM volunteers " +
                "WHERE volunteer_id = ?;";

        jdbcTemplate.update(sql, id);
    }


    private Volunteer mapRowToVolunteer(SqlRowSet rsVol) {
        Volunteer volunteer = new Volunteer();
        volunteer.setId(rsVol.getInt("volunteer_id"));
        volunteer.setName(rsVol.getString("name"));
        volunteer.setEmail(rsVol.getString("email"));
        volunteer.setPhone(rsVol.getInt("phone"));
        volunteer.setApplicationStatusId(rsVol.getInt("application_status_id"));

        return volunteer;
    }


}
