package com.example.gilderNetcracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "dates_delete")
public class DateDelete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dates_delete_id")
    private int id;

    @Column(name = "date_delete",nullable = false)
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "event_id",insertable = false,updatable = false, referencedColumnName = "event_id")
    private Event event;

}
