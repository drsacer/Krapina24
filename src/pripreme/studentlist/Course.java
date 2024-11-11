package pripreme.studentlist;

public class Course {
    private String name;
    private int points;
    private boolean isPassedCourse;
    private boolean isRegisterExam;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Course(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public boolean isPassedCourse() {
        return isPassedCourse;
    }

    public void setPassedCourse(boolean passedCourse) {
        if (passedCourse == true)  System.out.println("\nWell done, you passed " + name);
        isPassedCourse = passedCourse;
    }

    public boolean isRegisterExam() {
        return isRegisterExam;
    }

    public void setRegisterExam(boolean registerExam) {
        isRegisterExam = registerExam;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", isPassedCourse=" + isPassedCourse +
                ", isRegisterExam=" + isRegisterExam +
                '}';
    }
}
