package com.projectk.requester.interfaces.loggedinUserRequesters;

import javax.servlet.http.HttpSession;

public interface UserLogoutRequester {
    Object executeLogout(HttpSession session);
}
