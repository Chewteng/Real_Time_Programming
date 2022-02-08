package my.uum;

/**
 * This class is to set and get the data of the students (matric, name, GitHub name, GitHub link).
 *
 * @author H'ng Chew Teng
 */
public class StudentData {

    String matric, name, githubLink, githubName;

    /**
     * This method is the constructor for student's data
     *
     * @param column1 The matric number of students
     * @param column2 The name of students
     * @param column3 The GitHub submission link of students
     * @param column4 The GitHub name of students
     */
    StudentData(String column1, String column2, String column3, String column4) {
        this.matric = column1;
        this.name = column2;
        this.githubLink = column3;
        this.githubName = column4;
    }

    /**
     * This method is the constructor for student's data
     *
     * @param m The matric number of students
     * @param n The name of students
     */
    StudentData(String m, String n) {
        this.matric = m;
        this.name = n;
    }

    /**
     * This method is for getting the matric number of students
     *
     * @return The matric number of students
     */
    public String getMatric() {
        return matric;
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
        return name;
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
     * This method is for getting the GitHub submission link of students
     *
     * @return The GitHub submission link of students
     */
    public String getLink() {
        return githubLink;
    }

    /**
     * This method is for setting the GitHub submission link of students
     *
     * @param column3 The GitHub submission link of students
     */
    public void setLink(String column3) {
        this.githubLink = column3;
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
     * @param column4 The GitHub name of students
     */
    public void setGithubName(String column4) {
        this.githubName = column4;
    }
}
