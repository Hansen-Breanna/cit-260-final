/**
 * Simple Model of a Multiplex
 */
public class Multiplex extends Residence {

    private int units;
    private double utilities;

    /**
     * Default constructor
     */
    public Multiplex() {
        units = 1;
        utilities = 0;
    }

    /**
     * Constructor
     * @param address
     * @param bedrooms
     * @param bathrooms
     * @param sqfeet
     * @param purchasePrice
     * @param taxes
     * @param units
     * @param utilities
     */
    public Multiplex(String address, int bedrooms, int bathrooms, int sqfeet, double purchasePrice, double taxes,
                     int units, double utilities) {
        super(address, bedrooms, bathrooms, sqfeet, purchasePrice, taxes);
        this.units = units;
        this.utilities = utilities;
    }

    /**
     * Return units
     * @return
     */
    public int getUnits() {
        return units;
    }

    /**
     * Set units
     * @param units
     */
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * Return utilities
     * @return
     */
    public double getUtilities() {
        return utilities;
    }

    /**
     * Set utilities
     * @param utilities
     */
    public void setUtilities(double utilities) {
        this.utilities = utilities;
    }

    /**
     * The monthlyNetProfit method
     * This method calculates the net profit after subtracting utilities, taxes, and mortgage from rental income
     * @param monthlyPayment
     * @param taxes
     * @param rentalIncome
     * @param utilities
     * @return netProfit
     */
    @Override
    public double monthlyNetProfit(double monthlyPayment, double taxes, double rentalIncome, double utilities) {
        double monthlyNetProfit = rentalIncome - (monthlyPayment + taxes + utilities);
        return monthlyNetProfit;
    }

    /**
     * The String method
     * Return a string representation of the multiplex
     * @return String
     */
    @Override
    public String toString() {
        return String.format(" ");
    }
}
