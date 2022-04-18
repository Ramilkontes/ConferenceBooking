package com.local.conferencebooking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Desktop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private List<User> users = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
}
