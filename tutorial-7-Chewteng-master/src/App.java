import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class App implements Runnable {

    static List<String> arrayCharacter = new ArrayList<>();
    static int wordCount = 0;
    static int characterCount = 0;

    CyclicBarrier barrier1, barrier2;

    public App(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            this.barrier1.await();

            Thread.sleep(1000);
            this.barrier2.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            //Connect to the database
            String dbUrl = "jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\tutorial-7-Chewteng\\word.db";
            Connection connection = DriverManager.getConnection(dbUrl);

            Scanner scan = new Scanner(System.in);

            System.out.print("\nInput Length: ");
            String input = scan.next();

            System.out.println(" ");

            String selectSubmitSql = "SELECT * FROM Word WHERE WordLength LIKE ?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectSubmitSql);
            preparedStatement.setString(1, input);
            ResultSet submitResult = preparedStatement.executeQuery();

            Runnable r1 = new Runnable() {
                public void run() {
                    try {
                        while (submitResult.next()) {

                            //String wordLength = submitResult.getString("WordLength");
                            String word = submitResult.getString("Word");

                            //Output is displayed
                            System.out.println(word);
                            wordCount++;

                            arrayCharacter.add(word);

                        }
                        System.out.println("Total words: " + wordCount + "\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable r2 = new Runnable() {
                public void run() {
                    try {
                        for (int i = 0; i < arrayCharacter.size();i++)
                        {
                            for(int j = 0; j < arrayCharacter.get(i).length(); j++) {

                                if(arrayCharacter.get(i).charAt(j) != ' ') {

                                    System.out.print(arrayCharacter.get(i).charAt(j) + ", ");

                                    characterCount++;

                                }
                            }
                        }
                        System.out.println("\nTotal characters: " + characterCount);

                        DecimalFormat newFormat = new DecimalFormat("#.###");

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

                        System.out.println("\n" + "Execution time: " + threeDecimal + " seconds");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            CyclicBarrier barrier1 = new CyclicBarrier(2, r1);
            CyclicBarrier barrier2 = new CyclicBarrier(2, r2);

            App myCyclicBarrier1 = new App(barrier1, barrier2);
            App myCyclicBarrier2 = new App(barrier1, barrier2);

            new Thread(myCyclicBarrier1).start();
            new Thread(myCyclicBarrier2).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
