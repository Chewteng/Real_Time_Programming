package my.uum;

import java.sql.*;

/**
 * This class is to display the students' data that is stored in the database with a certain format.
 */
public class dbResult {

    static String messageIndex = "\n| Matric | Name                               | Github Link                           | Status | \n" +
            "|--------|------------------------------------|---------------------------------------|--------|";
    static String matric, name, githubLink, status;

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

        // List all students' data from Sqlite database using the specific format
        String createSql = "select * from StudentDetails order by Matric ASC";

        Statement statement = connection.createStatement();
        ResultSet dbresult = statement.executeQuery(createSql);

        System.out.println(messageIndex);

        try {
            while (dbresult.next()) {
                //int rowId = result.getInt("rowid");
                matric = dbresult.getString("Matric");
                name = dbresult.getString("Name");
                githubLink = dbresult.getString("GithubLink");
                status = dbresult.getString("Status");

                //Output is displayed
                System.out.println(String.format("| %-6s | %-34s | %-37s | %-6s |", matric, name, githubLink, status));
            }
        } catch (Exception e) {
            //Error message
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}
