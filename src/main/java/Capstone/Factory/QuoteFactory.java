package Capstone.Factory;

import Capstone.Insurable;
import Capstone.Quote;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.time.temporal.ChronoUnit;

public class QuoteFactory {
    private int idCount;

    public QuoteFactory() {
        this.idCount = 1;
    }

    public Quote generateQuote(Insurable insurable) {
        LocalDate generationStartDate = LocalDate.of(2020, 4, 20); // Year, Month, Day
        LocalDate generationEndDate = LocalDate.of(2020, 4, 30); // Year, Month, Day
        LocalDate generationDate = getRandomDate(generationStartDate, generationEndDate);

        int daysUntilActivation = ThreadLocalRandom.current().nextInt(1,14);
        LocalDate activationDate = generationDate.plusDays(daysUntilActivation);

        String type = "Home";
        if (ThreadLocalRandom.current().nextInt(2) == 1) {
            type = "Auto";
        }

        boolean activeStatus = ThreadLocalRandom.current().nextInt(2) == 1;

        Quote newQuote = new Quote(this.getId(), generationDate, type, activeStatus, insurable);
        if (!activeStatus && ThreadLocalRandom.current().nextInt(2) == 1) {
            newQuote.setAcceptanceDate(activationDate);
        }

        return newQuote;
    }

    public int getId() {
        int currentId = this.idCount;
        this.idCount++;

        return currentId;
    }

    public static LocalDate getRandomDate(LocalDate d1, LocalDate d2) {
        int days = (int) ChronoUnit.DAYS.between(d1, d2);
        LocalDate randomDate = d1.plusDays(
                ThreadLocalRandom.current().nextInt((days)+1));

        return randomDate;
    }

}
