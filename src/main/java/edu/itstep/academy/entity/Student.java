package edu.itstep.academy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
    @Column(name = "username")
    private String username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, grades);
    }
}
