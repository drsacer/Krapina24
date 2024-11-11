package studentorganizer.lists;

public class Course {
    private String name;

    // broj bodova koje nosi kurs
    private int points;

    // Postavlja se na true kad je kurs položen
    private boolean isPassed;

    //postavlja se na true kad student krene slušat predavanja iz tog kursa
    private boolean isActive;

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
