package my.uum;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This class is to get all student data who have submitted the YouTube video from the below url link and store into the database named "YoutubeLink".
 *
 * @author H'ng Chew Teng
 */
public class GetYoutubeLink {

    //Link for the Youtube video submission page
    private final String youtubeLink = "https://github.com/STIW3054-A202/class-activity-A202/issues/2";
    private Document document;

    //Create ArrayList to store data
    private final ArrayList<StudentData2> data2 = new ArrayList<StudentData2>();


    /**
     * This method is for running the Main() method
     */
    public void main(String[] args) {
        new GetYoutubeLink().Main();
    }

    /**
     * This method is to get the responding data from the url link and pass that data to insert into the database
     */
    public void Main() {

        try {

            document = Jsoup.connect(youtubeLink).get();

            Elements body = document.select("div.TimelineItem.js-comment-container");

            for(Element e: body){

                String name = e.select("strong.css-truncate a").attr("href");

                //Remove certain name from the page
                String removedName1 = name.toString().replace("zhamri","").trim();
                String removedName2 = removedName1.toString().replace("GokulNath20","").trim();

                //Remove the symbol "/" from the name
                String updatedName = removedName2.toString().replace("/","").trim();

                String link = e.select("p a").attr("href").trim();

                //Remove certain link from the page
                String removedlink = link.toString().replace("https://youtu.be/AQB5Zx69Q_4","").trim();

                //System.out.println(updatedName + "  " + removedlink);

                //Assign attributes to an object and add the object into the ArrayList
                data2.add(new StudentData2(updatedName, removedlink));

                insertData(updatedName, removedlink);

            }

        } catch (Exception e) {
            e.printStackTrace();
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
     * @param githubName The github name of students who have submitted their YouTube video
     * @param youtubeLink The youtube link of students who have submitted their YouTube video
     */
    private void insertData(String githubName, String youtubeLink){

        String insertSql = "INSERT INTO YoutubeLink(GithubName, YoutubeLink) VALUES (?,?)";

        try(Connection connection = this.connect();
            PreparedStatement statement = connection.prepareStatement(insertSql)) {
            statement.setString(1, githubName);
            statement.setString(2, youtubeLink);

            statement.executeUpdate();
            // System.out.println("SUCCESS");

        } catch (SQLException error) {
            error.printStackTrace();
            System.out.println("ERROR");
        }
    }
}