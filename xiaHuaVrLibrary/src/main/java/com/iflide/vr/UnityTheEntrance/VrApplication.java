package com.iflide.vr.UnityTheEntrance;

import android.app.Application;

import com.iflide.vr.util.Utility;

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
 * @Description: ${todo}(程序入口)
 * @date 2019/1/25
 * @email ${18011009889@163.com}
 */
public class VrApplication extends Application {
    /**
     * xutilsDb路径
     */
    public static String SD_PATH = "";
    /**
     * 数据库名字
     */
    public static final String DATABASE_NAME = "flide_input_method.db";


    public static  final  boolean IS_DEBUG=false;

    public static  VrApplication vrApplication;


    public static VrApplication getInstance() {
        return vrApplication;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        // 将数据库copy到系统目录下
        Utility.copyDB(this.getApplicationContext());
        vrApplication=this;
//        // 初始化，只需要调   用一次
//        AssetsDatabaseManager.initManager(getApplicationContext());
//        // 获取管理对象，因为数据库需要通过管理对象才能够获取
//        AssetsDatabaseManager mg = AssetsDatabaseManager.getManager();
//        // 通过管理对象获取数据库
//        addressDB = mg.getDatabase(DATABASE_NAME);

//        //初始化xuitls配置
//        x.Ext.init(this);
//        //数据库
//        XutilsDBManage.getInstance().Instance();
    }
}
