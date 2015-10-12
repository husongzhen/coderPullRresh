package com.coder.pullrefresh.util;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.graphics.Bitmap;

/**
 * 统一数据检查类
 *
 * @author abu
 */

public class CodeCheck {

    public static boolean isNotNull(Object str) {
        return str != null && !"".equals(str);
    }

    public static boolean isNotNullString(String str) {
        return (str != null && !"".equals(str) && !"null".equals(str));
    }

    public static boolean isEqualString(String one, String anther) {
        return (one != null && anther != null && one.equals(anther));
    }

    /**
     * @param bitmap
     * @return
     */
    public static final boolean isNotNullBitmap(Bitmap bitmap) {
        return (bitmap != null && !bitmap.isRecycled());
    }

    public static final boolean isNotNullList(List list) {
        return (list != null && list.size() != 0);
    }

    public static final boolean isNotNullBytes(byte[] bytes) {
        return (bytes != null && bytes.length != 0);
    }

    public static final boolean isNotNullMap(Map map) {
        return (map != null && map.size() != 0);
    }


    /**
     * 检查电话号码
     *
     * @param phone
     * @return
     */
    public static final boolean isPhone(String phone) {
        Pattern p = Pattern.compile("^[1]\\d{10}$");
        Matcher m = p.matcher(phone);
        return m.find();
    }


    /**
     * 检查密码
     *
     * @param
     * @return
     */
    public static final boolean checkPwd(String pwd) {
        Pattern p = Pattern.compile("^[A-Za-z0-9]{6,16}$");
        Matcher m = p.matcher(pwd);
        return m.find();
    }

//    public static final boolean checkName(String nick) {
//        int len = StringUtils.length(nick);
//        if (len < 2 * 2 || len > 8 * 2) {
//            return false;
//        }
//        return true;
//    }

    public static boolean isEmail(String email) {
        String p = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
