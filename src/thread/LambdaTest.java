package thread;

public class LambdaTest {

    //��̬�ڲ���
    static class Like2 implements Ilike {
        @Override
        public void lambda(int a, String b) {
            System.out.println("2");
        }
    }

    public static void main(String[] args) {
        Ilike like = new Like();
        like.lambda(2, "");

        new Like2().lambda(2, "");

        //�ֲ��ڲ���
        class Like3 implements Ilike {
            @Override
            public void lambda(int a, String b) {
                System.out.println();
            }
        }
        new Like3().lambda(3, "");

        // ����ʽ�ӿ�����ֻ��һ������
        // �������Ͷ���Ҫô��д��Ҫô����д
        Ilike like2 = (a, b) -> {
            System.out.println("lambda4");
        };
        like2.lambda(2, "");

    }


}

//�ӿ�
interface Ilike {
    void lambda(int a, String b);
}

//ʵ����
class Like implements Ilike {

    @Override
    public void lambda(int a, String b) {
        System.out.println();
    }
}

