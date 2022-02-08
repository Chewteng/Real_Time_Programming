package my.uum;

/**
 * This class is to set and get the students' data (matric, name, github link).
 *
 * @author H'ng Chew Teng
 */
public class StudentData {
    private int num;
    private String matric, name, githubLink;

    //Default Constructor
    public StudentData() {

    }

    /**
     * This method is the constructor for student's data from issue page (GithubAccount).
     *
     * @param column1 This column is for the matric number of students
     * @param column2 This column is for the name of students
     * @param column3 This column is for the github link of students
     */
    public StudentData(String column1, String column2, String column3) {
        this.matric = column1;
        this.name = column2;
        this.githubLink = column3;
    }

    /**
     * This method is the constructor for student's data from wiki page (StudentList).
     *
     * @param column1 This column is for the matric number of students
     * @param column2 This column is for the name of students
     */
    public StudentData(String column1, String column2) {
        this.matric = column1;
        this.name = column2;
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
     * @param column1 The matric number of students
     */
    public void setMatric(String column1) {
        this.matric = column1;
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
     * @param column2 The name of students
     */
    public void setName(String column2) {
        this.name = column2;
    }


    /**
     * This method is for getting the github link of students
     *
     * @return The github link of students
     */
    public String getLink() {
        return githubLink;
    }

    /**
     * This method is for setting the github link of students
     *
     * @param column3 The github link of students
     */
    public void setLink(String column3) {

        this.githubLink = column3;
    }
}
