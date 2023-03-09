public class WhileTests {

    public void whileTest1(int a) {
        while (a-- < 100) {
            System.out.println("Hello World");
        }
    }

    public void whileTest2(int a, int b) {
        while (a-- < 100 || b < 10) {
            System.out.println("Hello World");
        }
    }

    public void whileAndIf(int a, int b) {
        while (a-- < 100 || b < 10) {
            if (a == b && Integer.bitCount(b) == a) {
                System.out.println("Hello World");
            }
        }
    }

}
