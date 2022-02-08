import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App implements Callable<String>{

    @Override
    public String call() {

        return "Execution time: ";

    }

    public static void main(String[] args) {

        try {
            DecimalFormat newFormat = new DecimalFormat("#.###");

            Document doc = Jsoup.connect("https://www.rossberesford.com/crosswordman").get();

            String link1 = String.valueOf(doc.select("div.jXK9ad-SmKAyb p").text());
            String link2 = String.valueOf(doc.select("span.QTKDff").text());
            String link3 = "Home";
            String link4 = String.valueOf(doc.select("div.jXK9ad-SmKAyb h1").text());
            String link5 = "Contact";

            //System.out.println(link1);

            Scanner scan = new Scanner(System.in);

            System.out.print("\nInput word: "); // Captures char
            String input = scan.nextLine();

            int i = 0, j= 0, k=0, x=0, y=0;
            Pattern p = Pattern.compile(input.toLowerCase());
            Matcher m1 = p.matcher(link1.toLowerCase());
            Matcher m2 = p.matcher(link2.toLowerCase());
            Matcher m3 = p.matcher(link3.toLowerCase());
            Matcher m4 = p.matcher(link4.toLowerCase());
            Matcher m5 = p.matcher(link5.toLowerCase());

            while(m1.find()){
                i++;
            }

            while(m2.find()){
                j++;
            }

            while(m3.find()){
                k++;
            }

            while(m4.find()){
                x++;
            }

            while(m5.find()){
                y++;
            }

            System.out.println("\n" + input + " - " + (i + j + k + x + y));

            // get the start time
            long start = System.nanoTime();

            Thread.sleep(50);

            // get the end time
            long end = System.nanoTime();

            // execution time
            long elapsedTime = end - start;

            // 1 second = 1_000_000_000 nano seconds
            double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
            double threeDecimal =  Double.valueOf(newFormat.format(elapsedTimeInSecond));

            ExecutorService ex = Executors.newSingleThreadExecutor();
            App helloCallable = new App();
            Future<String> result = ex.submit(helloCallable);

            System.out.println("\n" + result.get() + threeDecimal + " seconds");

            ex.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}