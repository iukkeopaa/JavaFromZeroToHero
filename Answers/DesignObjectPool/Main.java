package DesignObjectPool;

import java.util.concurrent.LinkedBlockingQueue;

// ��������Ҫ����Ķ�����
class MyObject {
    private int id;

    public MyObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // ��������������������ڶ���ľ������
}

// �������
class ObjectPool {
    private LinkedBlockingQueue<MyObject> pool;
    private int poolSize;

    // ���캯������ʼ�������
    public ObjectPool(int poolSize) {
        this.poolSize = poolSize;
        this.pool = new LinkedBlockingQueue<>(poolSize);
        // ��ʼ��������еĶ���
        for (int i = 0; i < poolSize; i++) {
            pool.offer(new MyObject(i));
        }
    }

    // �Ӷ�����л�ȡһ������
    public MyObject getObject() throws InterruptedException {
        return pool.take();
    }

    // �����󷵻ص��������
    public void releaseObject(MyObject obj) {
        if (obj != null && pool.size() < poolSize) {
            pool.offer(obj);
        }
    }

    // ��ȡ��ǰ������еĶ�������
    public int getCurrentSize() {
        return pool.size();
    }
}

// ������
public class Main {
    public static void main(String[] args) {
        ObjectPool pool = new ObjectPool(5);
        try {
            // �Ӷ���ػ�ȡ����
            MyObject obj1 = pool.getObject();
            System.out.println("Got object with id: " + obj1.getId());
            System.out.println("Current pool size: " + pool.getCurrentSize());

            // �ͷŶ���ض����
            pool.releaseObject(obj1);
            System.out.println("Released object. Current pool size: " + pool.getCurrentSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}    