package projectcoffeemachine2.studentorganizer;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<User> allStudentsList = new ArrayList<>();
    private List <Course> allCoursesList = new ArrayList<>();
    private List<Event> eventsList = new ArrayList<>();
    private List<User> adminsList = new ArrayList<>();

    public List<User> getAllStudentsList() {
        return allStudentsList;
    }
    public List<Course> getAllCoursesList() {
        return allCoursesList;
    }
    public List<Event> getEventsList() {
        return eventsList;
    }

    public List<User> getAdminsList() {
        return adminsList;
    }

    public void addNewStudent(String firstName, String lastName, String oib, String userName, String password, int type ) {
        User newUser = new User(firstName, lastName, oib, userName, password, type);
        allStudentsList.add(newUser);

        /* 1.način dodavanja transakcije u listu
        newTransaction = new Transaction("Added student " + firstName);
        transactions.add(newTransaction); */

        //2. način
        addNewEvent("Added student " + firstName);
    }
    public void addNewCourse(String name, int points, int numberOfLectureDays) {
        Course newCourse = new Course(name, points, numberOfLectureDays);
        allCoursesList.add(newCourse);

        addNewEvent("Added course " + name);

    }
    public void addNewEvent(String action) {
        Event event = new Event(action);
        eventsList.add(event);
    }

    public void removeCourse(String name) {
        boolean courseFinded = false;
        for (Course course : allCoursesList ) {
            if (name.equals(course.getName())){
                allCoursesList.remove(course);
                courseFinded = true;
                System.out.println("Course " + name + " is successfully deleted");
                break;
            }
        }
        if (!courseFinded) System.out.println("Course " + name + " doesnt exist");
    }

    public void removeStudent(String oib) {
        boolean studentFinded = false;
        for (User student : allStudentsList ) {
            if (oib.equals(student.getOib())){
                allCoursesList.remove(student);
                studentFinded = true;
                System.out.println("Student by oib: " + oib + " is successfully deleted");
                break;
            }
        }
        if (!studentFinded) System.out.println("Student oib: " + oib + " doesnt exist");
    }
}
