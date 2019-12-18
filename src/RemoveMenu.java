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
        System.out.println();
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
        //Check if data file is empty
        ArrayList<Residence> newData = Storage.returnData();
        if (newData.size() == 0) {
            System.out.println();
            System.out.println("There are no properties in the list to remove.");
            // Display the Main Menu title and options
            new MainMenu().display();
        }
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
            MainMenu mmenu = new MainMenu();
            return mmenu.display();
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
    public void removeProperty(String type) {
        //Load data from file and create ArrayList
        ArrayList<Residence> residenceData = Storage.returnData();

        try {
            //Display table by type
            tableType(residenceData, type);
            System.out.println();

            //Intiailize variables for choosing
            String choice = "";
            String choose = "";
            int pickedNumber = 0;

            //Prompts user to choose a property to delete.
                do {
                    choose = Menu.prompt("Which property would you like to delete? (choose X for none or if" +
                                    " list is empty):",
                            true);
                    //Change choice to integer if not an X or x
                    if (choose.toUpperCase().charAt(0) != 'X') {
                        pickedNumber = Integer.parseInt(choose);
                    } else {
                        System.out.println("Property list is empty or none chosen.");
                        return;
                    }

                    //Check to see if user enters an invalid number
                    if ((residenceData.size() < pickedNumber) || (pickedNumber < 1)) {
                        System.out.println("\nProperty number does not exist. Please try again.");
                        return;
                    }
                    //Asks user to confirm their selection, loops choice if no is selected
                    choice = Menu.prompt("You selected " + choose + ". Is this correct? (Y or N) ",
                            true);
                    if (choice.toUpperCase().charAt(0) == 'Y') {
                        //remove selected data
                        int number = pickedNumber - 1;
                        residenceData.remove(number);
                        //Displays new table and saves to file

                    } else if (choice.toUpperCase().charAt(0) == 'N') {
                        //continue through to while
                    } else {
                        //Display statement and display Main Menu again
                        System.out.println("Enter valid selection.");
                    }
                } while (choice.toUpperCase().charAt(0) != 'Y');

            //Writes new list to file
            Storage.storeData("data.txt", residenceData);

            //Notifies user property is removed
            System.out.println("Choice " + choose + "has been removed from the list.");
        } catch (IOException ex) {
            System.out.println("Could not find file.");
        }
    }

    /**
     * The tableType method
     * This method chooses which type of property table to display
     * @param residenceData
     * @param type
     */
    public static void tableType(ArrayList<Residence> residenceData, String type) {
        int count = 0;
        switch (type) {
            case "House":
                //Create new instance
                House newHouse = new House();
                //Display table header
                System.out.println(newHouse.tableHeader());
                //Display table data
                for (Residence residence: residenceData) {
                    count ++;
                    if (residence instanceof House) {
                        System.out.print(count + ". ");
                        House h = (House) residence;
                        System.out.println(h.toString());
                    }
                }
                break;
            case "Condo":
                //Create new instance
                Condo newCondo = new Condo();
                //Display table header
                System.out.println(newCondo.tableHeader());
                //Display table data
                for (Residence residence: residenceData) {
                    count ++;
                    if (residence instanceof Condo) {
                        System.out.print(count + ". ");
                        Condo c = (Condo) residence;
                        System.out.println(c.toString());
                    }
                }
                break;
            case "Multiplex":
                //Create new instance
                Multiplex newMulti = new Multiplex();
                //Display table header
                System.out.println(newMulti.tableHeader());
                //Display table data
                for (Residence residence: residenceData) {
                    count ++;
                    if (residence instanceof Multiplex) {
                        System.out.print(count + ". ");
                        Multiplex m = (Multiplex) residence;
                        System.out.println(m.toString());
                    }
                }
                break;
        }
    }
}