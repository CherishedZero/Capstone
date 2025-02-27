package Capstone;

import java.util.ArrayList;

public abstract class Insurable {
    private ArrayList<Quote> quotes;
    private ArrayList<Policy> policies;
    private double value;
    private Customer customer;

    public Insurable(double value, Customer customer) {
        this.value = value;
        this.quotes = new ArrayList<>();
        this.policies = new ArrayList<>();
        this.customer = customer;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ArrayList<Quote> getQuotes() {
        return quotes;
    }

    public ArrayList<Policy> getPolicies() {
        return policies;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addQuote(Quote quote) {
        if(!quotes.contains(quote)) {
            quotes.add(quote);
        }
    }

    public void addPolicy(Policy policy) {
        if(!policies.contains(policy)) {
            policies.add(policy);
        }
    }

    public abstract double getAgeFactor();
    public abstract double getAdditionalFactor();
}
