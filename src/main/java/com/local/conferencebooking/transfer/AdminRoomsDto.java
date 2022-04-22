package com.local.conferencebooking.transfer;

import com.local.conferencebooking.models.Room;
import com.local.conferencebooking.models.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRoomsDto {
    private Long id;
    private String name;
    private Date date;
    private int amountPeople;
    private RoomStatus status;

    public static AdminRoomsDto from(Room room) {
        return AdminRoomsDto.builder()
                .id(room.getId())
                .name(room.getName())
                .date(room.getDate())
                .amountPeople(room.getAmountPeople())
                .status(room.getStatus())
                .build();
    }

    public static List<AdminRoomsDto> from(List<Room> rooms) {
        return rooms.stream().map(AdminRoomsDto::from).collect(Collectors.toList());
    }
}
