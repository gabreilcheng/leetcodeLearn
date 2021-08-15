package com.cheng.learn.study02;

import java.util.HashMap;
import java.util.Map;

/**
 * 242、有效字母的异位
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class ValidLetter {

    /**
     * 利用了hash的思想，第一个字符串中的字符放入的时候+1，
     * 第二个字符串中的字符，判断是否存在hash表中，如果存在就-1，并且去除为0的字符
     * 最后只需要判断map是否为空即可。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length(); i ++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int j = 0;j < t.length(); j++) {
            char ch = t.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                map.remove(ch, 0);
            }
        }
        return map.isEmpty();
    }


}
