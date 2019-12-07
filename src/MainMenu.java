import menu.Menu;
import menu.MenuItem;

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
        MenuItem[] menuItems = new MenuItem[] {
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
        if (key == 'X') {
            return false;
        }
        else {
            System.out.println(key);
            return true;
        }
    }
}
