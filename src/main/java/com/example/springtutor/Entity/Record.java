package com.example.springtutor.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Entity
@EqualsAndHashCode(exclude = "tutors")
@Table(name = "Records")
@Data
@ToString(exclude = "tutors")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 4, max = 32, message = "Record name must contain from from 4 to 32 symbols")
    private String name;

    @Column
    @Size(min = 4, max = 32, message = "Record description must contain from 4 to 32 symbols")
    private String description;

    @Column
    private int price;

    @Column
    @Enumerated(EnumType.STRING)
    private Categorys categorys;


    @JsonIgnore
    @ManyToMany(mappedBy = "records")
    private Set<Tutor> tutors = new HashSet<>() ;

    public Record(){
    }
}
