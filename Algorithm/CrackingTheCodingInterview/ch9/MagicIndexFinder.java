package CrackingTheCodingInterview.ch9;

public class MagicIndexFinder {
    // 处理数组元素各不相同的情况
    public static int findMagicIndexDistinct(int[] array) {
        return binarySearchDistinct(array, 0, array.length - 1);
    }

    private static int binarySearchDistinct(int[] array, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return binarySearchDistinct(array, left, mid - 1);
        } else {
            return binarySearchDistinct(array, mid + 1, right);
        }
    }

    // 处理数组元素有重复值的情况
    public static int findMagicIndexDuplicates(int[] array) {
        return binarySearchDuplicates(array, 0, array.length - 1);
    }

    private static int binarySearchDuplicates(int[] array, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == mid) {
            return mid;
        }
        // 先搜索左半部分
        int leftResult = binarySearchDuplicates(array, left, Math.min(mid - 1, array[mid]));
        if (leftResult != -1) {
            return leftResult;
        }
        // 再搜索右半部分
        return binarySearchDuplicates(array, Math.max(mid + 1, array[mid]), right);
    }

    public static void main(String[] args) {
        int[] distinctArray = {-1, 0, 2, 4, 5};
        int[] duplicateArray = {-1, 0, 2, 2, 5};

        int magicIndexDistinct = findMagicIndexDistinct(distinctArray);
        int magicIndexDuplicates = findMagicIndexDuplicates(duplicateArray);

        System.out.println("Distinct array magic index: " + magicIndexDistinct);
        System.out.println("Duplicate array magic index: " + magicIndexDuplicates);
    }
}    