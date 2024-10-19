package edu.itstep.academy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(
            cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE},
            mappedBy = "student",
            fetch = FetchType.EAGER
    )
    private List<Grade> grades = new ArrayList<>();

    public Student()
    {
    }

    public Student(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
