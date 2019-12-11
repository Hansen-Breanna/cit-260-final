import menu.Menu;
import menu.MenuItem;

/**
 *
 */
public class RemoveMenu extends Menu {
    @Override
    protected String getTitle() {
        return null;
    }

    @Override
    protected String getDescription() {
        return "Choose a type of property to remove.";
    }

    @Override
    protected MenuItem[] getMenuItems() {
        MenuItem[] menuItems = new MenuItem[]{
                new MenuItem('1', "House"),
                new MenuItem('2', "Condo"),
                new MenuItem('3', "Multiplex"),
                new MenuItem('4', "Return to Main Menu"),
        };
        return menuItems;
    }

    @Override
    protected boolean handleMenuSelection(char key) {
        if (key == 'X' || key == 'x') {
            return false;
        } else if (key == '1') {
            //Display prompts for house
            //Save data to file
            return true;
        } else if (key == '2') {
            //Display prompts for Condo
            //Save data to file
            return true;
        } else if (key == '3') {
            //Display prompts for Multiplex
            //Save data to file
            return true;
        } else if (key == '4') {
            new MainMenu().display();
            return true;
        } else {
            System.out.println("Enter valid selection.");
            return true;
        }
    }
}
