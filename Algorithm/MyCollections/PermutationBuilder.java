package MyCollections;

import java.util.ArrayList;
import java.util.List;

//����һ������Ϊ��-1�� 01 �ַ�����Ҫ�󹹽�һ����1��n������һ�εĳ���Ϊn�����С��ַ����ĵ�iλΪ0��
//ʾ���е�i+ 1λ�ȵ�ڥλС����֮����ڥλΪ1 ��ʾ���е�i+1λ�ȵ�ڥλ��
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