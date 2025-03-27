package DesignTimingWheel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// ��ʱ����ӿ�
interface TimedTask {
    void execute();
}

// ʱ������
class TimingWheel {
    // ÿ���۵�ʱ���������룩
    private final long tickInterval;
    // ʱ���ֵĲ�����
    private final int wheelSize;
    // ʱ���֣�ÿ���۴洢һ�������б�
    private final List<List<TimedTask>> wheel;
    // ��ǰָ��λ��
    private int currentIndex;
    // ��ʱ��
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
        // ������ʱ����ÿ�� tickInterval ����ִ��һ��ת������
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        }, 0, tickInterval);
    }

    // ��Ӷ�ʱ����
    public void addTask(long delay, TimedTask task) {
        // ��������Ӧ�÷���Ĳ�����
        int slotIndex = (currentIndex + (int) (delay / tickInterval)) % wheelSize;
        // ��������ӵ���Ӧ�Ĳ���
        wheel.get(slotIndex).add(task);
    }

    // ʱ����ת������
    private void tick() {
        // ��ȡ��ǰ���е������б�
        List<TimedTask> currentTasks = wheel.get(currentIndex);
        // ִ�е�ǰ���е���������
        for (TimedTask task : currentTasks) {
            task.execute();
        }
        // ��յ�ǰ���е������б�
        currentTasks.clear();
        // ָ����ǰ�ƶ�һλ
        currentIndex = (currentIndex + 1) % wheelSize;
    }

    // ֹͣʱ����
    public void stop() {
        timer.cancel();
    }
}

// ʾ��������
class ExampleTask implements TimedTask {
    @Override
    public void execute() {
        System.out.println("Task executed!");
    }
}

// ���࣬���ڲ���ʱ����
public class Main {
    public static void main(String[] args) {
        // ����ʱ���֣�ÿ���۵�ʱ����Ϊ 1000 ���루�� 1 �룩��ʱ���ִ�СΪ 10 ����
        TimingWheel timingWheel = new TimingWheel(1000, 10);
        // ����ʾ������
        ExampleTask exampleTask = new ExampleTask();
        // ���һ���ӳ� 3 ��ִ�е�����
        timingWheel.addTask(3000, exampleTask);

        try {
            // �ó�������һ��ʱ��
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // ֹͣʱ����
        timingWheel.stop();
    }
}