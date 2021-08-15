package com.cheng.learn.study02;

import java.util.*;

/**
 * 49.字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/submissions/
 * 也是用到了hashmap的方法去解
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());

    }

}
