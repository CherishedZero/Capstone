package Capstone;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Home extends Insurable {

    public enum heatSource {
        ELECTRIC,
        OIL,
        WOOD,
        GAS,
        OTHER
    }
    private int buildYear;
    private heatSource heating;
    private boolean urban;
    private Address address;

    public Home(double value, int buildYear, heatSource heating, boolean urban, Address address, Customer customer) {
        super(value, customer);
        this.buildYear = buildYear;
        this.heating = heating;
        this.urban = urban;
        this.address = address;
    }

    public String toString() {
        return address + "\n" + (urban ? "Urban" : "Rural") + "\nHeating: " + heating.toString() + "\nYear: " + buildYear + "\nValue: $" + String.format("%.2f", this.getValue());
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public heatSource getHeating() {
        return heating;
    }

    public void setHeating(heatSource heating) {
        this.heating = heating;
    }

    public boolean isUrban() {
        return urban;
    }

    public void setUrban(boolean urban) {
        this.urban = urban;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public double getAgeFactor() {
        double factor = 1;
        LocalDate date = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int age = date.getYear() - buildYear;
        if (age >= 25 && age < 50) {
            factor = 1.25;
        } else if (age >= 50) {
            factor = 1.5;
        }
        return factor;
    }

    @Override
    public double getAdditionalFactor() {
        double factor = urban ? 1 : 1.15;
        if (heating == heatSource.WOOD) {
            factor *= 1.25;
        } else if (heating == heatSource.OIL) {
            factor *= 2;
        }
        return factor;
    }
}
