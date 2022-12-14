package thread;

/**
 * 生产者消费者 ：信号灯法，标志位解决
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
                this.tv.play("快乐大本营播放中");
            } else {
                this.tv.play("抖音：记录美好生活");
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

    //演员表演，观众等待
    //观众观看，演员等待
    String voice; // 表演的节目
    boolean flag = true;

    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        //通知观众观看
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
        System.out.println("观众观看了：" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }

}
