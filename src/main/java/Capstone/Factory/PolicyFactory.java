package Capstone.Factory;

import Capstone.Insurable;
import Capstone.Policy;
import Capstone.Quote;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.time.temporal.ChronoUnit;

public class PolicyFactory {
    private int idCount;
    private final QuoteFactory qf;

    public PolicyFactory() {
        this.idCount = 1;
        this.qf = new QuoteFactory();
    }

    public Policy generatePolicy(Insurable insurable) {

        Quote quote = qf.generateQuote(insurable);

        int daysUntilActivation = ThreadLocalRandom.current().nextInt(1,14);
        LocalDate activationDate = quote.getGenerationDate().plusDays(daysUntilActivation);

        quote.setAcceptanceDate(activationDate);
        quote.setActive(false);

        insurable.addQuote(quote);

        LocalDate effectiveStartDate = LocalDate.of(2020, 5, 1);
        LocalDate effectiveEndDate = LocalDate.of(2020, 5, 31);
        LocalDate effectiveDate = getRandomDate(effectiveStartDate, effectiveEndDate);

        return new Policy(getId(), effectiveDate, quote);
    }

    private int getId() {
        int currentId = this.idCount;
        this.idCount++;

        return currentId;
    }

    private static LocalDate getRandomDate(LocalDate start, LocalDate end) {
        int daysBetween = (int) ChronoUnit.DAYS.between(start, end);
        return start.plusDays(ThreadLocalRandom.current().nextInt(daysBetween + 1));
    }
}
