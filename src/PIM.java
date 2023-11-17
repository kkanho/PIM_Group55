import java.util.*;

public class PIM  {

    //init
    PIR pirs[] = new PIR[99];
    int pir_id = 0;

    //constructor
    public PIM(){
        //init
        mainScreen();
    }

    Scanner scanner = new Scanner(System.in);
    Scanner scannerForLine = new Scanner(System.in);

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
                createPIR(pirs, pir_id);
                break;
            case 2: 
                removePIR(pirs, pir_id);
                break;
            case 3:
                // modifyExistingPIR(pirs, pir_id);
                break;
            case 4:
                // loadPIR(pirs, pir_id);
                break;
            case 5: 
                showAllPIRs(pirs);
                break;
            case 6: 
                quit();
                break;
            default:
                System.out.println("Please select a valid number!!!"); 
                mainScreen();
        }


    }

    public void createPIR(PIR[] pirs, int pir_id) {
        // try {

            //prompt user to select the type of PIR to be created

            System.out.println("Please select desire PIR type!!!\n"
                    + "*********************\n"
                    + "[1] Text\n"
                    + "[2] Task\n"
                    + "[3] Contact\n"
                    + "[4] Event\n"
                    + "[5] Back\n"
                    + "*********************");
            System.out.print("Select a type(1 - 5): ");
            int userInput = scanner.nextInt();

            switch(userInput) {
                case 1:
                    System.out.println("Please input Description");
                    String Description = scannerForLine.nextLine();
                    pirs[pir_id]= new Text(pir_id,"Text",Description);
                    updatePIRId();
                    break;
                case 2: 
                    System.out.println("Please input Description");
                    String Description2 = scannerForLine.nextLine();
                    System.out.println("Please input Deadline");
                    String Deadline = scannerForLine.nextLine();
                    pirs[pir_id]= new Task(pir_id,"Task",Description2,Deadline);
                    updatePIRId();

                    break;
                case 3:
                    System.out.println("Please input Name");
                    String name = scannerForLine.nextLine();
                    System.out.println("Please input Address");
                    String address = scannerForLine.nextLine();
                    System.out.println("Please input mobile number");
                    int mobile_number = scanner.nextInt();
                    pirs[pir_id]= new Contact(pir_id,"Contact",name,address,mobile_number);
                    updatePIRId();

                    break;
                case 4:
                    System.out.println("Please input Description");
                    String Description3 = scannerForLine.nextLine();
                    System.out.println("Please input start time");
                    String start_time = scannerForLine.nextLine();
                    System.out.println("Please input alarm");
                    Boolean alarm = false;
                    pirs[pir_id]= new Event(pir_id,"Contact",Description3,start_time,alarm);
                    updatePIRId();
                    break;
                case 5: 
                    mainScreen();
                    break;

                default:
                    System.out.println("Please select a valid number!!!"); 
                    createPIR(pirs, pir_id);
            }

        //return to main screen
        mainScreen();

        // }   catch(Exception e) {

        //     System.out.println("Error: " + e)

        //     //return to main screen
        //     mainScreen();
        // }

        // public createTextPIR() {
            
        // }

    }
    public void removePIR(PIR[] pirs, int pir_id) {

        //return to main screen
        mainScreen();
    }
    public void modifyExistingPIR(PIR[] pirs, int pir_id) {

        //return to main screen
        mainScreen();
    }
    public void showAllPIRs(PIR[] pirs) {

        for(int i = 0; i < pirs.length; i++){
            if(pirs[i] != null){
                System.out.println(pirs[i].toString());
            }
        }
        pressEnterToContinue();
    
        //return to main screen
        mainScreen();
    }
    public void loadPIR(PIR[] pirs, int pir_id) {

        //return to main screen
        mainScreen();
    }
    public void quit() {
        System.out.println("Thank you for using this system");
        System.exit(0);
    }

    public void updatePIRId() {
        pir_id += 1;
    }

    private void pressEnterToContinue(){ 
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        }  
        catch(Exception e) {
            System.out.println("Error: " + e);
        }  
    }
}

