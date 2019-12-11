/**
 * Simple model of a House
 */
public class House extends Residence {

    private double acreage = 0;

    /**
     * Return acreage
     * @return acreage
     */
    public double getAcreage() {
        return acreage;
    }

    /**
     * Set acreage
     * @param acreage for yard of house object
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
     * @param address a string
     * @param bedrooms an integer
     * @param bathrooms a double
     * @param sqfeet an integer
     * @param acreage a double
     * @param purchasePrice a double
     * @param taxes annual, a double
     */
    House(String address, int bedrooms, double bathrooms, int sqfeet, double acreage, double purchasePrice,
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