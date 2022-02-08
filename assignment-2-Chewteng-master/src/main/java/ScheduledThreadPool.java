import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * In this example, I schedule a task to be executed after a delay of 5 seconds.
 *
 * @author H'ng Chew Teng
 */
public class ScheduledThreadPool
{
    //Link for the GitHub Wiki page
    static String studentLink = "https://github.com/STIW3054-A202/Main-Data/wiki/List_of_Student";

    public static void main(String[] args) throws IOException {

        //Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.
        //corePoolSize - The number of threads to keep in the pool, even if they are idle, unless allowCoreThreadTimeOut is set.
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        //Get all data from the specified link
        Document doc = Jsoup.connect(studentLink).get();
        Elements table = doc.select("table");

        for(int i = 0; i <= 29; i++) {

            //Get elements by CSS Selectors
            Elements name = table.select("tbody > tr:nth-child(" + i + ") > td:nth-child(3)");

            //This line is a functional interface to print all names scraped from the link to the console.
            Runnable task = () -> {
                System.out.println(name.text());
            };

            //This line is how long the outcome will be executed based on how much time you set (5 seconds).
            executor.schedule(task, 5, TimeUnit.SECONDS);

        }
        //This line is called on an executor service, it stops accepting new tasks, waits for previously submitted tasks to execute, and then terminates the executor.
       executor.shutdown();
    }
}
