package com.local.conferencebooking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
    @Column(name = "name", nullable = false, columnDefinition = "Event")
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dateStart;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dateFinish;
    private int amountPeople;
    @Enumerated(EnumType.STRING)
    private EventStatus status;
    @ManyToMany(mappedBy = "events")
    private List<User> users = new ArrayList<>();
}
