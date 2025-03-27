package SlideWindows.Q3;

import java.util.*;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }




        public int lengthOfLongestSubstring4(String S) {
            char[] s = S.toCharArray(); // 转换成 char[] 加快效率（忽略带来的空间消耗）
            int n = s.length;
            int ans = 0;
            int left = 0;
            int[] cnt = new int[128]; // 也可以用 HashMap<Character, Integer>，这里为了效率用的数组
            for (int right = 0; right < n; right++) {
                char c = s[right];
                cnt[c]++;
                while (cnt[c] > 1) { // 窗口内有重复字母
                    cnt[s[left]]--; // 移除窗口左端点字母
                    left++; // 缩小窗口
                }
                ans = Math.max(ans, right - left + 1); // 更新窗口长度最大值
            }
            return ans;
        }


    public int lengthOfLongestSubstring3(String S) {
        char[] s = S.toCharArray(); // 转换成 char[] 加快效率（忽略带来的空间消耗）
        int n = s.length;
        int ans = 0;
        int left = 0;
        boolean[] has = new boolean[128]; // 也可以用 HashSet<Character>，这里为了效率用的数组
        for (int right = 0; right < n; right++) {
            char c = s[right];
            // 如果窗口内已经包含 c，那么再加入一个 c 会导致窗口内有重复元素
            // 所以要在加入 c 之前，先移出窗口内的 c
            while (has[c]) { // 窗口内有 c
                has[s[left]] = false;
                left++; // 缩小窗口
            }
            has[c] = true; // 加入 c
            ans = Math.max(ans, right - left + 1); // 更新窗口长度最大值
        }
        return ans;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String input = scanner.nextLine();
        scanner.close();

        int result = lengthOfLongestSubstring(input);
        System.out.println("不含有重复字符的最长子串的长度是: " + result);
    }
}    