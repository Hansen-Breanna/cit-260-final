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
     * @param units
     * @param utilities
     */
    public Multiplex(int units, double utilities) {
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
     * @return netProfit
     */
    @Override
    public double monthlyNetProfit() {
        var netProfit = 0;
        return netProfit;
    }

    /**
     * The String method
     * Return a string representation of the multiplex
     * @return String
     */
    @Override
    public String toString() {

    }
}
