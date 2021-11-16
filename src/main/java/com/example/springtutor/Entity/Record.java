package com.example.springtutor.Entity;

import com.example.springtutor.service.Validator.Description.Description;
import com.example.springtutor.service.Validator.Name.Name;
import com.example.springtutor.service.Validator.Price.Price;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
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
    @Name
    private String name;

    @Column
    @Description
    private String description;

    @Column
    @Price
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
