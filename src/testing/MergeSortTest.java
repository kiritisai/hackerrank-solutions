package testing;
import java.util.Arrays;

import sorting.MergeSort;

public class MergeSortTest {
	public static void main(String[] args)
	{
		int[] numbers = {10,9,8,7,3,2,1};
		MergeSort sorter = new MergeSort();
		numbers = sorter.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
