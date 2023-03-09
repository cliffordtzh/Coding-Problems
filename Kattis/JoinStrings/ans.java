import java.io.*;
import java.util.*;

class Index { 
    public Index before; 
    public Index after;
    public String word; 

    public Index (String word) {
        this.word = word;
        this.after = null;
        this.before = null;
    }

    @Override
    public String toString() {
        return (this.word);
    }
}
class joinStrings {
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);

        int number = io.getInt();
        Index[] wordArr = new Index[number];

        for (int i = 0; i < number; i++) {
            wordArr[i] = new Index(io.getWord()); 
        }
        Index update; 
        Index original;
        int[] arr = new int[]{1,1};
        for (int i = 0; i < number - 1 ; i++) {
            arr[0] = io.getInt();
            arr[1] = io.getInt();

            update = wordArr[arr[0]-1];
            original = wordArr[arr[1]-1];
            if(update.before != null) { 
                update.before.after = original;  
            }

            update.after = (update.before == null) 
            ? original
            : update.after;
    
            update.before = (original.after != null) 
            ? original.before
            : original;

            System.out.println(String.format(
                "%s, %s, %s", update.before, update, update.after
            ));
            System.out.println(String.format(
                "%s, %s, %s", original.before, original, original.after
            ));
            System.out.println("");
        }

        for (update = wordArr[arr[0]-1]; update.after!= null; update= update.after) {
            io.print(update.word);
        }
        
        io.print(update.word);
        io.close();
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }
    
    public boolean hasMoreTokens() {
        return peekToken() != null;
    }
    
    public int getInt() {
        return Integer.parseInt(nextToken());
    }
    
    public double getDouble() {
        return Double.parseDouble(nextToken());
    }
    
    public long getLong() {
        return Long.parseLong(nextToken());
    }
    
    public String getWord() {
        return nextToken();
    }
    
    
    
    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;
    
    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }
    
    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}