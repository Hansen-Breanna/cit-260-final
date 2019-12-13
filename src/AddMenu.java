import menu.Menu;
import menu.MenuItem;

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

            //Load data from file and create ArrayList

            //Somehow pull in Residence to get interest rate and loan period?
            Residence newRes = new Residence();

            //Display prompts for Residence variables from method. Store values in array
            final int NUMBER_OF_INDEXES = 6;
            String[] userInput = readNumbers(NUMBER_OF_INDEXES);

            //Display prompts for House
            String acreage = prompt("Enter acreage (ex. 0.25): ", true);

            //Create new House instance
            House newHouse = new House(userInput[0], Integer.parseInt(userInput[1]), Double.parseDouble(userInput[2]),
                    Integer.parseInt(userInput[3]), Double.parseDouble(userInput[4]), Double.parseDouble(userInput[5]),
                    Double.parseDouble(acreage));

            //Add new House to ArrayList

            //Run storeData method to write to file

            //Display that property has been added
            System.out.println("\nHouse at " + newHouse.getAddress() + " has been added.");

            //Delay new list printout
            delay(2000);

            //Call tableHeader method to display table header
            System.out.println(newHouse.tableHeader());

            //For loop printing out all Condos on the ArrayList using the following format. Make another method?
            //Run methods from Residence class inside for loop? Make another method?
            double downPayment = newRes.downPayment(newHouse.getPurchasePrice(), newRes.getPERCENT_DOWN());
            double pricePerSqft = newRes.pricePerSqFt(newHouse.getPurchasePrice(), newHouse.getSqfeet());
            double rentalIncome = newRes.rentalIncome(newHouse.getSqfeet(), newRes.getRENT_PER_SQFT());
            double mortgage = newRes.monthlyPayment(newHouse.getPurchasePrice(), newRes.getInterestRate(),
                    newRes.getLoanPeriod());
            double profit = newHouse.monthlyNetProfit(mortgage, newHouse.getTaxes(), rentalIncome);

            //Return polymorphic String of each property in data file for table with code below as layout
            System.out.println(newHouse.toString());
            //TODO Change to House references
//            System.out.format("%-50s  %-5d   %-4d   %-5.2f   %-,6d   $%-,11.2f  $%-,9.2f  $%-,9.2f  $%-,10.2f   " +
//                            "$%-,7.2f  $%-,9.2f  $%-,9.2f  $%-,8.2f%n", newMulti.getAddress(), newMulti.getUnits(),
//                    newMulti.getBedrooms(), newMulti.getBathrooms(), newMulti.getSqfeet(), newMulti.getPurchasePrice(),
//                    newMulti.getTaxes(), newMulti.getUtilities(), downPayment, pricePerSqft, mortgage, rentalIncome,
//                    profit);

            //Delay displaying Main Menu so user has time to read House list
            delay(7000);

            return true;
        //Else if user enters 2, this block runs
        } else if (key == '2') {

            //Load data from file and create ArrayList

            //Somehow pull in Residence to get interest rate and loan period?
            Residence newRes = new Residence();

            //Display prompts for Residence variables from method. Store values in array
            final int NUMBER_OF_INDEXES = 6;
            String[] userInput = readNumbers(NUMBER_OF_INDEXES);

            //Display prompts for Condo
            String hoa = prompt("Enter HOA monthly fee (ex. 50): ", true);
            double hoaFee = Double.parseDouble(hoa);
            String amenities = prompt("Enter amenities (ex. pool, tennis court): ", true);

            Condo newCondo = new Condo(userInput[0], Integer.parseInt(userInput[1]), Double.parseDouble(userInput[2]),
                    Integer.parseInt(userInput[3]), Double.parseDouble(userInput[4]), Double.parseDouble(userInput[5]),
                    hoaFee, amenities);

            //Add new Condo to ArrayList

            //Run storeData method to write to file

            //Display that property has been added
            System.out.println("\nCondo at " + newCondo.getAddress() + " has been added.");

            //Delay new list printout
            delay(2000);

            //Call tableHeader method to display table header
            System.out.println(newCondo.tableHeader());

            //For loop printing out all Condos on the ArrayList using the following format. Make another method?
            //Run methods from Residence class inside for loop? Make another method?
            double downPayment = newRes.downPayment(newCondo.getPurchasePrice(), newRes.getPERCENT_DOWN());
            double pricePerSqft = newRes.pricePerSqFt(newCondo.getPurchasePrice(), newCondo.getSqfeet());
            double rentalIncome = newRes.rentalIncome(newCondo.getSqfeet(), newRes.getRENT_PER_SQFT());
            double mortgage = newRes.monthlyPayment(newCondo.getPurchasePrice(), newRes.getInterestRate(),
                    newRes.getLoanPeriod());
            double profit = newCondo.monthlyNetProfit(mortgage, newCondo.getTaxes(), rentalIncome,
                    newCondo.getHoaFee());

            //Return polymorphic String of each property in data file for table with code below as layout
            System.out.println(newCondo.toString());
            //TODO change to Condo references
//            System.out.format("%-50s  %-5d   %-4d   %-5.2f   %-,6d   $%-,11.2f  $%-,9.2f  $%-,9.2f  $%-,10.2f   " +
//                            "$%-,7.2f  $%-,9.2f  $%-,9.2f  $%-,8.2f%n", newMulti.getAddress(), newMulti.getUnits(),
//                    newMulti.getBedrooms(), newMulti.getBathrooms(), newMulti.getSqfeet(), newMulti.getPurchasePrice(),
//                    newMulti.getTaxes(), newMulti.getUtilities(), downPayment, pricePerSqft, mortgage, rentalIncome,
//                    profit);

            //Delay displaying Main Menu so user has time to read Condo list
            delay(7000);

            return true;
        //Else if user enters 3, this block runs
        } else if (key == '3') {  //multiplex

            //Load data from file and create ArrayList

            //Somehow pull in Residence to get interest rate and loan period?
            Residence newRes = new Residence();

            //Display prompts for Residence variables from method. Store values in array
            final int NUMBER_OF_INDEXES = 6;
            String[] userInput = readNumbers(NUMBER_OF_INDEXES);

            //Display prompts for Multiplex and set values for each variable. Make a method?
            String units = prompt("Enter number of units: ", true);
            int numUnits = Integer.parseInt(units);
            String utilities = prompt("Enter monthly utilities (ex 225): ", true);
            double utilitiesCost = Double.parseDouble(utilities);

            //Create new Multiplex
            Multiplex newMulti = new Multiplex(userInput[0], Integer.parseInt(userInput[1]),
                    Double.parseDouble(userInput[2]), Integer.parseInt(userInput[3]), Double.parseDouble(userInput[4]),
                    Double.parseDouble(userInput[5]), numUnits, utilitiesCost);

            //Add new multiplex to ArrayList

            //Run storeData method to write to file

            //Display that property has been added
            System.out.println("\nMultiplex at " + newMulti.getAddress() + " has been added.");

            //Delay new list printout
            delay(2000);

            //Call tableHeader method to display table header
            System.out.println(newMulti.tableHeader());

            //For loop printing out all multiplexes on the ArrayList using the following format. Make another method?
            //Run methods from Residence class inside for loop? Make another method?
            double downPayment = newRes.downPayment(newMulti.getPurchasePrice(), newRes.getPERCENT_DOWN());
            double pricePerSqft = newRes.pricePerSqFt(newMulti.getPurchasePrice(), newMulti.getSqfeet());
            double rentalIncome = newRes.rentalIncome(newMulti.getSqfeet(), newRes.getRENT_PER_SQFT());
            double mortgage = newRes.monthlyPayment(newMulti.getPurchasePrice(), newRes.getInterestRate(),
                    newRes.getLoanPeriod());
            double profit = newMulti.monthlyNetProfit(mortgage, newMulti.getTaxes(), rentalIncome,
                    newMulti.getUtilities());

            //Return polymorphic String of each property in data file for table with code below as layout
            System.out.println(newMulti.toString());
//            System.out.format("%-50s  %-5d   %-4d   %-5.2f   %-,6d   $%-,11.2f  $%-,9.2f  $%-,9.2f  $%-,10.2f   " +
//                            "$%-,7.2f  $%-,9.2f  $%-,9.2f  $%-,8.2f%n", newMulti.getAddress(), newMulti.getUnits(),
//                    newMulti.getBedrooms(), newMulti.getBathrooms(), newMulti.getSqfeet(), newMulti.getPurchasePrice(),
//                    newMulti.getTaxes(), newMulti.getUtilities(), downPayment, pricePerSqft, mortgage, rentalIncome,
//                    profit);

            //Delay displaying Main Menu so user has time to read MultiPlex list
            delay(7000);

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
     * The readNumbers method
     * This method returns an array of values the user inputted for Residence variables
     * @param NUMBER_OF_INDEXES
     * @return
     */
    private static String[] readNumbers(int NUMBER_OF_INDEXES) {
        String[] userValues = new String[NUMBER_OF_INDEXES];

        //Display prompts for Residence properties
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
}