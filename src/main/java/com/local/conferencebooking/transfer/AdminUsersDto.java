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
public class AdminUsersDto {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private State state;

    public static AdminUsersDto from(User user) {
        return AdminUsersDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .state(user.getState())
                .build();
    }

    public static List<AdminUsersDto> from(List<User> users) {
        return users.stream().map(AdminUsersDto::from).collect(Collectors.toList());
    }
}

