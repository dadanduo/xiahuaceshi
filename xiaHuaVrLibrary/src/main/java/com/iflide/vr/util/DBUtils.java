package com.iflide.vr.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iflide.vr.Entity.Dictionary;

import java.util.ArrayList;
import java.util.List;

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
 * @Description: ${todo}(数据库查询)
 * @date 2019/1/26
 * @email ${18011009889@163.com}
 */
public class DBUtils {

    private SQLiteDatabase db;

    public DBUtils(SQLiteDatabase db){

        this.db=db;
    }
    /**
     * 多个拼音同时查询按频率排序
     * @param pinyins
     * @return
     */
    public  List<Dictionary> SearchDictionaryByPinyinMore(List<String> pinyins){
        if(db!=null) {
            List<Dictionary> dictionaries = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("select * from dictionary where");
            for (int i = 0; i < pinyins.size(); i++) {
                if (i == 0) {
                    stringBuffer.append(" pinyin=" + "\"" + pinyins.get(i) + "\"");
                } else {
                    stringBuffer.append(" or pinyin=" + "\"" + pinyins.get(i) + "\"");
                }
            }
            stringBuffer.append(" order by defaultSort DesC");
            LogPrint.printError("当前sql" + stringBuffer.toString());
            Cursor cursor = db.rawQuery(stringBuffer.toString(), null);
            if (cursor != null && !cursor.isLast()) {
                if (cursor.moveToPosition(0)) {
                    Dictionary dictionary = new Dictionary();
                    String word = cursor.getString(cursor.getColumnIndex("word"));
                    String pinyinReturn = cursor.getString(cursor.getColumnIndex("pinyin"));
                    dictionary.setWord(word);
                    dictionary.setPinyin(pinyinReturn);
                    dictionaries.add(dictionary);
                }
                if (cursor.moveToFirst()) {//判断数据表里有数据
                    while (cursor.moveToNext()) {//遍历数据表中的数据
                        Dictionary dictionary = new Dictionary();
                        String word = cursor.getString(cursor.getColumnIndex("word"));
                        String pinyinReturn = cursor.getString(cursor.getColumnIndex("pinyin"));
                        dictionary.setWord(word);
                        dictionary.setPinyin(pinyinReturn);
                        dictionaries.add(dictionary);
                    }
                    cursor.close();
                }
            }
            if (dictionaries.size() == 0) {
                return null;
            }
            return dictionaries;
        }else{
            return null;
        }
    }

    /**
     * 多个拼音同时查询按频率排序
     * @param pinyins
     * @return
     */
    public  List<Dictionary> SearchDictionaryByPinyin(String pinyins){
        if(db!=null) {
            List<Dictionary> dictionaries = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("select * from dictionary where");
            stringBuffer.append(" pinyin=" + "\"" + pinyins + "\"");
            stringBuffer.append(" order by defaultSort DesC");
            LogPrint.printError("当前sql" + stringBuffer.toString());
            Cursor cursor = db.rawQuery(stringBuffer.toString(), null);
            if (cursor != null && !cursor.isLast()) {
                if (cursor.moveToPosition(0)) {
                    Dictionary dictionary = new Dictionary();
                    String word = cursor.getString(cursor.getColumnIndex("word"));
                    String pinyinReturn = cursor.getString(cursor.getColumnIndex("pinyin"));
                    dictionary.setWord(word);
                    dictionary.setPinyin(pinyinReturn);
                    dictionaries.add(dictionary);
                }
                if (cursor.moveToFirst()) {//判断数据表里有数据
                    while (cursor.moveToNext()) {//遍历数据表中的数据
                        Dictionary dictionary = new Dictionary();
                        String word = cursor.getString(cursor.getColumnIndex("word"));
                        String pinyinReturn = cursor.getString(cursor.getColumnIndex("pinyin"));
                        dictionary.setWord(word);
                        dictionary.setPinyin(pinyinReturn);
                        dictionaries.add(dictionary);
                    }
                    cursor.close();
                }
            }
            if (dictionaries.size() == 0) {
                return null;
            }
            return dictionaries;
        }
        return null;
    }
}
