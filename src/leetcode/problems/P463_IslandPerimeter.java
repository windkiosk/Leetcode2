package leetcode.problems;

import java.util.LinkedList;

public class P463_IslandPerimeter {

    static int MOD = 10000;

    static int[][] sample = new int[][] {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
    };

    static int[][] sample2 = new int[][] {
            {1, 1},
            {1, 1},
    };

    static int genId(int row, int col) {
        return row * MOD + col;
    }

    static int rowFromId(int id) {
        return (id - colFromId(id)) / MOD;
    }

    static int colFromId(int id) {
        return id % MOD;
    }

    public static void main(String[] args) {
        P463_IslandPerimeter islandPerimeter = new P463_IslandPerimeter();
        System.out.println(islandPerimeter.islandPerimeter(sample2));
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int w = grid[0].length;
        int h = grid.length;

        for (int row = 0; row < h; row ++) {
            for (int col = 0; col < w; col ++) {
                if (grid[row][col] == 1) {
                    return bfs(grid, row, col);
                }
            }
        }

        return 0;
    }

    private int bfs(int[][] grid, int row, int col) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(genId(row, col));
        grid[row][col] = 2;
        int ret = 0;
        while (!queue.isEmpty()) {
            int id = queue.poll();
            row = rowFromId(id);
            col = colFromId(id);
            ret += 4;

            if (row - 1 >= 0 && grid[row - 1][col] > 0) {
                ret --;
                if (grid[row - 1][col] == 1) {
                    queue.add(genId(row - 1, col));
                    grid[row - 1][col] = 2;
                }
            }

            if (col - 1 >= 0 && grid[row][col - 1] > 0) {
                ret --;
                if (grid[row][col - 1] == 1)
                    queue.add(genId(row, col - 1));
                grid[row][col - 1] = 2;
            }

            if (row + 1 < grid.length && grid[row + 1][col] > 0) {
                ret --;
                if (grid[row + 1][col] == 1) {
                    queue.add(genId(row + 1, col));
                    grid[row + 1][col] = 2;
                }
            }

            if (col + 1 < grid[0].length && grid[row][col + 1] > 0) {
                ret --;
                if (grid[row][col + 1] == 1) {
                    queue.add(genId(row, col + 1));
                    grid[row][col + 1] = 2;
                }
            }

        }

        return ret;
    }

    // https://leetcode.com/problems/island-perimeter/discuss/
    public int islandPerimeter_clean_butBrute_force(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
