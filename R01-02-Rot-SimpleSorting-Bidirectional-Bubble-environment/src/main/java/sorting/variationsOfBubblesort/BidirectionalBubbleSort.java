package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
        if (!(leftIndex < 0) && rightIndex < array.length) {
            int i = rightIndex, j; 
            int k = leftIndex, l;
            boolean swapped = true;
            for (; swapped; k++) {
                swapped = false;
                for (j = k; j < i; j++) {
                    if(array[j].compareTo(array[j + 1]) > 0) {
                        Util.swap(array, j, j + 1);
                        swapped = true;
                    }
                }

                if (swapped == false) break;
                swapped = false;

                for (l = --i; l > k; l--)
                    if(array[l].compareTo(array[l - 1]) < 0) {
                        Util.swap(array, l, l - 1);
                        swapped = true;
                    }
            }
        }
	}
}
