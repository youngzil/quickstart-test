/**
 * 项目名称：quickstart-mock 
 * 文件名：MyDictionary.java
 * 版本信息：
 * 日期：2017年11月23日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.mockito;

import java.util.HashMap;
import java.util.Map;

/**
 * MyDictionary
 * 
 * @author：youngzil@163.com
 * @2017年11月23日 下午3:48:46
 * @since 1.0
 */
public class MyDictionary {
    Map<String, String> wordMap;

    public MyDictionary() {
        wordMap = new HashMap<String, String>();
    }

    public void setMap(final Map<String, String> wordMap) {
        this.wordMap = wordMap;
    }

    public void add(final String word, final String meaning) {
        wordMap.put(word, meaning);
    }

    public String getMeaning(final String word) {
        return wordMap.get(word);
    }
}
