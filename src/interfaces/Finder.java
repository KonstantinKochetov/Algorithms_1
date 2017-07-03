package interfaces;

/**
 *  Interface with a find function which returns {@link Listable} with elements founded
 *
 * @param <T>   Generic class
 */
public interface Finder<T> {
    Listable<T> find(String o, Listable<T> list);
}
