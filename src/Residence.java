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
    private int loanPeriod;
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
     * @param address
     * @param bedrooms
     * @param bathrooms
     * @param sqfeet
     * @param purchasePrice
     * @param taxes
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
     * @param purchasePrice
     * @param PERCENT_DOWN
     * @return purchasePrice
     */
    public double downPayment(double purchasePrice, double PERCENT_DOWN) {
        return purchasePrice * PERCENT_DOWN;
    }

    /**
     * The pricePerSqFt method
     * This method calculates the price per square foot of the residence based on the purchase price and size.
     * @param purchasePrice
     * @param sqFt
     * @return pricePerSqFt
     */
    public double pricePerSqFt(double purchasePrice, int sqfeet) {
        return purchasePrice / sqfeet;
    }

    /**
     * The monthlyPayment method
     * This method calculates the monthly payment based on loan length, purchase price, and interest rate.
     * @param purchasePrice
     * @param interestRate
     * @param loanPeriod
     * @return monthlyPayment
     */
    public double monthlyPayment(double purchasePrice, double interestRate, int loanPeriod) {
        double termInMonths = loanPeriod * 12;
        double monthlyRate = (interestRate / 100) / 12;
        return (purchasePrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
    }

    /**
     * The rentalIncome method
     * This method calculates the possible rental income based on the square footage of the residence and a base
     * rent per square foot unit of .70.
     * @param sqfeet
     * @param RENT_PER_SQFT
     * @return
     */
    public double rentalIncome(int sqfeet, double RENT_PER_SQFT) {
        return sqfeet * RENT_PER_SQFT;
    }

    /**
     * The monthlyNetProfit method
     * The method calculates the net profit after subtracting the taxes and mortgage payment from the rental income.
     * @param monthlyPayment
     * @param taxes
     * @param rentalIncome
     * @return
     */
    public double monthlyNetProfit(double monthlyPayment, double taxes, double rentalIncome) {
        return rentalIncome - (monthlyPayment + (taxes / 12));
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
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set Address
     * @param address
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Return bedrooms
     * @return
     */
    public int getBedrooms() {
        return bedrooms;
    }

    /**
     * Set bedrooms
     * @param bedrooms
     */
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    /**
     * Return bathrooms
     * @return
     */
    public double getBathrooms() {
        return bathrooms;
    }

    /**
     * Set bathrooms
     * @param bathrooms
     */
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    /**
     * Return sqft
     * @return
     */
    public int getSqfeet() { return sqfeet; }

    /**
     * Set SqFeet
     * @param
     */
    public void setSqfeet(int sqfeet) {
        this.sqfeet = sqfeet;
    }

    /**
     * Return purchasePrice
     * @return
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Set purchasePrice
     * @param purchasePrice
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Return taxes
     * @return
     */
    public double getTaxes() {
        return taxes;
    }

    /**
     * Set taxes
     * @param taxes
     */
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    /**
     * Return interestRate
     * @return
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Set interestRate
     * @param interestRate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Return loanPeriod
     * @return
     */
    public int getLoanPeriod() {
        return loanPeriod;
    }

    /**
     * Set loanPeriod
     * @param loanPeriod
     */
    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    /**
     * Return PERCENTAGE_DOWN
     * @return
     */
    public double getPERCENT_DOWN() { return PERCENT_DOWN;}

    /**
     * Return RENT_PER_SQFT
     * @return
     */
    public double getRENT_PER_SQFT() { return RENT_PER_SQFT; }
}