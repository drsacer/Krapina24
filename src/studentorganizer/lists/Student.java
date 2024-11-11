package studentorganizer.lists;

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
    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
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

    public void increaseNumberOfPoints(int points) {
        currentPoints+=points;
        System.out.println("You have "  + currentPoints + " points.");
    }

    public void addNewCourse (String name, List<Course> allCourses) {
        boolean courseExist = false;
        for (Course c : allCourses) {
            if (name.equals(c.getName())) {
                for (Course cs : studentCoursesList) {
                    if (cs.getName().equals(name)) {
                        System.out.println("Course by name " + name + " already exist.");
                    }
                }
                studentCoursesList.add(c);
                System.out.println("Successfully aded " + c.getName());
                courseExist = true;
            }
        }
        if (!courseExist) {
            System.out.println("There is no course by name " + name);
        }
    }

    public void acivateCourse(String name) {
        boolean courseActivated = false;
        // koristi da se nakon što se upiše web, a nisu još svi ispiti položeni ne ispisuje poruka There is no course by name " + name + " or course is active or passed"
        boolean web = false;
        for (Course c : studentCoursesList) {
            if (c.getName().equals(name) && !c.isPassed() && !c.isActive()) {
                if (c.getName().equals("Web")) {
                    if (currentPoints == 24) {
                        c.setActive(true);
                        System.out.println("Course " + c.getName() + " is active");
                        System.out.println(c);
                        courseActivated = true;
                        web = true;
                    }
                   /* else {
                        System.out.println("Not all exams were passed");
                    }*/
                }
                else {
                    c.setActive(true);
                    System.out.println("Course " + c.getName() + " is active");
                    System.out.println(c);
                    courseActivated = true;
                }
            }
        }
        if (name.equals("Web") && currentPoints != 24) {
            System.out.println("Not all exams were passed");
        } else if (!courseActivated) {
            System.out.println("There is no course by name " + name + " or course is already active or passed");
        }
    }

    public void markCourseAsPassed(String passedCourse) {
        boolean coursePassed= false;
        for (Course c : studentCoursesList) {
            if (c.getName().equals(passedCourse) && !c.isPassed() && c.isActive()) {
                c.setPassed(true);
                c.setActive(false);
                System.out.println("Course " + c.getName() + " is passed");
                System.out.println(c);
                increaseNumberOfPoints(c.getPoints());
                coursePassed = true;
            }
        }
        if (!coursePassed) {
            System.out.println("There is no course by name " + passedCourse + " or course is not yet active or passed");
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
