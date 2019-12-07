/**
 *
 */
public class House extends Residence {

    private double acreage = 0;

    /**
     * Return acreage
     * @return
     */
    public String getAcreage() {
        return acreage;
    }

    /**
     * Set acreage
     * @param acreage
     */
    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    /**
     * Default constructor
     */
    public static House();

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
    public static House(String address, int bedrooms, int bathrooms, int sqfeet, double acreage, double purchasePrice,
                        double taxes) {
        super(address, bedrooms, bathrooms, sqfeet, purchasePrice, taxes);
        this.acreage = acreage;
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
