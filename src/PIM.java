import java.util.Scanner;

public class PIM  {

    //constructor
    public PIM(){
        //init
        mainScreen();
    }

    Scanner scanner = new Scanner(System.in);

    public void mainScreen() {

        //prompt user to select the functionality
        System.out.println("Welcome to PIM system!!!\n\n"
                        + "*********************\n"
                        + "[1] Create a PIR\n"
                        + "[2] Remove a PIR\n"
                        + "[3] Modified a PIR\n"
                        + "[4] Load a PIR\n"
                        + "[5] Show existing PIRs\n"
                        + "[6] Quit\n"
                        + "*********************");
        System.out.print("Select a function(1 - 6): ");

        int userInput = scanner.nextInt();

        switch(userInput) {
            case 1: 
                createPIR();
                break;
            case 2: 
                removePIR();
                break;
            case 3:
                modifyExistingPIR(); 
                break;
            case 4:
                loadPIR();
                break;
            case 5: 
                showPIRs();
                break;
            case 6: 
                quit();
                break;
            default:
                System.out.println("Please select a valid number!!!"); 
                mainScreen();
        }


    }

    public void createPIR() {

        // try {

            //prompt user to select the type of PIR to be created
            System.out.println("Please select desire PIR type!!!\n"
                    + "*********************\n"
                    + "[1] Text\n"
                    + "[2] Task\n"
                    + "[3] Content\n"
                    + "[4] Event\n"
                    + "[5] Back\n"
                    + "*********************");
            System.out.print("Select a type(1 - 5): ");
            int userInput = scanner.nextInt();

            switch(userInput) {
                case 1: 

                    break;
                case 2: 

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5: 
                    mainScreen();
                    break;

                default:
                    System.out.println("Please select a valid number!!!"); 
                    createPIR();
            }

        //return to main screen
        mainScreen();

        // }   catch(Exception e) {

        //     System.out.println("Error: " + e)

        //     //return to main screen
        //     mainScreen();
        // }

    }
    public void removePIR() {

        //return to main screen
        mainScreen();
    }
    public void modifyExistingPIR() {

        //return to main screen
        mainScreen();
    }
    public void showPIRs() {

        //return to main screen
        mainScreen();
    }
    public void loadPIR() {

        //return to main screen
        mainScreen();
    }
    public void quit() {
        System.out.println("Thank you for using this system");
        System.exit(0);
    }
}

