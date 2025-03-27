package Shared_ptr;

// 引用计数类
class ReferenceCounter {
    private int count;

    public ReferenceCounter() {
        this.count = 1;
    }

    // 增加引用计数
    public synchronized void increment() {
        count++;
    }

    // 减少引用计数
    public synchronized int decrement() {
        return --count;
    }

    // 获取当前引用计数
    public synchronized int getCount() {
        return count;
    }
}

// 自定义的 SharedPtr 类
class SharedPtr<T> {
    private T object;
    private ReferenceCounter counter;

    public SharedPtr(T object) {
        this.object = object;
        this.counter = new ReferenceCounter();
    }

    // 拷贝构造函数，增加引用计数
    public SharedPtr(SharedPtr<T> other) {
        this.object = other.object;
        this.counter = other.counter;
        this.counter.increment();
    }

    // 获取引用计数
    public int getReferenceCount() {
        return counter.getCount();
    }

    // 获取对象
    public T get() {
        return object;
    }

    // 释放引用
    public void release() {
        if (counter.decrement() == 0) {
            // 当引用计数为 0 时，可在这里添加额外的清理逻辑
            object = null;
            counter = null;
        }
    }
}

// 测试类
public class Main {
    public static void main(String[] args) {
        SharedPtr<String> ptr1 = new SharedPtr<>("Hello");
        System.out.println("ptr1 引用计数: " + ptr1.getReferenceCount());

        SharedPtr<String> ptr2 = new SharedPtr<>(ptr1);
        System.out.println("ptr1 引用计数: " + ptr1.getReferenceCount());
        System.out.println("ptr2 引用计数: " + ptr2.getReferenceCount());

        ptr1.release();
        System.out.println("ptr1 释放后，ptr2 引用计数: " + ptr2.getReferenceCount());

        ptr2.release();
        System.out.println("ptr2 释放后，对象已无引用");
    }
}    