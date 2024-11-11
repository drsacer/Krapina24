package pripreme.studentlist;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentConsoleMain {
    private static Scanner scanner;
    static String enterUserName = "";
    static String enterPassword = "";
   /* static String studentUserName = "student";
    static String studentPassword = "123";*/
    static String adminUserName = "admin";
    static String adminPassword = "123";
    static Scanner s = new Scanner(System.in);

    static List<Course> courses = new ArrayList<>();
    static List<Student> studentList = new ArrayList<>();

    static Student currentStudent = null;

    public static void main(String[] args) throws FileNotFoundException {

        // boolean loop = true;
        int choice = 0;

        //Student ivan = new Student("Ivan", "Ivančić", 18, 1, 0);

       // List<Course> coursesList = ivan.getStudentCoursesList();

        while (true) {
            boolean loop = true;
            System.out.println("***********************");
            System.out.println("Login");
            System.out.println("1- Student\n2- Admin");
            System.out.println("3- Exit");
            System.out.println("***********************");
            choice = s.nextInt();

            if (choice == 1) {
                if (!checkUsernameAndPassword("Student"))  {
                    checkUsernameAndPassword("Student");
                }
                int ch;

                while (loop) {
                    printStudentMenu();
                    ch = s.nextInt();

                    if (ch == 1) {
                        for (Course c : courses) {
                            System.out.println(c.getName() + " - " + c.getPoints());
                        }
                        System.out.print("Course name:");
                        String courseName = s.next();
                        currentStudent.addNewCourse(courseName);
                    } else if (ch == 2) {
                        for (Object courses : currentStudent.getStudentCoursesList()) {
                            System.out.println("Courses:" + courses);
                        }
                    } else if (ch == 3) {
                        for (Course c : courses) {
                            System.out.println(c.getName() + " - " + c.getPoints());
                        }
                        System.out.print("Which course do you want to register? Enter the name:");
                        String courseToRegister = s.next();
                        currentStudent.registerCourse(courseToRegister);
                    } else if (ch == 4) {
                        loop = false;
                    }
                }

            } else if (choice == 2) {
                if (!checkUsernameAndPassword("Admin"))  {
                    checkUsernameAndPassword("Admin");
                }

                while (loop) {
                    printAdminMenu();
                    choice = s.nextInt();
                    if (choice == 1) {
                        addNewCourseToAcademy();
                    } else if (choice == 2) {
                        addNewStudent();
                    } else if (choice == 3) {

                        for (Course c : courses) {
                            System.out.println("Name:" + c.getName() + " | Points:" + c.getPoints());
                        }
                        System.out.println("Enter course to delete");
                        String courseToDelete = s.next();

                        deleteCourse(courseToDelete);

                    } else if (choice == 4) {
                        for (Student s : studentList) {
                            System.out.println(s);
                        }
                        System.out.println("Enter student OIB");
                        String oib = s.next();
                        deleteStudent(oib);

                    } else if (choice == 5) {
                        for (Course c : courses) {
                            System.out.println(c);
                        }
                    } else if (choice == 6) {
                        for (Student s : studentList) {
                            System.out.println(s);
                        }
                    } else if (choice == 7) {
                        loop = false;
                    }
                }
            } else if (choice == 3) {
                return;
            }
        }
    }

    public static boolean checkUsernameAndPassword(String typeOfPerson) {

        System.out.println("User name:");
        enterUserName = s.next();
        System.out.println("Password:");
        enterPassword = s.next();

        if (typeOfPerson.equals("Student")) {
            for (Student s: studentList) {
                if (enterUserName.equals(s.getUsername()) && enterPassword.equals(s.getPassword())) {
                    currentStudent = s;
                    System.out.println("Hello " + s.getFirstName() + " " + s.getLastName());
                    return true;
                }
            }

            if (currentStudent == null) {
                System.out.println("Wrong userName or password");
                System.out.println("Enter again");
                return false;
            }
        } else {
            if (enterUserName.equals("admin") && enterPassword.equals("123")) {
                System.out.println("Hello admin");
                return true;
            }
            else {
                System.out.println("Wrong userName or password");
                System.out.println("Enter again");
                return false;
            }
        }
        return false;
    }

    public static void printStudentMenu() {
        System.out.println("***************************");
        System.out.println("1 - Adding new course");
        System.out.println("2 - Print all courses");
        System.out.println("3 - Register the exam ");
        System.out.println("4 - Exit");
        System.out.println("***************************");
        System.out.println("Enter choice:");
    }

    public static void printAdminMenu() {
        System.out.println("**********************************");
        System.out.println("1 - Adding new course to Academy");
        System.out.println("2 - Adding new student");
        System.out.println("3 - Delete course");
        System.out.println("4 - Delete student");
        System.out.println("5 - Print all courses");
        System.out.println("6 - Print all students");
        System.out.println("7 - Exit");
        System.out.println("**********************************");
        System.out.println("Enter choice:");
    }

    public static void addNewCourseToAcademy() {
        System.out.println("Course name:");
        String courseName = s.next();
        System.out.println("Course points:");
        int points = s.nextInt();

        Course newCourse = new Course(courseName, points);
        newCourse.setPassedCourse(false);

        courses.add(newCourse);
    }

    private static void addNewStudent() {
        System.out.println("First name:");
        String firstName = s.next();
        System.out.println("Last name:");
        String lastName = s.next();
        System.out.println("OIB:");
        String oib = s.next();
        System.out.println("Age:");
        int age = s.nextInt();
        System.out.println("User name:");
        String userName = s.next();
        System.out.println("Password:");
        String password = s.next();

        Student newStudent = new Student(firstName,lastName,oib,age,userName,password);
        studentList.add(newStudent);
    }
    private static void deleteCourse(String courseToDelete) {
        Course toDelete = null;
        for (Course c : courses) {
            if (courseToDelete.equals(c.getName())) {
               toDelete = c;
            }
        }
        courses.remove(toDelete);
    }
    private static void deleteStudent(String oib) {
        Student toDelete = null;
        for (Student s : studentList) {
            if (oib.equals(s.getOib())) {
                toDelete = s;
            }
        }
        studentList.remove(toDelete);
    }
/*
BRISANJE - NE MOŽE SE BRISATI DOK SE ITERIRA PO LISTI
Iterator<String> itr = names.iterator();
while(itr.hasNext()){
    String name = itr.next();
    if(name.equals("def")){
        itr.remove();
    }
}*/

}
