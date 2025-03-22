package Question.Q11;

import java.util.concurrent.TimeUnit;

// 车库类
class Garage {
    private static final int TOTAL_SPACES = 3; // 车库总车位数量
    private int availableSpaces = TOTAL_SPACES; // 当前可用车位数量

    // 停车方法
    public synchronized boolean park() {
        if (availableSpaces > 0) {
            availableSpaces--;
            System.out.println(Thread.currentThread().getName() + " 成功停车，当前剩余车位: " + availableSpaces);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " 停车失败，车库已满。");
            return false;
        }
    }

    // 离开方法
    public synchronized boolean leave() {
        if (availableSpaces < TOTAL_SPACES) {
            availableSpaces++;
            System.out.println(Thread.currentThread().getName() + " 离开车库，当前剩余车位: " + availableSpaces);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " 离开失败，车库已空。");
            return false;
        }
    }
}

// 用户类
class User implements Runnable {
    private Garage garage;

    public User(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void run() {
        try {
            // 模拟用户到达车库
            TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
            if (garage.park()) {
                // 模拟用户停车一段时间
                TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
                garage.leave();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 主类
public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        int numUsers = 10; // 模拟的用户数量

        // 创建并启动多个用户线程
        for (int i = 1; i <= numUsers; i++) {
            Thread userThread = new Thread(new User(garage), "用户 " + i);
            userThread.start();
        }
    }
}