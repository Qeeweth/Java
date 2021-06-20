
// Мыть посуду = 45 мин
// Стирать белье = 60 мин + 10 мин = 70 мин
// Мыть полы = 20 мин

public class MultiThread {
    public static void main(String[] args) {
        Thread myRunnableThread1 = new Thread(new MyRunnableThread("Мыть посуду"));
        Thread myRunnableThread2 = new Thread(new MyRunnableThread("Стирать белье"));
        Thread myRunnableThread3 = new Thread(new MyRunnableThread("Мыть полы"));
        myRunnableThread1.start();
        myRunnableThread2.start();
        myRunnableThread3.start();

    }
}

class MyRunnableThread implements Runnable {
    private String task;

    public MyRunnableThread(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.task + " выполнено: " + i + "%");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     class MyThread extends Thread {
        private String task;


        public MyThread(String task) {
            super(task);
            this.task = task;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(this.task + " выполнено: " + i + "%");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



