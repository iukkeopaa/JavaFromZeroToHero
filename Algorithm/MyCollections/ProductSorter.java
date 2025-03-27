package MyCollections;

import java.util.ArrayList;
import java.util.List;

//����һλ����ƽ̨�Ŀ�����Ա����Ҫ����һ����Ʒ�б�ÿ����Ʒ��һ����ά�����ʾ������ÿ�����������������
//������һ����������Ʒ�� ID���ڶ�����������Ʒ�Ŀ������������Ҫ������Ʒ�Ŀ����������Ʒ�б��������:
//1.�����������ƷӦ�����б��ǰ�棬������Щ��Ʒ��˳��Ӧ���ֲ���,
//2.���Ϊ�����ƷӦ�����б�ĺ��棬������Щ������Ʒ��˳��ҲӦ���ֲ��䡣
public class ProductSorter {
    public static List<List<Integer>> sortProducts(List<List<Integer>> products) {
        List<List<Integer>> positiveStock = new ArrayList<>();
        List<List<Integer>> zeroStock = new ArrayList<>();

        for (List<Integer> product : products) {
            if (product.get(1) > 0) {
                positiveStock.add(product);
            } else if (product.get(1) == 0) {
                zeroStock.add(product);
            }
        }

        List<List<Integer>> result = new ArrayList<>(positiveStock);
        result.addAll(zeroStock);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> products = new ArrayList<>();
        products.add(List.of(1, 5));
        products.add(List.of(2, 0));
        products.add(List.of(3, 3));
        products.add(List.of(4, 0));

        List<List<Integer>> sortedProducts = sortProducts(products);
        System.out.println(sortedProducts);
    }
}