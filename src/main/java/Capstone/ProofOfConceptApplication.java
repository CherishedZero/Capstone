package Capstone;

import Capstone.Factory.CustomerFactory;
import Capstone.Factory.InsurableFactory;
import Capstone.Factory.PolicyFactory;
import Capstone.Factory.QuoteFactory;

import java.util.ArrayList;
import java.util.Random;

public class ProofOfConceptApplication {

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        CustomerFactory cf = new CustomerFactory();
        InsurableFactory inf = new InsurableFactory();
        QuoteFactory qf = new QuoteFactory();
        PolicyFactory pf = new PolicyFactory();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            customers.add(cf.generateCustomer());
        }
        customers.forEach(customer -> {
            for (int i = 0; i < rand.nextInt(1,4); i++) {
                customer.getInsuredItems().add(inf.generateInsurable(customer));
            }
            if (customer.getInsuredItems().size() > 1) {
                int item = rand.nextInt(customer.getInsuredItems().size());
                customer.getInsuredItems().get(item).addQuote(qf.generateQuote(customer.getInsuredItems().get(item)));
            } else {
                customer.getInsuredItems().get(0).addQuote(qf.generateQuote(customer.getInsuredItems().get(0)));
            }
            if (customer.getInsuredItems().size() > 1) {
                int item = rand.nextInt(customer.getInsuredItems().size());
                customer.getInsuredItems().get(item).addPolicy(pf.generatePolicy(customer.getInsuredItems().get(item)));
            } else {
                customer.getInsuredItems().get(0).addPolicy(pf.generatePolicy(customer.getInsuredItems().get(0)));
            }
        });
        customers.forEach(System.out::println);
    }
}
