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
}