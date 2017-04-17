package com.lxwp.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public String getCookie(Cookie[] cookies, String key) { 
        if (cookies != null) { 
            for (Cookie cookie : cookies) { 
                if (cookie.getName().equals(key)) { 
                    return cookie.getValue(); 
                } 
            } 
        } 
        return null; 
    } 
}
