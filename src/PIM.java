import java.util.Scanner;

public class PIM  {

    //constructor
    public PIM(){
        //init
        mainScreen();
    }

    public void mainScreen() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello There!");
        System.out.println("[1] Create a PIR");
        System.out.println("[2] Remove a PIR");
        System.out.println("[3] Modified a PIR");
        System.out.println("[4] Show existing PIRs");
        System.out.println("[5] Load a PIR");
        System.out.println("[6] Quit");
        System.out.print("Select an function: ");

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
                showPIRs();
                break;
            case 5: 
                loadPIR();
                break;
            case 6: 
                quit();
                break;
            default:
                System.out.println("Please select a valid number"); 
                mainScreen();
        }
    }

    public void createPIR() {

        //return to main screen
        mainScreen();
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

