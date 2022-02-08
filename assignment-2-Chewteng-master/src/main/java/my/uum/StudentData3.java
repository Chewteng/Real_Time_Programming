package my.uum;

/**
 * This class is to set and get the data of students (matric, name, GitHub name, YouTube link, YouTube channel name).
 *
 * @author H'ng Chew Teng
 */
public class StudentData3 {

   String matric, name, githubName, githubLink, youtubeLink, youtubeName;


    /**
     * This method is the constructor for student's data
     *
     * @param m The matric number of students
     * @param n The name of students
     * @param column3 The GitHub name of students
     * @param column4 The GitHub submission link of students
     * @param column5 The YouTube submission link of students
     * @param column6 The YouTube channel name of students
     */
    StudentData3 (String m, String n, String column3, String column4, String column5, String column6) {
        this.matric = m;
        this.name = n;
        this.githubName = column3;
        this.githubLink = column4;
        this.youtubeLink = column5;
        this.youtubeName = column6;
    }

    /**
     * This method is the constructor for student's data
     *
     * @param m The matric number of students
     * @param n The name of students
     */
    StudentData3 (String m, String n) {
        this.matric = m;
        this.name = n;
    }

    /**
     * This method is for getting the matric number of students
     *
     * @return The matric number of students
     */
    public String getMatric() {
        return this.matric;
    }

    /**
     * This method is for setting the matric number of students
     *
     * @param m The matric number of students
     */
    public void setMatric(String m) {
        this.matric = m;
    }


    /**
     * This method is for getting the name of students
     *
     * @return The name of students
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method is for setting the name of students
     *
     * @param n The name of students
     */
    public void setName(String n) {
        this.name = n;
    }


    /**
     * This method is for getting the GitHub name of students
     *
     * @return The GitHub name of students
     */
    public String getGithubName() {
        return this.githubName;
    }

    /**
     * This method is for setting the GitHub name of students
     *
     * @param column3 The GitHub name of students
     */
    public void setGithubName(String column3) {
        this.githubName = column3;
    }


    /**
     * This method is for getting the GitHub submission link of students
     *
     * @return The GitHub submission link of students
     */
    public String getGithubLink() {
        return this.githubLink;
    }

    /**
     * This method is for setting the GitHub submission link of students
     *
     * @param column4 The GitHub submission link of students
     */
    public void setGithubLink(String column4) {
        this.githubLink = column4;
    }


    /**
     * This method is for getting the YouTube submission link of students
     *
     * @return The YouTube submission link of students
     */
    public String getYoutubeLink() { return this.youtubeLink; }

    /**
     * This method is for setting the YouTube submission link of students
     *
     * @param column5 The YouTube submission link of students
     */
    public void setYoutubeLink(String column5) {
        this.youtubeLink = column5;
    }


    /**
     * This method is for getting the YouTube channel name of students
     *
     * @return The YouTube channel name of students
     */
    public String getYoutubeName() { return this.youtubeName; }

    /**
     * This method is for setting the YouTube channel name of students
     * @param column6 The YouTube channel name of students
     */
    public void setYoutubeName(String column6) {
        this.youtubeName = column6;
    }

}
