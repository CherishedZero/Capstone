package Capstone.Factory;

import Capstone.Address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AddressFactory {
    private ArrayList<String> streets = new ArrayList<>(Arrays.asList("Maple St", "Topsail Ave", "Grinding Road", "Stop Ln"));
    private ArrayList<String> cities = new ArrayList<>(Arrays.asList("St. John's", "Syrup", "Leaf", "Cola Town"));
    private ArrayList<String> provinces = new ArrayList<>(Arrays.asList("NL", "QC", "AB", "NB"));
    private ArrayList<String> zips = new ArrayList<>(Arrays.asList("A1E 3C3", "X0X 0X0", "L0L 0W0", "T1T 8L8"));

    public Address generateAddress() {
        Random rand = new Random();
        return new Address(rand.nextInt(1, 101), this.streets.get(rand.nextInt(4)), this.cities.get(rand.nextInt(4)), this.provinces.get(rand.nextInt(4)), this.zips.get(rand.nextInt(4)));
    }
}
