/*
 * Question URL: https://www.hackerrank.com/challenges/repeated-string
 */
package algorithmImplementation;

import java.util.Scanner;

public class RepeatedString {
	public static int letter_count(String s, int max_len)
	{
		int count = 0;
		for(int i=0; i<max_len; i++)
		{
			if(s.charAt(i) == 'a')
				count++;
		}
		return count;
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        
        long result = (n/s.length())*letter_count(s, s.length());
        
        int remainder = (int)(n%s.length());
        result += letter_count(s, remainder);
        
        System.out.println(result);
    }
}
