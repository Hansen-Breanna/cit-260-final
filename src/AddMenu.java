//imports
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
     * @return String
     */
    @Override
    protected String getTitle() {
        return null;
    }

    /**
     * Return string description
     * @return String
     */
    @Override
    protected String getDescription() {
        return "Choose a menu option.";
    }

    /**
     * The getMenuItems method
     * Return array MenuItems
     * @return array
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
     * @return boolean
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
            MainMenu mmenu = new MainMenu();
            return mmenu.display();
            //Else user enters anything else, this block runs
        } else {
            //Display statement and display Main Menu again
            System.out.println("Enter valid selection.");
            return true;
        }
    }

    /**
     * The addRes method
     * This method add an instance of Residence and subclass to the ArrayList in data.txt
     * @return boolean
     */
    private static boolean addRes(String type) {

        //Load data from file and create ArrayList
        ArrayList<Residence> newData;
        newData = Storage.returnData();

        //Create instance for each subclass type of property
        House newHouse = new House();
        Condo newCondo = new Condo();
        Multiplex newMultiplex = new Multiplex();

        //Pass type in and call tableHeader method to display table header and loop printing list of type of property.
        //House header and list
        if (type.equals("House")) {
            System.out.println(newHouse.tableHeader());
            for (Residence r : newData) {
                if (r instanceof House) {
                    House h = (House) r;
                    System.out.println(h.toString());
                }
            }
            System.out.println();
        //Condo header and list
        } else if (type.equals("Condo")) {
            System.out.println(newCondo.tableHeader());
            for (Residence r : newData) {
                if (r instanceof Condo) {
                    Condo c = (Condo) r;
                    System.out.println(c.toString());
                }
            }
            System.out.println();
        //Multiplex header and list
        } else {
            System.out.println(newMultiplex.tableHeader());
            for (Residence r : newData) {
                if (r instanceof Multiplex) {
                    Multiplex m = (Multiplex) r;
                    System.out.println(m.toString());
                }
            }
            System.out.println();
        }

        //Display prompts for Residence variables from method. Store values in array
        String[] userInput = readNumbers();

        //Display prompts for each type of residence and add instance to array list
        if (type.equals("House")) {
            newHouse = addHouse(userInput);
            newData.add(newHouse);
        } else if (type.equals("Condo")) {
            newCondo = addCondo(userInput);
            newData.add(newCondo);
        } else {
            newMultiplex = addMultiplex(userInput);
            newData.add(newMultiplex);
        }

        //Run storeData method to write to file
        try {
            Storage.storeData("data.txt", newData);
        } catch(IOException ex) {
            System.out.println("Could not write data to file.");
        }

        //Display that property has been added
        System.out.println("\n" + type + " at " + userInput[0] + " has been added.");

        //Delay displaying Main Menu
        delay(2000);

        return true;
    }

    /**
     * The readNumbers method
     * This method returns an array of values the user inputted for Residence variables
     * @return array
     */
    private static String[] readNumbers() {
        //Create initial array
        String[] userValues = new String[6];

        //Display all Residence prompts to user, validate, and add to array
        try {
            //Display prompts for Residence properties
            boolean checkVal = false;

            //Address
            String address = prompt("Enter address: ", true);
            userValues[0] = address;
            //Bedrooms
            do {
                String beds = prompt("Enter number of bedrooms: ", true);
                try {
                    int checkBeds = Integer.parseInt(beds);
                    userValues[1] = beds;
                    if (checkBeds > 0) {
                        checkVal = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input an integer.");
                }
            } while (!checkVal);
            //Bathrooms
            do {
                checkVal = false;
                String baths = prompt("Enter number of bathrooms (ex. 1.5): ", true);
                try {
                    double checkBaths = Double.parseDouble(baths);
                    userValues[2] = baths;
                    if (checkBaths > 0) {
                        checkVal = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input a number.");
                }
            } while (!checkVal);
            //Square footage
            do {
                checkVal = false;
                String sqft = prompt("Enter square footage (ex. 1500): ", true);
                try {
                    int checkSqFt = Integer.parseInt(sqft);
                    userValues[3] = sqft;
                    if (checkSqFt > 0) {
                        checkVal = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input an integer.");
                }
            } while (!checkVal);
            //Price
            do {
                checkVal = false;
                String price = prompt("Enter purchase price (ex. 200000): ", true);
                try {
                    double checkPrice = Double.parseDouble(price);
                    userValues[4] = price;
                    if (checkPrice > 0) {
                        checkVal = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input a number.");
                }
            } while (!checkVal);
            //Taxes
            do {
                checkVal = false;
                String taxes = prompt("Enter yearly homeowner's taxes (ex 1500): ", true);
                try {
                    double checkTaxes = Double.parseDouble(taxes);
                    userValues[5] = taxes;
                    if (checkTaxes > 0) {
                        checkVal = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input a number.");
                }
            } while (!checkVal);
        } catch (Exception ex) {
            System.err.println("Error: input must be an integer.");
        }

        //Return array of user inputted values
        return userValues;
    }

    /**
     *The addHouse method
     * Displays prompts specific to houses and creates new instance
     * @return House
     */
    private static House addHouse(String[] userInput) {
        boolean checkDouble = false;
        House newHouse = new House();
        //Display prompts for House
        do {
            String acreage = prompt("Enter acreage (ex. 0.25): ", true);
            try {
                double checkAcreage = Double.parseDouble(acreage);
                //Create new House instance
                if (checkAcreage > 0) {
                    newHouse = new House(userInput[0], Integer.parseInt(userInput[1]), Double.parseDouble(userInput[2]),
                            Integer.parseInt(userInput[3]), Double.parseDouble(userInput[4]), Double.parseDouble(userInput[5]),
                            checkAcreage);
                    checkDouble = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input a number.");
            }
        } while (!checkDouble);

        //Return instance
        return newHouse;
    }

    /**
     *The addCondo method
     * Displays prompts specific to condos and creates new instance
     * @return
     */
    private static Condo addCondo(String[] userInput) {
        boolean checkDouble = false;
        Condo newCondo = new Condo();
        do {
            //Display prompts for Condo
            String hoa = prompt("Enter HOA monthly fee (ex. 50): ", true);
            try {
                double checkHoa = Double.parseDouble(hoa);
                //Create new Condo instance
                if (checkHoa > 0) {
                    String amenities = prompt("Enter amenities (ex. pool, tennis court): ", true);
                    newCondo = new Condo(userInput[0], Integer.parseInt(userInput[1]), Double.parseDouble(userInput[2]),
                            Integer.parseInt(userInput[3]), Double.parseDouble(userInput[4]), Double.parseDouble(userInput[5]),
                            checkHoa, amenities);
                    checkDouble = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input a number.");
            }
        } while (!checkDouble);
        return newCondo;
    }

    /**
     * The addMultiplex method
     * Displays prompts specific to multiplexes and creates new instance
     * @return
     */
    private static Multiplex addMultiplex(String[] userInput) {

        boolean checkVal = false;
        Multiplex newMulti = new Multiplex();
        //Display prompts for Multiplex and set values for each variable. Make a method?
        do {
            //Units
            String units = prompt("Enter number of units: ", true);
            try {
                //Parse string
                int numUnits = Integer.parseInt(units);
                //Check for positive number
                if (numUnits > 0) {
                    String utilities = prompt("Enter monthly utilities (ex 225): ", true);
                    double utilitiesCost = Double.parseDouble(utilities);
                    if (utilitiesCost > -1) {
                        //Create new Multiplex
                        newMulti = new Multiplex(userInput[0], Integer.parseInt(userInput[1]),
                                Double.parseDouble(userInput[2]), Integer.parseInt(userInput[3]), Double.parseDouble(userInput[4]),
                                Double.parseDouble(userInput[5]), numUnits, utilitiesCost);
                        checkVal = true;
                    } else {
                        System.out.println("Please enter a number greater than 0 for utilities.");
                    }
                } else {
                    System.out.println("Please enter a number greater than 0 for units.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input a number.");
            }
        } while (!checkVal);
        return newMulti;
    }
}