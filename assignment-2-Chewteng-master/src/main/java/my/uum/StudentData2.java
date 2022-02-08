package my.uum;

/**
 * This class is to set and get the data of students (GitHub name, YouTube link).
 *
 * @author H'ng Chew Teng
 */
public class StudentData2 {

    private String githubName, youtubeLink;


    /**
     * This method is the constructor for student's data
     *
     * @param column1 This column is for the GitHub name of students
     * @param column2 This column is for the YouTube submission link of students
     */
    public StudentData2(String column1, String column2) {
        this.githubName = column1;
        this.youtubeLink = column2;
    }


    /**
     * This method is for getting the GitHub name of students
     *
     * @return The GitHub name of students
     */
    public String getGithubName() {
        return githubName;
    }

    /**
     * This method is for setting the GitHub name of students
     *
     * @param column1 The GitHub name of students
     */
    public void setGithubName(String column1) {
        this.githubName = column1;
    }


    /**
     * This method is for getting the YouTube submission link of students
     *
     * @return The YouTube submission link of students
     */
    public String getYoutubeLink() {
        return youtubeLink;
    }

    /**
     * This method is for setting the YouTube submission link of students
     *
     * @param column2 The YouTube submission link of students
     */
    public void setYoutubeLink(String column2) {
        this.youtubeLink = column2;
    }
}
