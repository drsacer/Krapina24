package projectcoffeemachine2.studentorganizer;

import java.sql.Timestamp;

public class Event {
    private String action;
    private int id = 1;

    //Timestamp date;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event(String action) {
        this.action = action;
        id++;
    }

    public Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Event{" +
                "action='" + action + '\'' +
                ", id=" + id +
                '}';
    }
}
