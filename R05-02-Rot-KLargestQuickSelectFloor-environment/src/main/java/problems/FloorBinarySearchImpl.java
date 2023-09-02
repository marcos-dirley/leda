
package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
        int i = 0;
        for (; array[i] > x; i++) 
            if (i >= array.length) return null;
        if (array[i] == x) return x;

        int maior = array[i];
        for (i++; i < array.length; i++)
           if (array[i] > maior && array[i] < x) maior = array[i]; 
        return maior;
	}

}
