public class LazySingleton {

    private static volatile LazySingleton instance = null; //保证 instance 在所有线程中同步

    private LazySingleton() {
    } //private 避免类在外部被实例化

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
// 饿汉式
class HungrySingleton {
    public static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public HungrySingleton getInstance() {
        return instance;
    }

}

