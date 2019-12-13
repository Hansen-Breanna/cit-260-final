import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides methods to store and load data from files
 */
public class Storage {
    /**
     * The storeData method
     * Store the data in the specified file
     * @param filename The name of the file where the data are to be stored.
     * @param data     The data to be stored
     * @throws IOException
     */
    public static void storeData(String filename, ArrayList<Residence> data) throws IOException {

        //Check if file exists. If not, create file.
        if (filename == null || filename.trim().length() == 0) {
            throw new IllegalArgumentException("Inputs must not be null");
        }

        // File format will be:
        // One object per line of the file
        // type parentField child-field
        try (PrintWriter out = new PrintWriter(filename)) {
            for (Residence obj : data) {
                //This will make sure each object type is getting saved with same order before it adds class variables
                if (obj instanceof House) {
                    //Info stored for House objects-same as Residence + acreage
                    House h = (House) obj;
                    out.format("%s|%s|%d\n", "house", obj.getAddress(), obj.getBedrooms(), obj.getBathrooms(),
                            obj.getSqfeet(), obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(),
                            h.getAcreage(), obj.downPayment(), obj.pricePerSqFt(), obj.monthlyPayment(),
                            obj.rentalIncome(), obj.monthlyNetProfit());

                } else if (obj instanceof Condo) {
                    //Info stored for Condo objects-same as Residence + hoaFee & amenities
                    Condo c = (Condo) obj;
                    out.format("%s|%s|%f\n", "condo", obj.getAddress(), obj.getBedrooms(), obj.getBathrooms(),
                            obj.getSqfeet(), obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(),
                            c.getHoaFee(), c.getAmenities(), obj.downPayment(), obj.pricePerSqFt(),
                            obj.monthlyPayment(), obj.rentalIncome(),
                            obj.monthlyNetProfit());

                } else if (obj instanceof Multiplex) {
                    //Info saved for Multiplex-same as Residence + units & utilities
                    Multiplex m = (Multiplex) obj;
                    out.format("%s|%s|%f\n", "multiplex", obj.getAddress(), obj.getBedrooms(), obj.getBathrooms(),
                            obj.getSqfeet(), obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(),
                            m.getUnits(), m.getUtilities(), obj.downPayment(), obj.pricePerSqFt(),
                            obj.monthlyPayment(), obj.rentalIncome(),
                            obj.monthlyNetProfit());

                } else {
                    //In case of not House, Condo or Multiplex, will be saved in file as Residence object
                    out.format("%s|%s\n", "residence", obj.getAddress(), obj.getBedrooms(), obj.getBathrooms(),
                            obj.getSqfeet(), obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(),
                            obj.downPayment(), obj.pricePerSqFt(), obj.monthlyPayment(), obj.rentalIncome(),
                            obj.monthlyNetProfit());
                }
            }
        } catch (IOException exception) {
            throw new IOException("Couldn't write file", exception);
        }
    }

    /**
     * Load the data from the specified file
     *
     * @param filename The name of the file containing the data.
     * @return The list of objects loaded from the file.
     * @throws IOException
     */
    public static ArrayList<Residence> loadData(String filename) throws IOException {
        ArrayList<Residence> newData = new ArrayList<>();

        //Check if file exists. If not, create file.
        if (filename == null || filename.trim().length() == 0) {
            throw new IllegalArgumentException("Inputs must not be null");
        }

        File file = new File(filename);
        if (file.exists() == false || file.canRead() == false) {
            throw new IOException("Cannot find or read file");
        }

        //Initialize line number
        int lineNumber = 0;

        try (Scanner input = new Scanner(new File(filename))) {
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                lineNumber += 1;

                //Splits the data per line after the | symbol
                //if the first field has the parent class, adds it to its own array
                String[] fields = line.split("\\|");
                if (fields[0].equals("residence")) {
                    //Should have 7 fields, including [0] for "residence" --plus 5 more for method calculations
                    Residence r = new Residence();
                    if (fields.length > 12) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                        //This is the correct order with their field #--0: type, 1: address, 2: bedrooms, 3: bathrooms,
                        // 4: sqfeet, 5: purchasePrice, 6: taxes, 7: interest rate
                        //plus $Down, $/SqFt, monthlyPayment, monthlyIncome, monthlyNetProfit

                        //Load the address from the file
                        //TODO check field is correct
                        String loadAddress = fields[1];
                        r.setAddress(loadAddress);

                        //Load the bedrooms from the file
                        int numBedrooms = Integer.parseInt(fields[2]);
                        r.setBedrooms(numBedrooms);

                        //Load the bathrooms from the file
                        double numBathrooms = Double.parseDouble(fields[3]);
                        r.setBathrooms(numBathrooms);

                        //Load sqfeet from the file
                        int numSqFt = Integer.parseInt(fields[4]);
                        r.setSqfeet(numSqFt);

                        //Load purchasePrice from the file
                        double loadPrice = Double.parseDouble(fields[5]);
                        r.setPurchasePrice(loadPrice);

                        //Load taxes from the file
                        double numTaxes = Double.parseDouble(fields[6]);
                        r.setTaxes(numTaxes);

                        //Load interestRate from the file
                        double loadRate = Double.parseDouble(fields[7]);
                        r.setInterestRate(loadRate);

                        //Load interestRate from the file
                        double loadRate = Double.parseDouble(fields[8]);
                        r.setInterestRate(loadRate);

                        //Load pricePerSqFt from the file
                        double loadSqFtPrice = Double.parseDouble(fields[9]);
                        r.pricePerSqFt(loadSqFtPrice);

                        //Load monthlyPayment from the file
                        double loadPayment = Double.parseDouble(fields[10]);
                        r.monthlyPayment(loadPayment);

                        //Load monthlyIncome from the file
                        double loadIncome = Double.parseDouble(fields[11]);
                        r.rentalIncome(loadIncome);

                        //Load monthlyNetProfit from the file
                        double loadProfit = Double.parseDouble(fields[12]);
                        r.monthlyNetProfit(loadProfit);
                    }
                    newData.add(r);
                    //if the first field has the house class, adds it to its own array
                } else if (fields[0].equals("house")) {
                    // house|first child value|1
                    //Should have 9 fields, including [0] for "house" --plus 5 more for method calculations
                    if (fields.length < 14) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    House h = new House();
                    //This is the correct order
                    //obj.getAddress()--field[1], etc, obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(),
                    // obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(), h.getAcreage());
                    //plus $Down, $/SqFt, monthlyPayment, monthlyIncome, monthlyNetProfit

                    //Repeat same as Residence, but adding in acreage

                    //if the first field has the condo class, adds it to its own array
                } else if (fields[0].equals("condo")) {
                    //Should have 10 fields, including [0] for "condo" --plus 5 more for method calculations
                    if (fields.length < 15) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    Condo c = new Condo();
                    //This is the correct order
                    //obj.getAddress()--field[1], etc, obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(),
                    // obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(), c.getHoaFee(), c.getAmenities();
                    //plus $Down, $/SqFt, monthlyPayment, monthlyIncome, monthlyNetProfit

                    //Repeat same as Residence, but adding in hoaFee and amenities

                    //if the first field has the multiplex class, adds it to its own array
                } else if (fields[0].equals("multiplex")) {
                    //Should have 10 fields, including [0] for "multiplex" --plus 5 more for method calculations
                    if (fields.length < 15) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    Multiplex m = new Multiplex();
                    //This is the correct order
                    //obj.getAddress()--field[1], etc, obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(),
                    // obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(), m.getUnits(), m.getUtilities();
                    //plus $Down, $/SqFt, monthlyPayment, monthlyIncome, monthlyNetProfit

                    //Repeat same as Residence, but adding in units and utilities


                } else {
                    throw new IOException(String.format("Invalid record type '%s' on line %d", fields[0], lineNumber));
                }
            }
        } catch (NumberFormatException exception) {
            throw new IOException("Invalid number format on line " + lineNumber);
        }

        return newData;
    }
}
