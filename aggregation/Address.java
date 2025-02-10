public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    // constructor
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // toString() method
    public String toString() {
        return this.street + ", " + this.city + ", " + this.state + " " + this.zip;
    }
}