import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Storage class for reading to and writing form files
 */
public class Storage {

    /**
     * Writes the data for the house object to the house file
     * @param filename
     * @param data
     * @throws IOException
     */
    public static void addHouse(String filename, String[] data) throws IOException {

        if (filename == null || data == null) {
            throw new IllegalArgumentException("Inputs must not be null");
        }

        try (PrintWriter out = new PrintWriter(filename)) {
            for (String str : data) {
                out.println(str);
            }
        }
    }

    /** Writes the data for the condo object to the condo file
     *
     * @param filename
     * @param data
     * @throws IOException
     */
    public static void addCondo(String filename, String[] data) throws IOException {

        if (filename == null || data == null) {
            throw new IllegalArgumentException("Inputs must not be null");
        }

        try (PrintWriter out = new PrintWriter(filename)) {
            for (String str : data) {
                out.println(str);
            }
        }
    }

    /** Writes the data for the multiplex object to the multiplex file
     *
     * @param filename
     * @param data
     * @throws IOException
     */
    public static void addMulti(String filename, String[] data) throws IOException {

        if (filename == null || data == null) {
            throw new IllegalArgumentException("Inputs must not be null");
        }

        try (PrintWriter out = new PrintWriter(filename)) {
            for (String str : data) {
                out.println(str);
            }
        }
    }

    /**
     * Read strings from the file specified by filename.
     * @param filename
     * @return
     * @throws IOException
     */
    public static String[] viewProperties(String filename) throws IOException {
        if (filename == null || filename.trim().length() == 0) {
            throw new IllegalArgumentException("Inputs must not be null");
        }

        File file = new File(filename);
        if (file.exists() == false || file.canRead() == false) {
            throw new IOException("Cannot find or read file");
        }

        ArrayList<String> rawData = new ArrayList<>();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                rawData.add(input.nextLine().trim());
            }
        }

        return convertListToArray(rawData);
    }
    public static String[] convertListToArray(ArrayList<String> data) {
        // convert arraylist to array
        String[] strings = new String[data.size()];
        for (int i=0; i < data.size(); i++) {
            strings[i] = data.get(i);
        }

        return strings;
}