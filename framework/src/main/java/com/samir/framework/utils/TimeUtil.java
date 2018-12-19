package com.samir.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * TimeUtil
 * @author: Samir
 */
public class TimeUtil {

    public static String parseDate(String createTime) {
        try {
            String ret = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long create = sdf.parse(createTime).getTime();
            Calendar now = Calendar.getInstance();
            long ms = 1000 * (now.get(Calendar.HOUR_OF_DAY) * 3600 + now.get(Calendar.MINUTE) * 60 + now.get(Calendar.SECOND));//毫秒数
            long ms_now = now.getTimeInMillis();
            if (ms_now - create < ms) {
                ret = "今天";
            } else if (ms_now - create < (ms + 24 * 3600 * 1000)) {
                ret = "昨天";
            } else if (ms_now - create < (ms + 24 * 3600 * 1000 * 2)) {
                ret = "前天";
            } else {
                ret = "更早";
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    public static String getAgoTime(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
            Date date = format.parse(time);
            long delta = new Date().getTime() - date.getTime();
            if (delta < 1L * ONE_MINUTE) {
                long seconds = toSeconds(delta);
                return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
            }
            if (delta < 45L * ONE_MINUTE) {
                long minutes = toMinutes(delta);
                return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
            }
            if (delta < 24L * ONE_HOUR) {
                long hours = toHours(delta);
                return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
            }
            if (delta < 48L * ONE_HOUR) {
                return "昨天";
            }
            if (delta < 30L * ONE_DAY) {
                long days = toDays(delta);
                return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
            }
            if (delta < 12L * 4L * ONE_WEEK) {
                long months = toMonths(delta);
                return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
            } else {
                long years = toYears(delta);
                return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }

    /**
     * 数据四舍五入取整
     * @param str
     * @return
     */
    public static String getIntData(String str){
        if (str == null || "".equals(str)){
            return "——";
        }else{
            long data = Math.round(Double.parseDouble(str));//四舍五入
            return data + "";
        }
    }
}
