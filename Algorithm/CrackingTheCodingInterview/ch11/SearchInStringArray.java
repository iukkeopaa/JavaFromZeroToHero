package CrackingTheCodingInterview.ch11;

public class SearchInStringArray {
    public static int search(String[] strings, String target) {
        if (strings == null || target == null) {
            return -1;
        }
        return search(strings, target, 0, strings.length - 1);
    }

    private static int search(String[] strings, String target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        // 处理空字符串
        if (strings[mid].isEmpty()) {
            int leftIndex = mid - 1;
            int rightIndex = mid + 1;
            while (true) {
                if (leftIndex < left && rightIndex > right) {
                    return -1;
                } else if (rightIndex <= right &&!strings[rightIndex].isEmpty()) {
                    mid = rightIndex;
                    break;
                } else if (leftIndex >= left &&!strings[leftIndex].isEmpty()) {
                    mid = leftIndex;
                    break;
                }
                leftIndex--;
                rightIndex++;
            }
        }

        if (target.equals(strings[mid])) {
            return mid;
        } else if (target.compareTo(strings[mid]) < 0) {
            return search(strings, target, left, mid - 1);
        } else {
            return search(strings, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        String[] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String target = "ball";
        int result = search(strings, target);
        if (result != -1) {
            System.out.println("找到目标字符串，位置是: " + result);
        } else {
            System.out.println("未找到目标字符串。");
        }
    }
}    