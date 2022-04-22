package com.local.conferencebooking.transfer;

import com.local.conferencebooking.models.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {
    private Long id;
    private String name;
    private int amountPeople;
    private Date date;

    public static RoomDto from(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .amountPeople(room.getUsers().size())
                .date(room.getDate())
                .build();
    }

    public static List<RoomDto> from(List<Room> rooms) {
        return rooms.stream().map(RoomDto::from).collect(Collectors.toList());
    }
}
