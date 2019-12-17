//imports
import menu.Menu;
import menu.MenuItem;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Method creates Main Menu to display to user
 */
public class MainMenu extends Menu {

    /**
     * Returns the title "Main Menu" to user
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
     * The getMenuItems method
     * Method returns an array of Menu Items
     * @return
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
            //Create a new Residence object to get interest rate
            Residence obj = new Residence();
            //Needed a boolean condition for the while loop
            boolean valid = false;

            //Keeps current interest rate display out of the loop so it doesn't display if user has to re-enter
            //also pulls the interestRate from the new Residence object & displays it
            System.out.format("Current loan interest rate is: %5.3f%%\n", (obj.getInterestRate()));

            //Sets up a try-catch in a while loop, so it will loop again if it catches InputMismatchException
            while (!valid) {
                try {
                    //Initial prompt for new interest rate
                    String newRate = prompt("Enter a new interest rate percent (example: 5.25): ",
                            true);
                    //Passes newRate into the object's InterestRate setter
                    obj.setInterestRate(Double.parseDouble(newRate));

                    //Make sure the rate is not less than 1%, or not greater than or equal to 100%
                    if (obj.getInterestRate() < 1 || obj.getInterestRate() >= 100) {
                        System.out.println("The rate must be a positive value that is between 1 and 100.\n");
                    }
                    //If the input fits within the requested values
                    else {
                        //This line ends the loop
                        valid = true;
                        //This display will return the new rate that was passed in
                        System.out.format("Your new interest rate is: %5.3f%%\n", (obj.getInterestRate()));

                        //Let user know main menu will reload
                        //TODO look into how to store/return the newRate to Residence
                        System.out.println("\nReturning to the Main Menu...");

                        //Delay printing main menu
                        delay(2000);
                    }

//                    //Prompt to enter loan period
//                    String loanPeriod = prompt("Enter the loan period in years (ex. 30): ", true);
//                    obj.setLoanPeriod(Integer.parseInt(loanPeriod));
//
//                    if (obj.getLoanPeriod() < 1 || obj.getLoanPeriod() > 30) {
//                        System.out.println("The rate must be a positive value that is between 1 and 30.\n");
//                    }
//                    //If the input fits within the requested values
//                    else {
//                        //This line ends the loop
//                        valid = true;
//                        //This display will return the new rate that was passed in
//                        System.out.format("Your new loan period is $d.\n" + obj.getLoanPeriod());
//
//                        //Let user know main menu will reload
//                        //TODO look into how to store/return the loanPeriod to Residence
//                        System.out.println("\nReturning to the Main Menu...");
//
//                        //Delay printing main menu
//                        delay(2000);
//                    }

                    return true;
                    //This will make sure that it will not accept non-numbers as input, and will loop
                } catch (InputMismatchException ex) {
                    System.out.println("Your input is not valid. It must be a number.");
                }
            }
            //If user enters 2, this block runs
        } else if (key == '2') {
            //Run loadData method
            //Write all data from file into tables by property types
            // Display all properties
            System.out.println("Display all listed properties...");
            return true;
            //If user enters 3, this block runs
        } else if (key == '3') {
            // Display the Add Menu description and options
            new AddMenu().display();
            return true;
            //If user enters 4, this block runs
        } else if (key == '4') {
            // Display the Remove Menu title and options
            new RemoveMenu().display();
            return true;
            //Else user enters anything other than above options, main menu prints again
        } else {
            System.out.println("Enter valid selection for Main Menu.");
            return true;
        }
        return true;
    }
}