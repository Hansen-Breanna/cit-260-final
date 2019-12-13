import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provide methods to store and load data from files.
 */
public class Storage {

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
                if (obj instanceof House) {
                    House h = (House) obj;
                    out.format("%s|%s|%d\n", "house", obj.getResidentield(), h.getHouseField());
                } else if (obj instanceof Condo) {
                    Condo c = (Condo) obj;
                    out.format("%s|%s|%f\n", "condo", obj.getResidenceField(), c.getCondoField());
                } else if (obj instanceof Multiplex) {
                    Multiplex m = (Multiplex) obj;
                    out.format("%s|%s|%f\n", "condo", obj.getResidenceField(), m.getMultiplexField());
                } else {
                    out.format("%s|%s\n", "residence", obj.getResidenceField());
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
                    Residence r = new Residence();
                    if (fields.length > 1) {
                        r.setResidenceField(fields[1]);
                    }
                    newData.add(r);
                //if the first field has the house class, adds it to its own array
                } else if (fields[0].equals("house")) {
                    // house|first child value|1
                    if (fields.length < 3) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    House h = new House();
                    h.setResidenceField(fields[1]);
                    h.setHouseField(Integer.parseInt(fields[2]));
                    newData.add(h);
                //if the first field has the condo class, adds it to its own array
                } else if (fields[0].equals("condo")) {
                    if (fields.length < 3) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    Condo c = new Condo();
                    c.setParentField(fields[1]);
                    c.setChildField(Double.parseDouble(fields[2]));
                    newData.add(c);

                //if the first field has the multiplex class, adds it to its own array
                } else if (fields[0].equals("multiplex")) {
                    if (fields.length < 3) {
                        throw new IOException("Invalid record format on line " + lineNumber);
                    }
                    Multiplex m = new Multiplex();
                    m.setParentField(fields[1]);
                    m.setChildField(Double.parseDouble(fields[2]));
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
