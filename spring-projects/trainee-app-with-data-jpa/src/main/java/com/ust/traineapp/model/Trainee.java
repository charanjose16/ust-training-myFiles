package com.ust.traineapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="trainee_db")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    @Column(name="trainee_name",length=50)
    private String name;
    @Column(length=100)
    private  String location;
    @Column(name = "joined_date")
//    @JsonFormat(pattern = "dd/MMM/yyyy")
    private LocalDate joinedDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;
}
