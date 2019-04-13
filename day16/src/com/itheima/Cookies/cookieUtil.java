package com.itheima.Cookies;



import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class cookieUtil {
    public static Cookie findCookie(Cookie[] cookies,String cookieName) throws IOException {
        if (cookies.length==0||cookies==null){
            return null;
        }
        for (Cookie cookie : cookies) {
            Date date = new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:SS");

            String str_date = URLEncoder.encode(sdf.format(date),"utf-8");
            cookie.setValue(str_date);
            cookie.setPath("/day16");
            cookie.setMaxAge(60*60*24*30);
            return cookie;
        }
        return null;
    }
}
