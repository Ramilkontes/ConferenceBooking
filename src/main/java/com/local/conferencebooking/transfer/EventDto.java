package com.local.conferencebooking.transfer;

import com.local.conferencebooking.models.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    private Long id;
    private String name;
    private int amountPeople;
    private LocalDateTime dateStart;
    private LocalDateTime dateFinish;

    public static EventDto from(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .amountPeople(event.getUsers().size())
                .dateStart(event.getDateStart())
                .dateFinish(event.getDateFinish())
                .build();
    }

    public static List<EventDto> from(List<Event> events) {
        return events.stream().map(EventDto::from).collect(Collectors.toList());
    }
}
