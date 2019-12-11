/**
 * Simple model of a Condo
 */
public class Condo extends Residence {

    private double hoaFee;
    private String amenities;

    /**
     * Default constructor
     */
    Condo() {
        hoaFee = 0;
        amenities = "null";
    }

    /**
     * Constructor
     * @param hoaFee
     * @param amenities
     * @param bedrooms
     * @param bathrooms
     * @param sqfeet
     * @param purchasePrice
     * @param taxes
     * @param address
     */
    Condo(String address, int bedrooms, int bathrooms, int sqfeet, double purchasePrice, double taxes, double hoaFee,
          String amenities) {
        super(address, bedrooms, bathrooms, sqfeet, purchasePrice, taxes);
        this.hoaFee = hoaFee;
        this.amenities = amenities;
    }

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
     * Set amenities
     * @param amenities
     */
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

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
        double monthlyNetProfit = rentalIncome - (monthlyPayment + taxes + hoaFee);
        return monthlyNetProfit;
    }

    /**
     * The String method
     * This method display the data about each property as a string in a table
     * @return String
     */
    @Override
    public String toString() {
        return String.format(" ");
    }
}