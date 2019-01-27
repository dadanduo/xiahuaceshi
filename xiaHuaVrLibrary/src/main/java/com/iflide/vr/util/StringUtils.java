package com.iflide.vr.util;

import android.text.TextUtils;

public class StringUtils {


    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static int orderIndexOf(String source, String des, int index) {
        if (source == null) {
            return -1;
        }
        int count = 0;
        int i = 0;
        final char dest = des.charAt(0);
        for (; i < source.length(); i++) {
            if (source.charAt(i) == dest) {
                count++;
            }
            if (count == index) {
                break;
            }
        }
        return i;
    }

    public static int orderIndexOf(String source, char des, int index) {
        if (source == null) {
            return -1;
        }
        int count = 0;
        int i = 0;
        for (; i < source.length(); i++) {
            if (source.charAt(i) == des) {
                count++;
            }
            if (count == index) {
                break;
            }
        }
        return i;
    }

    /**
     *
     * @param source
     * @param des
     * @return
     */
    public static int characterCount(String source, String des) {
        if (source == null) {
            return 0;
        }
        int count = 0;
        final char dest = des.charAt(0);
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == dest) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculate how many letters in source string
     * @param source source String
     * @param des des letter
     * @return count
     */
    public static int characterCount(String source, char des) {
        if (source == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == des) {
                count++;
            }
        }
        return count;
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A;
    }

    public static boolean isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumber(CharSequence strName) {
        return TextUtils.isDigitsOnly(strName);
    }

}
