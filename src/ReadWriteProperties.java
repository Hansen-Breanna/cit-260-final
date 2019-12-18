import java.io.*;
import java.util.Properties;

/**
 * Simple model of ReadWriteProperties
 */
public class ReadWriteProperties {

    private static String propertiesPath = "rateLoan.properties";
    public int loanPeriod;
    public double interestRate;

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
        writeProperties();
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
        writeProperties();
    }

    /**
     * The loadProperties method
     * This method loads the properties into the file
     * @throws IOException
     */
    public void loadProperties() throws IOException {

        File yourFile = new File(propertiesPath);

        //Create new file if it doesn't exist
        if (!yourFile.exists()) {
            yourFile.createNewFile();
        }

        //Set properties to file
        try (InputStream input = new FileInputStream(propertiesPath)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            //Set values for interestRate and loanPeriod
            setInterestRate(Double.parseDouble(prop.getProperty("interestRate")));
            setLoanPeriod(Integer.parseInt(prop.getProperty("loanPeriod")));
        } catch (IOException ex) {
            System.out.println("Input/Output failure.");
        }
    }

    /**
     * The writeProperties method
     * This method writes the new property values to the file
     */
    public void writeProperties() {

        //Set properties
        try (OutputStream output = new FileOutputStream(propertiesPath)) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("interestRate", String.valueOf(getInterestRate()));
            prop.setProperty("loanPeriod", String.valueOf(getLoanPeriod()));

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            System.out.println("Error writing to file.");
        }
    }

    /**
     * The initializeProps method
     * This method initializes the loanPeriod and interestRate variables in the Residence class to the inputted values.
     */
    public static void initializeProps() {

        //Create new instance
        ReadWriteProperties props = new ReadWriteProperties();

        //get property values
        try {
            props.loadProperties();
            //Change values in Residence file of loanPeriod and interestRate
            Residence.loanPeriod = props.getLoanPeriod();
            Residence.interestRate = props.getInterestRate();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}