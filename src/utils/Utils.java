package utils;

import values.Strings;

import java.util.Scanner;

/**
 * Utils class for static operations
 */
public class Utils {

    public static int getListChoiceFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Strings.CHOOSE_LIST);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getOperationChoiceFromUser(int listType) {
        Scanner scanner = new Scanner(System.in);
        if (listType == 1) {
            System.out.println(Strings.CHOOSE_OPERATION_DOUBLY);
        } else {
            System.out.println(Strings.CHOOSE_OPERATION_SINGLY);
        }
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getStudentNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please set the number");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    public static int getMajorIdFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please set the major id");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getIntegerFromUser(String toDisplay) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(toDisplay);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getIntegerStringFromUser(String toDisplay) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(toDisplay);
        try {
            String string = scanner.nextLine();
            Integer.parseInt(string);
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public static String getStringFromUser(String toDisplay) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(toDisplay);
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }


    public static int parseOperationChoiceFromUser(int choice, int listType) {
        if (listType == 0) {
            switch (choice) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                case 9:
                    return 9;
                case 10:
                    return 10;
                case 11:
                    return 11;
                case 12:
                    return 12;
                case 13:
                    return 13;
                case 14:
                    return 14;
                case 15:
                    return 15;
                case 16:
                    return 16;
                case 17:
                    return 17;
                default:
                    return -1;
            }
        } else {
            switch (choice) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                default:
                    return -1;
            }
        }
    }
}