package Shared_ptr;

// ���ü�����
class ReferenceCounter {
    private int count;

    public ReferenceCounter() {
        this.count = 1;
    }

    // �������ü���
    public synchronized void increment() {
        count++;
    }

    // �������ü���
    public synchronized int decrement() {
        return --count;
    }

    // ��ȡ��ǰ���ü���
    public synchronized int getCount() {
        return count;
    }
}

// �Զ���� SharedPtr ��
class SharedPtr<T> {
    private T object;
    private ReferenceCounter counter;

    public SharedPtr(T object) {
        this.object = object;
        this.counter = new ReferenceCounter();
    }

    // �������캯�����������ü���
    public SharedPtr(SharedPtr<T> other) {
        this.object = other.object;
        this.counter = other.counter;
        this.counter.increment();
    }

    // ��ȡ���ü���
    public int getReferenceCount() {
        return counter.getCount();
    }

    // ��ȡ����
    public T get() {
        return object;
    }

    // �ͷ�����
    public void release() {
        if (counter.decrement() == 0) {
            // �����ü���Ϊ 0 ʱ������������Ӷ���������߼�
            object = null;
            counter = null;
        }
    }
}

// ������
public class Main {
    public static void main(String[] args) {
        SharedPtr<String> ptr1 = new SharedPtr<>("Hello");
        System.out.println("ptr1 ���ü���: " + ptr1.getReferenceCount());

        SharedPtr<String> ptr2 = new SharedPtr<>(ptr1);
        System.out.println("ptr1 ���ü���: " + ptr1.getReferenceCount());
        System.out.println("ptr2 ���ü���: " + ptr2.getReferenceCount());

        ptr1.release();
        System.out.println("ptr1 �ͷź�ptr2 ���ü���: " + ptr2.getReferenceCount());

        ptr2.release();
        System.out.println("ptr2 �ͷź󣬶�����������");
    }
}    