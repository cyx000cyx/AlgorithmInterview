package com.algorithm.interview.week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/bulls-and-cows/
 */
public class Day6GetHint {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length; i++) {
            map.put(s[i], map.get(s[i]) == null ? 1 : map.get(s[i]) + 1);
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                A++;
                map.put(g[i], map.get(g[i]) - 1);
                s[i] = 'A';
                g[i] = 'A';
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (map.get(g[i]) != null && map.get(g[i]) > 0) {
                B++;
                map.put(g[i], map.get(g[i]) - 1);
            }
        }

        return A+"A"+B+"B";
    }

    public static void main(String[] args) {
        Day6GetHint day = new Day6GetHint();
        String hint = day.getHint("1122", "1222");
        System.out.println(hint);
    }
}
