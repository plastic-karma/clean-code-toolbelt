public class DoTests {

    public void doTest1(int a) {
        do {
            System.out.println("Hello World");
        } while (a-- < 100);
    }

    public void doTest2(int a, int b) {
        do {
            System.out.println("Hello World");
        } while (a-- < 100 || b < 10);
    }

    public void doAndIf(int a, int b) {
        do  {
            if (a == b && Integer.bitCount(b) == a) {
                System.out.println("Hello World");
            }
        } while(a-- < 100 || b < 10);
    }

}
