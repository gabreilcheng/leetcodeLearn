package com.cheng.learn.week08;

/**
 * 52. N皇后 II
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 */
public class SolveNQueens2 {

    private int count = 0;
    private int size = 0;

    public int totalNQueens(int n) {
        size = (1 << n) - 1;
        resolve(0,0,0);
        return count;
    }
    public void resolve(int row, int ld, int rd) {
        if(row == size) {
            count ++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0){
            int p = pos & (-pos);
            pos -= p;
            resolve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public static void main(String[] args) {
        System.out.println( 1 << 4);
    }
}
