package sorting;

import java.util.Arrays;

public class QuickSort {
	private int[] numbers;
	private int length;

	private void swap(int i, int j)
	{
		int temp = this.numbers[i];
		this.numbers[i] = this.numbers[j];
		this.numbers[j] = temp;
	}

	/*
	 * Lomuto partition method. Ref: https://en.wikipedia.org/wiki/Quicksort 
	 */
	private int partition(int start, int end)
	{
		// i is used to track number of elements less than pivot found
		// After finding all the elements less than the pivot, put pivot at i+1
		System.out.println(Arrays.toString(this.numbers));
		int i=start-1;
		int pivot = this.numbers[end];
		for(int j=start; j<end; j++)
		{
			if(this.numbers[j] < pivot)
			{
				i++;
				//swap a[i], a[j]
				swap(i, j);
			}
		}
		if(this.numbers[i+1] > pivot) {
			//Swap the pivot to i+1
			swap(i+1, end);
		}
		return i+1;
	}

	private void quicksort(int start, int end)
	{
		int pi = partition(start, end);
		if(pi > start)
			quicksort(start, pi-1);
		if(pi < end)
			quicksort(pi+1, end);
	}

	public int[] sort(int[] numbers) {
		this.numbers = numbers;
		this.length = this.numbers.length;
		int start = 0;
		int end = this.length - 1;
		quicksort(start, end);
		return this.numbers;
	}
}
