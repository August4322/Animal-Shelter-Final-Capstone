package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetDao implements PetDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPetDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> listAllPets() {
        List<Pet> allPets = new ArrayList<>();

        //sql
        String sql =    "SELECT * " +
                        "FROM pets;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            allPets.add(mapRowToPet(results));
        }

        return allPets;
    }

    private Pet mapRowToPet(SqlRowSet rs) {
        Pet pet = new Pet();
        pet.setId(rs.getInt("id"));
        pet.setGender(rs.getString("gender"));
        pet.setName(rs.getString("pet_name"));
        pet.setType(rs.getString("animal_type"));
        pet.setColor(rs.getString("color"));
        pet.setAge(rs.getDouble("age"));
        pet.setImage(rs.getString("image_link"));
        pet.setAvailable(rs.getBoolean("is_available"));
        pet.setFixed(rs.getBoolean("spayed_neutered"));
        pet.setTagline(rs.getString("tagline"));

        return pet;

    }






}
