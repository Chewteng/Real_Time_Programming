package my.uum;

import java.sql.*;

/**
 * This class is to display the students' data that is divided into two parts, which are submitted and not submitted the Github account.
 *
 * @author H'ng Chew Teng
 */
public class App {

    static String submitIndex = "\n| No. | Matric | Name                               | Github Link                           | \n" +
            "|-----|--------|------------------------------------|---------------------------------------|";
    static String NotSubmitIndex = "\n| No. | Matric | Name                               | \n" +
            "|-----|--------|------------------------------------|";
    static String rowId, matric, name, githubLink;

    /**
     * This method is to connect to the Sqlite database first before displaying the result.
     *
     * @param args Main method
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public static void main(String[] args) throws SQLException {

        //Connect to the database
        String dbUrl = "jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\assignment-1-Chewteng\\GithubLink.db";
        Connection connection = DriverManager.getConnection(dbUrl);

        //Display the students' data who have submitted the GitHub account
        String selectSubmitSql = "select rowid, * from StudentDetails where Status = 'Yes'";

        Statement statement = connection.createStatement();
        ResultSet submitResult = statement.executeQuery(selectSubmitSql);

        System.out.println("\n List all students who have submitted the GitHub account: ");
        System.out.println(submitIndex);

        try {
            while (submitResult.next()){

                rowId = submitResult.getString("rowid");
                matric = submitResult.getString("Matric");
                name = submitResult.getString("Name");
                githubLink = submitResult.getString("GithubLink");

                //Output is displayed
                System.out.println(String.format("| %-3s | %-6s | %-34s | %-37s |",Integer.parseInt(rowId)-1, matric, name, githubLink));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Display the students' data who have not submitted the GitHub account
        String selectNotSubmitSql = "select rowid, * from StudentDetails where Status = 'No'";

        //Statement statement = connection.createStatement();
        ResultSet notSubmitResult = statement.executeQuery(selectNotSubmitSql);

        System.out.println("\n\n List all students who have NOT submitted the GitHub account: ");
        System.out.println(NotSubmitIndex);

        try {
            while (notSubmitResult.next()){

                rowId = notSubmitResult.getString("rowid");
                matric = notSubmitResult.getString("Matric");
                name = notSubmitResult.getString("Name");

                //Output is displayed
                System.out.println(String.format("| %-3s | %-6s | %-34s |",Integer.parseInt(rowId), matric, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

