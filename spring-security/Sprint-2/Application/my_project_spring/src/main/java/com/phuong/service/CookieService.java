package com.phuong.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class CookieService {

    public Map<String, String> cookie(HttpServletRequest request) {
        Map<String, String> cookie = new HashMap<>();
        cookie.put(getCookieName(request), getCookieValue(request));
        return cookie;
    }

    private String getCookieName(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("Authorization")) {
                    return cookie.getName();
                }
            }
        }
        return null;
    }

    private String getCookieValue(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("Authorization")) {
                    return "Bearer " + cookie.getValue();
                }
            }
        }
        return null;
    }
}
