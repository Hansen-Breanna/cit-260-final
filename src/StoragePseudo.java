import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides methods to store and load data from files
 */
public class StoragePseudo {
    /**
     * Store the data in the specified file
     * @param filename The name of the file where the data are to be stored.
     * @param data The data to be stored
     * @throws IOException
     */
    public static void storeData(String filename, ArrayList<Residence> data) throws IOException {
        // File format will be:
        // One object per line of the file
        // type parentField child-field
        try (PrintWriter out = new PrintWriter(filename)) {
            for (Residence obj: data) {
                //This will make sure each object type is getting saved with same order before it adds class variables
                if (obj instanceof House) {
                    //Info stored for House objects-same as Residence + acreage
                    House h = (House) obj;
                    out.format("%s|%s|%d\n", "house", obj.getAddress(), obj.getBedrooms(), obj.getBathrooms(),
                            obj.getSqfeet(), obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(),
                            h.getAcreage());
                } else if (obj instanceof Condo) {
                    //Info stored for Condo objects-same as Residence + hoaFee & amenities
                    Condo c = (Condo) obj;
                    out.format("%s|%s|%f\n", "condo", obj.getAddress() ,obj.getBedrooms(), obj.getBathrooms(),
                            obj.getSqfeet(), obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(),
                            c.getHoaFee(), c.getAmenities());
                } else if (obj instanceof Multiplex) {
                    //Info saved for Multiplex-same as Residence + units & utilities
                    Multiplex m = (Multiplex) obj;
                    out.format("%s|%s|%f\n", "multiplex", obj.getAddress(), obj.getBedrooms(), obj.getBathrooms(),
                            obj.getSqfeet(), obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(),
                            m.getUnits(), m.getUtilities());
                } else {
                    //In case of not House, Condo or Multiplex, will be saved in file as Residence object
                    out.format("%s|%s\n", "residence", obj.getAddress(), obj.getBedrooms(), obj.getBathrooms(),
                            obj.getSqfeet(), obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate());
                }
            }
        } catch(IOException exception) {
            throw new IOException("Couldn't write file", exception);
        }
    }

    /**
     * Load the data from the specified file
     * @param filename The name of the file containing the data.
     * @return The list of objects loaded from the file.
     * @throws IOException
     */
    public static ArrayList<Residence> loadData(String filename) throws IOException {
        ArrayList<Residence> newData = new ArrayList<>();

        // Remember to check if the file exists.

        int lineNumber = 0;

        try (Scanner input = new Scanner(new File(filename))) {
            while(input.hasNextLine()) {
                String line = input.nextLine().trim();
                lineNumber += 1;

                //Splits the data per line after the | symbol
                //if the first field has the parent class, adds it to its own array
                String[] fields = line.split("\\|");
                if (fields[0].equals("residence")) {
                    //Should have 7 fields, including "0" of type for residence
                    Residence r = new Residence();
                    if (fields.length > 7) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                        //This is the correct order
                        // obj.getAddress()-field[1], etc, obj.getBedrooms(), obj.getBathrooms(),
                        // obj.getSqfeet(), obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate());
                        //double numBathrooms = Double.parseDouble(fields[1]);
                        //r.setBathrooms(numBathrooms);
                    }
                    newData.add(r);
                //if the first field has the house class, adds it to its own array
                } else if (fields[0].equals("house")) {
                    // house|first child value|1
                    //Should have 8 fields, including "0" of type for house
                    if (fields.length < 9) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    House h = new House();
                    //This is the correct order
                    //obj.getAddress()--field[1], etc, obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(),
                    // obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(), h.getAcreage());
                    double numBathrooms= Double.parseDouble(fields[1]);
                    //TODO fix the h.set order below
                    h.setBathrooms(numBathrooms);
                    h.setAcreage(Double.parseDouble(fields[2]));
                    newData.add(h);
                //if the first field has the condo class, adds it to its own array
                } else if (fields[0].equals("condo")) {
                    if (fields.length < 3) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    Condo c = new Condo();
                    //This is the correct order
                    //obj.getAddress()--field[1], etc, obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(),
                    // obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(), c.getHoaFee(), c.getAmenities();
                    //TODO fix the c.set order below
                    double numBathrooms= Double.parseDouble(fields[1]);
                    c.setBathrooms(numBathrooms);
                    newData.add(c);

                //if the first field has the multiplex class, adds it to its own array
                } else if (fields[0].equals("multiplex")) {
                    if (fields.length < 3) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    Multiplex m = new Multiplex();
                    //This is the correct order
                    //obj.getAddress()--field[1], etc, obj.getBedrooms(), obj.getBathrooms(), obj.getSqfeet(),
                    // obj.getPurchasePrice(), obj.getTaxes(), obj.getInterestRate(), m.getUnits(), m.getUtilities();
                    //TODO fix the m.set order below
                    double numBathrooms= Double.parseDouble(fields[1]);
                    m.setBathrooms(numBathrooms);
                    //TODO set the rest of the fields
                    // c.setChildField(Double.parseDouble(fields[2]));
                    newData.add(m);
                } else {
                    throw new IOException(String.format("Invalid record type '%s' on line %d",fields[0], lineNumber));
                }
            }
        } catch (NumberFormatException exception) {
            throw new IOException("Invalid number format on line " + lineNumber);
        }
        return newData;
    }
}
