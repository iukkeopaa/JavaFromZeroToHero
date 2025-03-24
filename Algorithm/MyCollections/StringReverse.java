package MyCollections.FindSubtreeNodes;


//然 后 说 做 个 代 码 反 转 代 码 题 ：
//www.baidu.com->com.baidu.www
public class StringReverse {
    public static void main(String[] args) {
        String input = "sxwww.baidu.com";
        String[] parts = input.split("\\.");
        StringBuilder reversed = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            reversed.append(parts[i]);
            if (i > 0) {
                reversed.append(".");
            }
        }
        System.out.println(reversed.toString());
    }
}    