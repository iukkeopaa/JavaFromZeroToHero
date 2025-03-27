package DesignThreadPool;

import java.util.LinkedList;
import java.util.List;

// �Զ����̳߳���
class SimpleThreadPool {
    // ������У����ڴ洢��ִ�е�����
    private final LinkedList<Runnable> taskQueue;
    // �����߳��б��洢�̳߳��еĹ����߳�
    private final List<WorkerThread> workerThreads;
    // �̳߳��Ƿ�رյı�־
    private boolean isShutdown = false;

    // ���캯������ʼ���̳߳�
    public SimpleThreadPool(int poolSize) {
        taskQueue = new LinkedList<>();
        workerThreads = new LinkedList<>();
        // ����ָ�������Ĺ����̲߳�����
        for (int i = 0; i < poolSize; i++) {
            WorkerThread worker = new WorkerThread();
            workerThreads.add(worker);
            worker.start();
        }
    }

    // ���̳߳��ύ����ķ���
    public synchronized void execute(Runnable task) {
        if (isShutdown) {
            throw new IllegalStateException("�̳߳��ѹرգ��޷��ύ����");
        }
        // ��������ӵ��������
        taskQueue.add(task);
        // ����һ���ȴ��Ĺ����߳�
        notify();
    }

    // �ر��̳߳صķ���
    public synchronized void shutdown() {
        isShutdown = true;
        // �������еȴ��Ĺ����߳�
        notifyAll();
        for (WorkerThread worker : workerThreads) {
            try {
                // �ȴ������߳�ִ�����
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // �����߳��࣬�̳��� Thread ��
    private class WorkerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task;
                synchronized (SimpleThreadPool.this) {
                    // ���������Ϊ�����̳߳�δ�ر�ʱ�������߳̽���ȴ�״̬
                    while (taskQueue.isEmpty() && !isShutdown) {
                        try {
                            SimpleThreadPool.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // ����̳߳��ѹر����������Ϊ�գ������߳��˳�ѭ��
                    if (isShutdown && taskQueue.isEmpty()) {
                        break;
                    }
                    // �����������ȡ��һ������
                    task = taskQueue.poll();
                }
                if (task != null) {
                    try {
                        // ִ������
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

// ���࣬���ڲ����̳߳�
public class Main {
    public static void main(String[] args) {
        // ����һ������ 3 �������̵߳��̳߳�
        SimpleThreadPool threadPool = new SimpleThreadPool(3);

        // �ύ 5 �������̳߳�
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            threadPool.execute(() -> {
                System.out.println("����ִ������: " + taskId);
                try {
                    // ģ������ִ�к�ʱ
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("���� " + taskId + " ִ����ϡ�");
            });
        }

        // �ر��̳߳�
        threadPool.shutdown();
    }
}    