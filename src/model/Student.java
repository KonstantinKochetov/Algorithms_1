package model;

/**
 * POJO class that holds information about the student
 */
public class Student {

    private String firstName;
    private String lastName;
    private int number;
    private int majorId;

    public Student() {
        firstName = "";
        lastName = "";
    }

    public Student(String firstName, String lastName, Integer number, Integer majorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.majorId = majorId;
    }

    /**
     * Gets the string representation of the class
     * @return      String representation of the class
     */
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", number=" + number +
                ", majorId=" + majorId +
                '}';
    }

    /**
     * Gets first name of the student
     * @return  First name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name of the student
     * @return  Last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets number of the student
     * @return  Number of the student
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Gets major id of the student
     * @return  Major id of the student
     */
    public Integer getMajorId() {
        return majorId;
    }

    /**
     * Sets the first name of the student
     * @param firstName     First name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the student
     * @param lastName     Last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the number of the student
     * @param number     Number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Sets the majorId of the student
     * @param majorId     Major id to set
     */
    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }
}
