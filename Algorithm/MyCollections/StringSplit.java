package MyCollections.FindSubtreeNodes;

import java.util.ArrayList;
import java.util.List;

//,给一个字符串，然后用 5 个*分割成 6 份,分割出来的每一部分的大小
//不超过 600，打印出所有分割情况
public class StringSplit {
    public static List<String> findAllSplits(String s) {
        int n = s.length();
        List<String> results = new ArrayList<>();

        // 生成所有可能的分割位置组合
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        for (int m = l + 1; m < n; m++) {
                            List<String> parts = new ArrayList<>();
                            boolean valid = true;

                            // 分割字符串
                            parts.add(s.substring(0, i));
                            if (parts.get(0).length() > 600) {
                                valid = false;
                            }
                            parts.add(s.substring(i, j));
                            if (parts.get(1).length() > 600) {
                                valid = false;
                            }
                            parts.add(s.substring(j, k));
                            if (parts.get(2).length() > 600) {
                                valid = false;
                            }
                            parts.add(s.substring(k, l));
                            if (parts.get(3).length() > 600) {
                                valid = false;
                            }
                            parts.add(s.substring(l, m));
                            if (parts.get(4).length() > 600) {
                                valid = false;
                            }
                            parts.add(s.substring(m));
                            if (parts.get(5).length() > 600) {
                                valid = false;
                            }

                            if (valid) {
                                results.add(String.join("*", parts));
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // 示例字符串
        String s = "abcdefghijklmnopqrstuvwxyz".repeat(100);
        List<String> allSplits = findAllSplits(s);
        for (String split : allSplits) {
            System.out.println(split);
        }
    }
}    