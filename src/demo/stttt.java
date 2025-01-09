package demo;

public class stttt {
	public static void main(String[] args) {
		
	
	
	int c=0;
	String []s= {"alex","balexndjk","jhdalexdw"};
	String s1="alex";
	for(int i=0;i<s.length;i++)	{
		if (s1.length()<=s[i].length()) {
			for(int j=0;j<=s[i].length()-s1.length();j++) {
				if(s1.equalsIgnoreCase(s[i].substring(j,j+s1.length()))) {
					c++;
				}
			}
			
			
		}
	}
	
	System.out.println(c);
	
	}

}
