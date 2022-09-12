package thread;

import java.util.concurrent.atomic.AtomicStampedReference;

public class CasDemo {
    private static AtomicStampedReference<Integer> atomicStampedRef = new AtomicStampedReference<>(1, 0);

    public static void main(String[] args) {
        Thread main = new Thread(() -> {
            System.out.println("�����߳�" + Thread.currentThread() + ",��ʼֵ a = " + atomicStampedRef.getReference());
            int stamp = atomicStampedRef.getStamp(); //��ȡ��ǰ��ʶ��
            try {
                Thread.sleep(1000); //�ȴ�1�� ���Ա��ø����߳�ִ��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean isCASSuccess = atomicStampedRef.compareAndSet(1, 2, stamp, stamp + 1);  //��ʱexpectedReferenceδ�����ı䣬����stamp�Ѿ����޸���,����CASʧ��
            System.out.println("�����߳�" + Thread.currentThread() + ",CAS�������: " + isCASSuccess);
        }, "�������߳�");

        Thread other = new Thread(() -> {
            Thread.yield(); // ȷ��thread-main ����ִ��
            atomicStampedRef.compareAndSet(1, 2, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
            System.out.println("�����߳�" + Thread.currentThread() + ",��increment�� ,ֵ = " + atomicStampedRef.getReference());
            atomicStampedRef.compareAndSet(2, 1, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
            System.out.println("�����߳�" + Thread.currentThread() + ",��decrement�� ,ֵ = " + atomicStampedRef.getReference());
        }, "�����߳�");

        main.start();
        other.start();
    }
}
