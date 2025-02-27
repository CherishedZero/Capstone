package Capstone.Factory;

import Capstone.Customer;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.List;

public class CustomerFactory {
    private int idCount;
    private AddressFactory af;

    public CustomerFactory() {
        idCount = 0;
        af = new AddressFactory();
    }

    public Customer generateCustomer() {
        LocalDate birthdayStartDate = LocalDate.of(1999, 1, 1); // Year, Month, Day
        LocalDate birthdayEndDate = LocalDate.of(2000, 12, 31); // Year, Month, Day
        LocalDate birthday = getRandomDate(birthdayStartDate, birthdayEndDate);

        int accidents = getRandomAccidentAmount();

        Customer newCustomer = new Customer("user" + getId(), "1234", getRandomFirstName(), getRandomLastName(), getRandomPhoneNumber(), getRandomEmail(), af.generateAddress(), getId(), birthday, accidents);

        return newCustomer;
    }

    public int getId() {
        int currentId = idCount;
        idCount++;

        return currentId;
    }

    public static LocalDate getRandomDate(LocalDate d1, LocalDate d2) {
        Random random = new Random();
        int days = (int) ChronoUnit.DAYS.between(d1, d2);
        LocalDate randomDate = d1.plusDays(
                random.nextInt((days)+1));

        return randomDate;
    }

    public static String getRandomFirstName() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Emma", "Fiona", "George", "Hannah", "Ian", "Julia");
        Random random = new Random();
        return names.get(random.nextInt(names.size()));
    }

    public static String getRandomLastName() {
        List<String> lastNames = List.of("Smith", "Johnson", "Brown", "Taylor", "Anderson", "Thomas", "White", "Harris", "Martin", "Clark");
        Random random = new Random();
        return lastNames.get(random.nextInt(lastNames.size()));
    }

    public static String getRandomPhoneNumber() {
        Random random = new Random();

        // Generates a random area code (100-999)
        int areaCode = random.nextInt(900) + 100;

        // Generates a random central office code (100-999)
        int centralOfficeCode = random.nextInt(900) + 100;

        // Generates a random line number (1000-9999)
        int lineNumber = random.nextInt(9000) + 1000;

        // Formats as (XXX) XXX-XXXX
        return String.format("(%03d) %03d-%04d", areaCode, centralOfficeCode, lineNumber);
    }

    public static String getRandomEmail() {
        List<String> firstNames = List.of("alice", "bob", "charlie", "david", "emma", "fiona", "george", "hannah", "ian", "julia");
        List<String> lastNames = List.of("smith", "johnson", "brown", "taylor", "anderson", "thomas", "white", "harris", "martin", "clark");
        List<String> domains = List.of("gmail.com", "yahoo.com", "outlook.com", "example.com", "mail.com");

        Random random = new Random();

        // Pick a random first name, last name, and domain
        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));
        String domain = domains.get(random.nextInt(domains.size()));

        // Generate a random number to make the email more unique
        int randomNumber = random.nextInt(1000); // 0 - 999

        // Format: firstname.lastname###@domain.com
        return String.format("%s.%s%d@%s", firstName, lastName, randomNumber, domain);
    }

    public static int getRandomAccidentAmount() {
        Random random = new Random();
        return random.nextInt(0,3);
    }

}
