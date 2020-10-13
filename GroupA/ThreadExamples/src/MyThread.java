public class MyThread extends Thread {

    public void run(){
        System.out.println("MyThread running");
    }

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
        Thread myThread1 = new Thread () {
            @Override
            public void run() {
                System.out.println("MyThread1 running");
            }
        };
        myThread1.start();
        Thread myThread2 = new Thread(new MyRunnable());
        myThread2.start();
        Thread myThread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("MyThread inner class");
            }
        });
        myThread3.start();
    }
}
