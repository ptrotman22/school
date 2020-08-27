package com.example.school.rest;

import com.example.school.entity.School;
import com.example.school.dao.SchoolDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is to allow calls from React
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class SchoolController {


    private final com.example.school.dao.SchoolDaoImpl schoolDaoImpl;

    @Autowired
    public SchoolController(SchoolDaoImpl schoolDaoImpl) {
        this.schoolDaoImpl = schoolDaoImpl;
    }

    //http://localhost:8080/retrieveAllSchool
    @GetMapping("/retrieveAllSchool")
    public List<School> findAll() {
        return schoolDaoImpl.findAll();
    }

    //http://localhost:8080/retrieveAllForStudent
    @GetMapping("/retrieveAllForStudent")
    public List<School> findAllForStudent() {
        return schoolDaoImpl.findAllForStudent();
    }

    //http://localhost:8080/school/1
    @GetMapping("/flashcard/{FlashcardID}")
    public School findSchoolByID(@PathVariable("SchoolID") int schoolID) {

        School flashcard = schoolDaoImpl.findById(schoolID);

        if(flashcard == null) {
            throw new RuntimeException("FlashcardID is not found : " + schoolID);
        }

        return flashcard;
    }

    //http://localhost:8080/password/email
    @GetMapping("/password/{email}")
    public String findPasswordByEmail(@PathVariable("email") String email) {

        School school = SchoolDaoImpl.findInfoByEmail(email);

        if(school == null) {
            throw new RuntimeException("Email is not found : " + email);
        }

        return school.getPassword();
    }

    //http://localhost:8080/type/email
    @GetMapping("/type/{email}")
    public String findTypeByEmail(@PathVariable("email") String email) {

        School school = SchoolDaoImpl.findInfoByEmail(email);

        if(school == null) {
            throw new RuntimeException("Email is not found : " + email);
        }

        return school.getType();
    }





    //http://localhost:8080/addSchool
    @PostMapping("/addSchool")
    public School addFlashcard(@RequestBody School theSchool) {
        //also just in case they pass an id in JSON .... set id to o
        //this is to force a save of new item .... instead of update
        theSchool.setId(0);

        schoolDaoImpl.save(theSchool);
        return theSchool;
    }

    //http://localhost:8080/updateSchool
    @PutMapping("/updateSchool")
    public School updateFlashcard(@RequestBody School updateSchool) {
        //No theFlashcard.setId(0); this will execute an update instead of a create
        schoolDaoImpl.save(updateSchool);
        return updateSchool;
    }

    //http://localhost:8080/deleteSchool/1
    @DeleteMapping("/deleteSchool/{schoolId}")
    public String deleteSchool(@PathVariable int schoolId) {

        //Creating a tempFlashcard to check to see if an employee exists
        School tempSchool = schoolDaoImpl.findById(schoolId);

        //This will throw an exception if the School is null
        if(tempSchool == null) {
            throw new RuntimeException("SchoolId is not found : " + schoolId);
        }

        //This will execute the deleteByID method in the SchoolDaoImpl.
        schoolDaoImpl.deleteById(schoolId);
        return "Deleted School id : " + schoolId;
    }
}
