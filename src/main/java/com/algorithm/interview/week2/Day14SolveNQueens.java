package com.algorithm.interview.week2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class Day14SolveNQueens {

    public List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        List<char[]> board = new ArrayList<char[]>();

        for (int i = 0; i < n; i++) {
            char[] node = new char[n];
            for (int j = 0; j < n; j++) {
                node[j] = '.';
            }
            board.add(node);
        }

        process(board, 0);
        return res;
    }

    public void process(List<char[]> board, int row) {
        if (row == board.size()) {
            res.add(parse(board));
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (!check(board, row, col)) {
                continue;
            }

            board.get(row)[col] = 'Q';
            process(board, row + 1);
            board.get(row)[col] = '.';
        }
    }

    public boolean check(List<char[]> board, int row, int col) {
        // col
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public List<String> parse(List<char[]> board) {
        List<String> solve = new ArrayList<String>();
        for (char[] rows : board) {
            solve.add(String.valueOf(rows));
        }
        return solve;
    }

    public static void main(String[] args) {
        Day14SolveNQueens day = new Day14SolveNQueens();
        List<List<String>> result = day.solveNQueens(4);
        System.out.println(JSON.toJSONString(result));
    }
}
