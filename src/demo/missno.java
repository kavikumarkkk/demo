package demo;

class missno {
    public static void main(String[] args) {
        int[] a = {3, 2, 4, 6, 7, 25};
        int n = 9; 
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (index < a.length && a[index] == i) {
                index++;
            } else {
                System.out.println(i);
            }
        }
        
    }

}
