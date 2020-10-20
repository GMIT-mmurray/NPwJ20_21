public class Main {

    public static void main(String[] args) {
        Q q = new Q();
        new Thread(new Producer(q),"Producer").start();
        new Thread(new Consumer(q),"Consumer").start();
        System.out.println("Press Control-C to stop.");
    }
}
