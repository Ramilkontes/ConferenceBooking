package com.local.conferencebooking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/*@Embeddable
@Table(name = "users_events", uniqueConstraints = {
        @UniqueConstraint(columnNames = "users_id"),
        @UniqueConstraint(columnNames = "events_id")})*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceClassForMeetRoom implements Serializable {
    @Column(name = "users_id")
    private Long userId;
    @Column(name = "events_id")
    private Long eventId;
}
