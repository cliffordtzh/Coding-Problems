import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        sc.nextLine();
        String s = sc.nextLine();

        //int a = "a";
        boolean[] typeable = new boolean[26];
        for (int i = 0; i < k; i++) {
            int newChar = sc.next().charAt(0);
            typeable[newChar - 'a'] = true;
        }

        int[] masked = new int[n];
        for (int i = 0; i < n; i++) {
            if (typeable[s.charAt(i) - 'a']) {
                masked[i] = 1;
            } else {
                masked[i] = 0;
            }
        }

        int[] f = new int[n];
        f[0] = masked[0];
        int total = f[0];

        for (int i = 1; i < n; i++) {
            if (masked[i] == 1) {
                f[i] = f[i-1] + 1;
            } else {
                f[i] = 0;
            }

            total += f[i];
        }
        System.out.println(total);
    }
}

