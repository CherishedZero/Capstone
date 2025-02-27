package Capstone;

import java.time.LocalDate;

public class Policy {
    private int id;
    private LocalDate effectiveDate;
    private LocalDate cancelDate = null;
    private String type;
    private Quote quote;
    private double premium;
    private boolean active;

    public Policy(int id, LocalDate effectiveDate, Quote quote) {
        this.id = id;
        this.effectiveDate = effectiveDate;
        this.type = quote.getType();
        this.quote = quote;
        this.active = true;
        this.premium = quote.getPremium();
    }

    public String toString() {
        return "ID: " + id +
                "\nEffective Date: " + effectiveDate +
                (cancelDate == null ? "" : "\nCancelled: " + cancelDate) +
                "\nType: " + type +
                "\nActive: " + active +
                "\nPremium: $" + String.format("%.2f", quote.getPremium());
    }

    public int getId() {
        return id;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public LocalDate getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(LocalDate cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getType() {
        return type;
    }

    public Quote getQuote() {
        return quote;
    }

    public double getPremium() {
        return premium;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
