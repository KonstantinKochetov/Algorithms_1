package model;

import interfaces.Finder;
import interfaces.Listable;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Listable<T>, Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /*******************************************************
     * The Node class
     ********************************************************/

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public Iterator<T> iterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public DoublyLinkedList() {
        size = 0;
    }

    /**
     * Creates one element of the defined class. Not supported
     *
     * @param newClass  Defined class to createList instance from
     * @return          Return instance of the defined class
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Override
    public T createNewEmptyElement(Class<T> newClass) throws IllegalAccessException, InstantiationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates one element of the defined enum type. Not supported
     * @param element      Enum type to createList instance of
     * @return             Instance of the defined class
     */
    @Override
    public T createNewEmptyElementWithEnum(Data.Element element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the element of the list.
     * @param index    Index of the element in the list
     * @return         The element of the list
     */
    @Override
    public T get(int index) throws UnsupportedOperationException {
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null) {
            throw new NoSuchFieldError();
        } else {
            int counter = 0;
            Node<T> tmp = head;
            while (tmp.next != null) {
                if (counter == index) {
                    return tmp.data;
                }
                tmp = tmp.next;
                ++counter;
            }
            return tmp.data;
        }
    }

    /**
     * Set element in the list. Not supported
     * @param index     Index to set element into
     * @param element   Element to set
     */
    @Override
    public void set(int index, T element) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds element as the first
     * @param element   Element to add
     */
    @Override
    public void addFirst(T element) {
        Node<T> tmp = new Node<>(element, head, null);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
    }

    /**
     * Adds element as the last
     * @param element   Element to add
     */
    @Override
    public void addLast(T element) {
        Node<T> tmp = new Node<>(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
    }

    /**
     * Prints element to standard output. Not supported
     * @param index     Index of the element
     */
    @Override
    public void printElement(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Prints all elements of the list
     */
    @Override
    public void printAll() throws RuntimeException {
        if (head == null) {
            throw new RuntimeException("nothing to print");
        } else {
            Node<T> tmp = head;
            while (tmp.next != null) {
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
            System.out.println(tmp.data);
        }
    }

    /**
     * Prints the number of elements of the list
     */
    @Override
    public void printSize() {
        System.out.println(String.valueOf(size()));
    }

    /**
     * Returns the number of elements of the list
     * @return  The number of elements of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes the element with the specified key
     * @param key   Element to deleteByKey
     */
    @Override
    public void deleteByKey(T key) throws RuntimeException {
        if (head == null || tail == null) throw new RuntimeException("cannot deleteByKey");
        if (head.data.equals(key)) {// deleteByKey first
            try {
                head = head.next;
                head.prev = null;
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            size--;
            return;
        } else if (tail.data.equals(key)) {// deleteByKey last
            try {
                tail = tail.prev;
                tail.next = null;
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            size--;
            return;
        }

        Node<T> cur = head;//traverse and deleteByKey
        while (cur != null && !cur.data.equals(key)) {
            cur = cur.next;
        }
        if (cur == null) throw new RuntimeException("no findings");
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
    }

    /**
     * Removes the element with the specified index
     * @param index   Element to delete
     */
    @Override
    public void deleteByIndex(int index) throws RuntimeException {
        T t = this.get(index);
        this.deleteByKey(t);
    }

    /**
     * Clears the list
     */
    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Find the defined elements of the list. Not supported
     * @param o         String to find in the elements of the list
     * @param finder    Finder to execute the implementation of the find() method
     * @return          Return {@link Listable} instance with founded elements
     */
    @Override
    public Listable<T> find(String o, Finder<T> finder) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Swaps elements in the list. Not supported
     * @param i         1st element to swap
     * @param j         2nd element to swap
     */
    @Override
    public void swap(int i, int j) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
}
