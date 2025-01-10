package demo;

import java.util.Arrays;

public class seclarg{
	
    public static void main(String[] args) {
    	
        int a[] = {10, 30, 55, 20, 40, 11};

        int largest = findLargest(a);
        System.out.println("Largest: " + largest);
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] == largest) {
                a[i] = 0;
                break; 
            }
        }

        System.out.println("Array after setting largest to 0: " + Arrays.toString(a));

        int secondLargest = findLargest(a);
        
        System.out.println("Second Largest: " + secondLargest);
        
    }
    public static int findLargest(int[] a) {
        int max = Integer.MIN_VALUE; 
        
        for (int num : a) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
