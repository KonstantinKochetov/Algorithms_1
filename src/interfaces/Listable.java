package interfaces;

import model.Data;

/* An ordered collection interface
 * @param <T>       Generic class
 */
public interface Listable<T> extends Iterable<T> {

    /**
     * Creates one element of the defined class
     *
     * @param newClass  Defined class to createList instance from
     * @return          Return instance of the defined class
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    T createNewEmptyElement(Class<T> newClass) throws IllegalAccessException, InstantiationException;

    /**
     * Creates one element of the defined enum type
     * @param element      Enum type to createList instance of
     * @return             Instance of the defined class
     */
    T createNewEmptyElementWithEnum(Data.Element element);

    /**
     * Returns the element of the list
     * @param index    Index of the element in the list
     * @return         The element of the list
     */
    T get(int index);

    /**
     * Set element in the list
     * @param index     Index to set element into
     * @param element   Element to set
     */
    void set(int index, T element);

    /**
     * Adds element as the first
     * @param element   Element to add
     */
    void addFirst(T element);

    /**
     * Adds element as the last
     * @param element   Element to add
     */
    void addLast(T element);

    /**
     * Prints element to standard output
     * @param index     Index of the element
     */
    void printElement(int index);

    /**
     * Prints all elements of the list
     */
    void printAll();

    /**
     * Prints the number of elements of the list
     */
    void printSize();

    /**
     * Returns the number of elements of the list
     * @return  The number of elements of the list
     */
    int size();

    /**
     * Removes the element with the specified key
     * @param key   Element to deleteByKey
     */
    void deleteByKey(T key);

    /**
     * Removes the element with the specified index
     * @param index   Element to delete
     */
    void deleteByIndex(int index) throws RuntimeException;

    /**
     * Clears the list
     */
    void clear();

    /**
     * Find the defined elements of the list
     * @param o         String to find in the elements of the list
     * @param finder    Finder to execute the implementation of the find() method
     * @return          Return {@link Listable} instance with founded elements
     */
    Listable<T> find(String o, Finder<T> finder);

    /**
     * Swaps elements in the list
     * @param i         1st element to swap
     * @param j         2nd element to swap
     */
    void swap(int i, int j);

}
