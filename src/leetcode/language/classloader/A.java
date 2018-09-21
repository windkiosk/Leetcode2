package leetcode.language.classloader;

public class A {

    static {
        print(1);
    }

    {
        print(2);
    }

    public A() {
        print(3);
    }

    public static void print(int i) {
        System.out.println("" + i);
    }
}
