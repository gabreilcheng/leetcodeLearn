package com.cheng.learn.study07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 36. 有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/description/
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>(), col = new HashMap<>(), area = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') { continue; }
                int n = c - '0';
                int index = i / 3 * 3 + j / 3;
                if(row.get(i).contains(n) || col.get(j).contains(n) || area.get(index).contains(n)) {
                    return false;
                }
                row.get(i).add(n);
                col.get(j).add(n);
                area.get(index).add(n);
            }
        }
        return true;
    }

}
