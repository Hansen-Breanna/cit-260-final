//imports
import menu.Menu;
import menu.MenuItem;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Sub menu for Remove Property on Main Menu
 */
public class RemoveMenu extends Menu {

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
        return "Choose a type of property to remove.";
    }

    /**
     * The getMenuItems method
     * Return array of menu items
     * @return
     */
    @Override
    protected MenuItem[] getMenuItems() {
        //Array of Remove Property menu items
        MenuItem[] menuItems = new MenuItem[]{
                new MenuItem('1', "House"),
                new MenuItem('2', "Condo"),
                new MenuItem('3', "Multiplex"),
                new MenuItem('4', "Return to Main Menu"),
        };
        return menuItems;
    }

    /**
     * The handleMenuSelection method
     * Return boolean value to decide whether menu runs again or not
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
        } else if (key == '1') { //House
            //Run removeProperty method
            removeProperty("House");
            return true;
        //Else if user enters 2, this block runs
        } else if (key == '2') { //Condo
            removeProperty("Condo");
            return true;
        //Else if user enters 3, this block runs
        } else if (key == '3') { //Multiplex
            removeProperty("Multiplex");
            return true;
        //Else if user enters 4, this block runs
        } else if (key == '4') {
            //Display Main Menu
            new MainMenu().display();
            return true;
        //Else user enters anything other than above options, main menu prints again
        } else {
            System.out.println("Enter valid selection.");
            return true;
        }
    }

    /**
     * The removeProperty Method
     * Removes selected property from data file
     * @param type of residence as a string
     */
    public static void removeProperty(String type) throws IOException {
        //Load Variable type data from file

        //TODO wrap in try/catch block and add scanner
        ArrayList<Residence> residenceData = StoragePseudo.loadData("filename");
        ArrayList<Residence> residenceType = new ArrayList<>();
        for (Residence residence : residenceData) {
            //If statement to pull correct residences if type matches
            //residenceType.add();
        }
        //Display to user in a table
        for (Residence residence : residenceType) {
            //display address, beds, baths, purchasePrice
        }
        //Prompts user to choose a property to delete.
        System.out.print("Which property would you like to delete?");
        //take input
        //Asks user to confirm their selection, loops choice if no is selected
        //Displays new table
        //Writes new list to file
    }

}
