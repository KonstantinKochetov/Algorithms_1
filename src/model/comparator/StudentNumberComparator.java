package model.comparator;

import interfaces.Comparator;
import model.Student;

/**
 * Class with a comparison function, which imposes a total ordering based on the student number on some
 * collection of students.
 */
public class StudentNumberComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getNumber() == null && s2.getNumber() == null) {
            return 0;
        } else if (s1.getNumber() == null) {
            return 1;
        } else if (s2.getNumber() == null) {
            return -1;
        } else if(s1.getNumber() < s2.getNumber()) {
            return -2;
        } else {
            return 2;
        }
    }
}