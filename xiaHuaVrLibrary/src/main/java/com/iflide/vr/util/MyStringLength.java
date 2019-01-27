package com.iflide.vr.util;

import java.util.Comparator;

/**
 * ////////////////////////
 * //  ┏┓　　　┏┓///////////
 * //┏┛┻━━━┛┻┓ ////////////
 * //┃　　　　　　　┃     ////
 * //┃　　　━　　　┃     ////
 * //┃　┳┛　┗┳　┃       /////
 * //┃　　　　　　　┃     ////
 * //┃　　　┻　　　┃         //
 * //┃　　　　　　　┃        ///
 * //┗━┓　　　┏━┛           ///
 * //    ┃　　　┃   神兽保佑  ///
 * //    ┃　　　┃   代码无BUG！///
 * //    ┃　　　┗━━━┓     ///
 * //    ┃　　　　　　　┣┓ ///
 * //    ┃　　　　　　　┏┛ ///
 * //    ┗┓┓┏━┳┓┏┛      ///
 * //      ┃┫┫　┃┫┫     ///
 * ///////////////////////
 *
 * @author ${chenda}
 * @version V1.0
 * @Description: ${todo}()
 * @date 2019/1/26
 * @email ${18011009889@163.com}
 */
public class MyStringLength implements Comparator {
    //重写 compare 方法
    public int compare(Object obj1, Object obj2) {
        String str1 = (String) obj1;
        String str2 = (String) obj2;
		/*
		return str1.length() - str2.length();
		如果这样直接返回长度的值，这样会把相同长度的数据简略掉。
		*/
        int num = str1.length() - str2.length();
        if (num == 0) {
            return str1.compareTo(str2);    //如果长度相同比较大小。
        }
        return num;
    }
}
