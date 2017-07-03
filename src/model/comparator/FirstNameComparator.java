package model.comparator;

import interfaces.Comparator;
import model.Student;

/**
 * Class with a comparison function, which imposes a total ordering based on the first names on some
 * collection of students.
 */
public class FirstNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getFirstName() == null && s2.getFirstName() == null) {
            return 0;
        } else if (s1.getFirstName() == null) {
            return 1;
        } else if (s2.getFirstName() == null) {
            return -1;
        }

        return s1.getFirstName().compareTo(s2.getFirstName());
    }
}
