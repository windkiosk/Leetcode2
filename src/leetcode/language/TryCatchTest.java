package leetcode.language;

public class TryCatchTest {

    public static void main(String[] args) {

        try {
            String a = null;
            System.out.println("try");
            //a.length();
            return;
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
        } finally {
            System.out.println("final");
        }
    }
}
