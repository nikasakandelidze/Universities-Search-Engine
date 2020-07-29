package com.projectk.requester.interfaces;

import javax.servlet.http.HttpSession;

public interface UserLogoutRequester {
    Object executeLogout(HttpSession session);
}
