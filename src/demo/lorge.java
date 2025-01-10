package demo;

import java.util.*;

public class lorge {
	
	public static void main(String[] args) {
		
	int a[]= {10,7,6,3,4,7,8};
	
for (int i = 0; i < 2; i++) {
	for (int j =i+1 ; j < a.length; j++) {
		if(a[i]<a[j]) {	
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		
		}
	}
	
}
	System.out.println(Arrays.toString(a));
	
	}

}



