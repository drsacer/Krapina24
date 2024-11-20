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
    int typeOfUser; // 1 - admin, 2 - student
    private List<Course> studentCoursesList = new ArrayList<>();

    private StudentManager studentManager;
    public User() {
    }

    public User(String firstName, String lastName, String oib, int typeOfUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.oib = oib;
        this.typeOfUser = typeOfUser;
        this.setCurrentPoints(0);
    }

    public User(String firstName, String lastName, String oib, String username, String password, int typeOfUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.oib = oib;
        this.username = username;
        this.password = password;
        if (typeOfUser == 2) {
            this.setCurrentPoints(0);
        }
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

    public int getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(int typeOfUser) {
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
