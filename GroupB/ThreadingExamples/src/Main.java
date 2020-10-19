public class Main extends Thread {

      public static void main(String[] args) {
        Thread t0 = new MyThread();
        t0.start();
        Thread t1 = new MyThread();
        t1.start();
        Thread t2 = new Main();
        t2.start();
        Thread t3 = new Thread("My Thread 3 ") {
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
        t3.start();
        Thread t4 = new Thread(new MyRunnable());
        t4.start();
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10;i++) {
                    System.out.println("Hello from Thread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t5.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <10;i++) {
                    System.out.println("Hello from Thread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10;i++) {
                    System.out.println("Hello from Thread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10;i++) {
                    System.out.println("Hello from Thread " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(r).start();
    }

    @Override
    public void run() {
        for (int i = 0; i <10;i++) {
            System.out.println("Hello from Thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
