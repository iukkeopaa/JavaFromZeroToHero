public class SingletonDemo {

    //1. 饿汉式（静态常量）
    //特点：线程安全，类加载时就创建实例，可能会造成资源浪费。
    public static class Singleton{
        private static final Singleton INSTANCE=new Singleton();
        private Singleton(){

        }
        public static Singleton getInstance(){
            return INSTANCE;
        }
    }


    //懒汉式（线程不安全）
    //特点：延迟加载，线程不安全，多线程环境下可能会创建多个实例。
    public static class Singleton2{
        private static Singleton2 INSTANCE;
        private Singleton2(){

        }
        public static Singleton2 getInstance(){
            if(INSTANCE==null){
                INSTANCE=new Singleton2();
            }
            return INSTANCE;
        }
    }


    //懒汉式（线程安全，同步方法）
    //特点：延迟加载，线程安全，但同步方法的开销较大。
    public static class Singleton3 {
        private static Singleton3 instance = null;

        private Singleton3() {

        }

        public static synchronized Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }

            return instance;
        }
    }

    //饿汉式（静态代码块）
    //线程安全，类加载时就创建实例，可能会造成资源浪费。
    public static class Singleton4 {
        private static Singleton4 instance = null;

        static {
            instance = new Singleton4();
        }

        private Singleton4() {

        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    //静态内部类
    //特点：延迟加载，线程安全，性能较高。
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }


    //枚举
    //特点：线程安全，可防止反序列化重新创建新的对象。
    public enum Singleton6 {
        INSTANCE;

        public void whateverMethod() {

        }
    }



    //懒汉式（线程安全，双重检查锁定）
    //特点：延迟加载，线程安全，性能较高。
    public static class Singleton7 {
        //关键在这里的volatile关键字，防止指令重排。
        private volatile static Singleton7 instance = null;

        private Singleton7() {

        }

        public static Singleton7 getInstance() {
            if (instance == null) {
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }

            return instance;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton6.INSTANCE == Singleton6.INSTANCE);
        System.out.println(Singleton7.getInstance() == Singleton7.getInstance());
    }
}
