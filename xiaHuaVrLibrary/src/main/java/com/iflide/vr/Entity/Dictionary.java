package com.iflide.vr.Entity;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

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
 * @Description: ${todo}(字典表)
 * @date 2019/1/25
 * @email ${18011009889@163.com}
 */
@Table(name = "dictionary",onCreated = "")
public class Dictionary {

    @Column(name="word",isId=true,autoGen=true,property="NOT NULL" )
    private String word;


    @Column(name="pinyin",isId=true,autoGen=true,property="NOT NULL" )
    private String pinyin;

    @Column(name="firstLetters")
    private String firstLetters;

    @Column(name="wordLength")
    private int wordLength;

    @Column(name="defaultSort")
    private int defaultSort;

    @Column(name="frequence")
    private int frequence;

    @Column(name="latestFlag")
    private Boolean latestFlag;

    @Column(name="createTime")
    private String createTime;

    @Column(name="modifyTime")
    private String modifyTime;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getFirstLetters() {
        return firstLetters;
    }

    public void setFirstLetters(String firstLetters) {
        this.firstLetters = firstLetters;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public int getDefaultSort() {
        return defaultSort;
    }

    public void setDefaultSort(int defaultSort) {
        this.defaultSort = defaultSort;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public Boolean getLatestFlag() {
        return latestFlag;
    }

    public void setLatestFlag(Boolean latestFlag) {
        this.latestFlag = latestFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}
