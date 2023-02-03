package b9_groub4project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class B9_groub4Project {

    static int BPrice = 20, PPrice = 15, DPrice = 25, GPrice = 30, SPrice = 30;
    static int BQua = 0, PQua = 0, DQua = 0, SQua = 0, GQua = 0, total = 0;
    static int B = 12, P = 20, Da = 5, S = 20, G = 25;

    public static void main(String[] args) {

        boolean flag = true;

        while (flag) {

            System.out.println("----------------------------------------------------------");
            System.out.println("\t\tWelcome to STLA World");
            System.out.println("----------------------------------------------------------");

            System.out.println("B: Bumper cars          20SR          " + B + " Tickets left");
            System.out.println("P: Pirate Ship          15SR          " + P + " Tickets left");
            System.out.println("D: Drop tower           25SR          " + Da + " Tickets left");
            System.out.println("G: Giant Wheel          30SR          " + G + " Tickets left");
            System.out.println("S: Ice skating          30SR          " + S + " Tickets left");
            System.out.println("E: Confirm and Exit");

            System.out.println("----------------------------------------------------------");
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your selection: ");
            String select = input.next().toUpperCase();

            if (select.equalsIgnoreCase("E")) {
                flag = false;
            } else {
                selectEvent(select);
            }

        }

        String date = selectDate();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = in.nextLine();

        String mobileNum = "";

        while (!isCorrectMobile(mobileNum)) {
            System.out.print("Enter your Mobile Number (must start with 05): ");
            mobileNum = in.next();
        }

        String userEmail = "";
        while (!isCorrectEmail(userEmail)) {
            System.out.print("Enter your Email: ");
            userEmail = in.next();
        }

        price();
        generateTicket(date);
        invoice(userName);

    }

    public static boolean isCorrectMobile(String mobileNum) {
        return mobileNum.startsWith("05") && mobileNum.length() == 10;
    }

    public static boolean isCorrectEmail(String userEmail) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userEmail);
        return matcher.matches();
    }

    public static String selectDate() {
        Scanner input = new Scanner(System.in);
        ArrayList<String> dateList = new ArrayList<>();
        dateList.add("01/03/2023  Wednesday ");
        dateList.add("02/03/2023  Thursday ");
        dateList.add("03/03/2023  Friday ");
        dateList.add("03/03/2023  Saturday ");
        dateList.add("05/03/2023  Sunday ");
        dateList.add("06/03/2023  Monday ");
        dateList.add("07/03/2023  Tuesday ");
        System.out.println("\nSelect the date of the event:");
        for (int i = 0; i < dateList.size(); i++) {
            System.out.println((i + 1) + ". " + dateList.get(i));
        }
        System.out.print("\nEnter your selection: ");
        int selection = input.nextInt();
        while (selection < 1 || selection > dateList.size()) {
            System.out.println("Invalid selection. Please choose a valid option.");
            selection = input.nextInt();
        }
        String selectedDate = dateList.get(selection - 1);
        System.out.println("You selected: " + selectedDate + "\n");
        return selectedDate;

    }

  public static void selectEvent(String select) {
    Scanner input = new Scanner(System.in);
    int quaTemp;

    switch (select) {
        case "B":
            quaTemp = askQuantity(input);
            BQua += quaTemp;
            B -= quaTemp;
            break;
        case "P":
            quaTemp = askQuantity(input);
            PQua += quaTemp;
            P -= quaTemp;
            break;
        case "D":
            quaTemp = askQuantity(input);
            DQua += quaTemp;
            Da -= quaTemp;
            break;
        case "G":
            quaTemp = askQuantity(input);
            GQua += quaTemp;
            G -= quaTemp;
            break;
        case "S":
            quaTemp = askQuantity(input);
            SQua += quaTemp;
            S -= quaTemp;
            break;
        case "E":
            if (BQua == 0 && PQua == 0 && SQua == 0 && GQua == 0 && DQua == 0) {
                System.out.println("Nothing Selected. See you again.");
                System.exit(0);
            }
        default:
            System.out.println("Wrong selection!");
    }
}

private static int askQuantity(Scanner input) {
    System.out.print("Quantity: ");
    return input.nextInt();
}

    public static void price() {

        int price = 0;

        if (BQua != 0) {
            price = BQua * BPrice;
            total += price;
        }
        if (PQua != 0) {
            price = PQua * PPrice;
            total += price;
        }
        if (SQua != 0) {
            price = SQua * SPrice;
            total += price;
        }
        if (GQua != 0) {
            price = GQua * GPrice;
            total += price;
        }
        if (DQua != 0) {
            price = DQua * DPrice;
            total += price;
        } else {
            total += 0;
        }
    }

    public static void invoice(String userName) {

        System.out.println("");
        System.out.println("****************** INVOICE ********************");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Date: " + dtf.format(now));
        System.out.println("Bill to: " + userName + "\n");

        System.out.println("Item              Quantity          Item Total");

        if (BQua != 0) {
            System.out.println("Bumper cars          " + BQua + "                 " + BQua * BPrice);
        }
        if (PQua != 0) {
            System.out.println("Pirate Ship          " + PQua + "                 " + PQua * PPrice);
        }
        if (SQua != 0) {
            System.out.println("Ice skating          " + SQua + "                 " + SQua * SPrice);
        }
        if (GQua != 0) {
            System.out.println("Giant Wheel          " + GQua + "                 " + GQua * GPrice);
        }
        if (DQua != 0) {
            System.out.println("Drop tower           " + DQua + "                 " + DQua * DPrice);
        }

        System.out.println("\nSubtotal: " + total);
        double tax = total * 0.15;
        System.out.println("Tax: " + tax);
        double totalPrice = total + tax;
        System.out.println("Total Price: " + totalPrice);
        System.out.println("***********************************************");
        System.out.println("");

    }

    public static void generateTicket(String date) {
        System.out.println("");
        int randomNumber1 = (int) (Math.random() * 999 + 100);
        int randomNumber2 = (int) (Math.random() * 999 + 100);
        int randomNumber3 = (int) (Math.random() * 999 + 100);
        String dateNo = date.substring(0, 10);
        String day = date.substring(10);

        System.out.println("\n\t\tSTLA WORLD");
        System.out.println("------------------TICKET---------------------");
        System.out.println("       Date: " + dateNo + "   | " + day);
        System.out.println("\t     4:00pm - 11:30pm");
        System.out.println("\t TICKET CODE: " + randomNumber1 + "-" + randomNumber2 + "-" + randomNumber3);
        System.out.println("---------------------------------------------");
        System.out.println("");

    }

}
