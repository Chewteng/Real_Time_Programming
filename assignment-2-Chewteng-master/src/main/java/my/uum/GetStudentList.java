package my.uum;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is to get all student data in this Real-Time Programming class from the below url link and store into the database named "StudentList".
 *
 * @author H'ng Chew Teng
 */
public class GetStudentList {

    //Link for the GitHub Wiki page
    String studentLink = "https://github.com/STIW3054-A202/Main-Data/wiki/List_of_Student";
    Document doc;

    //Create ArrayList to store data
    private final ArrayList<StudentData> data = new ArrayList<StudentData>();

    /**
     * This method is for running the Main() method
     *
     * @throws IOException A checked exception thrown when working with input or output operations
     */
    public void main(String[] args) throws IOException {

        new GetStudentList().Main();
    }

    /**
     * This method is to get the responding data from the url link and then pass that data to insert into the database
     *
     * @throws IOException A checked exception thrown when working with input or output operations.
     */
    public void Main() throws IOException {

        doc = Jsoup.connect(studentLink).get();
        Elements table = doc.select("table");

        for(int i = 0; i <= 29; i++){

            //Get elements by CSS Selectors
            Elements matric = table.select("tbody > tr:nth-child(" + i + ") > td:nth-child(2)");
            Elements name = table.select("tbody > tr:nth-child(" + i + ") > td:nth-child(3)");

            //Assign attributes to an object and add the object into the ArrayList
            data.add(new StudentData(matric.text(), name.text()));

            insertData(matric.text(), name.text());
            // System.out.println(matric.text() + " " + name.text());
        }
    }

    /**
     * This method is to test the status of the database connection
     *
     * @return The database connection
     */
    private Connection connect() {

        // SQLite connection string
        String dburl = "jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\assignment-2-Chewteng\\StudentListData.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dburl);
            //System.out.println("Connection to database success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    /**
     * This method is to insert the scraped data into the specific database if the connection is success
     *
     * @param Matric The matric number of students
     * @param Name The name of students
     */
    private void insertData(String Matric, String Name){

        String insertSql = "INSERT INTO StudentList(Matric, Name) VALUES (?,?)";

        try(Connection connection = this.connect();
            PreparedStatement statement = connection.prepareStatement(insertSql)) {
            statement.setString(1, Matric);
            statement.setString(2, Name);

            statement.executeUpdate();
            // System.out.println("SUCCESS");

        } catch (SQLException error) {
            error.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
