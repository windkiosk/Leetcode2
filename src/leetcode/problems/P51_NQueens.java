package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51_NQueens {

    public static void main(String[] args) {
        P51_NQueens nQueens = new P51_NQueens();
        List<List<String>> lists = nQueens.solveNQueens(8);
        for (List<String> list : lists) {
            for (String line : list) {
                System.out.println(line);
            }
            System.out.println("--------");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(ret, 0, n, board);
        return ret;
    }

    private void helper(List<List<String>> ret, int rowIndex, int size, char[][] board) {
        if (rowIndex == size) {
            ret.add(toList(board));
            return;
        }

        for (int x = 0; x < size; x++) {
            char c = board[rowIndex][x];
            if (c == 0) {
                char[][] newBoard = deepCopy(board);
                mark(newBoard, x, rowIndex, size);
                helper(ret, rowIndex + 1, size, newBoard);
            }
        }
    }

    List<String> toList(char[][] current) {
        List<String> list = new ArrayList<>();
        for (char[] chars : current) {
            list.add(String.valueOf(chars));
        }
        return list;
    }

    void mark(char[][] board, int x, int y, int size) {
        board[y][x] = 'Q';
        for (int i = 0; i < size; i++) {
            if (i == x) { continue; }
            board[y][i] = '.';
        }

        for (int i = 0; i < size; i++) {
            if (i == y) { continue; }
            board[i][x] = '.';
        }

        for (int i = -size; i < size; i++) {
            if (x + i >= 0 && y + i >= 0 && x + i < size && y + i < size && i != 0) {
                board[y + i][x + i] = '.';
            }
        }

        for (int i = -size; i < size; i++) {
            if (x - i >= 0 && y + i >= 0 && x - i < size && y + i < size && i != 0) {
                board[y + i][x - i] = '.';
            }
        }
    }

    public static char[][] deepCopy(char[][] original) {
        if (original == null) {
            return null;
        }

        final char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
            // For Java versions prior to Java 6 use the next:
            // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }
}
