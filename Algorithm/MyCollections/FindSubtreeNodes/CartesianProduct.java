package MyCollections.FindSubtreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//数组的笛卡尔积

public class CartesianProduct {
    public static <T> List<List<T>> cartesianProduct(List<List<T>> arrays) {
        List<List<T>> result = new ArrayList<>();
        if (arrays.isEmpty()) {
            return result;
        }
        result.add(new ArrayList<>());

        for (List<T> array : arrays) {
            List<List<T>> temp = new ArrayList<>();
            for (List<T> current : result) {
                for (T element : array) {
                    List<T> newList = new ArrayList<>(current);
                    newList.add(element);
                    temp.add(newList);
                }
            }
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        List<List<Integer>> result = cartesianProduct(arrays);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}    