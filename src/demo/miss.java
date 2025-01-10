package demo;

public class miss {
    public static void main(String[] args) {
        String input = "the the user is is used";
        String[] w = input.split(" ");
        StringBuffer r = new StringBuffer();
        
        for (int i = 0; i < w.length; i++) {
            boolean d = false;

            for (int j = 0; j < i; j++) {
                if (w[i].equals(w[j])) {
                    d = true;
                    break;
                }
            }

            if (!d) {
                if (r.length() > 0) {
                    r.append(" ");
                }
                r.append(w[i]);
            }
        }
        

        System.out.println(r.toString());
    }
}

 
