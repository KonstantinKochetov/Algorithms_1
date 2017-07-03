package model;

import interfaces.Listable;
import model.finders.FirstNameFinder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kochetov on 7/3/2017.
 */
public class ListTest {
    Listable<Student> firstList;
    Listable<Student> secondList;
    Student s1;
    Student s2;
    Student s3;
    Student s4;

    @Before
    public void setUp() throws Exception {
        firstList = new SinglyLinkedList<>();
        secondList = new DoublyLinkedList<>();
        s1 = new Student("Konstantin", "Kochetov", 1, 10);
        s2 = new Student("Barrack", "Obama", 2, 9);
        s3 = new Student("Donald", "Trump", 3, 8);
        s4 = new Student("Vladimir", "Putin", 4, 7);
        firstList.addFirst(s1);
        secondList.addFirst(s2);
    }

    @After
    public void tearDown() throws Exception {
        firstList.clear();
        secondList.clear();
    }

    @Test
    public void createNewEmptyElement() throws Exception {
        Student s5 = firstList.createNewEmptyElement(Student.class);
        assertNotEquals(s5, null);
    }

    @Test
    public void addFirst() throws Exception {
        firstList.addFirst(s3);
        assertEquals(firstList.size(), 2);
        secondList.addFirst(s4);
        assertEquals(secondList.size(), 2);
    }

    @Test
    public void addLast() throws Exception {
        firstList.addLast(s3);
        assertEquals(firstList.size(), 2);
        secondList.addLast(s4);
        assertEquals(secondList.size(), 2);
    }

    @Test
    public void printElement() throws Exception {
        firstList.printElement(0);

    }

    @Test
    public void printAll() throws Exception {
        firstList.printAll();
        secondList.printAll();
    }

    @Test
    public void printSize() throws Exception {
        firstList.printSize();
        secondList.printSize();

    }

    @Test
    public void deleteByIndex() throws Exception {
        firstList.deleteByIndex(0);
        assertEquals(firstList.size(), 0);
        secondList.deleteByIndex(0);
        assertEquals(secondList.size(), 0);
}

    @Test
    public void clear() throws Exception {
        firstList.clear();
        secondList.clear();
    }

    @Test
    public void find() throws Exception {
        Listable<Student> list = firstList.find("Kon", new FirstNameFinder());
        assertEquals(list.size(), 1);

    }

}