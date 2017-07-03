package model;

/**
 *  Class that holds enum types
 */
public class Data {

    /**
     * Enum types that can be used in the {@link interfaces.Listable}
     */
    public enum Element {
        STUDENT
    }

    private static Element element;

    Data(Element element) {
        Data.element = element;
    }

    /**
     * Creates element of the defined enum type
     * @return  Element of the defined enum type
     */
    Object createElement() {
        switch (element) {
            case STUDENT:
                return new Student();
            default:
                return new Student();
        }
    }

}
