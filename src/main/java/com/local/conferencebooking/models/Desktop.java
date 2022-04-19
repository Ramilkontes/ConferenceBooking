package com.local.conferencebooking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
