package MyCollections;

//多多最近在玩一个推箱子游戏，在一个二维坐标中，箱子的起坐标是(ェ,y)，多多有四个方向键可以操作:
//·W:将箱子向上移动，即:(±,y)->(,y+1)
//A:将箱子向左移动，即:(,y)- >(ェ - 1,y)
//S:将箱子向下移动，即:(,y)->(,y-1
//"D:将箱子向右移动，即:(,y)->(ェ +1,y)
//在经过多多一系列按键操作后，如果恰好最终箱子的位置恰好在(0,0)就算赢了，请你帮忙计算多多是否能赢。
public class BoxPushingGame {
    public static boolean canWin(int startX, int startY, String operations) {
        if (operations == null) {
            return startX == 0 && startY == 0;
        }
        int currentX = startX;
        int currentY = startY;

        for (int i = 0; i < operations.length(); i++) {
            char operation = operations.charAt(i);
            switch (operation) {
                case 'W':
                    currentY++;
                    break;
                case 'A':
                    currentX--;
                    break;
                case 'S':
                    currentY--;
                    break;
                case 'D':
                    currentX++;
                    break;
                default:
                    // 忽略无效操作
                    break;
            }
        }

        return currentX == 0 && currentY == 0;
    }

    public static void main(String[] args) {
        int startX = 1;
        int startY = 1;
        String operations = "AS";
        boolean result = canWin(startX, startY, operations);
        if (result) {
            System.out.println("多多赢了！");
        } else {
            System.out.println("多多输了。");
        }
    }
}    