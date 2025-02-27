package Capstone.Factory;

import Capstone.Home;
import Capstone.Insurable;
import Capstone.Customer;
import Capstone.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class InsurableFactory {
    private ArrayList<Integer> years = new ArrayList<>(Arrays.asList(1974, 1999, 2010, 2002));
    private ArrayList<String> makes = new ArrayList<>(Arrays.asList("Honda", "Toyota", "Mazda", "Ford"));
    private ArrayList<String> models = new ArrayList<>(Arrays.asList("Super Car", "Old Car", "Neat Car", "Junker"));

    public Insurable generateInsurable(Customer customer) {
        Random rand = new Random();
        Insurable output;
        if (rand.nextInt(100) > 50) {
            Home.heatSource heat = Home.heatSource.OTHER;
            switch (rand.nextInt(5)) {
                case 0 -> heat = Home.heatSource.ELECTRIC;
                case 1 -> heat = Home.heatSource.OIL;
                case 2 -> heat = Home.heatSource.WOOD;
                case 3 -> heat = Home.heatSource.GAS;
            }
            output = new Home(rand.nextDouble(100, 500000), years.get(rand.nextInt(4)), heat, rand.nextBoolean(), customer.getAddress(), customer);
        } else {
            output =  new Vehicle(rand.nextDouble(100, 50000), makes.get(rand.nextInt(4)), models.get(rand.nextInt(4)), years.get(rand.nextInt(4)), customer);
        }
        return output;
    }
}
