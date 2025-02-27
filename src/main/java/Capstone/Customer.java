package Capstone;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Date;

public class Customer extends User {
    private int id;
    private LocalDate birthday;
    private ArrayList<Insurable> insuredItems;
    private int accidents;

    public Customer(String username, String password, String fName, String lName, String phone, String email, Address address, int id, LocalDate birthday, int accidents) {
        super(username, password, fName, lName, phone, email, address);
        this.id = id;
        this.birthday = birthday;
        this.insuredItems = new ArrayList<>();
        this.accidents = accidents;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        String base = "Name: " + this.getfName() + " " + this.getlName() +
                    "\nID: " + id +
                    "\nUsername: " + this.getUsername() +
                    "\nPassword: " + this.getPassword() +
                    "\nPhone: " + this.getPhone() +
                    "\nEmail: " + this.getEmail() +
                    "\nBirthday: " + birthday +
                    "\nAccidents: " + accidents + "\n-=-=-=-=-=-=-=-=-=-=-=-\nInsurable Items\n-=-=-=-=-=-=-=-=-=-=-=-\n";
        output.append(base);
        insuredItems.forEach(item -> {
            output.append(item).append("\n--Quotes--\n");
            item.getQuotes().forEach(quote -> output.append(quote).append("\n--\n"));
            output.append("\n--Policies--\n");
            item.getPolicies().forEach(policy -> output.append(policy).append("\n--\n"));
            output.append("\n-=-=-=-=-=-=-=-=-=-=-=-\n");
        });
        output.append("\nNext Customer\n\n-=-=-=-=-=-=-=-=-=-=-=-\n");
        return output.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        LocalDate date = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return date.getYear() - birthday.getYear();
    }

    public ArrayList<Insurable> getInsuredItems() {
        return insuredItems;
    }

    public void addInsuredItem(Insurable item) {
        if(!insuredItems.contains(item)) {
            insuredItems.add(item);
        }
    }

    public void removeInsuredItem(Insurable item) {
        insuredItems.remove(item);
    }

    public int getAccidents() {
        return accidents;
    }

    public void setAccidents(int accidents) {
        this.accidents = accidents;
    }
}
