import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyPrimeNumber {

    static int x;
    static int total1 = 0, total2 = 0, total3 = 0;

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner= new Scanner(System.in);

        do{
            System.out.print("Please input x: ");
            while (!scanner.hasNextInt()){
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
                System.out.print("Please input x: ");
            }
            x = scanner.nextInt();
        } while (x < 0);

        System.out.println();

        PrimeNumber1 t1 = new PrimeNumber1();
        PrimeNumber2 t2 = new PrimeNumber2();
        PrimeNumber3 t3 = new PrimeNumber3();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

        executorService1.shutdown();
        executorService2.shutdown();
        executorService3.shutdown();

        // creation of child thread
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);

        // thread starts
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

    }


    static class PrimeNumber1 implements Runnable {

        @Override
        public void run() {
            for (int i = x; i <= x+5; i++) {

                try {
                    if (isPrimeNumber(i)) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                        Thread.sleep(100);
                        total1 = total1 + i;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class PrimeNumber2 implements Runnable {

        @Override
        public void run() {
            for (int j = x+5; j <= x+10; j++) {
                try {
                    if (isPrimeNumber(j)) {
                        System.out.println(Thread.currentThread().getName() + ": " + j);
                        Thread.sleep(100);
                        total2 = total2 + j;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class PrimeNumber3 implements Runnable {

        @Override
        public void run() {
            for (int k = x+10; k <= x+20; k++) {
                try {
                    if (isPrimeNumber(k)) {
                        System.out.println(Thread.currentThread().getName() + ": " + k);
                        Thread.sleep(100);
                        total3 = total3 + k;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Total: " + (total1+total2+total3));
        }
    }


    public static boolean isPrimeNumber (int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
