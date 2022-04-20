package com.local.conferencebooking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String firsName;
    private String lastName;
    private String hashPassword;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private State state;
    @ManyToMany
    @JoinTable(name = "users_rooms",
            joinColumns = @JoinColumn(name = "users_id"),
    inverseJoinColumns = @JoinColumn(name = "rooms_id"))
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Token> tokens = new ArrayList<>();
}
