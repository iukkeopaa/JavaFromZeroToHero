package Rectangle.Q240;

import java.util.Scanner;

public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1; // 从右上角开始
        while (i < matrix.length && j >= 0) { // 还有剩余元素
            if (matrix[i][j] == target) {
                return true; // 找到 target
            }
            if (matrix[i][j] < target) {
                i++; // 这一行剩余元素全部小于 target，排除
            } else {
                j--; // 这一列剩余元素全部大于 target，排除
            }
        }
        return false;
    }

    public boolean searchMatrix4(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            if(matrix[i][matrix[i].length - 1] < target){
                continue;
            }
            int col = binarySearch(matrix[i], target);
            if (col != -1) {
                return true;
            }
        }
        return false;
    }

    //二分查找
    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    //一维二分
    public boolean searchMatrix7(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midRow = mid / cols;
            int midCol = mid % cols;
            int midValue = matrix[midRow][midCol];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }



    //二维二分
        public boolean searchMatrix11(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;

            // 先对行进行二分查找，确定可能包含目标值的行范围
            int top = 0;
            int bottom = rows - 1;
            while (top <= bottom) {
                int midRow = top + (bottom - top) / 2;
                if (matrix[midRow][0] <= target && target <= matrix[midRow][cols - 1]) {
                    // 对当前行进行二分查找
                    int left = 0;
                    int right = cols - 1;
                    while (left <= right) {
                        int midCol = left + (right - left) / 2;
                        if (matrix[midRow][midCol] == target) {
                            return true;
                        } else if (matrix[midRow][midCol] < target) {
                            left = midCol + 1;
                        } else {
                            right = midCol - 1;
                        }
                    }
                    // 当前行没找到，继续缩小行范围
                    top = midRow + 1;
                } else if (matrix[midRow][0] > target) {
                    bottom = midRow - 1;
                } else {
                    top = midRow + 1;
                }
            }
            return false;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入矩阵的行数和列数（用空格分隔）：");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("请逐行输入矩阵的元素，每行元素用空格分隔：");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("请输入要搜索的目标值：");
        int target = scanner.nextInt();

        MatrixSearch solution = new MatrixSearch();
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("是否找到目标值: " + result);

        scanner.close();
    }
}    