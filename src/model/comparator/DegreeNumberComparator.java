package model.comparator;

import interfaces.Comparator;
import model.Student;

/**
 * Class with a comparison function, which imposes a total ordering based on the degree number on some
 * collection of students.
 */
public class DegreeNumberComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getMajorId() == null && s2.getMajorId() == null) {
            return 0;
        } else if (s1.getMajorId() == null) {
            return 1;
        } else if (s2.getMajorId() == null) {
            return -1;
        } else if (s1.getMajorId() < s2.getMajorId()) {
            return -2;
        } else {
            return 2;
        }
    }
}
