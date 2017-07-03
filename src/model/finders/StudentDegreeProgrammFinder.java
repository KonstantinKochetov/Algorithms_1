package model.finders;

import interfaces.Finder;
import interfaces.Listable;
import model.SinglyLinkedList;
import model.Student;

import java.util.Iterator;

/**
 *  Class with a find function which returns {@link Listable} with elements founded based on the student degree of the student
 */
public class StudentDegreeProgrammFinder implements Finder<Student> {

    @Override
    public Listable<Student> find(String o, Listable<Student> list) {
        Listable<Student> findings = new SinglyLinkedList<>();

        Iterator<Student> iterator = list.iterator();
        while(iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getMajorId() == Integer.parseInt(o)) {
                findings.addLast(student);
            }
        }
        return findings;
    }
}
