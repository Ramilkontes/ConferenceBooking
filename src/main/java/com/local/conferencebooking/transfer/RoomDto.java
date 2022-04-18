package com.local.conferencebooking.transfer;

import com.local.conferencebooking.models.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {
    private Long id;
    private int amountPeople;
    private Time time;

    public static RoomDto from (Room room){
        return RoomDto.builder()
                .id(room.getId())
                .amountPeople(room.getAmountPeople())
                .time(room.getTime())
                .build();
    }
}
