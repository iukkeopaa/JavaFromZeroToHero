import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// 定义一个任务类，实现 Runnable 接口
class MyTask implements Runnable {
    private String taskName;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskName + " is running on thread: " + Thread.currentThread().getName());
    }
}

public class JavaMultiThreadedScheduledCall {
    public static void main(String[] args) {
        // 创建一个包含 3 个线程的 ScheduledExecutorService
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        // 创建多个任务
        MyTask task1 = new MyTask("Task1");
        MyTask task2 = new MyTask("Task2");
        MyTask task3 = new MyTask("Task3");

        // 安排任务在延迟 1 秒后开始执行，之后每隔 2 秒执行一次
        executorService.scheduleAtFixedRate(task1, 1, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(task2, 1, 2, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(task3, 1, 2, TimeUnit.SECONDS);

        // 主线程休眠一段时间，让任务有机会执行
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭 executorService
        executorService.shutdown();
    }
}