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
     * @param units
     * @param bedrooms
     * @param bathrooms
     * @param sqfeet
     * @param purchasePrice
     * @param taxes
     * @param units
     * @param utilities
     */
    public Multiplex(String address, int units, int bedrooms, double bathrooms, int sqfeet, double purchasePrice,
                     double taxes, double utilities) {
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
    public double monthlyNetProfit(double monthlyPayment, double taxes, double rentalIncome, double utilities) {
        double monthlyNetProfit = rentalIncome - (monthlyPayment + (taxes / 12) + utilities);
        return monthlyNetProfit;
    }
	
	/**
	* The header Method
	* This method returns the header for the Multiplex table
	*/
	@Override
	public String header() {
		//Return string representation of the Multiplex table header
		return String.format("%nMultiplex Properties List%n%-50s  %-5s   %-4s   %-5s   %-6s   %-11s   %-9s   %-9s   %-10s    %-7s   %-9s   %-9s" +
				"   %-8s%n-------------------------------------------------   -----   ----   -----   " +
				"------   -----------   ---------   ---------   -----------   -------   ---------   " +
				"---------   --------%n", "Address", "Units", "Beds", "Baths", "SqFt", "Price", "Taxes",
				"Utilities", "$ Down", "$/SqFt", "Payment", "Income", "Profit");
	}

    /**
     * The String method
     * Return a string representation of the Multiplex
     * @return String
     */
    @Override
    public String toString() {
		//Retuirns the string for each object of a Multiplex to the table
		return String.format(" ");
    }
}