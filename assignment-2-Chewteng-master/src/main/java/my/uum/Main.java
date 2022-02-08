package my.uum;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class is to store the database data into the specific ArrayList by specifying the corresponding database table.
 *
 * @author H'ng Chew Teng
 */
public class Main {

    String matric, name, githubName, githubLink, youtubeLink, youtubeName;

    //Create ArrayList to store data
    public static ArrayList<StudentData3> studentData = new ArrayList<>();
    public static ArrayList<StudentData3> githubData1 = new ArrayList<>();
    public static ArrayList<StudentData3> githubData2 = new ArrayList<>();
    public static ArrayList<StudentData> youtubeData1 = new ArrayList<>();
    public static ArrayList<StudentData> youtubeData2 = new ArrayList<>();
    public static ArrayList<StudentData3> wrongMatricData = new ArrayList<>();

    /**
     * This method is is for running the main() method
     *
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    public void main(String[] args) throws SQLException {
        new Main().main();
    }

    /**
     * This method is to connect to the Sqlite database first before storing the data into the ArrayList
     *
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    public void main() throws SQLException {

        //Connect to the database
        String dbUrl = "jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\assignment-2-Chewteng\\StudentListData.db";
        Connection connection = DriverManager.getConnection(dbUrl);

        //Select the database that stores all student data (Matric, Name, GitHub Name, YouTube Name, YouTube Link)
        String studentDataSql = "select * from StudentData";

        Statement statement = connection.createStatement();
        ResultSet studentDataResult = statement.executeQuery(studentDataSql);

        //System.out.println(index);

        try {
            while (studentDataResult.next()) {

               // rowId = submitResult.getString("rowid");
                matric = studentDataResult.getString("Matric");
                name = studentDataResult.getString("Name");
                githubName = studentDataResult.getString("GithubName");
                githubLink = studentDataResult.getString("GithubLink");
                youtubeName = studentDataResult.getString("YoutubeName");
                youtubeLink = studentDataResult.getString("YoutubeLink");

                //Output is displayed
               //System.out.println(String.format("| %-6s | %-34s | %-20s | %-43s | %-20s |", matric, name, githubName, youtubeLink, youtubeName));

                //Assign attributes to an object and add the object into the ArrayList
                studentData.add(new StudentData3(matric, name, githubName, githubLink, youtubeLink, youtubeName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Select the database which stores the data of the students who have submitted the GitHub account but the matric number is wrong
        String selectWrongSql = "select * from StudentData where Matric = '261826' ";

        ResultSet wrongResult = statement.executeQuery(selectWrongSql);

        //System.out.println("\n\n List all students who have submitted the GitHub account: ");
        //System.out.println(githubIndex);

        try {
            while (wrongResult.next()){

                //rowId = githubResult1.getString("rowid");
                matric = wrongResult.getString("Matric");
                name = wrongResult.getString("Name");

                //Output is displayed
                //System.out.println(String.format("| %-6s | %-34s |", matric, name));

                //Assign attributes to an object and add the object into the ArrayList
                wrongMatricData.add(new StudentData3(matric, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Select the database which stores the data of the students who have submitted the GitHub account with the correct matric number
        String selectGithubSql1 = "select * from StudentData where GithubLink != '-' AND Matric != '261826'";

        ResultSet githubResult1 = statement.executeQuery(selectGithubSql1);

        //System.out.println("\n\n List all students who have submitted the GitHub account: ");
        //System.out.println(githubIndex);

        try {
            while (githubResult1.next()){

                //rowId = githubResult1.getString("rowid");
                matric = githubResult1.getString("Matric");
                name = githubResult1.getString("Name");

                //Output is displayed
                //System.out.println(String.format("| %-6s | %-34s |", matric, name));

                //Assign attributes to an object and add the object into the ArrayList
                githubData1.add(new StudentData3(matric, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Select the database which stores the data of the students who do not submit the GitHub account
        String selectGithubSql2 = "select * from StudentData where GithubLink = '-' ";

        ResultSet githubResult2 = statement.executeQuery(selectGithubSql2);

        //System.out.println("\n\n List all students who have NOT submitted the GitHub account: ");
        //System.out.println(githubIndex);

        try {
            while (githubResult2.next()){

                //rowId = githubResult2.getString("rowid");
                matric = githubResult2.getString("Matric");
                name = githubResult2.getString("Name");
                // githubLink = githubResult.getString("GithubLink")

                //Output is displayed
                //System.out.println(String.format("| %-6s | %-34s |", matric, name));

                //Assign attributes to an object and add the object into the ArrayList
                githubData2.add(new StudentData3(matric, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Select the database which stores the data of the students who have submitted the YouTube video
        String selectYoutubeSql1 = "select * from StudentData where YoutubeLink != '-' ";

        ResultSet youtubeResult1 = statement.executeQuery(selectYoutubeSql1);

        //System.out.println("\n\n List all students who have submitted the YouTube video: ");
        //System.out.println(githubIndex);

        try {
            while (youtubeResult1.next()){

                //rowId = githubResult1.getString("rowid");
                matric = youtubeResult1.getString("Matric");
                name = youtubeResult1.getString("Name");

                //Output is displayed
                //System.out.println(String.format("| %-6s | %-34s |", matric, name));

                //Assign attributes to an object and add the object into the ArrayList
                youtubeData1.add(new StudentData(matric, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Select the database which stores the data of the students who do not submit the YouTube video
        String selectYoutubeSql2 = "select * from StudentData where YoutubeLink = '-' ";

        ResultSet youtubeResult2 = statement.executeQuery(selectYoutubeSql2);

        //System.out.println("\n\n List all students who have NOT submitted the YouTube video: ");
        //System.out.println(githubIndex);

        try {
            while (youtubeResult2.next()){

                //rowId = githubResult2.getString("rowid");
                matric = youtubeResult2.getString("Matric");
                name = youtubeResult2.getString("Name");
                // githubLink = githubResult.getString("GithubLink")

                //Output is displayed
                //System.out.println(String.format("| %-6s | %-34s |", matric, name));

                //Assign attributes to an object and add the object into the ArrayList
                youtubeData2.add(new StudentData(matric, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

