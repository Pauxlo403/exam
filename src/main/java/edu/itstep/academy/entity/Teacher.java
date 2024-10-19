package edu.itstep.academy.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Teacher()
    {

    }

    public Teacher(String firstName, String lastName)
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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(firstName, teacher.firstName) && Objects.equals(lastName, teacher.lastName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, firstName, lastName);
    }
}
