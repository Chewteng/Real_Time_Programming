import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class MyCallable implements Callable<String> {

    static int count1 = 0;
    static int count2 = 0;
    static int count3 = 0;

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return String.valueOf((count1+count2+count3));
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("\nPlease enter the 1st string: ");
        String input1 = scan.nextLine();

        System.out.print("Please enter the 2nd string: ");
        String input2 = scan.nextLine();

        System.out.print("Please enter the 3rd string: ");
        String input3 = scan.nextLine();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<Future<String>>();

        //Create MyCallable instance
        Callable<String> callable = new MyCallable();
        //submit Callable tasks to be executed by thread pool
        Future<String> future = executor.submit(callable);
        //add Future to the list, we can get return value using Future
        list.add(future);

        //Counts each character except space (1st input string)
        for(int i = 0; i < input1.length(); i++){
            if(input1.charAt(i) != ' ')
                count1++;
        }

        //Counts each character except space (2nd input string)
        for(int i = 0; i < input2.length(); i++){
            if(input2.charAt(i) != ' ')
                count2++;
        }

        //Counts each character except space (3rd input string)
        for(int i = 0; i < input3.length(); i++){
            if(input3.charAt(i) != ' ')
                count3++;
        }

        for(Future<String> fut : list){
            try {
                //Displays the total number of characters present in these three input string
                System.out.println("\nTotal Characters: " + fut.get());
                executor.shutdown();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

