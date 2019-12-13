/**
 * Simple model of a House
 */
public class House extends Residence {

	//Lot size in acres of investment property
    private double acreage = 0;

    /**
     * Return acreage
     * @return
     */
    public double getAcreage() {
        return acreage;
    }

    /**
     * Set acreage
     * @param acreage
     */
    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    /**
     * Default constructor
     */
    House() {
        acreage = 0;
    };

    /**
     * Constructor
     * @param address
     * @param bedrooms
     * @param bathrooms
     * @param sqfeet
     * @param acreage
     * @param purchasePrice
     * @param taxes
     */
    House(String address, int bedrooms, double bathrooms, int sqfeet, double acreage, double purchasePrice,
                        double taxes) {
        super(address, bedrooms, bathrooms, sqfeet, purchasePrice, taxes);
        this.acreage = acreage;
    }

	/**
	* The header Method
	* This method returns the header for the House table
	*/
	@Override
	public String header() {
		//Return string representation of the House table header
		return String.format("%nHouse Properties List%n%-50s   %-4s   %-5s   %-6s   %-11s   %-9s   %-10s    %-7s   %-9s   %-9s" +
				"   %-8s%n-------------------------------------------------   ----   -----   " +
				"------   -----------   ---------   -----------   -------   ---------   " +
				"---------   --------%n", "Address", "Beds", "Baths", "SqFt", "Price", "Taxes",
				"$ Down", "$/SqFt", "Payment", "Income", "Profit");
	}
	
    /**
     * The String method
     * This method displays the data about each property as a string in a table
     * @return String
     */
    @Override
    public String toString() {
        return String.format(" ");
    }

}