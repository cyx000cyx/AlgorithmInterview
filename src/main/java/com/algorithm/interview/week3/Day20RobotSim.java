package com.algorithm.interview.week3;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/walking-robot-simulation/
 */
public class Day20RobotSim {

    public static int[] addX = {0, 1, 0, -1};
    public static int[] addY = {1, 0, -1, 0};
    int pointer = 0;

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] add = {0, 1};
        int[] now = {0, 0};
        Set<Long> obstacleSet = getObstacleSet(obstacles);
        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            int cmd = commands[i];
            if (cmd < 0) {
                add = getDirection(cmd);
                continue;
            }
            for (int k = 1; k <= cmd; k++) {
                if (!checkObstacle(obstacleSet, new int[]{now[0] + add[0], now[1] + add[1]})) {
                    now[0] += add[0];
                    now[1] += add[1];
                    max = Math.max(max, now[0] * now[0] + now[1] * now[1]);
                }
            }
        }
        return max;
    }

    public int[] getDirection(int command) {
        if (command == -1) {
            pointer = (pointer + 1) % 4;
        }
        if (command == -2) {
            pointer = (pointer + 3) % 4;
        }
        return new int[]{addX[pointer], addY[pointer]};
    }

    public Set<Long> getObstacleSet(int [][] obstacles) {
        Set<Long> r = new HashSet<Long>();
        if (obstacles == null) {
            return r;
        }
        for (int i = 0; i < obstacles.length; i++) {
            r.add(buildKey(obstacles[i]));
        }
        return r;
    }

    public boolean checkObstacle(Set<Long> obstacleSet, int[] direction) {
        return obstacleSet.contains(buildKey(direction));
    }

    public Long buildKey(int[] direction) {
        return ((long) direction[0]) * 100000000000000000L + direction[1];
    }

    public static void main(String[] args) {
        Day20RobotSim day = new Day20RobotSim();
//        int i = day.robotSim(new int[]{1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,3,2,4,3,9,2,-1,-1,-2,1,3,-2,4,1,4,-1,
//                1,9,-1,-2,5,-1,5,5,-2,6,6,7,7,2,8,9,-1,7,4,6,9,9,9,-1,5,1,3,3,-1,5,9,7,4,8,-1,-2,1,3,2,9,3,-1,
//                -2,8,8,7,5,-2,6,8,4,6,2,7,2,-1,7,-2,3,3,2,-2,6,9,8,1,-2,-1,1,4,7},
//                new int[][]{});
        int i = day.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{new int[]{2,4}});
        System.out.println(i);
    }
}
