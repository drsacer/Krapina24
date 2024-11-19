package projectcoffeemachine2.studentorganizer;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String oib;
    private int currentPoints;
    private String username;
    private String password;
    String typeOfUser;
    private List<Course> studentCoursesList = new ArrayList<>();

    private StudentManager studentManager;
    public User() {
    }

    public User(String firstName, String lastName, String oib) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.oib = oib;
        this.setCurrentPoints(0);
    }

    public User(String firstName, String lastName, String oib, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.oib = oib;
        this.username = username;
        this.password = password;

        this.setCurrentPoints(0);
    }
    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List getStudentCoursesList() {
        return studentCoursesList;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getOib() {
        return oib;
    }

    public StudentManager getStudentManager() {
        return studentManager;
    }

    public void setStudentManager(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", currentPoints=" + currentPoints +
                '}';
    }
}
