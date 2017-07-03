package model.comparator;

import interfaces.Comparator;
import model.Student;

/**
 * Class with a comparison function, which imposes a total ordering based on the second names on some
 * collection of students.
 */
public class SecondNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getLastName() == null && s2.getLastName() == null) {
            return 0;
        } else if (s1.getLastName() == null) {
            return 1;
        } else if (s2.getLastName() == null) {
            return -1;
        }

        return s1.getLastName().compareTo(s2.getLastName());
    }
}
