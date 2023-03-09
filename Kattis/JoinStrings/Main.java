import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class FastReader {
	BufferedReader br;
	StringTokenizer st;
	public FastReader() {
		this.br = new BufferedReader(
			new InputStreamReader(System.in)
		);
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreElements()) {
			st = new StringTokenizer(this.br.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(this.next());
	}

	String nextLine() throws IOException {
		return br.readLine();
	}
}

class Node {
	public Node after;
	public Node tail;
	public String value;

	public Node(String value) {
		this.value = value;
		this.after = null;
		this.tail = this;
	}
}

public class Main {
	public static void main (String[] args) throws IOException {
		FastReader fr = new FastReader();
		
		int N = fr.nextInt();
		Node[] S = new Node[N];

		for (int i = 0; i < N; i++) {
			S[i] = new Node(fr.next());
		}
		
		solve(S, N - 1, fr);
	}

	public static void solve(Node[] S, int numInstr, FastReader fr) throws IOException {
		int a, b;
		
		int last = 0;
		for (int i = 0; i < numInstr; i++) {
			a = fr.nextInt() - 1;
			b = fr.nextInt() - 1;

			Node aNode = S[a];
			Node bNode = S[b];

			aNode.tail.after = bNode;		// Set the next word in link to be the new word
			aNode.tail = bNode.tail;		// Update the current last word in the link

			last = a;
		}

		Node curr = S[last];
		while (curr != null) {
			System.out.print(curr.value);
			curr = curr.after;
		}
	}
}
