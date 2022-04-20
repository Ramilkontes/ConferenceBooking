package com.local.conferencebooking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Desktop {

    @EmbeddedId
    private ServiceClassForDesktop serviceClassForDesktop;
    @Temporal(TemporalType.DATE)
    private Date date;
}
