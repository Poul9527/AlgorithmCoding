package common;

public class LazySingleton {

    private static volatile LazySingleton instance = null; //��֤ instance �������߳���ͬ��

    private LazySingleton() {
    } //private ���������ⲿ��ʵ����

    public static synchronized LazySingleton getInstance() {
        //getInstance ����ǰ��ͬ��
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
// ����ʽ
class HungrySingleton {
    public static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public HungrySingleton getInstance() {
        return instance;
    }

}

