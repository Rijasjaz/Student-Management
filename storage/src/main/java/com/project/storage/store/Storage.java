package com.project.storage.store;

import jakarta.persistence.*;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "storage")
public class Storage {
    @Column(name = "id")
    @Id
    private Long id;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private LocalDate dob;
    @Column
    private String gender;
    @Column
    private String email;
    @Column
    private Long contact;
    @Column
    private String qualification;

}
