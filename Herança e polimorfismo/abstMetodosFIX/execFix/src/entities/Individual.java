package entities;

public class Individual extends TaxPayer {

    private Double helthExpenditures;

    public Individual() {
        super();
    }

    public Individual(String name, Double anualIncome, Double helthExpenditures) {
        super(name, anualIncome);
        this.helthExpenditures = helthExpenditures;
    }

    public Double getHelthExpenditures() {
        return helthExpenditures;
    }

    public void setHelthExpenditures(Double helthExpenditures) {
        this.helthExpenditures = helthExpenditures;
    }

    @Override
    public double tax() {
        if (getAnualIncome() <= 20000.00) {
            return (0.15 * getAnualIncome()) - (getHelthExpenditures() * 0.50);
        } else {
            return (0.25 * getAnualIncome()) - (getHelthExpenditures() * 0.50);
        }
    }
}
