import java.util.Scanner;

public class MyCyclicBarrier {

    private static double primeCount;

    public static void main(String args[]) {

        int i, j, oddSum = 0, evenSum = 0, primeSum = 0, oddCount = 0, evenCount = 0;
        int evenAvg, oddAvg;
        double primeAvg = 0;
        Scanner scan = new Scanner(System.in);//create a scanner object for input

        System.out.print("\nEnter the X: ");
        int num1 = scan.nextInt();
        System.out.print("Enter the Y: ");
        int num2 = scan.nextInt();

        System.out.print("Odd numbers: ");
        for (j = num1; j < num2; j++) {
            if (j % 2 == 1 && j > num1) {

                System.out.print(j + " ");
                oddSum = oddSum + j;
                oddCount++;
            }
        }

        System.out.print("\nEven numbers: ");
        for (i = num1; i < num2; i++) {
            if (i % 2 == 0 && i > num1) {
                System.out.print(i + " ");
                evenSum = evenSum + i;
                evenCount++;
            }
        }

        int k,count;

        System.out.print("\nPrime numbers: ");
        for(int m = num1; m < num2; m++)
        {
            count = 0;
            for(k = 1;k <= m; k++)
            {
                if(m % k == 0 && m > num1)
                {
                    count++;
                }
            }
            if(count==2) {
                System.out.print(m + " ");
                primeSum += m;
                primeCount++;
            }
        }

            evenAvg = evenSum / evenCount;
            oddAvg = oddSum / oddCount;
            primeAvg = (primeSum / primeCount);

            System.out.println("\n\nAverage value of odd numbers: " + oddAvg);
            System.out.println("Average value of even numbers: " + evenAvg);
            System.out.println("Average value of prime numbers: " + primeAvg);
    }
}