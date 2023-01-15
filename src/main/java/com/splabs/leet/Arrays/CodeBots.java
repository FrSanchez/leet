package com.splabs.leet.Arrays;

public class CodeBots {
    /**
     * After becoming famous, the CodeBots decided to move into a new building together. Each of the rooms has a different cost, and some of them are free, but there's a rumour that all the free rooms are haunted! Since the CodeBots are quite superstitious, they refuse to stay in any of the free rooms, or any of the rooms below any of the free rooms.

Given matrix, a rectangular matrix of integers, where each value represents the cost of the room, your task is to return the total sum of all rooms that are suitable for the CodeBots (ie: add up all the values that don't appear below a 0).
     * @param matrix
     * @return
     */
    int solution(int[][] matrix) {
        int sum = 0;
        for(int x = 0; x < matrix[0].length; x++) {
            for(int y = 0; y < matrix.length; y++) {
                if(matrix[y][x] == 0) {
                    y = matrix.length;
                    break;
                }
                sum+=matrix[y][x];
            }
        }
        return sum;
    }
}
