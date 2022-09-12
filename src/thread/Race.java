package thread;

public class Race implements Runnable {

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName() == "����" && i % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "-->����" + i + "��");
            boolean flag = gameover(i);
            if (flag) {
                break;
            }
        }
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "------��������");
        }
    }

    private boolean gameover(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "����").start();
        new Thread(race, "�ڹ�").start();
    }
}
