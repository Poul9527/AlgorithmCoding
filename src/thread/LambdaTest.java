package thread;

public class LambdaTest {

    //静态内部类
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

        //局部内部类
        class Like3 implements Ilike {
            @Override
            public void lambda(int a, String b) {
                System.out.println();
            }
        }
        new Like3().lambda(3, "");

        // 函数式接口里面只有一个方法
        // 参数类型定义要么都写，要么都不写
        Ilike like2 = (a, b) -> {
            System.out.println("lambda4");
        };
        like2.lambda(2, "");

    }


}

//接口
interface Ilike {
    void lambda(int a, String b);
}

//实现类
class Like implements Ilike {

    @Override
    public void lambda(int a, String b) {
        System.out.println();
    }
}

