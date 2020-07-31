package com.projectk.requester.interfaces.basicUser;

import javax.servlet.http.HttpSession;

public interface UserRequester {
    Object displayLogin(HttpSession httpSession);

    Object executeLogin(String username, String password, HttpSession session);
}
