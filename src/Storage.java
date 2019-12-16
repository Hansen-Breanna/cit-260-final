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
                    //TODO input parameters for methods in format
                    out.format("%s|%s|%d|%f|%d|%f|%f|%f|\n", "House", obj.getAddress(),
                            obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(), obj.getPurchasePrice(),
                            obj.getTaxes(), obj.getInterestRate(), h.getAcreage());
                } else if (obj instanceof Condo) {
                    //Info stored for Condo objects-same as Residence + hoaFee & amenities
                    Condo c = (Condo) obj;
                    //TODO input parameters for methods in format
                    out.format("%s|%s|%d|%f|%d|%f|%f|%f|%f|\n", "Condo", obj.getAddress(),
                            obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(), obj.getPurchasePrice(),
                            obj.getTaxes(), obj.getInterestRate(), c.getHoaFee(), c.getAmenities());
                } else if (obj instanceof Multiplex) {
                    //Info saved for Multiplex-same as Residence + units & utilities
                    Multiplex m = (Multiplex) obj;
                    //TODO input parameters for methods in format
                    out.format("\"%s|%s|%d|%f|%d|%f|%f|%f|%f|\n", "Multiplex", obj.getAddress(),
                            obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(), obj.getPurchasePrice(),
                            obj.getTaxes(), obj.getInterestRate(), m.getUnits(), m.getUtilities());

                } else {
                    //In case of not House, Condo or Multiplex, will be saved in file as Residence object
                    //TODO input parameters for methods in format
                    out.format("%s|%s|%d|%f|%d|%f|%f|\n", "residence", obj.getAddress(),
                            obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(), obj.getPurchasePrice(),
                            obj.getTaxes(), obj.getInterestRate());
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

        if (filename == null || filename.trim().length() == 0) {
            throw new IllegalArgumentException("Inputs must not be null");
        }

        //Check if file exists and if it is readable
        File file = new File(filename);
        if(file.exists() == false || file.canRead() == false) {
            throw new IOException("Cannot find or read file");
        }

        ArrayList<Residence> newData = new ArrayList<>();

        //Initialize line number
        int lineNumber = 0;

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                lineNumber += 1;

                //Splits the data per line after the | symbol
                //if the first field has the parent class, adds it to its own array
                String[] fields = line.split("\\|");
                if (fields[0].equals("Residence")) {
                    //Should have 7 fields, including [0] for "residence" --plus 5 more for method calculations
                    Residence r = new Residence();
                    if (fields.length > 12) {
                        throw new IOException("Invalid record format on line " + lineNumber);

                        //This is the correct order with their field #--0: type, 1: address, 2: bedrooms, 3: bathrooms,
                        // 4: sqfeet, 5: purchasePrice, 6: taxes, 7: interest rate, 8: $Down, 9: $/SqFt,
                        // 10: monthlyPayment, 11: monthlyIncome, 12: monthlyNetProfit

//                        //Load the address from the file
//                        //TODO add correct field for String
//                        String loadAddress = fields[1];
//                        r.setAddress(loadAddress);
//
//                        //Load the bedrooms from the file
//                        int numBedrooms = Integer.parseInt(fields[2]);
//                        r.setBedrooms(numBedrooms);
//
//                        //Load the bathrooms from the file
//                        double numBathrooms = Double.parseDouble(fields[3]);
//                        r.setBathrooms(numBathrooms);
//
//                        //Load sqfeet from the file
//                        int numSqFt = Integer.parseInt(fields[4]);
//                        r.setSqfeet(numSqFt);
//
//                        //Load purchasePrice from the file
//                        double loadPrice = Double.parseDouble(fields[5]);
//                        r.setPurchasePrice(loadPrice);
//
//                        //Load taxes from the file
//                        double numTaxes = Double.parseDouble(fields[6]);
//                        r.setTaxes(numTaxes);
//
//                        //Load interestRate from the file
//                        double loadRate = Double.parseDouble(fields[7]);
//                        r.setInterestRate(loadRate);
//
//                        //Load interestRate from the file
//                        loadRate = Double.parseDouble(fields[8]);
//                        r.setInterestRate(loadRate);
//
//                        //Load pricePerSqFt from the file
//                        double loadSqFtPrice = Double.parseDouble(fields[9]);
//                        //r.pricePerSqFt(loadSqFtPrice);
//
//                        //Load monthlyPayment from the file
//                        double loadPayment = Double.parseDouble(fields[10]);
//                        //r.monthlyPayment(loadPayment);
//
//                        //Load monthlyIncome from the file
//                        double loadIncome = Double.parseDouble(fields[11]);
//                        //r.rentalIncome(loadIncome);
//
//                        //Load monthlyNetProfit from the file
//                        double loadProfit = Double.parseDouble(fields[12]);
//                        //r.monthlyNetProfit(loadProfit);
                    }
                    newData.add(r);
                    //if the first field has the House class, adds it to its own array
                } else if (fields[0].equals("House")) {
                    // house|first child value|1
                    //Should have 9 fields, including [0] for "House" --plus 5 more for method calculations
                    if (fields.length < 14) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    House h = new House();
                    //This is the correct order
                    //1: obj.getAddress()--field[1], etc, 2: obj.getBedrooms(), 3: obj.getBathrooms(),
                    // 4: obj.getSqfeet(), 5: obj.getPurchasePrice(), 6: obj.getTaxes(), 7: obj.getInterestRate(),
                    // 8: h.getAcreage()), 9: $Down, 10: $/SqFt, 12: monthlyPayment, 13: monthlyIncome,
                    // 14: monthlyNetProfit

                    //Repeat same as Residence, but adding in acreage

                    //if the first field has the condo class, adds it to its own array
                } else if (fields[0].equals("Condo")) {
                    //Should have 10 fields, including [0] for "Condo" --plus 5 more for method calculations
                    if (fields.length < 15) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    Condo c = new Condo();
                    //This is the correct order
                    //1: obj.getAddress()--field[1], etc, 2: obj.getBedrooms(), 3: obj.getBathrooms(),
                    // 4: obj.getSqfeet(), 5: obj.getPurchasePrice(), 6: obj.getTaxes(), 7: obj.getInterestRate(),
                    // 8: c.getHoaFee(), 9: c.getAmenities(), 10: $Down, 11: $/SqFt, 12: monthlyPayment,
                    // 13: monthlyIncome, 14: monthlyNetProfit

                    //Repeat same as Residence, but adding in hoaFee and amenities

                    //if the first field has the multiplex class, adds it to its own array
                } else if (fields[0].equals("Multiplex")) {
                    //Should have 10 fields, including [0] for "Multiplex" --plus 5 more for method calculations
                    if (fields.length < 15) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    Multiplex m = new Multiplex();
                    //This is the correct order
                    //1: obj.getAddress()--field[1], etc, 2: obj.getBedrooms(), 3: obj.getBathrooms(),
                    // 4: obj.getSqfeet(), 5: obj.getPurchasePrice(), 6: obj.getTaxes(), 7: obj.getInterestRate(),
                    // 8: m.getUnits(), 9: m.getUtilities(), 10: $Down, 11: $/SqFt, 12: monthlyPayment,
                    // 13: monthlyIncome, 14: monthlyNetProfit

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
