import menu.Menu;
import menu.MenuItem;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Submenu for option Add Property on MainMenu
 */
public class AddMenu extends Menu {
    /**
     * Return null
     * @return
     */
    @Override
    protected String getTitle() {
        return null;
    }

    /**
     * Return string description
     * @return
     */
    @Override
    protected String getDescription() {
        return "Choose a menu option.";
    }

    /**
     * The getMenuItems method
     * Return array MenuItems
     * @return
     */
    @Override
    protected MenuItem[] getMenuItems() {
        //Array of Add Property menu items
        MenuItem[] menuItems = new MenuItem[]{
                new MenuItem('1', "Add House"),
                new MenuItem('2', "Add Condo"),
                new MenuItem('3', "Add Multiplex"),
                new MenuItem('4', "Return to Main Menu"),
        };
        return menuItems;
    }

    /**
     * Handle user selection from Main Menu
     * @param key
     * @return
     */
    @Override
    protected boolean handleMenuSelection(char key) {
        //If user enters X, this block runs and menu quits
        if (key == 'X' || key == 'x') {
            //Exits program
            return false;
            //Else if user enters 1, this block runs
        } else if (key == '1') {
            addRes("House");
            return true;
            //Else if user enters 2, this block runs
        } else if (key == '2') {
            addRes("Condo");
            return true;
            //Else if user enters 3, this block runs
        } else if (key == '3') {  //multiplex
            addRes("Multiplex");
            return true;
            //Else if user enters 4, this block runs
        } else if (key == '4') {
            //Display Main Menu
            new MainMenu().display();
            return true;
            //Else user enters anything else, this block runs
        } else {
            //Display statement and display Main Menu again
            System.out.println("Enter valid selection.");
            return true;
        }
    }

    /**
     *
     * @return
     */
    private static boolean addRes(String type) {

        //Load data from file and create ArrayList
        ArrayList<Residence> newData = new ArrayList<>();
        try {
            newData = Storage.loadData("data.txt");
        } catch (Exception ex) {
            System.err.println("Error loading file: " + ex.getMessage());
            System.exit(1);
        }

        //Create instance for each subclass type of property
        House newHouse = new House();
        Condo newCondo = new Condo();
        Multiplex newMultiplex = new Multiplex();

        //Call tableHeader method to display table header
        //TODO For loop printing out all Condos on the ArrayList using the following format.
        if (type == "House") {
            System.out.println(newHouse.tableHeader());
        } else if (type == "Condo") {
            System.out.println(newCondo.tableHeader());
        } else if (type == "Multiplex") {
            System.out.println(newMultiplex.tableHeader());
        }

        //Somehow pull in Residence to get interest rate and loan period?
        Residence newResidence = new Residence();

        //Display prompts for Residence variables from method. Store values in array
        final int NUMBER_OF_INDEXES = 6;
        String[] userInput = readNumbers(NUMBER_OF_INDEXES);

        if (type == "House") {
            newHouse = addHouse(userInput);
            newData.add(newHouse);
        } else if (type == "Condo") {
            newCondo = addCondo(userInput);
            newData.add(newCondo);
        } else if (type == "Multiplex") {
            newMultiplex = addMultiplex(userInput);
            newData.add(newMultiplex);
        } else {
            //TODO
        }

        //TODO Add new property type to ArrayList

        //Run storeData method to write to file
        try {
            Storage.storeData("data.txt", newData);
        } catch(IOException ex) {
            //TODO
        }

        //Display that property has been added
        System.out.println("\n" + type + " at " + userInput[0] + " has been added.");

        //Delay new list printout
        delay(2000);

        //Call tableHeader method to display table header
        //TODO For loop printing out all Condos on the ArrayList using the following format.
        if (type == "House") {
            System.out.println(newHouse.tableHeader());
            System.out.println(newHouse.toString(newHouse));
        } else if (type == "Condo") {
            System.out.println(newCondo.tableHeader());
            System.out.println(newCondo.toString(newCondo));
        } else if (type == "Multiplex") {
            System.out.println(newMultiplex.tableHeader());
            System.out.println(newMultiplex.toString(newMultiplex));
        }

        //Delay displaying Main Menu so user has time to read House list
        delay(7000);
        return true;
    }

    /**
     * The readNumbers method
     * This method returns an array of values the user inputted for Residence variables
     * @param NUMBER_OF_INDEXES
     * @return
     */
    private static String[] readNumbers(int NUMBER_OF_INDEXES) {
        String[] userValues = new String[NUMBER_OF_INDEXES];

        //Display prompts for Residence properties
        //TODO validate each type entered is correct
        String address = prompt("Enter address: ", true);
        userValues[0] = address;
        String beds = prompt("Enter number of bedrooms: ", true);
        userValues[1] = beds;
        String baths = prompt("Enter number of bathrooms (ex. 1.5): ", true);
        userValues[2] = baths;
        String sqft = prompt("Enter square footage (ex. 1500): ", true);
        userValues[3] = sqft;
        String price = prompt("Enter purchase price (ex. 200000): ", true);
        userValues[4] = price;
        String taxes = prompt("Enter yearly homeowner's taxes (ex 1500): ", true);
        userValues[5] = taxes;
        //Return array of user inputted values
        return userValues;
    }

    /**
     *
     * @return
     */
    private static House addHouse(String[] userInput) {
        //Display prompts for House
        String acreage = prompt("Enter acreage (ex. 0.25): ", true);

        //Create new House instance
        House newHouse = new House(userInput[0], Integer.parseInt(userInput[1]), Double.parseDouble(userInput[2]),
                Integer.parseInt(userInput[3]), Double.parseDouble(userInput[4]), Double.parseDouble(userInput[5]),
                Double.parseDouble(acreage));
        return newHouse;
    }

    /**
     *
     * @return
     */
    private static Condo addCondo(String[] userInput) {

        //Display prompts for Condo
        String hoa = prompt("Enter HOA monthly fee (ex. 50): ", true);
        double hoaFee = Double.parseDouble(hoa);
        String amenities = prompt("Enter amenities (ex. pool, tennis court): ", true);

        Condo newCondo = new Condo(userInput[0], Integer.parseInt(userInput[1]), Double.parseDouble(userInput[2]),
                Integer.parseInt(userInput[3]), Double.parseDouble(userInput[4]), Double.parseDouble(userInput[5]),
                hoaFee, amenities);

        return newCondo;
    }

    /**
     *
     * @return
     */
    private static Multiplex addMultiplex(String[] userInput) {

        //Display prompts for Multiplex and set values for each variable. Make a method?
        String units = prompt("Enter number of units: ", true);
        int numUnits = Integer.parseInt(units);
        String utilities = prompt("Enter monthly utilities (ex 225): ", true);
        double utilitiesCost = Double.parseDouble(utilities);

        //Create new Multiplex
        Multiplex newMulti = new Multiplex(userInput[0], Integer.parseInt(userInput[1]),
                Double.parseDouble(userInput[2]), Integer.parseInt(userInput[3]), Double.parseDouble(userInput[4]),
                Double.parseDouble(userInput[5]), numUnits, utilitiesCost);

        return newMulti;
    }
}