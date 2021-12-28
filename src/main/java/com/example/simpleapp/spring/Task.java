package com.example.simpleapp.spring;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
}
