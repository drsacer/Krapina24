/* U ODREĐENOJ MJERI SIMULACIJA HITA AKADEMIJE
U ovom programu imamo 2 studenta i 3 tečaja. Student se prvo mora prijaviti u aplikaciju i tek tada mu se otvara izbornik :
  Student može upisati novi tečaj, može prikazati sve upisane tečajeve, prijaviti tečaj, potvrditi kad položi neki tečaj, promijeniti lozinku*/

package studentorganizer.lists;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentConsoleMain {
    static String enterUserName = "";
    static String enterPassword = "";
    static Scanner s = new Scanner(System.in);
    static List<Course> allCoursesList = new ArrayList<>();
    static List<Student> allStudentList = new ArrayList<>();
    static Student currentStudent = null;

    public static void main(String[] args) throws FileNotFoundException {

        // u sljedećem stageu dodajemo admina koji će ubacivati studente i tečajeve
        // u ovom stageu studenti i tečajevi su dodani u listu na sljedeći način

        Student ivan = new Student("Ivan","Ivančić","111",21,"ivan","3232");
        Student mona = new Student("Mona","Monić","222",22,"mona","1234");

        Course java = new Course("Java", 10);
        Course baze = new Course("Baze", 8);
        Course uxui = new Course("UX/UI", 6);
        Course finalCourse = new Course("Web",20);

        allStudentList.add(ivan);
        allStudentList.add(mona);

        allCoursesList.add(java);
        allCoursesList.add(baze);
        allCoursesList.add(uxui);
        allCoursesList.add(finalCourse);

        int choice ;

        while (true) {
            boolean loop = true;
            System.out.println("***********************");
            System.out.println("1 - Login");
            System.out.println("2 - Exit");
            System.out.println("***********************");
            choice = s.nextInt();

            if (choice == 1) {
                checkUsernameAndPassword();
                int ch;

                while (loop) {
                    printStudentMenu();
                    ch = s.nextInt();

                    if (ch == 1) {
                        for (Course c : allCoursesList) {
                            System.out.println(c);
                        }
                        System.out.print("Course name:");
                        String courseName = s.next();
                        currentStudent.addNewCourse(courseName, allCoursesList);
                    } else if (ch == 2) {
                        if (currentStudent.getStudentCoursesList().isEmpty()) {
                            System.out.println("No courses for " + currentStudent.getFirstName() + " " + currentStudent.getLastName() + " yet.");
                        }
                        else {
                            for (Object courses : currentStudent.getStudentCoursesList()) {
                                System.out.println("Courses:" + courses);
                            }
                        }

                    } else if (ch == 3) {
                        for (Course c : allCoursesList) {
                            System.out.println(c);
                        }
                        System.out.println();
                        System.out.print("Which course do you want to activated? Enter the name:");
                        String courseToActivate = s.next();
                        currentStudent.acivateCourse(courseToActivate);


                    } else if (ch == 4) {
                        for (Course c : allCoursesList) {
                            System.out.println(c);
                        }
                        System.out.println();
                        System.out.print("Which course do you want to mark as passed? Enter the name: ");
                        String passedCourse = s.next();
                        currentStudent.markCourseAsPassed(passedCourse);

                    } else if (ch == 5) {
                        System.out.print("Enter old password:");
                        String oldPassword = s.next();
                        changePassword(oldPassword);
                    } else if (ch == 6) {
                        loop = false;
                    }
                }
            } else return;
        }
    }

    public static boolean checkUsernameAndPassword() {

        System.out.print("User name:");
        enterUserName = s.next();
        System.out.print("Password:");
        enterPassword = s.next();

        for (Student s : allStudentList) {
            if (enterUserName.equals(s.getUsername()) && enterPassword.equals(s.getPassword())) {
                currentStudent = s;
                System.out.println("Hello " + s);
                return true;
            }
        }
        if (currentStudent == null) {
            System.out.println("Wrong username or password");
            System.out.println("1 - Exit");
            System.out.println("2 - Enter again");
            int again = s.nextInt();
            if (again == 1)  {
                return false;
            } else {
                checkUsernameAndPassword();
            }
        }
        return false;
    }

    public static boolean changePassword(String oldPassword){
        if (currentStudent.getPassword().equals(oldPassword)) {
            System.out.print("Enter new password:");
            String newPassword = s.next();
            currentStudent.setPassword(newPassword);
            System.out.println("Successfully changed password");
            System.out.println(currentStudent);
        }
        else {
            System.out.println("Wrong password");

            System.out.println("1 - Exit");
            System.out.println("2 - Enter again");
            int again = s.nextInt();
            if (again == 1)  {
                return false;
            } else {
                System.out.print("Enter old password:");
                String oldPasswordAgain = s.next();
                changePassword(oldPasswordAgain);
            }
        }
        return false;
    }

    public static void printStudentMenu() {
        System.out.println("***************************");
        System.out.println("1 - Registration of a new course");
        System.out.println("2 - Print all courses");
        System.out.println("3 - Activate the course ");
        System.out.println("4 - Confirm passed course");
        System.out.println("5 - Change password");
        System.out.println("6 - Exit");
        System.out.println("***************************");
        System.out.print("Enter choice:");
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
