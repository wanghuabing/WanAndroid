package com.samir.framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * PatternUtil
 * @author: Samir
 */
public class PatternUtil {

    public static boolean isEmail(String str) {
        String regex = "\\w+(\\.\\w)*@\\w+(\\.\\w{2,3}){1,3}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 判断是否是手机号码
     * @return
     */
    public static Boolean isTelephone(String telephone){
        //String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
        String regExp = "^[1][0-9]{10}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(telephone);
        return m.matches();
    }

    /**
     * 判断是否是固定号码
     * @return
     */
    public static Boolean isLandlineTelephone(String telephone){
        String regExp = "^(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(telephone);
        return m.matches();
    }

    public static boolean isNewVersion(String oldVersion, String newVersion){
        final int verLen = 3;
        String[] oldVerArr = oldVersion.split("\\.");
        String[] newVerArr = newVersion.split("\\.");
        if (oldVerArr.length != verLen || newVerArr.length!= verLen)
            return false;
        int oldVerValue = Integer.parseInt(oldVerArr[0]) * 100 + Integer.parseInt(oldVerArr[1]) * 10 + Integer.parseInt(oldVerArr[2]);
        int newVerValue = Integer.parseInt(newVerArr[0]) * 100 + Integer.parseInt(newVerArr[1]) * 10 + Integer.parseInt(newVerArr[2]);
        if(newVerValue > oldVerValue){
            return true;
        }
        return false;

    }

    public static boolean isMoney(String money){
        Pattern pattern = Pattern.compile("^(([1-9]\\d*)(\\.\\d{1,2})?)$|(0\\.0?([1-9]\\d?))$");
        Matcher matcher = pattern.matcher(money);

        return matcher.matches();
    }

    public static void main(String[] args) {
        boolean flag = isNewVersion("1.0.0", "1.0.1");
        System.out.println(flag);
    }
}
