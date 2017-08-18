package utils;

public class SubstringCheck {
	public static boolean isSubstring(String large, String small)
	{
		for(int i=0; i<=large.length()-small.length(); i++)
		{
			System.out.println(large.substring(i, i+small.length()));
			if(large.substring(i, i+small.length()).equals(small))
				return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		String s1 = "2229505813";
		String s2 = "813";
		
		System.out.println(isSubstring(s1, s2));
	}

}
