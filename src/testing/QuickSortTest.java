package testing;
import java.util.Arrays;

import sorting.QuickSort;

public class QuickSortTest {
	public static void main(String[] args)
	{
		int[] numbers = {1,2,6,3,8,7};
		QuickSort sorter = new QuickSort();
		numbers = sorter.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
