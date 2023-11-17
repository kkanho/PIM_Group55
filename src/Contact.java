// Concrete subclass for Contact
class Contact extends PIR {
    private String name;
    private String address;
    private int mobile_number;

    public Contact(int id, String type, String name, String address, int mobile_number) {
        super(id, type);
        this.name = name;
        this.address = address;
        this.mobile_number = mobile_number;
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() + 
                ",\nType: " + super.getType() + 
                "\nName: " + name +
                "\nAddress: " + address +
                "\nMobile Number: " + mobile_number;
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }
}