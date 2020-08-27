package com.example.school.dao;

//IMPORTANT If your code is not working your imports might be incorrect
import com.example.school.entity.School;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SchoolDaoImpl implements SchoolDAO {

    private EntityManager entityManager;

    @Autowired
    public SchoolDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<School> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<School> myQuery = currentSession.createQuery("from School");
        List<School> school = myQuery.getResultList();
        return school;
    }

    @Override
    @Transactional
    public List<School> findAllForStudent() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<School> myQuery = currentSession.createQuery("SELECT id, date, first_name, last_name, type, email from School");
        List<School> school = myQuery.getResultList();
        return school;
    }


    @Override
    @Transactional
    public School findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        School theSchool = currentSession.get(School.class, theId);
        return theSchool;
    }

    @Override
    @Transactional
    public School findInfoByEmail(String email){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<School> theQuery = currentSession.createQuery("FROM School WHERE email=:email");
        theQuery.setParameter("email", email);
        List<School> temp = theQuery.getResultList();
        return temp.get(0);
    }

    @Override
    @Transactional
    public School findSchoolByID(int theId){
        Session currentSession = entityManager.unwrap(Session.class);
        Query<School> theQuery = currentSession.createQuery("FROM School WHERE id=:schoolID");
        theQuery.setParameter("schoolID", theId);
        List<School> temp = theQuery.getResultList();
        return temp.get(0);
    }

    @Override
    @Transactional
    public void save(School theSchool) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theSchool);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<School> theQuery = currentSession.createQuery("delete from School where id=:ID");
        theQuery.setParameter("ID", theId);
        theQuery.executeUpdate();
    }
}
