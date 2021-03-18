package com.algorithm.interview.week2;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 */
public class Day11FizzBuzz {

    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return new ArrayList<String>();
        }

        String fizz = "Fizz";
        String buzz = "Buzz";
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            String node = "";
            if (i % 3 == 0) {
                node += fizz;
            }
            if (i % 5 == 0) {
                node += buzz;
            }
            if (node.length() == 0) {
                node += i;
            }
            result.add(node);
        }

        return result;
    }

    public static void main(String[] args) {
        Day11FizzBuzz day = new Day11FizzBuzz();
        List<String> result = day.fizzBuzz(150);
        System.out.println(JSON.toJSONString(result));
    }
}
