import menu.Menu;
import menu.MenuItem;
import java.util.ArrayList;

/**
 * Submenu for option on MainMenu
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
        return "Choose a type of property to add.";
    }

    /**
     * Return array MenuItems
     * @return
     */
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

    /**
     * Handle user selection from Main Menu
     * @param key
     * @return
     */
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

            //Create new House instance
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
        } else if (key == '3') {  //multiplex

            //Check if data file exists

            //If data file doesn't exist, create it

            //Pull in ArrayList from file

            //Somehow pull in Residence to get interest rate?
            Residence newRes = new Residence();

            //Create new Multiplex
            Multiplex newMulti = new Multiplex();

            //Display prompts for Multiplex and set values for each variable. Make a method?
            String address = prompt("Enter address: ", true);
            newMulti.setAddress(address);
            String units = prompt("Enter number of units: ", true);
            newMulti.setUnits(Integer.parseInt(units));
            String beds = prompt("Enter number of bedrooms: ", true);
            newMulti.setBedrooms(Integer.parseInt(beds));
            String baths = prompt("Enter number of bathrooms (ex. 1.5): ", true);

            // Won't let me parse it as a double???
            newMulti.setBathrooms(Integer.parseInt(baths));
            String sqft = prompt("Enter square footage (ex. 1500): ", true);
            newMulti.setSqfeet(Integer.parseInt(sqft));
            String price = prompt("Enter purchase price (ex. 200000): ", true);
            newMulti.setPurchasePrice(Double.parseDouble(price));
            String taxes = prompt("Enter yearly homeowner's taxes (ex 1500): ", true);
            newMulti.setTaxes(Double.parseDouble(taxes));
            String utilities = prompt("Enter monthly utilities (ex 225): ", true);
            newMulti.setUtilities(Double.parseDouble(utilities));

            //Set loan period from same Menu prompt 1 when interest rate is changed?
            String loanPeriod = prompt("Enter the loan period in years (ex. 30): ", true);
            newRes.setLoanPeriod(Integer.parseInt(loanPeriod));

            //Add new multiplex to ArrayList

            //Save Arraylist to file

            //Display that property has been added
            System.out.println("\nMultiplex at " + newMulti.getAddress() + " has been added.");

            //Delay new list printout
            delay(2000);

            //Return polymorphic String of table header
            System.out.println(newMulti.toString());

            //For loop printing out all multiplexes on the ArrayList using the following format. Make another method?
            //Run methods from Residence class inside for loop? Make another method?
            double downPayment = newRes.downPayment(newMulti.getPurchasePrice(), newRes.getPERCENT_DOWN());
            double pricePerSqft = newRes.pricePerSqFt(newMulti.getPurchasePrice(), newMulti.getSqfeet());
            double rentalIncome = newRes.rentalIncome(newMulti.getSqfeet(), newRes.getRENT_PER_SQFT());
            double mortgage = newRes.monthlyPayment(newMulti.getPurchasePrice(), newRes.getInterestRate(),
                    newRes.getLoanPeriod());
            double profit = newMulti.monthlyNetProfit(mortgage, newMulti.getTaxes(), rentalIncome,
                    newMulti.getUtilities());

            //Table row layout for each property
            System.out.format("%-50s  %-5d   %-4d   %-5.2f   %-,6d   $%-,11.2f  $%-,9.2f  $%-,9.2f  $%-,10.2f   " +
                            "$%-,7.2f  $%-,9.2f  $%-,9.2f  $%-,8.2f%n", newMulti.getAddress(), newMulti.getUnits(),
                    newMulti.getBedrooms(), newMulti.getBathrooms(), newMulti.getSqfeet(), newMulti.getPurchasePrice(),
                    newMulti.getTaxes(), newMulti.getUtilities(), downPayment, pricePerSqft, mortgage, rentalIncome,
                    profit);

            //Delay displaying Main Menu so user has time to read MultiPlex list
            delay(7000);

            return true;
        } else if (key == '4') {
            //Display Main Menu
            new MainMenu().display();
            return true;
        } else {
            //Display statement and display Main Menu again
            System.out.println("Enter valid selection.");
            return true;
        }
    }
}
