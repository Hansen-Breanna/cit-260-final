/**
 * Simple Model of a Multiplex
 */
public class multiplex extends residence {

    /**
     *    -units: int { get set }
     *     +utilities: double { get set }
     *
     *     +MultiPlex()
     *     +MultiPex(units: int, bedrooms: int, bathrooms: int, sqft: int, purchasePrice: double,  taxes: double, address: String)
     */
    private int units;
    private double utilities;

    /**
     * Default constructor
     */
    public multiplex() {
        units = 1;
        utilities = 0;
    }

    /**
     * Constructor
     * @return
     */
    public multiplex(int units, double utilities) {
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

    //+percentageDown(purchasePrice: double): double
    //+pricePerSqFt(purchasePrice: double, sqft: int): double
    //+monthlyPayment(purchasePrice: double, interestRate: double): double

    /**
     * This method calculates the rental income per each unit and adds them together for a final income amount
     * @param units
     * @param sqft
     */
    @Override
    public rentalIncome(int units, int sqft) {
        var income = sqft / units;
        return income;
    }

    /**
     * This method calculates the net profit after subtracting utilities, taxes, and mortgage from rental income
     * @return
     */
    @Override
    public double monthlyNetProfit() {
        var netProfit = 0;
        return netProfit;
    }

    /**
     *  This method calculates the rental income for if only one unit is rented, then 2, etc.
     * @return
     */
    public double portionRentalIncome() {
        var portionIncome = 0;
        return portionIncome;
    }

    /**
     * Return a string representation of the multiplex
     * @return
     */
    @Override
    public String toString() {

    }
}
