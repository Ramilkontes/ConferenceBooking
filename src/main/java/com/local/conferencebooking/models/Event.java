package com.local.conferencebooking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name = "Event";
    private LocalDateTime dateStart;
    private LocalDateTime dateFinish;
    private int amountPeople;
    @Enumerated(EnumType.STRING)
    private EventStatus status;
    @ManyToMany(mappedBy = "events")
    private List<User> users = new ArrayList<>();
}
