public class IfTests {

    public void ifTest1(int b, int a) {
        System.out.println("Hello World");
        if (b < 0 || b > 100 && b == a) {
            System.out.println("Hello World 1");
        }
        System.out.println("Hello World 2");
    }

    public void ifTest2(int b, int a) {
        System.out.println("Hello World");
        if (b < 0 || b > 100 && b == a) {
            System.out.println("Hello World 1");
        }
        if (b < 100 && a > 100 && b == a) {
            System.out.println("Hello World 1");
        }
        System.out.println("Hello World 2");
    }

    public void nestedIfTest1(int b) {
        System.out.println("Hello World");
        if (b > 0) {
            System.out.println("Hello World 1");
            if (b > 100) {
                System.out.println("Hello World 2");
            }
        }
        System.out.println("Hello World 3");
    }

    public void ifElseTest1(int b) {
        System.out.println("Hello World");
        if (b < 0) {
            System.out.println("Hello World 1");
        } else {
            System.out.println("Hello World 2");
        }
        System.out.println("Hello World 2");
    }

}
