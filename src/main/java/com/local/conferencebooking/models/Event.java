package com.local.conferencebooking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @Size(min = 2, max = 13, message = "Name should be between 2 and 13 characters")
    private String name = "Event";

    @FutureOrPresent
    private LocalDateTime dateStart;

    @FutureOrPresent
    private LocalDateTime dateFinish;
    private int amountPeople;
    @Enumerated(EnumType.STRING)
    private EventStatus status;
    @ManyToMany(mappedBy = "events")
    private List<User> users = new ArrayList<>();
}
