class Text extends PIR {
    
    private String description;

    public Text(int id, String type, String description) {
        super(id, type);
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() + 
                ",/nType: " + super.getType() + 
                "/nDescription: " + description;
    }

    //getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}