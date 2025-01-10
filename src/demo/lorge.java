package demo;

import java.util.*;

public class lorge {
	
	public static void main(String[] args) {
		
	int a[]= {1,7,9,6,3,4,7,8};
	int min=0;
	
for (int i = 0; i < 2; i++) {
	for (int j =i ; j < a.length; j++) {
		if(a[i]>a[j]) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=a[i];
		}
	}
	
}
	System.out.println(a[1]);
	
	}

}



