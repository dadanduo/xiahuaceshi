package com.iflide.vr.UnityTheEntrance;

import android.database.sqlite.SQLiteDatabase;

import com.alibaba.fastjson.JSON;
import com.iflide.vr.Entity.Dictionary;
import com.iflide.vr.Entity.InterfaceModel;
import com.iflide.vr.util.DBUtils;
import com.iflide.vr.util.LogPrint;
import com.iflide.vr.util.LogUtils;
import com.iflide.vr.util.Utility;

import java.io.File;
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
 * @Description: ${todo}(测试接口类)
 * @date 2019/1/24
 * @email ${18011009889@163.com}
 */
public class TestClass {
    public TestClass(){

    }
    /**
     * 查词入口
     * @param DividedLetters
     */
    public String  WordSearchingInterface(String DividedLetters,String DBPath){
        SQLiteDatabase db=null;
        DBUtils dbUtils=null;
        //查看该路径下的数据库是否存在
        File file=new File(DBPath, VrApplication.DATABASE_NAME);
        if(!file.exists()){
            return  "数据库不存在";
        }else{
            String openPath=DBPath+"/"+VrApplication.DATABASE_NAME;
            db= SQLiteDatabase.openOrCreateDatabase(openPath, null);
            dbUtils=new DBUtils(db);
        }
        //输出合法length合法组合
        List<String> wordMianPY=new ArrayList<>();
        InterfaceModel interfaceModel=new InterfaceModel();
        //候选拼音数据源
        List<InterfaceModel.LegalPinyinBean> legalPinyinBeans= new ArrayList<>();
        //输出源
        List<InterfaceModel.WordMainBean> wordMain=new ArrayList<>();
        //拆分组合
        String[] one=DividedLetters.split(";");
        for(String a:one)
            LogUtils.e("拆分后的组合分别为：",a);
        //组合后的所有情况
        String[] allCombination;
        if(one.length==1){
            allCombination=one[0].split("");
        }else{
            //组合后的所有情况
            allCombination = Utility.StringHandler(one);
        }
        List<String> sortingAllCombination=Utility.evalateByDesc(allCombination);
        int size=sortingAllCombination.size();
        //数据库ok
        if(dbUtils!=null) {
            //开始检验合法性  -------------------------------->根据拼音查询多次
            for (int i = 0; i < size; i++) {
                LogPrint.printError("所有的组合方式" + sortingAllCombination.get(i));
                //开始查询
                List<Dictionary> dictionaries = dbUtils.SearchDictionaryByPinyin(sortingAllCombination.get(i));
                //拼音合法
                if (dictionaries != null) {
                    StringBuffer stringBufferWord = new StringBuffer();
                    //查出来的所有字
                    for (int j = 0; j < dictionaries.size(); j++) {
                        stringBufferWord.append(dictionaries.get(j).getWord());
                        LogPrint.printError("第" + j + sortingAllCombination.get(i) + "查出来的字分别有" + dictionaries.get(j).getWord());
                    }
                    //每个同音节字全部放到集合中
                    InterfaceModel.LegalPinyinBean legalPinyinBean = new InterfaceModel.LegalPinyinBean();
                    legalPinyinBean.setPinyin(sortingAllCombination.get(i));
                    legalPinyinBean.setWords(stringBufferWord.toString());
                    legalPinyinBeans.add(legalPinyinBean);
                }
                if (sortingAllCombination.get(i).length() >= one.length) {
                    wordMianPY.add(sortingAllCombination.get(i));
                }
            }
            //------------------------------>开始多个拼音同时查询
            List<Dictionary> dictionaries = dbUtils.SearchDictionaryByPinyinMore(wordMianPY);
            LogPrint.printError("查出来的数据有" + dictionaries.size());
            for (int i = 0; i < dictionaries.size(); i++) {
                LogPrint.printError("分别是" + dictionaries.get(i).getWord() + "拼音是：" + dictionaries.get(i).getPinyin());
                InterfaceModel.WordMainBean wordMainBean = new InterfaceModel.WordMainBean();
                wordMainBean.setChineseCharacters(dictionaries.get(i).getWord());
                wordMainBean.setPinyin(dictionaries.get(i).getPinyin());
                wordMain.add(wordMainBean);
            }
            interfaceModel.setWordMain(wordMain);
            interfaceModel.setLegalPinyin(legalPinyinBeans);
        }else{
            return "数据库异常";
        }
        LogPrint.printError("json"+ JSON.toJSONString(interfaceModel));

        return JSON.toJSONString(interfaceModel);
    }
}
