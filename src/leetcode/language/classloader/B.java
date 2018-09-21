package leetcode.language.classloader;

public class B extends A {

    static {
        print(4);
    }

    {
        print(5);
    }

    public B() {
        print(6);
    }
}
