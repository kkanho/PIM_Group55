import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victor_tsang
 */
public class JUnitProgram {

    private PIM pim = null;
    private PIR pirs[] = new PIR[99];
    private Text text, text_remove, text_modify;
    private Task task, task_remove, task_modify;
    private Contact contact, contact_remove, contact_modify;
    private Event event, event_remove, event_modify;

    @Before
    public void setUp() {
        //Initialize the PersonalInformationManager before each test
        //pim = new PIM();
        //int[] pir = new int[pirs.length - 1];
        pirs[0] = text = new Text(0, "Text", "PolyU");
        pirs[1] = task = new Task(1, "Task", "Project", "2024-11-22");
        pirs[2] = contact = new Contact(2, "Contact", "John", "HongKong", "98765432");
        pirs[3] = event = new Event(3, "Event", "Exam", "2024-12-13", true);
        pirs[4] = text_remove = new Text(4, "Text", "PolyU_Remove");
        pirs[5] = task_remove = new Task(5, "Task", "Project_Remove", "2024-11-22_Remove");
        pirs[6] = contact_remove = new Contact(6, "Contact", "John_Remove", "HongKong_Remove", "98765432_Remove");
        pirs[7] = event_remove = new Event(7, "Event", "Exam_Remove", "2024-12-13_Remove", true);
        pirs[8] = text_modify = new Text(8, "Text", "PolyU");
        pirs[9] = task_modify = new Task(9, "Task", "Project", "2024-11-22");
        pirs[10] = contact_modify = new Contact(10, "Contact", "John", "HongKong", "98765432");
        pirs[11] = event_modify = new Event(11, "Event", "Exam", "2024-12-13", true);

    }

    /**
     * Test of Create Text method, of class PIM.
     */
    @Test
    public void testCreateText() {
        System.out.println("@testCreateText");
        pirs[20] = new Text(0, "Text", "PolyU"); // Add the text to the personal information manager
        String expected = text.toString();
        String result = pirs[20].toString();
        assertEquals(expected, result); // Verify that the text was created successfully
        System.out.println("Expected Test: " + expected + "Result Test: " + result);
    }

    /**
     * Test of Create Task method, of class PIM.
     */
    @Test
    public void testCreateTask() {
        System.out.println("@testCreateTask");
        pirs[21] = new Task(1, "Task", "Project", "2024-11-22"); // Add the task to the personal information manager
        String expected = task.toString();
        String result = pirs[21].toString();
        assertEquals(expected, result); // Verify that the task was created successfully
        System.out.println("Expected Test: " + expected + "Result Test: " + result);
    }

    /**
     * Test of Create Contact method, of class PIM.
     */
    @Test
    public void testCreateContact() {
        System.out.println("@testCreateContact");
        pirs[22] = new Contact(2, "Contact", "John", "HongKong", "98765432"); // Add the contact to the personal information manager
        String expected = contact.toString();
        String result = pirs[22].toString();
        assertEquals(expected, result); // Verify that the contact was created successfully
        System.out.println("Expected Test: " + expected + "Result Test: " + result);
    }

    /**
     * Test of Create Event method, of class PIM.
     */
    @Test
    public void testCreateEvent() {
        System.out.println("@testCreateEvent");
        pirs[23] = new Event(3, "Event", "Exam", "2024-12-13", true); // Add the event to the personal information manager
        String expected = event.toString();
        String result = pirs[23].toString();
        assertEquals(expected, result); // Verify that the event was created successfully
        System.out.println("Expected Test: " + expected + "Result Test: " + result);
    }

    /**
     * Test of Modify Text method, of class PIM.
     */
    @Test
    public void testModifyText() {
        System.out.println("@testModifyText");
        String before = text_modify.toString();
        pirs[8] = new Text(8, "Text_Modify", "PolyU_Modify"); // update the text to the personal information manager
        pirs[28] = new Text(8, "Text_Modify", "PolyU_Modify");
        String expected = pirs[28].toString();
        String result = pirs[8].toString();
        assertEquals(expected, result); // Verify that the text was updated successfully
        System.out.println("Before: \n" + before + "After: \n" + "Expected Test: " + expected + "Result Test: " + result);
    }

    /**
     * Test of Modify Task method, of class PIM.
     */
    @Test
    public void testModifyTask() {
        System.out.println("@testModifyTask");
        String before = task_modify.toString();
        pirs[9] = new Task(9, "Task", "Project_Mofify", "2024-11-22_Mofify"); // update the task to the personal information manager
        pirs[29] = new Task(9, "Task", "Project_Mofify", "2024-11-22_Mofify");
        String expected = pirs[29].toString();
        String result = pirs[9].toString();
        assertEquals(expected, result); // Verify that the task was updated successfully
        System.out.println("Before: \n" + before + "After: \n" + "Expected Test: " + expected + "Result Test: " + result);
    }

    /**
     * Test of Modify Contact method, of class PIM.
     */
    @Test
    public void testModifyContact() {
        System.out.println("@testModifyContact");
        String before = contact_modify.toString();
        pirs[10] = new Contact(10, "Contact", "John_Modify", "HongKong_Modify", "98765432_Modify"); // update the contact to the personal information manager
        pirs[30] = new Contact(10, "Contact", "John_Modify", "HongKong_Modify", "98765432_Modify");
        String expected = pirs[30].toString();
        String result = pirs[10].toString();
        assertEquals(expected, result); // Verify that the contact was updated successfully
        System.out.println("Before: \n" + before + "After: \n" + "Expected Test: " + expected + "Result Test: " + result);
    }

    /**
     * Test of Modify Event method, of class PIM.
     */
    @Test
    public void testModifyEvent() {
        System.out.println("@testModifyEvent");
        String before = event_modify.toString();
        pirs[11] = new Event(11, "Event", "Exam", "2024-12-13", true); // update the contact to the personal information manager
        pirs[31] = new Event(11, "Event", "Exam", "2024-12-13", true);
        String expected = pirs[31].toString();
        String result = pirs[11].toString();
        assertEquals(expected, result); // Verify that the contact was updated successfully
        System.out.println("Before: \n" + before + "After: \n" + "Expected Test: " + expected + "Result Test: " + result);
    }

    /**
     * Test of Remove Text method, of class PIM.
     */    
    @Test
    public void testRemoveText() {
        System.out.println("@testRemoveText");
        String before = pirs[4].toString();
        String searchType = "Text";
        for (int i = 0; i < pirs.length; i++) {
            if (pirs[i] != null && pirs[i].getType() == searchType) {
                pirs[i] = null;
            }
        }
        boolean result;

        if (pirs[4] == null) {
            result = true;
        } else {
            result = false;
        };
        assertTrue(result);
        System.out.println("Before: \n" + before + "After: \n" + pirs[4]);
    }
    
    /**
     * Test of Remove Task method, of class PIM.
     */    
    @Test
    public void testRemoveTask() {
        System.out.println("@testRemoveTask");
        String before = pirs[5].toString();
        String searchType = "Task";
        for (int i = 0; i < pirs.length; i++) {
            if (pirs[i] != null && pirs[i].getType() == searchType) {
                pirs[i] = null;
            }
        }
        boolean result;

        if (pirs[5] == null) {
            result = true;
        } else {
            result = false;
        };
        assertTrue(result);
        System.out.println("Before: \n" + before + "After: \n" + pirs[5]);
    }    

    /**
     * Test of Remove Contact method, of class PIM.
     */    
    @Test
    public void testRemoveContact() {
        System.out.println("@testRemoveContact");
        String before = pirs[6].toString();
        String searchType = "Contact";
        for (int i = 0; i < pirs.length; i++) {
            if (pirs[i] != null && pirs[i].getType() == searchType) {
                pirs[i] = null;
            }
        }
        boolean result;

        if (pirs[6] == null) {
            result = true;
        } else {
            result = false;
        };
        assertTrue(result);
        System.out.println("Before: \n" + before + "After: \n" + pirs[6]);
    }       

    /**
     * Test of Remove Event method, of class PIM.
     */    
    @Test
    public void testRemoveEvent() {
        System.out.println("@testRemoveEvent");
        String before = pirs[7].toString();
        String searchType = "Event";
        for (int i = 0; i < pirs.length; i++) {
            if (pirs[i] != null && pirs[i].getType() == searchType) {
                pirs[i] = null;
            }
        }
        boolean result;

        if (pirs[7] == null) {
            result = true;
        } else {
            result = false;
        };
        assertTrue(result);
        System.out.println("Before: \n" + before + "After: \n" + pirs[7]);
    }  

    /**
     * Test of Shown Text method, of class PIM.
     */    
    @Test
    public void testShowText() {
        System.out.println("@testShowText");     
        String searchType = "Text";
        for (int i = 0; i < pirs.length; i++) {
            if (pirs[i] != null && pirs[i].getType() == searchType) {
                System.out.println(pirs[i]);
            }
        }
        boolean result;

        if (pirs[0] != null && pirs[4] != null && pirs[8] != null) {
            result = true;
        } else {
            result = false;
        };
        assertTrue(result);
    }  

    /**
     * Test of Shown Task method, of class PIM.
     */    
    @Test
    public void testShowTask() {
        System.out.println("@testShowTask");     
        String searchType = "Task";
        for (int i = 0; i < pirs.length; i++) {
            if (pirs[i] != null && pirs[i].getType() == searchType) {
                System.out.println(pirs[i]);
            }
        }
        boolean result;

        if (pirs[1] != null && pirs[5] != null && pirs[9] != null) {
            result = true;
        } else {
            result = false;
        };
        assertTrue(result);
    } 

    /**
     * Test of Shown Contact method, of class PIM.
     */    
    @Test
    public void testShowContact() {
        System.out.println("@testShowContact");     
        String searchType = "Contact";
        for (int i = 0; i < pirs.length; i++) {
            if (pirs[i] != null && pirs[i].getType() == searchType) {
                System.out.println(pirs[i]);
            }
        }
        boolean result;

        if (pirs[2] != null && pirs[6] != null && pirs[10] != null) {
            result = true;
        } else {
            result = false;
        };
        assertTrue(result);
    } 

    /**
     * Test of Shown Contact method, of class PIM.
     */    
    @Test
    public void testShowEvent() {
        System.out.println("@testShowEvent");     
        String searchType = "Event";
        for (int i = 0; i < pirs.length; i++) {
            if (pirs[i] != null && pirs[i].getType() == searchType) {
                System.out.println(pirs[i]);
            }
        }
        boolean result;

        if (pirs[3] != null && pirs[7] != null && pirs[11] != null) {
            result = true;
        } else {
            result = false;
        };
        assertTrue(result);
    } 
    
}
