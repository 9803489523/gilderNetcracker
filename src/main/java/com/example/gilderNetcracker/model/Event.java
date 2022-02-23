package com.example.gilderNetcracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private int id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "event_date",nullable = false)
    private LocalDateTime eventDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "cycle_start")
    private LocalDate cycleStart;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "cycle_end")
    private LocalDate cycleEnd;

    @Column(name = "day_shorts")
    private String day;


}
