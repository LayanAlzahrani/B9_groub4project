package b9_groub4project;

import java.util.Scanner;
import java.util.regex.*;

public class B9_groub4Project {

    public static void main(String[] args) {

        int BPrice = 20;
        int PPrice = 15;
        int DPrice = 25;
        int GPrice = 30;
        int SPrice = 30;

        while (true) {

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

            selectEvent();

            Scanner in = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String userName = in.nextLine();

            String mobileNum = "";

            while (!isCorrectMobile(mobileNum)) {
                System.out.print("Enter your Mobile Number (must be 10 digits and start with 0): ");
                mobileNum = in.next();
            }

            String userEmail = "";
            while (!isCorrectEmail(userEmail)) {
                System.out.print("Enter your Email: ");
                userEmail = in.nextLine();
            }

        }

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

    public static void selectEvent() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your selection: ");
        String select = input.next().toUpperCase();

        int BQua = 0;
        int PQua = 0;
        int DQua = 0;
        int SQua = 0;
        int GQua = 0;

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

}
