package model.sort;

import interfaces.Comparator;
import interfaces.Listable;
import interfaces.Sortable;


/**
 * Class with a bubble sort function which sorts elements in the provided {@link Listable}
 *
 * @param <T>   Generic class
 */
public class BubbleSort<T> implements Sortable<T> {
    @Override
    public void sort(Listable<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j+1)) > 0) {
                    list.swap(j, j+1);
                }
            }
        }
    }
}
