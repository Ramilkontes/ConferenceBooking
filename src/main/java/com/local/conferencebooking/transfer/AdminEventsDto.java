package com.local.conferencebooking.transfer;

import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminEventsDto {
    private Long id;
    private String name;
    private Date date;
    private int amountPeople;
    private EventStatus status;

    public static AdminEventsDto from(Event event) {
        return AdminEventsDto.builder()
                .id(event.getId())
                .name(event.getName())
                .date(event.getDate())
                .amountPeople(event.getAmountPeople())
                .status(event.getStatus())
                .build();
    }

    public static List<AdminEventsDto> from(List<Event> events) {
        return events.stream().map(AdminEventsDto::from).collect(Collectors.toList());
    }
}
