package model;

import interfaces.Finder;
import interfaces.Listable;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Resizable implementation of the Listable interface
 * in the form of Singly linked list
 * @param <T>       Generic class
 */
public class SinglyLinkedList<T> implements Listable<T>, Iterable<T> {
    private Node<T> head;

    /** Class that represents the element of the list
     * @param <T>       Generic class
     */
    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }


    /**
     * Iterator class for iterating/traversing through the list. Implements {@link Iterator}
     */
    private class SinglyListIterator implements Iterator<T> {
        private Node<T> nextNode;

        SinglyListIterator() {
            nextNode = head;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        /**
         * The method to get the next element
         * @return  Generic class - element of the list
         */
        public T next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException();
            T res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        /**
         * Removes iterator. Not supported
         */
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Creates iterator to iterate through list
     *
     * @return      Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new SinglyListIterator();
    }

    public SinglyLinkedList() {
    }

    /**
     * Creates one element of the defined class
     *
     * @param newClass  Defined class to createList instance from
     * @return          Return instance of the defined class
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Override
    public T createNewEmptyElement(Class<T> newClass) throws IllegalAccessException, InstantiationException {
        T t = newClass.newInstance();
        head = new Node<>(t, head);
        return t;
    }

    /**
     * Creates one element of the defined enum type
     * @param element      Enum type to createList instance of
     * @return             Instance of the defined class
     */
    @Override
    public T createNewEmptyElementWithEnum(Data.Element element) {
        T t = (T)new Data(element).createElement();
        head = new Node<>(t, head);
        return t;
    }

    /**
     * Returns the element of the list
     * @param index    Index of the element in the list
     * @return         The element of the list
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
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
     * Set element in the list
     * @param index     Index to set element into
     * @param element   Element to set
     */
    @Override
    public void set(int index, T element) throws IndexOutOfBoundsException {
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null) {
            addFirst(element);
        } else {
            int counter = 0;
            Node<T> tmp = head;
            while (tmp.next != null) {
                if (counter == index) {
                    tmp.data = element;
                }
                tmp = tmp.next;
                counter++;
            }
            if (tmp.next == null && counter == index)tmp.data = element;
        }
    }

    /**
     * Adds element as the first
     * @param element   Element to add
     */
    @Override
    public void addFirst(T element) {
        head = new Node<>(element, head);
    }

    /**
     * Adds element as the last
     * @param element   Element to add
     */
    @Override
    public void addLast(T element) {
        if (head == null) {
            addFirst(element);
        } else {
            Node<T> tmp = head;
            while (tmp.next != null) tmp = tmp.next;
            tmp.next = new Node<>(element, null);
        }
    }

    /**
     * Prints element to standard output
     * @param index     Index of the element
     */
    @Override
    public void printElement(int index) throws RuntimeException {
        if (head == null || index < 0) {
            throw new RuntimeException("nothing to print");
        } else if (index == 0) {
            System.out.println(head.data);
        } else {
            int counter = -1;
            Node<T> tmp = head;
            while (tmp.next != null) {
                counter++;
                if (counter == index) {
                    System.out.println(tmp.data);
                }
                tmp = tmp.next;
            }
            counter++;
            if (counter == index) {
                System.out.println(tmp.data);
            } else if (index > counter) {
                throw new RuntimeException("nothing to print");
            }
        }
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
        if (head == null) {
            System.out.println(0);
        } else {
            int counter = 0;
            Node<T> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
                counter++;
            }
            System.out.println(++counter);
        }
    }

    /**
     * Returns the number of elements of the list
     * @return  The number of elements of the list
     */
    @Override
    public int size() {
        if (head == null) {
            return 0;
        } else {
            int counter = 0;
            Node<T> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
                counter++;
            }
            return ++counter;
        }
    }

    /**
     * Removes the element with the specified key
     * @param key   Element to delete
     */
    @Override
    public void deleteByKey(T key) throws RuntimeException {
        if (head == null) throw new RuntimeException("cannot deleteByKey");
        if (head.data.equals(key)) {
            head = head.next;
            return;
        }
        Node<T> cur = head;
        Node<T> prev = null;
        while (cur != null && !cur.data.equals(key)) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) throw new RuntimeException("no findings");
        prev.next = cur.next;
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
        head = null;
    }

    /**
     * Find the defined elements of the list
     * @param o         String to find in the elements of the list
     * @param finder    Finder to execute the implementation of the find() method
     * @return          Return {@link Listable} instance with founded elements
     */
    @Override
    public Listable<T> find(String o, Finder<T> finder) throws RuntimeException {
        if (o == null || o.equals("")) {
            System.out.println("no findings");
        }
        return finder.find(o, this);
    }

    /**
     * Swaps elements in the list
     * @param i         1st element to swap
     * @param j         2nd element to swap
     */
    @Override
    public void swap(int i, int j) {
        T memorizedObject = this.get(i);
        this.set(i, this.get(j));
        this.set(j, memorizedObject);
    }


}
