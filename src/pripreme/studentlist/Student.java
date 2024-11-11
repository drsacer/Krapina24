package pripreme.studentlist;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String oib;
    private int yearOfStudy;

    private int currentPoints;

    private String username;
    private String password;

    private List<Course> studentCoursesList = new ArrayList<>();
    private int minPointsForNextYear = 14;

    public Student() {
    }

    public Student(String firstName, String lastName, int age, int yearOfStudy, int currentPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.yearOfStudy = yearOfStudy;
        this.currentPoints = currentPoints;
    }

    public Student(String firstName, String lastName, String oib, int age, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.oib = oib;
        this.age = age;
        this.username = username;
        this.password = password;

        this.setYearOfStudy(1);
        this.setCurrentPoints(0);
    }
    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getMinPointsForNextYear() {
        return minPointsForNextYear;
    }

    public void setMinPointsForNextYear(int minPointsForNextYear) {
        this.minPointsForNextYear = minPointsForNextYear;
    }

    public List getStudentCoursesList() {
        return studentCoursesList;
    }

    public void setStudentCoursesList(List studentCoursesList) {
        this.studentCoursesList = studentCoursesList;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public void increaseYearOfStudy(){

        if(getYearOfStudy() < 2) {
            yearOfStudy++;
        }
        else {
            System.out.println("You are on the last year");
        }
    }
    public void increaseNumberOfPoints(int points) {
        currentPoints+=points;
        if (currentPoints >= minPointsForNextYear) {
            increaseYearOfStudy();
            System.out.println("You are on the " + yearOfStudy + ". year. \nYou have "  + currentPoints + " points." +
                    "Minimum for next year is " + minPointsForNextYear);
        }
        else {
            System.out.println("Still not enough points for next year. \nYou have "  + currentPoints + " points. " +
                    "Minimum for next year is " + minPointsForNextYear);
        }
    }

    public void addNewCourse (String name) {
        for (Course c : studentCoursesList) {
            if (name.equals(c.getName())) {
                studentCoursesList.add(c);
            }
        }
    }

    public void registerCourse(String name) {
        for (Course c : studentCoursesList) {
            if (c.equals(c.getName())) {
                c.isRegisterExam();
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", oib='" + oib + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", currentPoints=" + currentPoints +
                '}';
    }
}
