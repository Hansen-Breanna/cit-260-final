/**
 * Simple model of a Residence
 */
public class Residence {

    //VARIABLES
    private int bedrooms;
    private double bathrooms;
    private int sqft;
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
        sqft = 0;
        purchasePrice = 0;
        taxes = 0;
        address = null;
        interestRate = 0;
    }

    /**
     * Constructor
     * @param address
     * @param bedrooms
     * @param bathrooms
     * @param sqft
     * @param purchasePrice
     * @param taxes
     * @param interestRate
     */
    Residence(String address, int bedrooms, int bathrooms, int sqft, double purchasePrice, double taxes,
              double interestRate) {
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.sqft = sqft;
        this.purchasePrice = purchasePrice;
        this.taxes = taxes;
        this.address = address;
        this.interestRate = interestRate;
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
        double downPayment =  purchasePrice * PERCENT_DOWN;
        return downPayment;
    }

    /**
     * The pricePerSqFt method
     * This method calculates the price per square foot of the residence based on the purchase price and size.
     * @param purchasePrice
     * @param sqFt
     * @return pricePerSqFt
     */
    public double pricePerSqFt(double purchasePrice, int sqFt) {
        double pricePerSqFt = purchasePrice / sqFt;
        return pricePerSqFt;
    }

    /**
     * The monthlyPayment method
     * This method calculates the monthly payment based on loan length, purchase price, and interest rate.
     * @param purchasePrice
     * @param interestRate
     * @param loanPeriod
     * @return monthlyPayment
     */
    public double monthlyPayment(double purchasePrice, double interestRate, double loanPeriod) {
        double termInMonths = loanPeriod / 12;
        double monthlyRate = interestRate / 12;
        double monthlyPayment = (purchasePrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, termInMonths));
        return monthlyPayment;
    }

    /**
     * The rentalIncome method
     * This method calculates the possible rental income based on the square footage of the residence and a base
     * rent per square foot unit of .70.
     * @param sqFt
     * @param RENT_PER_SQFT
     * @return
     */
    public double rentalIncome(int sqFt, double RENT_PER_SQFT) {
        double rentalIncome = sqFt * RENT_PER_SQFT;
        return rentalIncome;
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
        double monthlyNetProfit = rentalIncome - (monthlyPayment + taxes);
        return monthlyNetProfit;
    }

    /**
     * The String method
     * This method returns the String representation of a residence.
     */
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
    public int getSqft() { return sqft; }

    /**
     * Set sqft
     * @param sqft
     */
    public void setSqft(int sqft) {
        this.sqft = sqft;
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

}
