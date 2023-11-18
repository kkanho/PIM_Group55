// Concrete subclass for Contact
class Contact extends PIR {
    private String name;
    private String address;
    private String mobile_number;

    public Contact(int id, String type, String name, String address, String mobile_number) {
        super(id, type);
        this.name = name;
        this.address = address;
        this.mobile_number = mobile_number;
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() + ", Type: " + super.getType() + ", Name: " + name +", Address: " + address +", Mobile Number: " + mobile_number + ";\n";
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

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
}