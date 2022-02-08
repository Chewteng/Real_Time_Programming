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
 * This class is to get all students' data who have submitted the github account from the url link and store into the database "GithubAccount".
 *
 * @author H'ng Chew Teng
 */
public class GetGithubLink {

    //Create ArrayList to store data
    private final ArrayList<StudentData> data = new ArrayList<StudentData>();

//    public static void main(String[] args) throws IOException {
//
//        new GetGithubLink().Main();
//    }

    /**
     * This method is to get the data from url link and insert that data into the database.
     *
     * @throws IOException A checked exception thrown when working with input or output operations.
     */
    public void Main() throws IOException {

        String linkURL = "https://github.com/STIW3054-A202/Main-Data/issues/1";
        Document doc = Jsoup.connect(linkURL).get();
        Elements table = doc.select("tbody.d-block");

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


                //Assign attributes to an object and add the object into the ArrayList
                data.add(new StudentData(matric, name, link));
                //System.out.println(name);
               insertData(matric, name, link);
            }
        }
    }

//    //Returns the ArrayList.
//    public ArrayList<StudentData> arrayList(){
//
//        return data;
//    }

    /**
     * This connect() method is to test the status of the database connection.
     *
     * @return The connection
     */
    private Connection connect() {
        // SQLite connection string
        String dburl = "jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\assignment-1-Chewteng\\GithubLink.db";
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
     * This method is to insert the scraped data into the specific database.
     *
     * @param Matric The matric number of students
     * @param Name The name of students
     * @param GithubLink The github link of students
     */
    private void insertData(String Matric, String Name, String GithubLink) {

        String insertSql = "INSERT INTO GithubAccount(Matric, Name, GithubLink) VALUES (?,?,?)";

        try(Connection connection = this.connect();
            PreparedStatement statement = connection.prepareStatement(insertSql)) {
            statement.setString(1, Matric);
            statement.setString(2, Name);
            statement.setString(3, GithubLink);

            statement.executeUpdate();
            //System.out.println("Insert Successfully");

        } catch (SQLException error) {
            error.printStackTrace();
            System.out.println("ERROR");
        }
    }
}


