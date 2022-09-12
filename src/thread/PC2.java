package thread;

/**
 * ������������ ���źŵƷ�����־λ���
 */
public class PC2 {
    public static void main(String[] args) {

        TV tv = new TV();
        new Player(tv).start();
        new Watch(tv).start();
    }
}


class Player extends Thread {
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("���ִ�Ӫ������");
            } else {
                this.tv.play("��������¼��������");
            }
        }
    }
}

class Watch extends Thread {
    TV tv;

    public Watch(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

class TV {

    //��Ա���ݣ����ڵȴ�
    //���ڹۿ�����Ա�ȴ�
    String voice; // ���ݵĽ�Ŀ
    boolean flag = true;

    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("��Ա�����ˣ�" + voice);
        //֪ͨ���ڹۿ�
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;

    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("���ڹۿ��ˣ�" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }

}
