import interfaces.Listable;
import interfaces.Sortable;
import model.DoublyLinkedList;
import model.SinglyLinkedList;
import model.Student;
import model.comparator.DegreeNumberComparator;
import model.comparator.FirstNameComparator;
import model.comparator.SecondNameComparator;
import model.comparator.StudentNumberComparator;
import model.finders.FirstNameFinder;
import model.finders.LastNameFinder;
import model.finders.StudentDegreeProgrammFinder;
import model.sort.SelectionSort;
import utils.Utils;
import values.Strings;

import java.util.Scanner;

public class Main {

    private static ConsoleApplication consoleApplication;
    private static Scanner scanner;
    private static Listable<Student> list;
    private static boolean operationMenu;

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // Greetings
        System.out.println(Strings.GREETING);
        // scanner
        scanner = new Scanner(System.in);
        // start the program
        boolean mainMenu = true;
        consoleApplication = new ConsoleApplication();
        // Main menu. Get the list
        while (mainMenu) {
            boolean isCreated = createList();
            while (!isCreated) {
                isCreated = createList();
            }

            int listType;
            if (list instanceof DoublyLinkedList) {
                listType = 1;
            } else {
                listType = 0;
            }
            // Operation menu. Choose operation
            operationMenu = true;
            while (operationMenu) {
                int choice = consoleApplication.createOperation(listType);
                while (choice == -1) {
                    choice = consoleApplication.createOperation(listType);
                }
                if (choice == 0) {
                    System.exit(0);
                }
                // pass an operation choice to run
                // Singly
                if (listType == 0) {
                    singlyOperationChoice(choice);
                } else {
                    doublyOperationChoice(choice);
                }

            }
        }
    }

    /**
     * Create an element in the list
     */
    private static void createNewElement() {
        Student student1 = consoleApplication.runCreateNewElementOperation(list);
        while (student1 == null) {
            System.out.println("Error creating an element. Trying one more time");
            student1 = consoleApplication.runCreateNewElementOperation(list);
            // ask to quit
            if (askToMainMenu()) {
                break;
            }
        }
        // set parameter to the element
        setParameters(student1);
    }

    /**
     * Adds element as first
     */
    private static void addFirst() {
        System.out.println("Creating an element\n");
        Student student2 = new Student();
        setParameters(student2);
        System.out.println("Adding an element as the first element\n");
        list.addFirst(student2);
        list.printAll();
        System.out.println();
    }

    /**
     * Adds element as last
     */
    private static void addLast() {
        System.out.println("Creating an element\n");
        Student student3 = new Student();
        setParameters(student3);
        System.out.println("Adding an element as the last element\n");
        list.addLast(student3);
        list.printAll();
        System.out.println();
    }

    /**
     * Print specified element
     */
    private static void printElement() {
        int choice = -1;
        while (choice < 0 && choice < list.size()) {
            choice = Utils.getIntegerFromUser("Please set the number of the list you want to print");
            if (choice >= list.size()) {
                System.out.println("No element to print");
                choice = -1;
            }
        }
        list.printElement(choice);
        System.out.println();
    }

    /**
     * Prints all elements in the list
     */
    private static void printAll() {
        try {
            list.printAll();
            System.out.println();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
            System.out.println("Operation not supported on doubly linked list. Returning to the operation menu\n");
        } catch (RuntimeException e) {
            System.out.println("There is nothing to print. Returning to the operation menu\n");
        }
    }

    /**
     * Deletes an element
     */
    private static void deleteElement() {
        int choice = -1;
        while (choice < 0 && choice < list.size()) {
            choice = Utils.getIntegerFromUser("Please set the number of the list you want to delete");
            if (choice >= list.size()) {
                System.out.println("No elements to delete");
                choice = -1;
            }
            if (list.size() == 0) {
                break;
            }
        }
        try {
            list.deleteByIndex(choice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    /**
     * Searches the elements based on the specified string
     * @param searchOption  Finder option
     */
    private static void searchByString(int searchOption) {
        String string = Utils.getStringFromUser(Strings.STRING_SEARCH);
        while (string.equals("-1") || string.trim().equals("")) {
            string = Utils.getStringFromUser(Strings.STRING_SEARCH);
        }
        Listable<Student> findings = new SinglyLinkedList<>();
        switch(searchOption) {
            case 0:
                findings = list.find(string, new FirstNameFinder());
                if (findings.size() == 0) {
                    System.out.println("No findings");
                } else {
                    findings.printAll();
                }
                System.out.println();
                break;
            case 1:
                findings = list.find(string, new LastNameFinder());
                if (findings.size() == 0) {
                    System.out.println("No findings");
                } else {
                    findings.printAll();
                }
                System.out.println();
                break;
        }
    }

    /**
     * Searches the elements based on the specified integer
     * @param searchOption  Finder option
     */
    private static void searchByInteger(int searchOption) {
        String search = Utils.getIntegerStringFromUser(Strings.INTEGER_SEARCH);
        while (search.equals("-1") || search.trim().equals("")) {
            search = Utils.getIntegerStringFromUser(Strings.INTEGER_SEARCH);
        }
        Listable<Student> findings = new SinglyLinkedList<>();
        switch (searchOption) {
            case 0:
                findings = list.find(search, new StudentDegreeProgrammFinder());
                if (findings.size() == 0) {
                    System.out.println("No findings");
                } else {
                    findings.printAll();
                }
                System.out.println();
                break;
            case 1:
                findings = list.find(search, new StudentDegreeProgrammFinder());
                if (findings.size() == 0) {
                    System.out.println("No findings");
                } else {
                    findings.printAll();
                }
                System.out.println();
                break;
        }
    }

    /**
     * Sorts the elements by name and last name
     * @param sortOption  Comparator option
     */
    private static void sortByString(int sortOption) {
        Sortable<Student> sortVar = new SelectionSort<>();
        switch(sortOption) {
            case 0:
                sortVar.sort(list, new FirstNameComparator());
                if (list.size() == 0) {
                    System.out.println("No items to sort");
                } else {
                    list.printAll();
                }
                System.out.println();
                break;
            case 1:
                sortVar.sort(list, new SecondNameComparator());
                if (list.size() == 0) {
                    System.out.println("No items to sort");
                } else {
                    list.printAll();
                }
                System.out.println();
                break;
        }
    }

    /**
     * Sorts the elements by student number and major id
     * @param sortOption  Comparator option
     */
    private static void sortByInteger(int sortOption) {
        Sortable<Student> sortVar = new SelectionSort<>();
        switch (sortOption) {
            case 0:
                sortVar.sort(list, new StudentNumberComparator());
                if (list.size() == 0) {
                    System.out.println("No items to sort");
                } else {
                    list.printAll();
                }
                System.out.println();
                break;
            case 1:
                sortVar.sort(list, new DegreeNumberComparator());
                if (list.size() == 0) {
                    System.out.println("No items to sort");
                } else {
                    list.printAll();
                }
                System.out.println();
                break;
        }
    }

    /** Sets parameter for the student
     * @param student       Newly created student object
     */
    private static void setParameters(Student student) {
        boolean isGivenParameters = false;
        while (!isGivenParameters) {
            isGivenParameters = consoleApplication.setParameterForTheElement(student);
        }
    }

    /**
     * Displays dialog that asks user to return to main menu
     * @return     true or false
     */
    private static boolean askToMainMenu() {
        String answer;
        while (true) {
            System.out.println("Do you want to return to the main menu? (y/n)");
            answer = scanner.nextLine();
            if (answer.equals("y")) {
                return true;
            } else if (answer.equals("n")) {
                System.exit(0);
            }
        }
    }

    /**
     * Creates a list
     * @return      true or false
     */
    private static boolean createList() {
        list = consoleApplication.createList();
        if (list == null) {
            System.out.println(Strings.ERROR_REPEAT);
            String choice = scanner.nextLine();
            while (!choice.equals("y")) {
                System.out.println(Strings.ERROR_REPEAT);
                choice = scanner.nextLine();
                if (choice.equals("n")) {
                    System.exit(0);
                }
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * Represents the choice operation by singly linked list
     * @param choice        Choice from the chosen menu point
     */
    private static void singlyOperationChoice(int choice) {
        switch (choice) {
            // create new element through listable interface
            case 1:
                createNewElement();
                break;
            // add element before the first element
            case 2:
                // create element with constructor
                addFirst();
                break;
            // add element after the last element
            case 3:
                addLast();
                break;
            // output an element of the list
            case 4:
                printElement();
                break;
            // print all elements
            case 5:
                printAll();
                break;
            // print size of the list
            case 6:
                list.printSize();
                System.out.println();
                break;
            // delete an item
            case 7:
                deleteElement();
                break;
            // delete list
            case 8:
                list.clear();
                break;
            // search
            case 9:
                searchByString(0);
                break;
            case 10:
                searchByString(1);
                break;
            case 11:
                searchByInteger(0);
                break;
            case 12:
                searchByInteger(1);
                break;
            // sort
            case 13:
                sortByString(0);
                break;
            case 14:
                sortByString(1);
                break;
            case 15:
                sortByInteger(0);
                break;
            case 16:
                sortByInteger(1);
                break;
            // exit
            case 17:
                System.exit(0);
                break;
        }
    }

    /**
     * Represents the choice operation by doubly linked list
     * @param choice        Choice from the chosen menu point
     */
    private static void doublyOperationChoice(int choice) {
        switch (choice) {
            // create new element through listable interface
            case 1:
                System.out.println("operation not supported");
                System.out.println();
                break;
            // add element before the first element
            case 2:
                // create element with constructor
                addFirst();
                break;
            // add element after the last element
            case 3:
                addLast();
                break;
            case 4:
                printAll();
                break;
            // print size of the list
            case 5:
                list.printSize();
                System.out.println();
                break;
            // delete an item
            case 6:
                deleteElement();
                break;
            // delete list
            case 7:
                list.clear();
                break;
            // exit
            case 8:
                System.exit(0);
                break;
        }
    }
}




