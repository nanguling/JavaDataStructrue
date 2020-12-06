package lambdatest;
//函数式接口
@FunctionalInterface
interface NoParameterNoReturn {
    //注意：只能有一个方法
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}
//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

public class TestDemo {
    public static void main(String[] args) {
        //有返回值无参数
        NoParameterReturn np = () -> {return 10;};
        NoParameterReturn np1 = () -> 10;
        System.out.println(np.test());
        System.out.println(np1.test());

        //有返回值一个参数
        OneParameterReturn op = (a) -> {return a;};
        OneParameterReturn op1 = a -> a;
        System.out.println(op.test(20));
        System.out.println(op1.test(30));

        //有返回值多个参数
        MoreParameterReturn mp = (a,b) -> {return a + b;};
        MoreParameterReturn mp1 = (a,b) -> a + b;
        System.out.println(mp.test(20,20));
        System.out.println(mp1.test(30,30));;
    }
    public static void main1(String[] args) {
        //无参无返回值
        NoParameterNoReturn no = () -> { System.out.println("hello"); };
        no.test();
        NoParameterNoReturn no1 = () -> System.out.println("word");
        no.test();

        //一个参数无返回值
        OneParameterNoReturn op = (int a) -> { System.out.println(a); };
        op.test(20);
        OneParameterNoReturn op1 = a -> System.out.println(a);
        op1.test(30);

        //多个参数无返回值
        MoreParameterNoReturn mp = (a,b) -> { System.out.println(a+b); };
        mp.test(20,30);
    }
}
