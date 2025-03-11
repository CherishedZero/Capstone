package Capstone;

import java.time.LocalDate;

// TODO Remove calculations from Quotes/Policies
// TODO Use a Factory Builder Pattern

public class Quote {
    private int id;
    private LocalDate generationDate;
    private LocalDate acceptanceDate = null;
    //TODO change type to enum
    private String type;
    private double basePremium;
    private boolean active;
    private Insurable insuredItem;

    //Base

    //id
    //genDate
    //accDate
    //Age
    //Premium
    //active
    //CusID

    //Address
    //Heating
    //Urban
    //Coverage




    public Quote(int id, LocalDate generationDate, String type, boolean active, Insurable insuredItem) {
        this.id = id;
        this.generationDate = generationDate;
        this.type = type;
        this.basePremium = type.equals("Home") ? 500 : 750;
        this.active = active;
        this.insuredItem = insuredItem;
    }

    public String toString() {
        return "ID: " + id +
                "\nGenerated: " + generationDate +
                (acceptanceDate == null ? "" : "\nAccepted: " + acceptanceDate) +
                "\nType: " + type +
                "\nActive: " + active +
                "\nPremium: $" + String.format("%.2f", getPremium());
    }

    public int getId() {
        return id;
    }

    public LocalDate getGenerationDate() {
        return generationDate;
    }

    public LocalDate getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(LocalDate acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getType() {
        return type;
    }

    public double getBasePremium() {
        return basePremium;
    }

    public double getPremium() {
        double output = basePremium;
        if(type.equals("Capstone.Home")) {
            output += insuredItem.getValue() > 250 ? insuredItem.getValue() * 0.002 * 1000 : 0;
        }
        output *= insuredItem.getAgeFactor() * insuredItem.getAdditionalFactor();
        return output;
    };

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
