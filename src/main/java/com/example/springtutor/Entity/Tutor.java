package com.example.springtutor.Entity;

import com.example.springtutor.service.Validator.Name.Name;
import com.example.springtutor.service.Validator.Rating.Rating;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tutors")
@Data
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Name
    private String name;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    @Column
    @Rating
    private int rating;


    @ManyToMany
    @JoinTable(
            name = "TutorRecords",
            joinColumns = @JoinColumn(name = "tutor_id"),
            inverseJoinColumns = @JoinColumn(name = "record_id")
    )
    private Set<Record> records = new HashSet<>();

    public Tutor() {
    }
}
