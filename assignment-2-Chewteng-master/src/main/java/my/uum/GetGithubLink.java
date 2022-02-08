package my.uum;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is to get all student data who have submitted the GitHub account from the below url link and store into the database named "GithubLink".
 *
 * @author H'ng Chew Teng
 */
public class GetGithubLink {

    //Link for the GitHub account submission page
    String githubLink = "https://github.com/STIW3054-A202/Main-Data/issues/1";
    Document doc;

    //Create ArrayList to store data
    private final ArrayList<StudentData> data = new ArrayList<StudentData>();

    /**
     * This method is for running the Main() method
     *
     * @throws IOException A checked exception thrown when working with input or output operations
     */
    public void main(String[] args) throws IOException {

        new GetGithubLink().Main();
    }

    /**
     * This method is to get the responding data from the url link and pass that data to insert into the database
     *
     * @throws IOException A checked exception thrown when working with input or output operations
     */
    public void Main() throws IOException {

        doc = Jsoup.connect(githubLink).get();
        Elements table = doc.select("div.TimelineItem.js-comment-container");

        for (Element tableNum:table){

            //Get String that is needed using regex
            String matricTrial = tableNum.getElementsMatchingOwnText("\\d{5,6}").text();

            String matric;
            String link;

            //Split and assign values to attributes
            Pattern matricPattern = Pattern.compile("(\\d{5,6})");
            Pattern linkPattern = Pattern.compile("(https://github.com/[a-zA-Z0-9_-]+)");
            int linkIndex = matricTrial.lastIndexOf("nk");
            int nameIndex = matricTrial.lastIndexOf("ame");
            String name = null;

            try {

                name = matricTrial.substring(nameIndex+3,linkIndex-2).replace(':',' ').trim().toLowerCase();

            }catch (Exception e) {
                System.out.print("");
            }

            // Stores each characters of the name to a char array
            char[] charArray = name.toCharArray();
            boolean foundSpace = true;

            for(int i = 0; i < charArray.length; i++) {

                // If the array element is a letter
                if(Character.isLetter(charArray[i])) {

                    // Check space is present before the letter
                    if(foundSpace) {

                        // Change the letter into uppercase
                        charArray[i] = Character.toUpperCase(charArray[i]);
                        foundSpace = false;
                    }
                }else {
                    // If the new character is not character
                    foundSpace = true;
                }
            }

            // Convert the char array to the string
            name = String.valueOf(charArray);

            Matcher matcher1 = matricPattern.matcher(matricTrial);
            Matcher matcher2 = linkPattern.matcher(matricTrial);


            if ((matcher1.find()) && (matcher2.find())){
                matric = matcher1.group(1).trim();
                link = matcher2.group(1).trim();

                String githubName = tableNum.select("strong.css-truncate a").attr("href");
                String updatedName = githubName.toString().replace("/","").trim();

               // System.out.println(matric + "  " + name + "  " + link + "  " + updatedName);

                //Assign attributes to an object and add the object into the ArrayList
                data.add(new StudentData(matric, name, link, updatedName));

                insertData(matric, name, link, updatedName);
            }
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
     * @param Matric The matric number of students who have submitted their GitHub account
     * @param Name The name of students who have submitted their GitHub account
     * @param GithubLink The github link of students who have submitted their GitHub account
     * @param GithubName The github name of students who have submitted their GitHub account
     */
    private void insertData(String Matric, String Name, String GithubLink, String GithubName) {

        String insertSql = "INSERT INTO GithubLink(Matric, Name, GithubLink, GithubName) VALUES (?,?,?,?)";

        try(Connection connection = this.connect();
            PreparedStatement statement = connection.prepareStatement(insertSql)) {

            statement.setString(1, Matric);
            statement.setString(2, Name);
            statement.setString(3, GithubLink);
            statement.setString(4, GithubName);

            statement.executeUpdate();
            //System.out.println("Insert Successfully");

        } catch (SQLException error) {
            error.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
