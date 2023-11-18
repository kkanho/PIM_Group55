import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class PIM  {

    //init
    PIR pirs[] = new PIR[99];
    int pir_id = 0;

    //constructor
    public PIM(){
        //init
        mainScreen(); //return to main screen
    }

    Scanner scanner = new Scanner(System.in);
    Scanner scannerForLine = new Scanner(System.in);

    public void mainScreen() {

        System.out.print("\033c"); //clear screen

        //prompt user to select the functionality
        System.out.println("Welcome to PIM system!!!\n\n"
                        + "***** P - I - M *****\n"
                        + "[1] Create a PIR\n"
                        + "[2] Remove a PIR\n"
                        + "[3] Modified a PIR\n"
                        + "[4] Load a PIR\n"
                        + "[5] Show specify PIR\n"
                        + "[6] Show all existing PIRs\n"
                        + "[7] Export all PIRs\n"
                        + "[8] Quit\n"
                        + "*********************");
        System.out.print("Select a function(1 - 8): ");
        int userInput = scanner.nextInt();

        switch(userInput) {
            
            case 1: 
                createPIR(pirs, pir_id);
                break;
            case 2: 
                removePIR(pirs);
                break;
            case 3:
                modifyExistingPIR(pirs, pir_id);
                break;
            case 4:
                loadPIR(pirs, pir_id);
                break;
            case 5: 
                searchPIRByType(pirs);
                break;
            case 6: 
                showAllPIRs(pirs);
                pressEnterToContinue();
                mainScreen(); //return to main screen
                break;
            case 7: 
                exportAllPIRs(pirs);
                break;
            case 8: 
                quit();
                break;
            default:
                System.out.println("Please select a valid number!!!"); 
                mainScreen(); //return to main screen
        }
    }

    public void createPIR(PIR[] pirs, int pir_id) {

        System.out.print("\033c"); //clear screen

        //prompt user to select the type of PIR to be created
        System.out.println("Please select desire PIR type!!!\n\n"
                + "***** P - I - M *****\n"
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
                createTextPIR("create", pir_id);
                updatePIRId();
                break;
            case 2: 
                createTaskPIR("create", pir_id);
                updatePIRId();
                break;
            case 3:
                createContactPIR("create", pir_id);
                updatePIRId();
                break;
            case 4:
                createEventPIR("create", pir_id);
                updatePIRId();
                break;
            case 5: 
                mainScreen(); //return to main screen
                break;

            default:
                System.out.println("Please select a valid number!!!"); 
                createPIR(pirs, pir_id);
        }

        mainScreen(); //return to main screen
    }
    
    public void removePIR(PIR[] pirs) {

        System.out.print("\033c"); //clear screen

        if(showAllPIRs(pirs)) { //able to show the list of PIRs
            //prompt user's input
            System.out.print("Please enter PIR id you want to remove: ");
            int intID = scanner.nextInt();
            
            //remove
            pirs[intID] = null;
            System.out.println("Removed!");
        }
        pressEnterToContinue();
        
        
        mainScreen(); //return to main screen
    }

    public void modifyExistingPIR(PIR[] pirs, int pir_id) {

        System.out.print("\033c"); //clear screen

        if(showAllPIRs(pirs)) {  //able to show the list of PIRs
            //prompt user's input
            System.out.print("Please enter PIR id you want to modify: ");
            int modifyID = scanner.nextInt();
            if (pirs[modifyID] == null){
                System.out.println("That PIR is empty");
                pressEnterToContinue();
            } else {
                if(pirs[modifyID].getType() == "Text") {
                    System.out.println(pirs[modifyID].toString());
                    createTextPIR("modify", modifyID);
                } else if (pirs[modifyID].getType() == "Task") {
                    System.out.println(pirs[modifyID].toString());
                    createTaskPIR("modify", modifyID);
                } else if (pirs[modifyID].getType() == "Contact") {
                    System.out.println(pirs[modifyID].toString());
                    createContactPIR("modify", modifyID);
                } else if (pirs[modifyID].getType() == "Event") {
                    System.out.println(pirs[modifyID].toString());
                    createEventPIR("modify", modifyID);
                }
            }
        }
        
        mainScreen(); //return to main screen
    }
    
    public void loadPIR(PIR[] pirs, int id) {
    
        String path = "./export/PIM.pim";
        Scanner scannerForFile = null;
        int counter = id;

        try {
            File file = new File(path);
            scannerForFile = new Scanner(file);
            
            while (scannerForFile.hasNextLine()) {
                // scannerForFile.nextLine() // ID: 0, Type: Text, Description: text1
                String temp = scannerForFile.nextLine();

                //create the pir according to the type
                if (temp.contains("Type: Text,")) {

                    String desc = temp.substring(temp.indexOf(", Description: ")+15, temp.indexOf(";"));
                    pirs[counter]= new Text(counter,"Text",desc);
                    counter += 1;

                } else if (temp.contains("Type: Task,")){
                    String desc = temp.substring(temp.indexOf(", Description: ")+15, temp.indexOf(", Deadline: "));
                    String deadline = temp.substring(temp.indexOf(", Deadline: ")+12, temp.indexOf(";"));
                    pirs[counter]= new Task(counter,"Task",desc,deadline);
                    counter += 1;

                } else if (temp.contains("Type: Contact,")) {
                    String name = temp.substring(temp.indexOf(", Name: ")+8, temp.indexOf(", Address: "));
                    String address = temp.substring(temp.indexOf(", Address: ")+11, temp.indexOf(", Mobile Number: "));
                    String mobile_number = temp.substring(temp.indexOf(", Mobile Number: ")+17, temp.indexOf(";"));
                    pirs[counter]= new Contact(counter,"Contact",name,address,mobile_number);
                    counter += 1;

                } else if (temp.contains("Type: Event,")){
                    String desc = temp.substring(temp.indexOf(", Description: ") + 15, temp.indexOf(", Start Time: "));
                    String start_time = temp.substring(temp.indexOf(", Start Time: ") + 14, temp.indexOf(", Alarm: "));
                    String alarm = temp.substring(temp.indexOf(", Alarm: ") + 9, temp.indexOf(";"));
                    pirs[counter] = new Event(counter,"Event",desc, start_time,(alarm.contains("ON"))?true:false);
                    counter += 1;
                }

                while(pir_id < counter) {
                    updatePIRId();
                }
            }
            System.out.println("Load successful!!!");
            pressEnterToContinue();
            // System.out.println(scannerForFile.nextLine());
            

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            scannerForFile.close();
        }

        
        mainScreen(); //return to main screen
    }

    public void searchPIRByType(PIR[] pirs) {

        System.out.print("\033c"); //clear screen

        //prompt user's input
        System.out.println("Please enter type you want to search by!!!\n\n"
                + "***** P - I - M *****\n"
                + "[1] Text\n"
                + "[2] Task\n"
                + "[3] Contact\n"
                + "[4] Event\n"
                + "[5] Back\n"
                + "*********************");
        System.out.print("Select a type(1 - 5): ");
        int userInput = scanner.nextInt();
        
        String searchType = "";
        
        switch (userInput) {
            case 1:
                searchType = "Text";
                for(int i = 0; i < pirs.length; i++){
                    if(pirs[i] != null && pirs[i].getType() == searchType){
                        System.out.print(pirs[i].toString());
                    }
                }
                break;
            case 2:
                searchType = "Task";
                for(int i = 0; i < pirs.length; i++){
                    if(pirs[i] != null && pirs[i].getType() == searchType){
                        System.out.print(pirs[i].toString());
                    }
                }
                break;
            case 3:
                searchType = "Contact";
                for(int i = 0; i < pirs.length; i++){
                    if(pirs[i] != null && pirs[i].getType() == searchType){
                        System.out.print(pirs[i].toString());
                    }
                }
                break;
            case 4:
                searchType = "Event";
                for(int i = 0; i < pirs.length; i++){
                    if(pirs[i] != null && pirs[i].getType() == searchType){
                        System.out.print(pirs[i].toString());
                    }
                }
                break;
            case 5:
                mainScreen(); //return to main screen
                break;
            default:
                System.out.println("Invalid type!");
                break;
        }

        pressEnterToContinue();
        
        mainScreen(); //return to main screen
    }

    public boolean showAllPIRs(PIR[] pirs) {
    
        boolean isEmptyPIM = true;

        System.out.print("\033c"); //clear screen

        System.out.println("***** P - I - M *****");
        for(int i = 0; i < pirs.length; i++){
            if(pirs[i] != null){
                System.out.print(pirs[i].toString());
                isEmptyPIM = false;
            }
        }
        if (isEmptyPIM) {
            System.out.println("PIM is empty!!!");
            return false;
        }
        System.out.println("*********************");
        
        return true;
    }

    public void exportAllPIRs(PIR[] pirs) {
        String path ="./export/PIM.pim";
        File file = new File(path);
        try {
            boolean flag = file.createNewFile();

            if(flag){
                System.out.println(".PIM Created!");
            }else {
                System.out.println("PIM already created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
        
        FileOutputStream fos = new FileOutputStream(path,true);
        for(int i = 0; i < pirs.length; i++){
            if(pirs[i] != null){
            byte b[]=pirs[i].toString().getBytes();
            fos.write(b);}
        }
        fos.close();
        System.out.println("Saved");
        } catch(Exception e)
        {
            System.out.println("not Saved");
            e.printStackTrace();
        }
        pressEnterToContinue();
        
        mainScreen(); //return to main screen

    }

    public void quit() {
        System.out.println("Thank you for using this system");
        System.exit(0); 
    }

    public void updatePIRId() {
        pir_id += 1;
    }

    private void pressEnterToContinue() { 
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        }  
        catch(Exception e) {
            System.out.println("Error: " + e);
        }  
    }

    public void createTextPIR(String func, int id){ 
        // System.out.print("\033c"); //clear screen
        System.out.print("Please input Description: ");
        String Description = scannerForLine.nextLine();
        pirs[id]= new Text(id,"Text",Description);
        System.out.println("PIR(text) " + func + " successful!!!");
        pressEnterToContinue();
    }
    public void createTaskPIR(String func, int id){ 
        // System.out.print("\033c"); //clear screen
        System.out.print("Please input Description: ");
        String Description2 = scannerForLine.nextLine();
        System.out.print("Please input Deadline: ");
        String Deadline = scannerForLine.nextLine();
        pirs[id]= new Task(id,"Task",Description2,Deadline);
        System.out.println("PIR(task) " + func + " successful!!!");
        pressEnterToContinue();
    }
    public void createContactPIR(String func, int id){
        // System.out.print("\033c"); //clear screen
        System.out.print("Please input Name: ");
        String name = scannerForLine.nextLine();
        System.out.print("Please input Address: ");
        String address = scannerForLine.nextLine();
        System.out.print("Please input mobile number： ");
        String mobile_number = scannerForLine.nextLine();
        pirs[id]= new Contact(id,"Contact",name,address,mobile_number);
        System.out.println("PIR(contact) " + func + " successful!!!");
        pressEnterToContinue();
    }
    public void createEventPIR(String func, int id){
        // System.out.print("\033c"); //clear screen
        System.out.print("Please input Description: ");
        String Description3 = scannerForLine.nextLine();
        System.out.print("Please input start time: ");
        String start_time = scannerForLine.nextLine();
        System.out.println("(Alarm default No)");
        System.out.print("Alarm(Y/N): ");
        String alarm = scannerForLine.nextLine();
        pirs[id]= new Event(id,"Event", Description3, start_time, alarm.contains("Y")?true:false);
        System.out.println("PIR(event) " + func + " successful!!!");
        pressEnterToContinue();
    }
    
}

