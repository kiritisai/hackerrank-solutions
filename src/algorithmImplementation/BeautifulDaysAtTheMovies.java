package algorithmImplementation;

import java.time.format.ResolverStyle;
import java.util.Scanner;


public class BeautifulDaysAtTheMovies {
	public static int reverse(int n)
	{
		// Returns the reverse of a number
		int reverse = 0;
		int temp = n;
		while(temp > 0)
		{
			reverse *= 10;
			reverse += temp%10;
			temp /= 10;
		}
		return reverse;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();
		
		int count = 0;
		for(int day=i; day<=j; day++)
		{
			int reverse_day = reverse(day);
			if((day - reverse_day) % k == 0)
				count++;
		}
		System.out.println(count);
	}
}
