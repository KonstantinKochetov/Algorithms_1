package model.sort;

import interfaces.Comparator;
import interfaces.Listable;
import interfaces.Sortable;

/**
 * Class with a bubble sort function which sorts elements in the provided {@link Listable}
 *
 * @param <T>   Generic class
 */
public class SelectionSort<T> implements Sortable<T> {
    @Override
        public void sort(Listable<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(min)) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                list.swap(min, i);
            }
        }
    }
}
