package Capstone;

public class Employee extends User {
    private int id;

    public Employee(String username, String password, String fName, String lName, String phone, String email, Address address, int id) {
        super(username, password, fName, lName, phone, email, address);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
