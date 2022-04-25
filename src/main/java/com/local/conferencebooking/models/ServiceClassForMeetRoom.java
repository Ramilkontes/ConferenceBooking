package com.local.conferencebooking.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Embeddable
@Table(name = "users_rooms", uniqueConstraints = {
        @UniqueConstraint(columnNames = "users_id"),
        @UniqueConstraint(columnNames = "rooms_id")})
@Data
public class ServiceClassForMeetRoom implements Serializable {
    @Column(name = "users_id")
    private Long userId;
    @Column(name = "rooms_id")
    private Long roomId;
}
