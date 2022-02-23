package com.example.gilderNetcracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "event_set")
public class EventSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "es_id")
    private int id;
}
