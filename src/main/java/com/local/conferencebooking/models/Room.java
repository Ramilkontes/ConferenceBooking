package com.local.conferencebooking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int amountPeople;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    private Time time;
    @ManyToMany(mappedBy = "rooms")
    private List<User> users = new ArrayList<>();


}
