package MyCollections;

//小红喜欢吃多彩糖葫芦，多彩糖葫芦上的每一个糖葫芦都有一种颜色。
//但小红有非常严重的强迫症，她绝对不会连续吃两个相同颜色的糖葫芦。
//一串糖葫芦只能从上往下吃，一旦小红发现下一颗糖葫芦和她刚吃过的糖葫芦颜色相同时，小红就会把整串多彩糖葫芦丢掉。
//
//小红想知道她吃一串多彩糖葫芦时可以吃到几颗糖葫芦。
public class CandyCount {
    public static int countEatenCandies(String colors) {
        if (colors == null || colors.length() == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) != colors.charAt(i - 1)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String colors = "RGBGR";
        int eaten = countEatenCandies(colors);
        System.out.println("小红能吃到的糖葫芦数量是: " + eaten);
    }
}    