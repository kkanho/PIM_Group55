// Concrete subclass for Task
class Task extends PIR {
    private String description;
    private String deadline;

    public Task(int id, String type, String description, String deadline) {
        super(id, type);
        this.description = description;
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() + 
                ",/nType: " + super.getType() + 
                "/nDescription: " + description +
                "/nDeadline: " + deadline;
    }
}