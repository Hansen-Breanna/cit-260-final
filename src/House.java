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
        //default value of acreage
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
    House(String address, int bedrooms, double bathrooms, int sqfeet, double purchasePrice, double taxes,
          double acreage) {
        super(address, bedrooms, bathrooms, sqfeet, purchasePrice, taxes);
        this.acreage = acreage;
    }

    /**
     * The header Method
     * This method returns the header for the House table
     */
    @Override
    public String tableHeader() {
        //Return string representation of the House table header
        return String.format("%nHouse Properties List%n%-50s   %-4s   %-5s   %-6s   %-11s   %-9s   %-10s    %-7s   " +
                        "%-9s   %-9s   %-8s   %-7s%n--------------------------------------------------   ----   " +
                        "-----   ------   -----------   ---------   -----------   -------   ---------   ---------   " +
                        "--------   -------%n", "Address", "Beds", "Baths", "SqFt", "Price", "Taxes", "$ Down",
                "$/SqFt", "Payment", "Income", "Profit", "Acreage");
    }

    /**
     * The String method
     * This method displays the data about each property as a string in a table
     * @return String
     */
    //@Override
    public String toString(House newHouse) {
        Double downPayment = super.downPayment(newHouse.getPurchasePrice(), .20);
        Double pricePerSqFoot = super.pricePerSqFt(newHouse.getPurchasePrice(), newHouse.getSqfeet());
        Double monthlyPayment = super.monthlyPayment(newHouse.getPurchasePrice(), super.getInterestRate(),
                super.getLoanPeriod());
        Double rentalIncome = super.rentalIncome(newHouse.getSqfeet(), .70);
        Double netProfit = super.monthlyNetProfit(monthlyPayment, rentalIncome, newHouse.getTaxes());

        //String of each object in arraylist that is a house
        return String.format("%-50s   %-4d   %-5.2f   %-,6d   $%-,11.2f  $%-,9.2f  $%-,10.2f   $%-,7.2f  $%-,9.2f  " +
                        "$%-,9.2f  $%-,8.2f   %-7.2f%n", newHouse.getAddress(), newHouse.getBedrooms(), newHouse.getBathrooms(),
                newHouse.getSqfeet(), newHouse.getPurchasePrice(), newHouse.getTaxes(), downPayment, pricePerSqFoot,
                monthlyPayment, rentalIncome, netProfit, newHouse.getAcreage());
        //TODO rent per square feet?
    }
}