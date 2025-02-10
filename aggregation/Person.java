public class Person {
    private String firstName;
    private String lastName;
    private Address home;

    // constructor, it represendts aggregation, since we do not create 
    // new Address object here, instead we pass the reference of the Address object
    // so if the Person object is destroyed, the Address object will still exist
    // and if the Address object is changed, the Person object will reflect the changes
    public Person(String firstName, String lastName, Address home) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.home = home;
    }

    // toString() method
    public String toString() {
        return this.firstName + " " + this.lastName + ", " + this.home;
    }
}