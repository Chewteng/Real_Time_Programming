import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


public class App {

    public static void main(String[] args) {

        try {
            DecimalFormat newFormat = new DecimalFormat("#.###");

            Document doc = Jsoup.connect("https://www.rossberesford.com/crosswordman").get();

            String link1 = String.valueOf(doc.select("div.jXK9ad-SmKAyb p").text());

            //System.out.println(link1);

            Scanner scan = new Scanner(System.in);

            System.out.print("\nInput 1st word: ");
            String input1 = scan.nextLine();

            System.out.print("Input 2nd word: ");
            String input2 = scan.nextLine();

            System.out.println("");


            link1 = link1.replaceAll("[.(),^]*","");

            java.util.List<String> strings = java.util.Arrays.asList(link1.split(" |,|\\."));

            java.util.ArrayList<String> keywords1 = new java.util.ArrayList<>();
            keywords1.add(input1);

            int counter1 = 0;

            for(String string1 : strings)
            {
                Boolean found1 = keywords1.contains(string1.toLowerCase());
                if(found1)
                {
                    counter1 ++;
                }
            }


            java.util.ArrayList<String> keywords2 = new java.util.ArrayList<>();
            keywords2.add(input2);

            int counter2 = 0;

            for(String string2 : strings)
            {
                Boolean found2 = keywords2.contains(string2.toLowerCase());
                if(found2)
                {
                    counter2 ++;
                }
            }

            CountDownLatch countDownLatch = new CountDownLatch(2);

            Thread app1 = new Thread(new Application(input1 + " - " + counter1, countDownLatch));
            Thread app2 = new Thread(new Application(input2 + " - " + counter2, countDownLatch));

            // initialize applications
            app1.start();
            app2.start();


            try {
                //wait until countDownLatch reduces to 0.
                countDownLatch.await();
                //As each word has been counted, print the total words
                System.out.println("\nTotal: " + (counter1 + counter2));
            } catch (InterruptedException error) {
                System.out.println(error.getMessage());
            }


            // get the start time
            long start = System.nanoTime();

            Thread.sleep(1000);

            // get the end time
            long end = System.nanoTime();

            // get the execution time
            long elapsedTime = end - start;

            // 1 second = 1_000_000_000 nano seconds
            double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
            double threeDecimal =  Double.valueOf(newFormat.format(elapsedTimeInSecond));

            System.out.println("\n" + "Execution time: " + threeDecimal + " seconds");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // A class to represent threads for which counts total words wait.
    static class Application implements Runnable {
        private String total;
        private CountDownLatch countDownLatch;

        public Application(String total, CountDownLatch countDownLatch) {
            this.total = total;
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            try {
                System.out.println(total);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            //reduce the count by 1
            countDownLatch.countDown();
        }
    }
}