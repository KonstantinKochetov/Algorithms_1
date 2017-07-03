package interfaces;

/**
 *  Interface with a sort function which sorts elements in the provided {@link Listable}
 * @param <T>   Generic class
 */
public interface Sortable<T> {
    void sort(Listable<T> list, Comparator<T> comparator);
}
