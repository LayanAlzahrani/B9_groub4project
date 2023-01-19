package b9_groub4project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class B9_groub4Project {

    static int BPrice = 20, PPrice = 15, DPrice = 25, GPrice = 30, SPrice = 30;
    static int BQua = 0, PQua = 0, DQua = 0, SQua = 0, GQua = 0 ,total = 0;
    public static void main(String[] args) {

        
        boolean flag = true;

        while (flag) {

            System.out.println("-----------------------------------------------");
            System.out.println("\tWelcome to STLA World");
            System.out.println("-----------------------------------------------");

            System.out.println("B: Bumper cars          20SR");
            System.out.println("P: Pirate Ship          15SR");
            System.out.println("D: Drop tower           25SR");
            System.out.println("G: Giant Wheel          30SR");
            System.out.println("S: Ice skating          30SR");
            System.out.println("E: Confirm and Exit");

            System.out.println("-----------------------------------------------");
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your selection: ");
            String select = input.next().toUpperCase();

            if (select.equalsIgnoreCase("E")) {
                flag = false;
            } else {
                selectEvent(select);
            }
         
        }
        
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = in.nextLine();

        String mobileNum = "";

       while (!isCorrectMobile(mobileNum)) {
            System.out.print("Enter your Mobile Number (must be start with 05): ");
            mobileNum = in.next();
        }

        String userEmail = "";
        while (!isCorrectEmail(userEmail)) {
            System.out.print("Enter your Email: ");
            userEmail = in.nextLine();
        }
        selectDate(); 
        price();
        invoice();
        
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
public static void selectDate() {
    Scanner input = new Scanner(System.in);
    ArrayList<String> dateList = new ArrayList<>();
    dateList.add("01/03/2023  Wednesday ");
    dateList.add("02/03/2023  Thursday ");
    dateList.add("03/03/2023  Friday ");
    dateList.add("03/03/2023  Saturday ");
    dateList.add("05/03/2023  Sunday "); 
    dateList.add("06/03/2023  Monday ");
    dateList.add("07/03/2023  Tuesday ");
    System.out.println("Select the date of the event:");
    for (int i = 0; i < dateList.size(); i++) {
        System.out.println((i + 1) + ". " + dateList.get(i));
    }
    int selection = input.nextInt();
    while (selection < 1 || selection > dateList.size()) {
        System.out.println("Invalid selection. Please choose a valid option.");
        selection = input.nextInt();
    }
    String selectedDate = dateList.get(selection - 1);
    System.out.println("You selected: " + selectedDate);
}
    public static void selectEvent(String select) {

        Scanner input = new Scanner(System.in);
        
        switch (select) {
            case "B":
                System.out.print("Quantity: ");
                BQua += input.nextInt();
                break;
            case "P":
                System.out.print("Quantity: ");
                PQua += input.nextInt();
                break;
            case "D":
                System.out.print("Quantity: ");
                DQua += input.nextInt();
                break;
            case "G":
                System.out.print("Quantity: ");
                GQua += input.nextInt();
                break;
            case "S":
                System.out.print("Quantity: ");
                SQua += input.nextInt();
                break;
            case "E":
                if (BQua == 0 && PQua == 0 && SQua == 0 && GQua == 0 && DQua == 0) {
                    System.out.println("Nothing Selected. See you again.");
                    System.exit(0);
                }
        }
    }
    public static void price(){
        int price=0;
        if (BQua != 0 ){
            price = BQua * BPrice;
            total+= price;
        }
        if (PQua != 0 ){
            price = PQua * PPrice;
            total+= price;
        }
        if (SQua != 0 ){
            price = SQua * SPrice;
            total+= price;
        }
        if (GQua != 0 ){
            price = GQua * GPrice;
            total+= price;
        }
        if (DQua != 0 ){
            price = DQua * DPrice;
            total+= price;
        }
        else {
            total+= 0;
        }
        
        
    }
    public static void invoice(){
        System.out.println("");
        System.out.println("-----------------------------------------------");
        System.out.println("Subtotal: "+ total );
        double tax = total * 0.15;
        System.out.println("Tax: " + tax);
        double totalPrice = total+ tax;
        System.out.println("Total Price: "+ totalPrice);
        System.out.println("-----------------------------------------------");
    }
    public static void generateTicket(String userName) {
        
        
        
    }

}
