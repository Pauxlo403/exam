package edu.itstep.academy.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grades")
public class Grade
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "grade")
    private int grade;

    @Column(name = "comment")
    private String comment;

    @Column(name = "datecurrent")
    private Date datecurrent;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST})
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST})
    @JoinColumn(name = "id_student")
    private Student student;

    public Grade()
    {
    }

    public Grade(int grade, String comment, Date datecurrent)
    {
        this.grade = grade;
        this.comment = comment;
        this.datecurrent = datecurrent;
    }

    public int getId()
    {
        return id;
    }

    public int getGrade()
    {
        return grade;
    }

    public void setGrade(int grade)
    {
        this.grade = grade;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public Date getDatecurrent()
    {
        return datecurrent;
    }

    public void setDatecurrent(Date datecurrent)
    {
        this.datecurrent = datecurrent;
    }

    @Override
    public String toString()
    {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                ", comment='" + comment + '\'' +
                ", datecurrent=" + datecurrent +
                '}';
    }
}
