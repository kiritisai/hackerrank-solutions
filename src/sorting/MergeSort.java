package sorting;

import java.util.Arrays;

public class MergeSort {
	private int[] numbers;
	private int length;
	
	//Note: start and end are inclusive
	private void mergesort(int start, int end)
	{
		if(start==end)
			return;
		int middle = (start + end)/2;
		
		// Sort the two halves
		mergesort(start, middle);
		mergesort(middle+1, end);
		
		System.out.println(Arrays.toString(this.numbers));
		// merge them.
		merge(start, end, middle);
	}
	
	private void merge(int start, int end, int middle)
	{
		int[] temp = new int[end-start+1];
		int temp_ptr = 0;

		int i=start;
		int j=middle+1;
		
		while(i<=middle && j<=end)
		{
			if(this.numbers[i] <= this.numbers[j]) {
				temp[temp_ptr++] = this.numbers[i];
				i++;
			}else {
				temp[temp_ptr++] = this.numbers[j];
				j++;
			}
		}
		
		while(i<=middle)
			temp[temp_ptr++] = this.numbers[i++];
		
		while(j<=end)
			temp[temp_ptr++] = this.numbers[j++];
		
		//Copy the numbers in temp to this.numbers
		for(i=start; i<=end; i++)
			this.numbers[i] = temp[i-start];
	}

	public int[] sort(int[] numbers)
	{
		this.numbers = numbers;
		this.length = numbers.length;
		mergesort(0, length-1);
		return this.numbers;
	}
}
