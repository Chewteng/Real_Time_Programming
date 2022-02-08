import java.util.Scanner;

public class MyPrimeNumber {

    static int x;
    static int total = 0, total2 = 0;

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

        // creation of child thread
        Thread t1 = new Thread(MyPrimeNumber::PrimeNumber);
        Thread t2 = new Thread(MyPrimeNumber::PrimeNumber2);

        // thread t1 starts
        t1.start();

        // starts second thread after when
        // first thread t1 has died.
        try
        {

            t1.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has " +
                    "been caught" + ex);
        }

        // t2 starts
        t2.start();

        // starts t3 after when thread t2 has died.
        try
        {

            t2.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has been" +
                    " caught" + ex);
        }

    }


    private static void PrimeNumber() {
        for (int i = x; i <= x+5; i++) {

            try {
                if (isPrimeNumber(i)) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(100);
                    total = total + i;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void PrimeNumber2() {
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
        System.out.println("Total: " + (total + total2));
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
