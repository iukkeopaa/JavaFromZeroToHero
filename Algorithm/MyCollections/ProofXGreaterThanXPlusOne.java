package MyCollections.FindSubtreeNodes;

//证明 x > x + 1
//在数学逻辑里，对于任意实数 x，\(x > x + 1\) 是不成立的，因为给 x 加 1 后得到的数必然大于 x 本身。不过，要是在编程里从数据类型的特性出发，比如在整数运算时产生溢出，就可能出现看似 \(x > x + 1\) 的情况。
public class ProofXGreaterThanXPlusOne {
public static void main(String[] args) {
    int x = Integer.MAX_VALUE;
    System.out.println("x 的值为: " + x);
    int xPlusOne = x + 1;
    System.out.println("x + 1 的值为: " + xPlusOne);
    if (x > xPlusOne) {
        System.out.println("在整数溢出的情况下，x > x + 1 成立");
    } else {
        System.out.println("x > x + 1 不成立");
    }
}
}