public class MyThread extends Thread {

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello from Thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();
        Thread myThread1 = new Thread () {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello from Thread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        myThread1.start();
        Thread myThread2 = new Thread(new MyRunnable());
        myThread2.start();
        Thread myThread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello from Thread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        myThread3.start();
    }
}
