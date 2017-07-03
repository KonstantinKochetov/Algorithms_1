import interfaces.Listable;
import model.DoublyLinkedList;
import model.SinglyLinkedList;
import model.Student;
import utils.Utils;
import values.Strings;

import java.util.Scanner;

/**
 * Helper class for the main class
 */
class ConsoleApplication {

    private Scanner mScanner;

    ConsoleApplication() {
        mScanner = new Scanner(System.in);

    }

    Listable<Student> createList() {

        // Choose the list
        mScanner = new Scanner(System.in);
        // get user input
        int choice = Utils.getListChoiceFromUser();
        // decide what to do
        switch (choice) {
            case 1:
                System.out.println(Strings.SINGLY_CREATION);
                return new SinglyLinkedList<>();
            case 2:
                System.out.println(Strings.DOUBLY_CREATION);
                return new DoublyLinkedList<>();
            case 3:
                System.exit(0);
                break;
            default:
                return null;
        }

        return null;

    }

    /**
     * Displays the list of operation based on the chosen implementation of {@link Listable}
     * @param listType      Type of the list
     * @return              Choice of the user
     */
    // choose the operation
    int createOperation(int listType) {
        // parse integer
        return Utils.parseOperationChoiceFromUser(Utils.getOperationChoiceFromUser(listType), listType);
    }

    /**
     *  Creates new element in the list
     * @param list  List to add element to
     * @return      Element of the list
     */
    // create new element
    Student runCreateNewElementOperation(Listable<Student> list) {
        return createNewElement(list);
    }

    /**
     * Helper method to create ne elemene
     * @param list  List to add element to
     * @return      Element of the list
     */
    // create new element
    private Student createNewElement(Listable<Student> list) {
        System.out.println(Strings.CREATE_ELEMENT);
        Student student = null;
        try {
            student = list.createNewEmptyElement(Student.class);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            System.out.println(Strings.FAIL_CREATE_ELEMENT);
            if (list instanceof DoublyLinkedList) {
                createOperation(1);
            } else {
                createOperation(0);
            }
        }
        return student;
    }

    /**
     * Sets parameters for the newly created element
     * @param student       Object to set parameters to
     * @return              Result of the operation
     */
    // set parameters to the element
    boolean setParameterForTheElement(Student student) {
        // name
        mScanner = new Scanner(System.in);
        String name = student.getFirstName();
        while (name == null || name.trim().equals("")) {
            System.out.println("Please set the name\n");
            name = mScanner.nextLine();
            if (name == null || name.trim().equals("")) {
                return false;
            } else {
                student.setFirstName(name);
                System.out.println(student.toString());
                System.out.println();
            }
        }
        // last name
        String lastName = student.getLastName();
        while (lastName == null || lastName.trim().equals("")) {
            System.out.println("Please set the last name\n");
            lastName = mScanner.nextLine();
            if (lastName == null || lastName.trim().equals("")) {
                return false;
            } else {
                student.setLastName(lastName);
                System.out.println(student.toString());
                System.out.println();
            }
        }

        // student number
        int number = student.getNumber();
        while (number < 1) {
            number = Utils.getStudentNumberFromUser();
        }
        student.setNumber(number);
        System.out.println(student.toString());
        System.out.println();

        // major id
        int majorId = student.getMajorId();
        while (majorId < 1) {
            majorId = Utils.getMajorIdFromUser();
        }

        student.setMajorId(majorId);
        System.out.println(student.toString());
        System.out.println();

        // parameters are set -> return
        return true;

    }


}
