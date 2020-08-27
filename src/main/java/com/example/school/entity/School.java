package com.example.school.entity;
import javax.persistence.*;

//Flashcard Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "School") //This is for the actual name of the database table we are mapping to the class.
public class School {

    //Define fields
    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "date") //This will map the date field to the column named date in the table.
    private String date;

    @Column(name = "first_name") //This will map the firstName field to the column named first_name in the table.
    private String firstName;

    @Column(name = "last_name") //This will map the lastName field to the column named last_name in the table.
    private String lastName;

    @Column(name = "type") //This will map the type field to the column named type in the table.
    private String type;

    @Column(name = "ssn") //This will map the ssn field to the column named ssn in the table.
    private String ssn;

    @Column(name = "email") //This will map the email field to the column named email in the table.
    private String email;

    @Column(name = "password") //This will map the password field to the column named password in the table.
    private String password;


    //default constructor
    public School() {
    }

    //para constructor
    public School(String date, String firstName, String lastName, String type, String ssn, String email, String password) {
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
    }

    //getter/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //ToString Method
    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
                ", ssn='" + ssn + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
