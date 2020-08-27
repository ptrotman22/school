package com.example.school.dao;

import com.example.school.entity.School;

import java.util.List;

public interface SchoolDAO {
    //DAO Methods
    List<School> findAll();
    List<School> findAllForStudent();
    School findById(int theId);
    //School findPasswordByEmail(String email);
    School findSchoolByID(int theId);
    School findInfoByEmail(String email);
    void save(School theSchool);
    void deleteById(int theId);
}
