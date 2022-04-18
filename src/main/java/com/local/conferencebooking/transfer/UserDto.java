package com.local.conferencebooking.transfer;

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
public class UserDto {
    private Long id;
    private String login;
    private String firsName;
    private String lastName;

    public static UserDto from (User user){
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .firsName(user.getFirsName())
                .lastName(user.getLastName())
                .build();
    }

    public static List<UserDto> from (List<User> users){
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
