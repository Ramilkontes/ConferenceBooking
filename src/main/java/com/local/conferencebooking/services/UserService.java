package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.UserForm;
import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.User;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface UserService {

    User findOneByLogin(String login);

    void joinToRoom(Long id, LocalDateTime date, Model model);

    Map<String, Boolean> getFlagsByDays(List<LocalDate> dates);
}
