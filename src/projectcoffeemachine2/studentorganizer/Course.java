package projectcoffeemachine2.studentorganizer;


public class Course {
    private String name;

    // Broj bodova koje nosi kurs
    private int points;

    // Postavlja se na true kad je kurs položen
    private boolean isPassed;

    // Postavlja se na true kad student krene slušat predavanja iz tog kursa
    private boolean isActive;

    // broj dana predavanja - koristi se jer student mora biti prisutan na određenom postotku predavanja
    private int numberOfLectureDays;

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

    public Course(String name, int points, int numberOfLectureDays) {
        this.name = name;
        this.points = points;
        this.numberOfLectureDays = numberOfLectureDays;
        setPassed(false);
        setActive(false);
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getNumberOfLectureDays() {
        return numberOfLectureDays;
    }

    public void setNumberOfLectureDays(int numberOfLectureDays) {
        this.numberOfLectureDays = numberOfLectureDays;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", isPassed=" + isPassed +
                ", isActive=" + isActive +
                '}';
    }
}

