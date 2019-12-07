/**
 *
 */
public class Residence {

    /**
     * The downPayment method
     * The method calculates the dollar amount needed for a down payment of 20% of purchase price.
     * @param purchasePrice
     * @param PERCENT_DOWN
     * @return purchasePrice
     */
    public double downPayment(double purchasePrice, double PERCENT_DOWN) {
        double downPayment =  purchasePrice * PERCENT_DOWN;
        return downPayment;
    }

    /**
     * The pricePerSqFt method
     * This method calculates the price per square foot of the residence based on the purchase price and size.
     * @param purchasePrice
     * @param sqFt
     * @return pricePerSqFt
     */
    public double pricePerSqFt(double purchasePrice, int sqFt) {
        double pricePerSqFt = purchasePrice / sqFt;
        return pricePerSqFt;
    }

    /**
     * The monthlyPayment method
     * This method calculates the monthly payment based on loan length, purchase price, and interest rate.
     * @param purchasePrice
     * @param interestRate
     * @param loanPeriod
     * @return monthlyPayment
     */
    public double monthlyPayment(double purchasePrice, double interestRate, double loanPeriod) {
        double termInMonths = loanPeriod / 12;
        double monthlyRate = interestRate / 12;
        double monthlyPayment = (purchasePrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, termInMonths));
        return monthlyPayment;
    }

    /**
     * The rentalIncome method
     * This method calculates the possible rental income based on the square footage of the residence and a base
     * rent per square foot unit of .70.
     * @param sqFt
     * @param RENT_PER_SQFT
     * @return
     */
    public double rentalIncome(int sqFt, double RENT_PER_SQFT) {
        return sqFt * RENT_PER_SQFT;
    }
}
