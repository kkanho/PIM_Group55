// Abstract class for Personal Information Record (PIR)
abstract class PIR {
    private int id;
    private String type;

    public PIR(int id, String description) {
        this.id = id;
        this.type = type;
    }



    @Override
    public String toString() {
        return "ID: " + id + 
                "/nType: " + type;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}







