import menu.Menu;
import menu.MenuItem;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Method creates Main Menu to display to user
 */
public class MainMenu extends Menu {

	/**
	* Returns "Main Menu" to user
	* @return
	*/
    @Override
    protected String getTitle() {
        return "Main Menu";
    }

	/**
	* Returns null since there is no description for this menu
	* @return
	*/
    @Override
    protected String getDescription() {
        return null;
    }

	/**
	* Method returns an array of Menu Items
	* @return
	*/
    @Override
    protected MenuItem[] getMenuItems() {
		//Array of menu items
        MenuItem[] menuItems = new MenuItem[]{
                new MenuItem('1', "Change interest rate (default is 4.375%)"),
                new MenuItem('2', "View all properties"),
                new MenuItem('3', "Add property"),
                new MenuItem('4', "Remove Property"),
                new MenuItem('X', "Exit"),
        };
        return menuItems;
    }
	
	/** 
	* Return boolean value to decide whether menu runs again or not
	* @return 
	*/
    @Override
    protected boolean handleMenuSelection(char key) {
		//If user enters X, this block runs and menu quits
        if (key == 'X' || key == 'x') {
            return false;
			
		//If user enters 1, this block runs
        } else if (key == '1') {
        	//Create a new Residence object
            //Display prompt for changing interest rate
            //Set a local variable, since I couldn't figure out how to get the MainMenu to call Residence class
            Residence obj = new Residence();
            //Needed a boolean condition for the while loop
            boolean valid = false;

            //Keeps current interest rate display out of the loop so it doesn't display if user has to re-enter
            //also pulls the interestRate from the new Residence object & displays it
            System.out.format("%nCurrent loan interest rate is: " + (obj.getInterestRate()) + "%%");

            //Sets up a try-catch in a while loop, so it will loop again if it catches InputMismatchException
            while (!valid) {
                try {
                    var input = new Scanner(System.in);
                    //Initial prompt for new interest rate
                    System.out.format("%n" + "Enter a new interest rate percent (example: 5.25): ");
                    //Saves the input and passes that into the object's InterestRate setter
                    double newRate = input.nextDouble();
                    obj.setInterestRate(newRate);

                    //Make sure the rate is not less than 1%, or not greater than or equal to 100%
                    if (obj.getInterestRate() < 1 || obj.getInterestRate() >= 100) {
                        System.out.format("The rate must be a positive value that is between 1 and 100." + "%n");
                    }
                    //If the input fits within the requested values
                    else {
                        //This line ends the loop
                        valid = true;
                        //This display will return the new rate that was passed in
                        System.out.format("Your new interest rate is " + obj.getInterestRate() + "%%" + "%n");

                        //It returns to main menu by default, but this displays a message to user
                        //I need to look into how to store/return the newRate to Residence
                        System.out.println("\nReturning to the Main Menu...");

                        //Delay printing main menu
                        delay(2000);
                    }
                    return true;
                    //This will make sure that it will not accept non-numbers as input, and will loop
                } catch (InputMismatchException ex) {
                    System.out.println("Your input is not valid. It must be a number.");
                }
            }
		//If user enters 2, this block runs
        } else if (key == '2') {
            // Display all properties
            System.out.println("Display all listed properties...");
            //Open files containing property information and display in a table
            //Use Storage Class
            return true;
		//If user enters 3, this block runs
        } else if (key == '3') {
            // Display the sub menu title and options
            new AddMenu().display();
            return true;
		//If user enters 4, this block runs
        } else if (key == '4') {
            // Display the sub menu title and options
            new RemoveMenu().display();
            return true;
		//If user enters anything othan than above options, main menu prints again
        } else {
            System.out.println("Enter valid selection for Main Menu.");
            return true;
        }
        return true;
    }
}