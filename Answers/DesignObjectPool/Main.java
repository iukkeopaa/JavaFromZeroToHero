package DesignObjectPool;

import java.util.concurrent.LinkedBlockingQueue;

// 假设我们要管理的对象类
class MyObject {
    private int id;

    public MyObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // 可以添加其他方法，用于对象的具体操作
}

// 对象池类
class ObjectPool {
    private LinkedBlockingQueue<MyObject> pool;
    private int poolSize;

    // 构造函数，初始化对象池
    public ObjectPool(int poolSize) {
        this.poolSize = poolSize;
        this.pool = new LinkedBlockingQueue<>(poolSize);
        // 初始化对象池中的对象
        for (int i = 0; i < poolSize; i++) {
            pool.offer(new MyObject(i));
        }
    }

    // 从对象池中获取一个对象
    public MyObject getObject() throws InterruptedException {
        return pool.take();
    }

    // 将对象返回到对象池中
    public void releaseObject(MyObject obj) {
        if (obj != null && pool.size() < poolSize) {
            pool.offer(obj);
        }
    }

    // 获取当前对象池中的对象数量
    public int getCurrentSize() {
        return pool.size();
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        ObjectPool pool = new ObjectPool(5);
        try {
            // 从对象池获取对象
            MyObject obj1 = pool.getObject();
            System.out.println("Got object with id: " + obj1.getId());
            System.out.println("Current pool size: " + pool.getCurrentSize());

            // 释放对象回对象池
            pool.releaseObject(obj1);
            System.out.println("Released object. Current pool size: " + pool.getCurrentSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}    