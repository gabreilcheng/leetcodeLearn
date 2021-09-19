package com.cheng.learn.study07;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class LadderLength {

    /**
     * 双向BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }

    //第二种方法：单向的
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
         Set<String> set = new HashSet<>(wordList);
         if (set.isEmpty() || !set.contains(endWord)) {
             return 0;
         }
         Queue<String> queue = new LinkedList<>();
         int level = 1;
         queue.offer(beginWord);
         while (!queue.isEmpty()) {
             int size = queue.size();
             for (int i = 0; i < size; i++) {
                 String currWord = queue.poll();
                 if (currWord.equals(endWord)) {
                     return level;
                 }
                 for (char j = 'a'; j <= 'z'; j++) {
                     for (int k = 0; k < currWord.length(); k++) {
                         String newWord = currWord.substring(0, k) + j + currWord.substring(k + 1);
                         if (set.contains(newWord)) {
                             queue.offer(newWord);
                             set.remove(newWord);
                         }
                     }
                 }
             }
             level++;
         }
         return 0;
    }
}
