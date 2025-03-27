package MyCollections;

import java.util.ArrayList;
import java.util.List;

//你是一位电商平台的开发人员，需要处理一个商品列表，每个商品由一个二维数组表示，其中每个子数组包含两个整
//数，第一个整数是商品的 ID，第二个整数是商品的库存数量。你需要根据商品的库存数量对商品列表进行排序:
//1.库存大于零的商品应排在列表的前面，并且这些商品的顺序应保持不变,
//2.库存为零的商品应排在列表的后面，并且这些零库存商品的顺序也应保持不变。
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