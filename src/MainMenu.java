//imports
import menu.Menu;
import menu.MenuItem;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Method creates Main Menu to display to user
 */
public class MainMenu extends Menu {

	/**
	* Returns the title "Main Menu" to user
	* @return string
	*/
    @Override
    protected String getTitle() {
        return "Main Menu";
    }

	/**
	* Returns null since there is no description for this menu
	* @return null
	*/
    @Override
    protected String getDescription() {
        return null;
    }

	/**
     * The getMenuItems method
	* Method returns an array of Menu Items
	* @return array
	*/
    @Override
    protected MenuItem[] getMenuItems() {
		//Array of main menu items
        MenuItem[] menuItems = new MenuItem[]{
                new MenuItem('1', "Change interest rate and loan period"),
                new MenuItem('2', "View all properties"),
                new MenuItem('3', "Add property"),
                new MenuItem('4', "Remove Property"),
                new MenuItem('X', "Exit"),
        };
        return menuItems;
    }

	/**
	* Return boolean value to decide whether menu runs again or not
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
            //Change interest rate and loan period
            changeRateAndLoan();
            return true;
        //If user enters 2, this block runs
        } else if (key == '2') {
            //Display all addresses and data
            displayAll();
            return true;
        //If user enters 3, this block runs
        } else if (key == '3') {
            // Display the Add Menu description and options
           AddMenu menu =  new AddMenu();
           return menu.display();
		//If user enters 4, this block runs
        } else if (key == '4') {
            //Return data file back to check if empty
            ArrayList<Residence> newData;
            newData = Storage.returnData();
            //Run if data file isn't empty
            if (newData.size() != 0) {
                // Display the Remove Menu title and options
                RemoveMenu rmenu = new RemoveMenu();
                return rmenu.display();
            } else {
                System.out.println("\nThere are currently no properties in the list to remove.");
            }
		//Else user enters anything other than above options, main menu prints again
        } else {
            System.out.println("Enter valid selection for Main Menu.");
            return true;
        }
        return true;
    }

    /**
     * The changeRateAndLoan Method
     * This method prints out prompts to change the interest rate and loan period. New values are saved to a file
     */
    public static void changeRateAndLoan() {
        //Needed a boolean condition for the do-while loop
        boolean validInput = false;

        //Create new properties instance
        ReadWriteProperties props = new ReadWriteProperties();
        try {
            props.loadProperties();
            //Change values in Residence file of loanPeriod and interestRate
            Residence.loanPeriod = props.getLoanPeriod();
            Residence.interestRate = props.getInterestRate();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        //Keeps current interest rate and loan period display out of the loop so it doesn't display if user has to
        //re-enter
        System.out.println();
        System.out.format("Current loan interest rate is: %5.3f%%\n", Residence.interestRate);
        System.out.println("Current loan period in years is: " + Residence.loanPeriod);

        //Sets up a try-catch in a do-while loop, so interest rate option will loop again if it catches
        do {
            try {
                //Initial prompt for new interest rate
                String newRate = prompt("Enter a new interest rate percent (example: 5.25): ",
                        true);
                double rate = Double.parseDouble(newRate);
                //Set new rate to property and variable
                props.setInterestRate(rate);
                Residence.interestRate = rate;

                //Make sure the rate is not less than 1%, or not greater than or equal to 100%
                if (Residence.interestRate < 1 || Residence.interestRate >= 100) {
                    System.out.println("The rate must be a positive value that is between 1 and 100.\n");
                }
                //If the input fits within the requested values
                else {
                    //This line ends the loop
                    validInput = true;
                    //This display will return the new rate that was passed in
                    System.out.format("Your new interest rate is: %5.3f%%\n", Residence.interestRate);
                }
            } catch (NumberFormatException ex) {
                System.out.println("The rate must be a positive value that is between 1 and 100.\n,");
            }
        } while (!validInput);

        do {
            validInput = false;
            try {
                //Prompt to enter loan period
                String loanPeriod = prompt("Enter the loan period in years (ex. 30): ", true);
                int loanYears = Integer.parseInt(loanPeriod);

                //Make sure rate is not less than 1% or greater than/equal to 100%
                if (Residence.loanPeriod < 1 || Residence.loanPeriod > 30) {
                    System.out.println("The loan period must be a positive value that is between 1 and 30 inclusive.\n");
                }
                //If the input fits within the requested values
                else {
                    //props.setLoanPeriod(loanYears);
                    Residence.loanPeriod = loanYears;
                    props.setLoanPeriod(loanYears);

                    //This line ends the loop
                    validInput = true;

                    //This display will return the new rate that was passed in
                    System.out.format("Your new loan period is: " + Residence.loanPeriod);
                    System.out.println();
                }
            } catch (NumberFormatException ex) {
                System.out.println("The loan period must be a positive value that is between 1 and 30.");
            }
        } while (!validInput);

        //Let user know main menu will reload
        System.out.println();
        System.out.println("Returning to the Main Menu...");

        //Delay printing main menu
        delay(2000);
    }

    /**
     * The displayAll method
     * Print out all Residence type headers and corresponding data tables
     */
    public static void displayAll() {
        //Load data from file and create ArrayList
        ArrayList<Residence> newData;
        newData = Storage.returnData();

        //Create instance for each subclass type of property
        House newHouse = new House();
        Condo newCondo = new Condo();
        Multiplex newMultiplex = new Multiplex();

        //Call tableHeader method to display table header and loop printing list of type of property.
        //House
        System.out.println(newHouse.tableHeader());
        for (Residence r : newData) {
            if (r instanceof House) {
                House h = (House) r;
                System.out.println(h.toString());
            }
        }

        //Condo
        System.out.println();
        System.out.println(newCondo.tableHeader());
        for (Residence r : newData) {
            if (r instanceof Condo) {
                Condo c = (Condo) r;
                System.out.println(c.toString());
            }
        }

        //Multiplex
        System.out.println(newMultiplex.tableHeader());
        for (Residence r : newData) {
            if (r instanceof Multiplex) {
                Multiplex m = (Multiplex) r;
                System.out.println(m.toString());
            }
        }
    }
}