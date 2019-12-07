/**
 * Test driver for residence, condo, house, and multiplex
 */
public class RealEstateInvestmentTool {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {

        //Welcome message
        System.out.println("Welcome to the Property Investment Tool.");

        //Tells the user what the program does.
        System.out.println("This tool is compiles a list of investment properties that are available for purchase, \n" +
                "maintains and display data for each, and helps find the best investment. Properties can be \n" +
                "removed or added by the user.\n");

        //Displays main menu to the user
        System.out.println("Please select an option:");
        new MainMenu().display();

        //Displays a goodbye message.
        System.out.println();
        System.out.println("Goodbye...");
    }
}
