package b9_groub4project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class B9_groub4ProjectTest {

    public B9_groub4ProjectTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class B9_groub4Project.
     */
    @Ignore
    @Test
    public void testMain() {

    }

    /**
     * Test of displayWelcomeMessage method, of class B9_groub4Project.
     */
    @Test
    public void testDisplayWelcomeMessage() {
        System.out.println("DisplayWelcomeMessage");
        String expectedOutput = "----------------------------------------------------------\n"
                + "\t\tWelcome to STLA World\n"
                + "----------------------------------------------------------\n"
                + "B: Bumper cars          20SR          12 Tickets left\n"
                + "P: Pirate Ship          15SR          20 Tickets left\n"
                + "D: Drop tower           25SR          5 Tickets left\n"
                + "G: Giant Wheel          30SR          25 Tickets left\n"
                + "S: Ice skating          30SR          20 Tickets left\n"
                + "E: Confirm and Exit\n"
                + "----------------------------------------------------------\n";
        assertEquals(expectedOutput, B9_groub4Project.displayWelcomeMessage());
    }

    /**
     * Test of isCorrectMobile method, of class B9_groub4Project.
     */
    @Test
    public void testIsCorrectMobile() {
        System.out.println("IsCorrectMobile");
        String Mobile = "0555555555";
        assertTrue(B9_groub4Project.isCorrectMobile(Mobile));
    }

    /**
     * Test of isCorrectEmail method, of class B9_groub4Project.
     */
    @Test
    public void testIsCorrectEmail() {
        System.out.println("IsCorrectEmail");
        String email = "Asmaa@gmail.com";
        assertTrue(B9_groub4Project.isCorrectEmail(email));
    }

    /**
     * Test of selectDate method, of class B9_groub4Project.
     */
    @Ignore
    @Test
    public void testSelectDate() {

    }

    /**
     * Test of selectEvent method, of class B9_groub4Project.
     */
    @Ignore
    @Test
    public void testSelectEvent() {

    }

    /**
     * Test of calculatePrice method, of class B9_groub4Project.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        B9_groub4Project.calculatePrice();
        int expPrice = B9_groub4Project.BQua * B9_groub4Project.BPrice + B9_groub4Project.PQua * B9_groub4Project.PPrice
                + B9_groub4Project.SQua * B9_groub4Project.SPrice + B9_groub4Project.GQua * B9_groub4Project.GPrice
                + B9_groub4Project.DQua * B9_groub4Project.DPrice;

        assertEquals(expPrice, B9_groub4Project.total);

    }

    /**
     * Test of invoice method, of class B9_groub4Project.
     */
    @Test
    public void testInvoice() {
        System.out.println("Invoice");
        String expected = "";
        expected += "\n\n****************** INVOICE ********************";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        expected += "\nDate: " + dtf.format(now);
        expected += "\nBill to: Maha";
        expected += "\n";
        expected += "\nItem              Quantity          Item Total";
        if (B9_groub4Project.BQua != 0) {
            expected += "\nBumper cars          " + B9_groub4Project.BQua + "                 " + B9_groub4Project.BQua * B9_groub4Project.BPrice;
        }
        if (B9_groub4Project.PQua != 0) {
            expected += "\nPirate Ship          " + B9_groub4Project.PQua + "                 " + B9_groub4Project.PQua * B9_groub4Project.PPrice;
        }
        if (B9_groub4Project.SQua != 0) {
            expected += "\nIce skating          " + B9_groub4Project.SQua + "                 " + B9_groub4Project.SQua * B9_groub4Project.SPrice;
        }
        if (B9_groub4Project.GQua != 0) {
            expected += "\nGiant Wheel          " + B9_groub4Project.GQua + "                 " + B9_groub4Project.GQua * B9_groub4Project.GPrice;
        }
        if (B9_groub4Project.DQua != 0) {
            expected += "\nDrop tower           " + B9_groub4Project.DQua + "                 " + B9_groub4Project.DQua * B9_groub4Project.DPrice;
        }
        expected += "\n\nSubtotal: " + B9_groub4Project.total;

        double tax = B9_groub4Project.total * 0.15;
        expected += "\nTax: " + tax;
        expected += "\nTotal Price: " + (tax + B9_groub4Project.total);
        expected += "\n***********************************************";
        expected += "\n";
        assertEquals(expected, B9_groub4Project.invoice("Maha"));
    }

    /**
     * Test of generateTicket method, of class B9_groub4Project.
     */
    @Test
    public void testGenerateTicket() {
        System.out.println("generateTicket");
        String date = "01/03/2023  Wednesday ";
        String dateNo = date.substring(0, 10);
        String day = date.substring(10);

        String expected = "";
        expected += "\n\n\t\tSTLA WORLD\n";
        expected += "------------------TICKET---------------------\n";
        expected += "       Date: " + dateNo + "   | " + day;
        expected += "\n\t     4:00pm - 11:30pm";
        expected += "\n\t TICKET CODE: " + 543 + "-" + 876 + "-" + 001;
        expected += "\n---------------------------------------------\n\n";
        assertEquals(expected, B9_groub4Project.generateTicket(date));

    }

}
