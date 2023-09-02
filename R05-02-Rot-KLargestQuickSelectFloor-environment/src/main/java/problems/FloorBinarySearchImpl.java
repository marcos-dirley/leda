package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
        if (array.length < 1) return null;

        boolean temMenor = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) return x;
            if (array[i] < x) temMenor = true;
        }
        if (!temMenor) return null;

        quicksort(array, 0, array.length - 1);
        return floorBinarySearch(array, 0, array.length - 1, x);
	}

    public Integer floorBinarySearch(Integer[] array, int left, int right, Integer x) {
        Integer floor = null;
        if (left > right) return floor;

        int meio = (left + right) / 2;
        if (array[meio] == x) return x;
        if(array[meio] > x) return floorBinarySearch(array, left, meio - 1, x);
        
        floor = floorBinarySearch(array, meio + 1, right, x);
        if (floor == null) floor = array[meio];
        return floor;
    }

    public void quicksort(Integer[] array, int left, int right) {
        if (left < right && left >= 0 && right < array.length) {
            int pivot = partition(array, left, right);
            quicksort(array, left, pivot - 1);
            quicksort(array, pivot + 1, right);
        }
    }

    public int partition(Integer[] array, int left, int right) {
        int pivot = array[left];
        int i = left;
        for (int j = i + 1; j <= right; j++) {
            if (array[j] < pivot) {
                i++;
                Util.swap(array, i, j);
            }
        }

        Util.swap(array, i, pivot);
        return i;
    }

}
