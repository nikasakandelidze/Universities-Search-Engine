package com.projectk.requester.interfaces;

import javax.servlet.http.HttpSession;

public interface UserRequester {
    Object displayLogin();

    Object executeLogin(String username, String password, HttpSession session);
}
