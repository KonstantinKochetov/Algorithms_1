package interfaces;

/**
 * Interface with a comparison function, which imposes a total ordering on some
 * collection of objects.
 *
 * @param <T>  Generic class
 */
public interface Comparator<T> {
    int compare(T o1, T o2);

}
