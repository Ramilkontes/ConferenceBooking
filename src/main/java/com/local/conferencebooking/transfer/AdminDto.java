package com.local.conferencebooking.transfer;

import com.local.conferencebooking.models.State;
import com.local.conferencebooking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDto {
    private Long id;
    private String login;
    private String firsName;
    private String lastName;
    private State state;

    public static AdminDto from(User user) {
        return AdminDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .firsName(user.getFirsName())
                .lastName(user.getLastName())
                .state(user.getState())
                .build();
    }

    public static List<AdminDto> from(List<User> users) {
        return users.stream().map(AdminDto::from).collect(Collectors.toList());
    }

    // TODO: сделать метод для админа с комнатами
}

