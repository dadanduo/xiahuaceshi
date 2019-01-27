package com.iflide.vr.util;

import android.content.Context;
import android.content.res.AssetManager;

import com.iflide.vr.R;
import com.iflide.vr.UnityTheEntrance.VrApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

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
 * @Description: ${todo}(工具类)
 * @date 2019/1/25
 * @email ${18011009889@163.com}
 */
public class Utility {

    /**
     * 将一维的字符串数组组合成为二维的数组
     *
     * @param ele
     * @return
     */
    public static String[] StringHandler(String[] ele) {
        String res = "";
        int len = ele.length;
        String[] ts = ele[1].split(",");
        String[][] abc = new String[len][ts.length];
        for (int f = 0; f < ele.length; f++) {
            String[] sub = ele[f].split("");
            abc[f] = sub;
        }
        String[][] ret = doExchange(abc);
        String[] result = ret[0];
        LogUtils.e("共有：", result.length + "种组合!");

        for (int i = 0; i < result.length; i++) {
            LogUtils.e("分别是：", result[i]);
        }
        return result;
    }

    /**
     * 使用递归调用将二维数组中的值进行排列组合
     *
     * @param doubleArrays
     * @return
     */
    private static String[][] doExchange(String[][] doubleArrays) {
        int len = doubleArrays.length;
        if (len >= 2) {
            int len1 = doubleArrays[0].length;
            int len2 = doubleArrays[1].length;
            int newlen = len1 * len2;
            String[] temp = new String[newlen];
            int index = 0;
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (doubleArrays[0][i] != null && doubleArrays[1][j] != null) {
                        temp[index] = doubleArrays[0][i] + "" + doubleArrays[1][j];
                    } else {
                        temp[index] = doubleArrays[0][i] + "" + doubleArrays[1][j];
                    }
                    index++;
                }
            }
            String[][] newArray = new String[len - 1][];
            for (int i = 2; i < len; i++) {
                newArray[i - 1] = doubleArrays[i];
            }
            newArray[0] = temp;
            return doExchange(newArray);
        } else {
            return doubleArrays;
        }

    }

    /**
     * 从asserts目录下拷贝文件到files
     *
     * @param context
     */
    public static void copyDB(Context context) {
        // 获取输出流,文件存储目录:data/data/包名/files目录下，文件名相同
        File file = new File(context.getFilesDir(), VrApplication.DATABASE_NAME);
        VrApplication.SD_PATH = context.getFilesDir().toString();
        // 当文件不存在的时候：才去拷贝，已经存在的不再去拷贝了。
        if (!file.exists()) {
            LogPrint.printError("文件不存在正在copy数据库到指定目录");
            AssetManager assetManager = context.getAssets();
            try {
                // 获取输入流
                InputStream is = assetManager.open(VrApplication.DATABASE_NAME);
                FileOutputStream fos = new FileOutputStream(file);
                // 开始读和写
                byte[] bys = new byte[1024];
                int len;
                while ((len = is.read(bys)) != -1) {
                    fos.write(bys, 0, len);
                }
                is.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            LogPrint.printError("数据库文件存在本地");
        }
    }
    /**
     * 从R.id.raw目录下拷贝文件到files
     *
     * @param context
     */
    public static void copyDBFromRaw(Context context) {
        //只要你拷贝了一次，我就不要你再拷贝了
        try {
            File file = new File(context.getFilesDir(), "address.db");
            if (file.exists() && file.length() > 0) {
                //正常了，就不需要拷贝了
                LogPrint.printError("正常了，就不需要拷贝了");
            } else {
                //().openRawResource
                //InputStream is = getAssets().open("address.db");
                InputStream is = context.getResources().openRawResource(R.raw.flide_input_method);
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                is.close();
                fos.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 按字母从多到少排序
     *
     * @param a
     * @return
     */
    public static List<String> evalateByDesc(String[] a) {
        List<String> c = new ArrayList<>();
        List<String> d = new ArrayList<>();
        TreeSet ts = new TreeSet(new MyStringLength());
        for (int i = 0; i < a.length; i++) {
            ts.add(a[i]);
        }
        Iterator it = ts.iterator();
        while (it.hasNext()) {
            c.add(it.next().toString());
        }
        Collections.reverse(c); // 倒序排列
        return c;
    }
}
