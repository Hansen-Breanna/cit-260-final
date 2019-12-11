/**
 * Simple model of a Residence
 */
public class Residence {

    //VARIABLES
    private int bedrooms;
    private double bathrooms;
    private int sqfeet;
    private double purchasePrice;
    private double taxes;
    private String address;
    private double interestRate;
    private double loanPeriod;
    private double monthlyPayment;
    private double rentalIncome;
    private final double PERCENT_DOWN = 0.2;
    private final double RENT_PER_SQFT = 0.7;

    //CONSTRUCTORS

    /**
     * Default Constructor
     */
    Residence() {
        bedrooms = 0;
        bathrooms = 0;
        sqfeet = 0;
        purchasePrice = 0;
        taxes = 0;
        address = null;
        interestRate = 4.375;
    }

    /**
     * Constructor
     * @param address string
     * @param bedrooms integer
     * @param bathrooms double
     * @param sqfeet integer
     * @param purchasePrice double
     * @param taxes double
     */
    Residence(String address, int bedrooms, double bathrooms, int sqfeet, double purchasePrice, double taxes) {
        this.address = address;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.sqfeet = sqfeet;
        this.purchasePrice = purchasePrice;
        this.taxes = taxes;
    }

    //Methods
    /**
     * The downPayment method
     * The method calculates the down payment by multiplying the purchase price by the required percentage down.
     * @param purchasePrice double
     * @param PERCENT_DOWN final double, twenty percent
     * @return purchasePrice
     */
    public double downPayment(double purchasePrice, double PERCENT_DOWN) {
        return purchasePrice * PERCENT_DOWN;
    }

    /**
     * The pricePerSqFt method
     * This method calculates the price per square foot of the residence based on the purchase price and size.
     * @param purchasePrice double
     * @param sqfeet integer
     * @return pricePerSqFt
     */
    public double pricePerSqFt(double purchasePrice, int sqfeet) {
        return purchasePrice / sqfeet;
    }

    /**
     * The monthlyPayment method
     * This method calculates the monthly payment based on loan length, purchase price, and interest rate.
     * @param purchasePrice double
     * @param interestRate double
     * @param loanPeriod double
     * @return monthlyPayment
     */
    public double monthlyPayment(double purchasePrice, double interestRate, double loanPeriod) {
        double termInMonths = loanPeriod / 12;
        double monthlyRate = interestRate / 12;
        return (purchasePrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, termInMonths));
    }

    /**
     * The rentalIncome method
     * This method calculates the possible rental income based on the square footage of the residence and a base
     * rent per square foot unit of .70.
     * @param sqfeet double
     * @param RENT_PER_SQFT final double = .70
     * @return rental income
     */
    public double rentalIncome(int sqfeet, double RENT_PER_SQFT) {
        return sqfeet * RENT_PER_SQFT;
    }

    /**
     * The monthlyNetProfit method
     * The method calculates the net profit after subtracting the taxes and mortgage payment from the rental income.
     * @param monthlyPayment double
     * @param taxes double
     * @param rentalIncome double
     * @return rentalIncome
     */
    public double monthlyNetProfit(double monthlyPayment, double taxes, double rentalIncome) {
        return rentalIncome - (monthlyPayment + taxes);
    }

    /**
     * The String method
     * This method returns the String representation of a residence.
     */
    @Override
    public String toString() {
        return String.format(" ");
    }

    //GETTERS AND SETTERS

    /**
     * Return address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set Address
     * @param address string
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Return bedrooms
     * @return bedrooms
     */
    public int getBedrooms() {
        return bedrooms;
    }

    /**
     * Set bedrooms
     * @param bedrooms integer
     */
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    /**
     * Return bathrooms
     * @return bathrooms
     */
    public double getBathrooms() {
        return bathrooms;
    }

    /**
     * Set bathrooms
     * @param bathrooms double
     */
    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }

    /**
     * Return sqft
     * @return sqfeet
     */
    public int getSqfeet() { return sqfeet; }

    /**
     * Set sqfeet
     * @param sqfeet integer
     */
    public void setSqfeet(int sqfeet) {
        this.sqfeet = sqfeet;
    }

    /**
     * Return purchasePrice
     * @return purchasePrice
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Set purchasePrice
     * @param purchasePrice double
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Return taxes
     * @return taxes
     */
    public double getTaxes() {
        return taxes;
    }

    /**
     * Set taxes
     * @param taxes double
     */
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    /**
     * Return interestRate
     * @return interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Set interestRate
     * @param interestRate double
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

}