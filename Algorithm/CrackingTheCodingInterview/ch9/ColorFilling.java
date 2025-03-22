package CrackingTheCodingInterview.ch9;

import java.util.Arrays;

public class ColorFilling {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor != newColor) {
            dfs(image, sr, sc, originalColor, newColor);
        }
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] result = floodFill(image, sr, sc, newColor);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}    