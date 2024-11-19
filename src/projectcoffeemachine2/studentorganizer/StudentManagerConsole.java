package projectcoffeemachine2.studentorganizer;

import java.util.List;
import java.util.Scanner;

public class StudentManagerConsole {

    static StudentManager studentManager = new StudentManager();
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String userName = "";
        String password = "";

        int choice = 0;
        while (true) {
            System.out.println("***********************");
            System.out.println("1 - Login");
            System.out.println("2 - Exit");
            System.out.println("***********************");
            choice = s.nextInt();

            if (choice == 1) {
                System.out.println("1 - Admin\n2 - Student");
                int typeOfUser = s.nextInt();
                if (typeOfUser == 2 && studentManager.getAllStudentsList().isEmpty()) {
                    System.out.println("Empty students list");
                }
                else {
                    System.out.print("User name:");
                    userName = s.next();
                    System.out.print("Password:");
                    password = s.next();
                }

                if (checkUsernameAndPassword(userName, password, typeOfUser)) {
                    if (typeOfUser == 1) {
                        User admin = new User();
                        admin.setStudentManager(studentManager);
                        while (true) {
                            System.out.println("***********************");
                            System.out.println("1 - Enter new student");
                            System.out.println("2 - Enter new course");
                            System.out.println("3 - Remove student");
                            System.out.println("4 - Remove course");
                            System.out.println("5 - Print all courses ");
                            System.out.println("6 - Print all students");
                            System.out.println("7 - Log");
                            System.out.println("8 - Exit");
                            System.out.println("***********************");
                            choice = s.nextInt();

                            if (choice == 1) {
                                System.out.print("Student first name:");
                                String firstName = s.next();
                                System.out.print("Student last name:");
                                String lastName = s.next();
                                System.out.print("Student oib:");
                                String oib = s.next();
                                System.out.print("User name");
                                String username = s.next();
                                System.out.print("Password");
                                String pass = s.next();

                                //studentManager.addNewStudent(firstName, lastName, oib);
                                admin.getStudentManager().addNewStudent(firstName, lastName, oib, userName, pass);


                            }  else if (choice == 2) {
                                System.out.print("Course name:");
                                String name = s.next();
                                System.out.print("Points:");
                                int points = s.nextInt();
                                System.out.print("Lectures days:");
                                int days = s.nextInt();

                                admin.getStudentManager().addNewCourse(name,points,days);

                            } else if (choice == 3 ) {
                                List <User> users = studentManager.getAllStudentsList();

                                if (!users.isEmpty()) {
                                    boolean studentFinded = false;
                                    for (User user : users) {
                                        System.out.println(user);
                                    }
                                    System.out.print("Student oib:");
                                    String oib = s.next();

                                    admin.getStudentManager().removeStudent(oib);

                                } else System.out.println("List is empty");



                            } else if (choice == 4) {
                                List <Course> courses = studentManager.getAllCoursesList();

                                if (!courses.isEmpty()) {
                                    for (Course course : courses ) {
                                        System.out.println(course);
                                    }
                                    System.out.print("Course name:");
                                    String name = s.next();

                                    admin.getStudentManager().removeCourse(name);

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
                    } else if (typeOfUser == 2) {
                        printStudentMenu();
                    }

                }
            } else return;
        }
    }

    public static boolean checkUsernameAndPassword(String userName, String password, int typeOfUser) {
        if (typeOfUser == 1) {
            if (userName.equals("admin") && password.equals("admin")) {
                return true;
            } else return false;
        } else if (typeOfUser == 2) {
            for (User user: studentManager.getAllStudentsList()) {
                if (userName.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    System.out.println("Hello " + user.getFirstName());
                    return true;
                }
            }

        }
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
