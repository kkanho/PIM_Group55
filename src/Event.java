// Concrete subclass for Event
class Event extends PIR {
    private String description;
    private String start_time;
    private boolean alarm;

    public Event(int id, String type, String description, String start_time, boolean alarm) {
        super(id, type);
        this.description = description;
        this.start_time = start_time;
        this.alarm = alarm;
    }

    public String isAlarmSet() {
        if (alarm)
            return "On";
        else
            return "OFF";
    }

    // Additional methods specific to Event can be added here

    @Override
    public String toString() {
        return "ID: " + super.getId() + 
                ",/nType: " + super.getType() + 
                "/nDescription: " + description +
                "/nStart Time: " + start_time +
                "/nAlarm: " + isAlarmSet();
    }

    //getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }
}