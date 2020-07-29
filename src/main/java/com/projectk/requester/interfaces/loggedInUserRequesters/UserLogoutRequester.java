package com.projectk.requester.interfaces.loggedInUserRequesters;

import javax.servlet.http.HttpSession;

public interface UserLogoutRequester {
    Object executeLogout(HttpSession session);
}
