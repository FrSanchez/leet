package com.splabs.codeSignal;

public class MineSweeper {
    int[][] solution(boolean[][] field, int x, int y) {
        int[][] board = new int[field.length][field[0].length];
        for(int r = 0; r < board.length; r++) {
            Arrays.fill(board[r], -1);
        }
        board[y][x] = bombs(field, x, y);
        if (board[y][x] == 0) {
            int width = field[0].length;
            Stack<Integer> stack = new Stack<>();
            Set<Integer> vis = new HashSet<>();
            stack.push(coord(x,y,width));
            while (!stack.empty()) {
                Integer curr = stack.pop();
                x = toX(curr, width);
                y = toY(curr, width);
                System.out.printf("%d %d ", x, y);
                if (!vis.contains(curr)) {
                    vis.add(curr);
                    for(int i = -1; i<=1; i++) {
                        for(int j = -1; j <= 1; j++) {
                            int r = y + j;
                            int c = x + i;
                            if (c>=0 && r>=0 && c<width && r<field.length) {
                                board[r][c] = bombs(field, c, r);
                                if (board[r][c] == 0) {
                                    stack.push(coord(c,r, width));
                                }
                            }
                        }
                    }
                }
            }
        }
        return board;
        
    }
    
    int toX(int coord, int w) { 
        int x = coord % w;   
        return x;
    }
    
    int toY(int coord, int w) {
        int y = coord / w;
        return y;
    }
    
    int bombs(boolean[][] field, int x, int y) {
        int sum = 0;
        for(int i = -1; i <=1; i++) {
            for(int j = -1; j <=1; j++) {
                int X = x + i;
                int Y = y + j;
                if (X>=0 && Y>=0 && Y < field.length && X < field[0].length && field[Y][X]) {
                    sum++;     
                }
            }
        }
        return sum;
    }
    
    int coord(int x, int y, int l) {
        return y * l + x;
    }
    
    void printB(int[][] board) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                System.out.printf(" %2d", board[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
