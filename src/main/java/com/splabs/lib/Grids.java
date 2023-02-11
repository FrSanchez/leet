package com.splabs.lib;

import javax.swing.text.html.ListView;
import java.util.*;

public class Grids {
/*
We need to navigate through an m x n grid, starting at the top-left and exiting at the bottom-right. We can only move either down or right at any point in order to get to the finish. Additionally, certain grid entries can be blocked, as shown in the table below.

How many unique paths exist?

Input:
[
  [0,0,0], // 0,1,2
  [0,1,0], // 3,4,5
  [0,0,0]   // 6,7,8
]
​
Expected Output: 2
​
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right


Input:
[
  [0,0,1],
  [0,0,0],
  [0,0,0]
]
​
Expected Output: 7
Paths:
1. Down -> Down  -> Right -> Right
2. Right -> Down -> Right -> Down
3. Right -> Down -> Down -> Right
4. Down -> Right -> Right -> Down
5. Down -> Right -> Down -> Right
6. Down -> Down -> Right -> Up -> Right -> Down
7. Right -> Down -> Left -> Down -> Right -> Right
*/

/*
 * Click `Run` to execute the snippet below!
 */


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


    int width ;
    int height;
    public int toPoint(int x, int y) {
        return y * width + x;
    }

    int[][] dirs = {{1, 0},{0, 1}, {-1, 0}, {0, -1}};

    int[] toXY(int point) {
        int x = point % width;
        int y = point / width;
        return new int[] { x,y};
    }

    public int printAllPaths(int[][] grid, int sx, int sy, int dx, int dy) {
        this.height = grid.length;
        this.width = grid[0].length;

        int s = toPoint(sx,sy);
        int d = toPoint(dx,dy);
        List<Integer> path = new ArrayList<>();
        path.add(s);
        return printAllPathsUtil(grid, s, d, new boolean[width * height], path, 0);
    }

    private void printXY(int point) {
        int[] xy = toXY(point);
        System.out.printf(" %d,%d", xy[0], xy[1]);
    }
    private void printPath(List<Integer> path) {
        path.forEach(this::printXY);
    }

    public int countPaths(int[][] maze, int sx, int sy, int dx, int dy) {
        this.height = maze.length;
        this.width = maze[0].length;
        return countAllPaths(maze, toPoint(sx, sy), toPoint(dx, dy), new HashSet<>(), 0);
    }

    private int countAllPaths(int[][] grid, int s, int d, Set<Integer> visited, int count) {
        if (s == d) {
            return count + 1;
        }
        int[] xy = toXY(s);
        visited.add(s);
        for (int[] dir : dirs) {
            int nx = xy[0] + dir[0];
            int ny = xy[1] + dir[1];
            if (nx >= 0 && ny >= 0 && nx < width && ny < height
                    && grid[ny][nx] == 0) {
                int pt = toPoint(nx, ny);
                if (!visited.contains(pt)) {
                    count = countAllPaths(grid, pt, d, visited, count);
                }
            }
        }
        visited.remove(s);
        return count;
    }

    private int printAllPathsUtil(int[][] grid, int s, int d, boolean[] isVisited, List<Integer> path, int count) {
        if (s == d) {
            path.forEach(this::printXY);
            System.out.println();
            return count + 1;
        }

        int[] xy = toXY(s);
        int x = xy[0];
        int y = xy[1];

        isVisited[s] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && ny >= 0 && nx < width && ny < height
                    && grid[ny][nx] == 0) {
                // it is a valid adjacent cell
                int pt = toPoint(nx, ny);
                if (!isVisited[pt]) {
                    path.add(pt);
                    count = printAllPathsUtil(grid, pt, d, isVisited, path, count);
                    path.remove(path.size() - 1);
                }
            }
        }
        isVisited[s] = false;
        return count;
    }

    public int findPaths(int[][] grid) {
        int height = grid.length;
        if (height < 1) {
            return 0;
        }
        int width = grid[0].length;
        if (width < 1) {
            return 0;
        }
        if (width == 1 && height == 1) {
            return grid[0][0] == 0 ? 1 : 0;
        }

        Queue<Integer> stx = new LinkedList<>();
        Queue<Integer> sty = new LinkedList<>();
        int sx = 0;
        int sy = 0;
        int ex = width - 1;
        int ey = height - 1;
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        visited.add(toPoint(sx, sy));
        Map<Integer,Integer> path = new HashMap<>();
        stx.add(sx);
        sty.add(sy);
        visited.add(toPoint(sx,sy));
        while(!stx.isEmpty()) {
            int x = stx.poll();
            int y = sty.poll();
            if (x == ex && y == ey) {
                count++;
                System.out.println(path);
                System.out.print(stx); System.out.println(sty);
                continue;
            }
            for(int i = 0; i < dirs.length; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >=0 && ny >=0 && nx < width && ny < height
                        &&  grid[ny][nx] == 0 && !visited.contains(toPoint(nx,ny))) {
                    stx.add(nx);
                    sty.add(ny);
                    visited.add(toPoint(nx,ny));
                    path.put(toPoint(nx,ny), toPoint(x,y));
                }
            }
        }

        return count;
    }
//
//    public static void main(String[] args) {
//        // int[][] grid = {
//        //   {0,0,0},
//        //   {0,1,0},
//        //   {0,0,0}
//        // };
//        // Solution s = new Solution();
//        // int n = s.findPaths(grid);
//        // System.out.println(n);
//
//        int[][] grid = {
//                {0,0,1},
//                {0,0,0},
//                {0,0,0}
//        };
//
//        Solution s = new Solution();
//        int n = s.findPaths(grid);
//        System.out.println(n);
//
//
//    }
}
