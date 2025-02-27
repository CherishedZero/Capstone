package Capstone;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Vehicle extends Insurable {
    private String make;
    private String model;
    private int year;

    public Vehicle(double value, String make, String model, int year, Customer customer) {
        super(value, customer);
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String toString() {
        return "Make: " + make + "\nModel: " + model + "\nYear: " + year + "\nValue: $" + String.format("%.2f", this.getValue());
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public double getAgeFactor() {
        double factor = this.getCustomer().getAge() < 25 ? 2 : 1;
        LocalDate date = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int age = date.getYear() - year;
        if(age > 10) {
            factor *= 2;
        } else if (age > 5) {
            factor *= 1.5;
        }
        return factor;
    }

    @Override
    public double getAdditionalFactor() {
        // TODO double check vehicle age
        double factor = 1;
        int accidents = this.getCustomer().getAccidents();
        if (accidents == 1) {
            factor *= 1.25;
        } else if (accidents >= 2) {
            factor *= 1.5;
        }
        return factor;
    }
}
