package com.free.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Date 2017/10/11 13:07
 * Description: 文本工具类；
 */
public class TxtUtil {

    /**
     * 判断字符串是否为空
     *
     * @param text 字符串
     * @return text is empty return true or else false；
     */
    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0 || "".equals(text.trim());
    }

    /**
     * 判断字符串是否非空
     *
     * @param text 字符串
     * @return text is empty return false or else true；
     */
    public static boolean isNotEmpty(String text) {
        return !TxtUtil.isEmpty(text);
    }


    /**
     * 获取异常信息
     *
     * @param ex
     * @return
     */
    public static String getExceptionDetails(Throwable ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        ex.printStackTrace(pw);
        sw.flush();
        pw.flush();
        return sw.toString();
    }
}
