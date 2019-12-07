/**
 * This class calculates the percentageDown, pricePerSqFt, monthlyPayment, rentalIncome, and
 * monthlyNetProfit for condo objects
 */
public class Condo extends Residence {

    private double hoaFee = 0;
    private String amenities = "null";

    /**
     * Return hoaFee
     * @return
     */
    public double getHoaFee() {
        return hoaFee;
    }

    /**
     * Set hoaFee
     * @param hoaFee
     */
    public void setHoaFee(double hoaFee) {
        this.hoaFee = hoaFee;
    }

    /**
     * Return amenities
     * @return
     */
    public String getAmenities() {
        return amenities;
    }

    /**
     * Set units
     * @param amenities
     */
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    /**
     * Default constructor
     */
    public static Condo();

    /**
     * Constructor
     * @param hoaFee
     * @param amenities
     * @param bedrooms
     * @param bathrooms
     * @param sqFt
     * @param purchasePrice
     * @param taxes
     * @param address
     */
    public static Condo(double hoaFee, String amenities, int bedrooms, int bathrooms, int sqFt, double purchasePrice,
                        double taxes, String address);

    @Override
    //Overrides from Residence class to account for hoaFee
    /**
     * The monthlyNetProfit method
     * This method calculates the expected monthly net profit after subtracting the monthly mortgage payment, taxes,
     * and hoaFee from the rental income.
     * @param monthlyPayment
     * @param taxes
     * @param rentalIncome
     * @param hoaFee
     * @return monthlyNetProfit
     */
    public double monthlyNetProfit(double monthlyPayment, double taxes, double rentalIncome, double hoaFee) {
        return rentalIncome - (monthlyPayment + taxes + hoaFee);
    }

    @Override
    /**
     * The String method
     * This method display the data about each property as a string in a table
     * @return String
     */
    public String toString();
}
