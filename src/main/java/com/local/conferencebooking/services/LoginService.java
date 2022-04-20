package com.local.conferencebooking.services;

import com.local.conferencebooking.forms.LoginForm;
import com.local.conferencebooking.transfer.TokenDto;

public interface LoginService {
    TokenDto login(LoginForm form);
}
