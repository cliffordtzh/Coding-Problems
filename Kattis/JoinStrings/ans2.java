
import java.io.*;
import java.util.*;

/**
 * Fast I/O
 * 
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;

    public FastIO() {
        super(new BufferedOutputStream(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

/**
 * Modified from Lecture Notes
 */
class ListNode {
    /* attributes */
    public int item;
    public ListNode next;
    public ListNode head;
    public ListNode tail;

    /* constructors */
    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode n) {
        item = val;
        next = null;
        tail = this;
    }

    /* get the next ListNode */
    public ListNode getNext() {
        return next;
    }

    /* get the item of the ListNode */
    public int getItem() {
        return item;
    }

    /* set the item of the ListNode */
    public void setItem(int val) {
        item = val;
    }

    /* set the next reference */
    public void setNext(ListNode n) {
        next = n;
    }

    @Override
    public String toString() {
        return String.format("%d", this.item);
    }
}

public class ans2 {
    public static void main(String[] args) throws IOException {
        FastIO fio = new FastIO();

        int n = fio.nextInt();
        String[] words = new String[n];
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        int last = 0;

        for (int i = 0; i < n; i++) {
            words[i] = fio.next();
            ListNode nodes = new ListNode(i);
            list.add(nodes);
        }

        for (int i = 0; i < n - 1; i++) {
            int a = fio.nextInt() - 1;
            int b = fio.nextInt() - 1;

            ListNode nodeA = list.get(a);
            ListNode nodeB = list.get(b);

            System.out.println(nodeA);

            nodeA.tail.next = nodeB;
            nodeA.tail = nodeB.tail;

            last = a;
        }

        ListNode curr = list.get(last);

        while (curr != null) {
            fio.print(words[curr.item]);
            curr = curr.next;
        }

        fio.print("\n");
        fio.close();
    }
}