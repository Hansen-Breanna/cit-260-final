import menu.Menu;
import menu.MenuItem;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class MainMenu extends Menu {
    @Override
    protected String getTitle() {
        return "Main Menu";
    }

    @Override
    protected String getDescription() {
        return null;
    }

    @Override
    protected MenuItem[] getMenuItems() {
        MenuItem[] menuItems = new MenuItem[]{
                new MenuItem('1', "Change interest rate (default is 4.375%)"),
                new MenuItem('2', "View all prroperties"),
                new MenuItem('3', "Add property"),
                new MenuItem('4', "Remove Property"),
                new MenuItem('X', "Exit"),
        };
        return menuItems;
    }

    @Override
    protected boolean handleMenuSelection(char key) {
        if (key == 'X' || key == 'x') {
            return false;
        } else if (key == '1') {
            //Display prompt for changing interest rate
            //Set a local variable, since I couldn't figure out how to get the MainMenu to call Residence class
            Residence obj = new Residence();
            //Needed a boolean condition for the while loop
            boolean valid = false;

            //Keeps current interest rate display out of the loop
            System.out.format("%nCurrent loan interest rate is: " + (obj.getInterestRate()) + "%%");

            //Sets up a try-catch in a while loop, so it will loop again if it catches InputMismatchException
            while (!valid) {
                try {
                    var input = new Scanner(System.in);
                    //Initial prompt for new interest rate
                    System.out.format("%n" + "Enter a new interest rate percent (example: 5.25): ");
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

        } else if (key == '2') {
            // Display all properties
            System.out.println("Display all listed properties...");
            return true;
        } else if (key == '3') {
            // Display the sub menu title and options
            new AddMenu().display();
            return true;
        } else if (key == '4') {
            // Display the sub menu title and options
            new RemoveMenu().display();
            return true;
        } else {
            System.out.println("Enter valid selection for Main Menu.");
            return true;
        }
        return true;
    }
}