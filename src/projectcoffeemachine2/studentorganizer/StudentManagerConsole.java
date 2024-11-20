package projectcoffeemachine2.studentorganizer;

import java.util.List;
import java.util.Scanner;

public class StudentManagerConsole {

    static StudentManager studentManager = new StudentManager();
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String userName = "";
        String password = "";

        User admin = new User("Adam","Adamić","123","admin", "admin",1 );

        studentManager.getAdminsList().add(admin);

        int choice = 0;
        while (true) {
            System.out.println("***********************");
            System.out.println("1 - Admin login");
            System.out.println("2 - Exit");
            System.out.println("***********************");
            choice = s.nextInt();

            if (choice == 1) {
                System.out.print("User name: ");
                userName = s.next();
                System.out.print("Password: ");
                password = s.next();

                if (checkUsernameAndPassword(userName, password)) {

                    while (true) {
                        System.out.println("***********************");
                        System.out.println("1 - Add new student");
                        System.out.println("2 - Add new course");
                        System.out.println("3 - Remove student");
                        System.out.println("4 - Remove course");
                        System.out.println("5 - Print all courses ");
                        System.out.println("6 - Print all students");
                        System.out.println("7 - Log");
                        System.out.println("8 - Exit");
                        System.out.println("***********************");
                        choice = s.nextInt();

                        if (choice == 1) {
                            System.out.print("Student first name: ");
                            String firstName = s.next();
                            System.out.print("Student last name: ");
                            String lastName = s.next();
                            System.out.print("Student oib: ");
                            String oib = s.next();
                            System.out.print("User name: ");
                            String username = s.next();
                            System.out.print("Password: ");
                            String pass = s.next();

                            studentManager.addNewStudent(firstName, lastName, oib, username, pass, 2);

                        }  else if (choice == 2) {
                            System.out.print("Course name: ");
                            String name = s.next();
                            System.out.print("Points: ");
                            int points = s.nextInt();
                            System.out.print("Lectures days: ");
                            int days = s.nextInt();

                           studentManager.addNewCourse(name,points,days);

                        } else if (choice == 3 ) {
                            List <User> users = studentManager.getAllStudentsList();

                            if (!users.isEmpty()) {
                                boolean studentFinded = false;
                                for (User user : users) {
                                    System.out.println(user);
                                }
                                System.out.print("Student oib: ");
                                String oib = s.next();

                                studentManager.removeStudent(oib);

                            } else System.out.println("List is empty");



                        } else if (choice == 4) {
                            List <Course> courses = studentManager.getAllCoursesList();

                            if (!courses.isEmpty()) {
                                for (Course course : courses ) {
                                    System.out.println(course);
                                }
                                System.out.print("Course name: ");
                                String name = s.next();

                                studentManager.removeCourse(name);

                            } else System.out.println("List is empty");
                        }
                        else if (choice == 5) {
                            if (!studentManager.getAllCoursesList().isEmpty()) {
                                for (Course courseList : studentManager.getAllCoursesList()) {
                                    System.out.println(courseList);
                                }
                            } else System.out.println("Course list is empty");

                        } else if (choice == 6) {
                            if (!studentManager.getAllStudentsList().isEmpty()) {
                                for (User userList : studentManager.getAllStudentsList()) {
                                    System.out.println(userList);
                                }
                            } else System.out.println("Student list is empty");

                        } else if (choice == 7) {
                            for (Event t: studentManager.getEventsList()) {
                                System.out.println(t.getTimestamp() + "\nEvent:" + t.getAction() + "\n");
                            }
                        } else if (choice == 8) {
                            break;
                        }
                    }
                }
            } else if (choice == 2) return;
        }
    }


    public static boolean checkUsernameAndPassword(String userName, String password) {
        for (User u: studentManager.getAdminsList()) {
            if (userName.equals(u.getUsername()) && password.equals(u.getPassword())) {
                System.out.println("Hello " + u.getFirstName() + " " + u.getLastName());
                return true;
            }
       }
        System.out.println("Wrong username or password");
        return false;
    }

    public static void printStudentMenu() {
        System.out.println("***************************");
        System.out.println("1 - Registration of a new course");
        System.out.println("2 - Print all courses");
        System.out.println("3 - Activate the course ");
        System.out.println("4 - Change password");
        System.out.println("5 - Exit");
        System.out.println("***************************");
        System.out.print("Enter choice:");
    }
}
