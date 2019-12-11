import com.sun.tools.javac.Main;
import menu.Menu;
import menu.MenuItem;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class AddMenu extends Menu {
    @Override
    protected String getTitle() {
        return null;
    }

    @Override
    protected String getDescription() {
        return "Choose a type of property to add.";
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
            //Display prompts for House
            String address = prompt("Enter address: ", true);
            String beds = prompt("Enter number of bedrooms: ", true);
            int numBeds = Integer.parseInt(beds);
            String baths = prompt("Enter number of bathrooms (ex. 1.5): ", true);
            double numBaths = Double.parseDouble(baths);
            String sqft = prompt("Enter square footage (ex. 1500): ", true);
            int numSqft = Integer.parseInt(sqft);
            String lot = prompt("Enter acreage (ex. 0.25): ", true);
            double lotSize = Double.parseDouble(lot);
            String price = prompt("Enter purchase price (ex. 200000): ", true);
            double purPrice = Double.parseDouble(baths);
            String taxes = prompt("Enter yearly homeowner's taxes (ex 1500): ", true);
            double homeTaxes = Double.parseDouble(baths);

            House newHouse = new House(address, numBeds, numBaths, numSqft, lotSize, purPrice, homeTaxes);

            //Save data to file
            return true;
        } else if (key == '2') {
            //Display prompts for Condo
            String address = prompt("Enter address: ", true);
            String beds = prompt("Enter number of bedrooms: ", true);
            int numBeds = Integer.parseInt(beds);
            String baths = prompt("Enter number of bathrooms (ex. 1.5): ", true);
            double numBaths = Double.parseDouble(baths);
            String sqft = prompt("Enter square footage (ex. 1500): ", true);
            int numSqft = Integer.parseInt(sqft);
            String price = prompt("Enter purchase price (ex. 200000): ", true);
            double purPrice = Double.parseDouble(baths);
            String taxes = prompt("Enter yearly homeowner's taxes (ex 1500): ", true);
            double homeTaxes = Double.parseDouble(baths);
            String hoa = prompt("Enter HOA monthly fee (ex. 50): ", true);
            double hoaFee = Double.parseDouble(hoa);
            String amenities = prompt("Enter amenities (ex. pool, tennis court): ", true);

            Condo newCondo = new Condo(address, numBeds, numBaths, numSqft, purPrice, homeTaxes, hoaFee, amenities);

            //Save data to file
            return true;
        } else if (key == '3') {
                //Display prompts for Multiplex
                String address = prompt("Enter address: ", true);
                String units = prompt("Enter number of units: ", true);
                int numUnits = Integer.parseInt(units);
                String beds = prompt("Enter number of bedrooms: ", true);
                int numBeds = Integer.parseInt(beds);
                String baths = prompt("Enter number of bathrooms (ex. 1.5): ", true);
                double numBaths = Double.parseDouble(baths);
                String sqft = prompt("Enter square footage (ex. 1500): ", true);
                int numSqft = Integer.parseInt(sqft);
                String price = prompt("Enter purchase price (ex. 200000): ", true);
                double purPrice = Double.parseDouble(baths);
                String taxes = prompt("Enter yearly homeowner's taxes (ex 1500): ", true);
                double homeTaxes = Double.parseDouble(baths);
                String utilities = prompt("Enter monthly utilities (ex 225): ", true);
                double utilitiesCost = Double.parseDouble(baths);

                Multiplex newMulti = new Multiplex(address, numUnits, numBeds, numBaths, numSqft, purPrice, homeTaxes,
                        utilitiesCost);

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
