package edu.itstep.academy.entity;

import org.springframework.format.annotation.DateTimeFormat;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
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

    public void setId(int id) {
        this.id = id;
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

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
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
