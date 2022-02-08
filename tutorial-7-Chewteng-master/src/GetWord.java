import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GetWord {

    static String word;

    private static final ArrayList<WordData> data = new ArrayList<>();


    public static void main(String[] args) {

        new GetWord().Main();
    }


    public void Main() {

        try {
            DecimalFormat newFormat = new DecimalFormat("#.###");

            Document doc = Jsoup.connect("https://www.rossberesford.com/crosswordman").get();

            String link1 = String.valueOf(doc.select("div.jXK9ad-SmKAyb p").text());

            link1 = link1.replaceAll("[—.(),^]*","");

            link1 = link1 + " ";

            int wordStart = 0;

            for (int i = 0; i < link1.length(); i++) {

                char c = link1.charAt(i);

                if (c == ' ') {
                    word = link1.substring(wordStart,i);
                    //System.out.println(word + word.length());
                    wordStart = i+1;

                    //Assign attributes to an object and add the object into the ArrayList
                    data.add(new WordData(String.valueOf(word.length()), word));
                    //System.out.println(name);
                    insertData(String.valueOf(word.length()), word);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        // SQLite connection string
        String dburl = "jdbc:sqlite:C:\\Users\\User\\IdeaProjects\\tutorial-7-Chewteng\\word.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dburl);
            //System.out.println("Connection to database success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }


    private void insertData(String WordLength, String Word) {

        String insertSql = "INSERT INTO Word(WordLength, Word) VALUES (?,?)";

        try(Connection connection = this.connect();
            PreparedStatement statement = connection.prepareStatement(insertSql)) {
            statement.setString(1, WordLength);
            statement.setString(2, Word);

            statement.executeUpdate();
            //System.out.println("Insert successfully.");

        } catch (SQLException error) {
            error.printStackTrace();
            System.out.println("ERROR");
        }
    }
}
