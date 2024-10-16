package com.splabs.codeSignal;
import java.util.ArrayList;
import java.util.List;

    /*
    Suppose we have a matrix where each cell represents a distinct symbol or integer. Our task is to decode this matrix by reading the cells in a particular order.

The decoding begins from the top-left cell of the matrix. We move in a bottom-left downward diagonal direction until we hit the left boundary. Upon hitting the left boundary, we move one cell down (unless we're at the bottom-left corner already, in which case we move one cell to the right) and start moving in an upward diagonal direction towards the upper-right.

While moving diagonally up-right, if we hit the top boundary, we move one cell to the right and start moving in a downward diagonal direction towards the bottom-left. However, if we hit the right boundary while moving diagonally upwards, we move one cell down and start moving in a bottom-left direction. In other words, we keep zigzagging diagonally across the matrix until every cell in the matrix is visited.

Upon completing this zigzag traversal, we will have a list of traversed cell values. Next, we process this list to uncover the indices of the perfect square numbers. The function diagonalTraverseAndSquares(int[][] matrix) should implement this traversal and return a list containing the 1-indexed positions of perfect square numbers in the traversed sequence.

     */

public class DiagonalMatrixTraversal {

    /*
Given a matrix of n x m integers, where n represents the number of rows and m represents the number of columns. Both n and m range from 1 to 100, inclusive.

The matrix cells may contain either a positive, a negative integer, or zero, with values ranging from -100 to 100, inclusive.

In this task, you are required to traverse the matrix diagonally from the top-left cell to the bottom-right cell in a zigzag pattern. Start from the top-left cell, move one cell to the right (if it exists), then move one step diagonally down-left. After reaching a left (bottom) boundary, move one step down (right) and start moving diagonally up-right. Continue this pattern until you reach the last cell of the matrix. Your task is to return a list of tuples, each tuple containing the index pair (in 1-based indexing format) of cells with negative integers encountered during your traversal.


     */
    public static List<int[]> diagonalTraversalAndNegatives(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> traversal = new ArrayList<>();
        List<int[]> answer = new ArrayList<>();
        int row = 0, col = 0, dir = 1;
        for(int i = 0; i < rows * cols; i++) {
            System.out.printf("%d,%d - %d\n", row, col, dir);
            int value = matrix[row][col];
            traversal.add(value);
            if (value < 0) {
                answer.add(new int[] { row + 1, col + 1 });
            }
            if (dir == 1) {
                if (col == cols -1) {
                    row += 1;
                    dir = -1;
                } else if (row == 0) {
                    col += 1;
                    dir = -1;
                } else {
                    row -= 1;
                    col += 1;
                }
            } else {
                if (row == rows -1) {
                    col += 1;
                    dir = 1;
                } else if (col == 0) {
                    row += 1;
                    dir = 1;
                } else {
                    row += 1;
                    col -= 1;
                }
            }
        }
        System.out.print("[");
        for (Integer num : traversal) {
            System.out.print(num + " ");
        }
        System.out.println("]");
        return answer;
    }

    public static List<Integer> diagonalTraverseAndSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> traversal = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        int row = 0, col = 0, dir = 1;
        for (int i = 0; i < rows * cols; ++i) {  // Loop runs for the total number of cells in the matrix.
            traversal.add(matrix[row][col]);  // Append the current cell value to traversal.

            // Logic to control direction based on edges:
            if (dir == 1) {  // Moving down-left
                if (row == rows - 1) {
                    col += 1;
                    dir = -1;
                } else if (col == 0) {
                    row += 1;
                    dir = -1;
                } else {
                    row += 1;
                    col -= 1;
                }
            } else {  // Moving up-right
                if (col == cols - 1) {
                    row += 1;
                    dir = 1;
                } else if (row == 0) {
                    col += 1;
                    dir = 1;
                } else {
                    row -= 1;
                    col += 1;
                }
            }
        }
        /*
        With a completed traversal, we have obtained a list of integers. Next, we evaluate this list to find perfect squares, i.e., numbers that are squares of other integers. For every perfect square we encounter, we add its 1-indexed position in the traversal list to the results list. In Java, we can use the Math.sqrt method. If the integer square root, when squared, equals the initial number, we know the initial number is a perfect square, so we add its position to our results.
         */

        for (int idx = 0; idx < traversal.size(); ++idx) {
            int val = traversal.get(idx);
            int root = (int) Math.sqrt(val);
            if (root * root == val) {  // Check if the value is a perfect square number.
                results.add(idx + 1);
            }
        }

        return results;
    }
}
