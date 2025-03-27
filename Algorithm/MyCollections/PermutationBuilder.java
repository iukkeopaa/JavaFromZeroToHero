package MyCollections;

import java.util.ArrayList;
import java.util.List;

//给定一个长度为几-1的 01 字符串，要求构建一个从1到n各出现一次的长度为n的排列。字符串的第i位为0表
//示排列第i+ 1位比第讠位小，反之，第讠位为1 表示排列第i+1位比第讠位大。
public class PermutationBuilder {
    public static List<Integer> buildPermutation(String s) {
        int n = s.length() + 1;
        List<Integer> permutation = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            permutation.add(i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                for (int j = 0; j < permutation.size() - 1; j++) {
                    if (permutation.get(j) == i + 1) {
                        int temp = permutation.get(j);
                        permutation.set(j, permutation.get(j + 1));
                        permutation.set(j + 1, temp);
                        break;
                    }
                }
            }
        }

        return permutation;
    }

    public static void main(String[] args) {
        String s = "010";
        List<Integer> result = buildPermutation(s);
        System.out.println(result);
    }
}