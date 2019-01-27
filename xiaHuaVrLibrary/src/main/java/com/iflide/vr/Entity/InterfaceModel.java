package com.iflide.vr.Entity;

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
 * @Description: ${todo}()
 * @date 2019/1/25
 * @email ${18011009889@163.com}
 */
public class InterfaceModel {

    private List<WordMainBean> wordMain;
    private List<LegalPinyinBean> LegalPinyin;

    public List<WordMainBean> getWordMain() {
        return wordMain;
    }

    public void setWordMain(List<WordMainBean> wordMain) {
        this.wordMain = wordMain;
    }

    public List<LegalPinyinBean> getLegalPinyin() {
        return LegalPinyin;
    }

    public void setLegalPinyin(List<LegalPinyinBean> LegalPinyin) {
        this.LegalPinyin = LegalPinyin;
    }

    public static class WordMainBean {
        /**
         * ChineseCharacters : 仓
         * pinyin : cang
         * pinyin  : bang
         * ChineseCharacters  : 藏
         */

        private String ChineseCharacters;
        private String pinyin;

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getPinyin() {
            return pinyin;
        }


        public String getChineseCharacters() {
            return ChineseCharacters;
        }

        public void setChineseCharacters(String ChineseCharacters) {
            this.ChineseCharacters = ChineseCharacters;
        }
    }

    public static class LegalPinyinBean {
        /**
         * pinyin  : bang
         * words : 棒绑帮榜磅...
         * pinyin : cang
         */

        private String pinyin;
        private String words;


        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public String getPinyin() {
            return pinyin;
        }

    }
}
