package DesignTimingWheel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// 定时任务接口
interface TimedTask {
    void execute();
}

// 时间轮类
class TimingWheel {
    // 每个槽的时间间隔（毫秒）
    private final long tickInterval;
    // 时间轮的槽数量
    private final int wheelSize;
    // 时间轮，每个槽存储一个任务列表
    private final List<List<TimedTask>> wheel;
    // 当前指针位置
    private int currentIndex;
    // 定时器
    private final Timer timer;

    public TimingWheel(long tickInterval, int wheelSize) {
        this.tickInterval = tickInterval;
        this.wheelSize = wheelSize;
        this.wheel = new ArrayList<>(wheelSize);
        for (int i = 0; i < wheelSize; i++) {
            wheel.add(new ArrayList<>());
        }
        this.currentIndex = 0;
        this.timer = new Timer();
        // 启动定时器，每隔 tickInterval 毫秒执行一次转动操作
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, 0, tickInterval);
    }

    // 添加定时任务
    public void addTask(long delay, TimedTask task) {
        // 计算任务应该放入的槽索引
        int slotIndex = (currentIndex + (int) (delay / tickInterval)) % wheelSize;
        // 将任务添加到对应的槽中
        wheel.get(slotIndex).add(task);
    }

    // 时间轮转动操作
    private void tick() {
        // 获取当前槽中的任务列表
        List<TimedTask> currentTasks = wheel.get(currentIndex);
        // 执行当前槽中的所有任务
        for (TimedTask task : currentTasks) {
            task.execute();
        }
        // 清空当前槽中的任务列表
        currentTasks.clear();
        // 指针向前移动一位
        currentIndex = (currentIndex + 1) % wheelSize;
    }

    // 停止时间轮
    public void stop() {
        timer.cancel();
    }
}

// 示例任务类
class ExampleTask implements TimedTask {
    @Override
    public void execute() {
        System.out.println("Task executed!");
    }
}

// 主类，用于测试时间轮
public class Main {
    public static void main(String[] args) {
        // 创建时间轮，每个槽的时间间隔为 1000 毫秒（即 1 秒），时间轮大小为 10 个槽
        TimingWheel timingWheel = new TimingWheel(1000, 10);
        // 创建示例任务
        ExampleTask exampleTask = new ExampleTask();
        // 添加一个延迟 3 秒执行的任务
        timingWheel.addTask(3000, exampleTask);

        try {
            // 让程序运行一段时间
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 停止时间轮
        timingWheel.stop();
    }
}