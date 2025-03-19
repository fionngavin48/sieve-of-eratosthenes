import java.util.Arrays;
import java.util.Scanner;

public class Sieve {

    public static boolean[] createSequence(int n) {
        boolean[] sequence = new boolean[n + 1];
        Arrays.fill(sequence, false);
        sequence[0] = true;
        sequence[1] = true; 
        return sequence;
    }

    public static void crossOutHigherMultiples(boolean[] sequence, int N) {
        for (int i = 2 * N; i < sequence.length; i += N) {
            sequence[i] = true; // Mark multiples of N as crossed out
        }
    }

    public static String sequenceToString(boolean[] sequence) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i]) {
                result.append("[").append(i).append("]");
            } else {
                result.append(i);
            }
            if (i < sequence.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public static String nonCrossedOutSubseqToString(boolean[] sequence) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < sequence.length; i++) {
            if (!sequence[i]) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(i);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print("Enter int >= 2 : ");
            if (!input.hasNextInt()) {
                System.out.println("Error: You must enter an integer.");
                input.next();
                continue;
            }

            n = input.nextInt();
            System.out.println(n);
            
            if (n > 1) {
                break;
            } else {
                System.out.println("Error: Please enter an integer greater than 1.");
            }
        }

        boolean[] sequence = createSequence(n);
        System.out.println(nonCrossedOutSubseqToString(sequence));
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!sequence[i]) {
                crossOutHigherMultiples(sequence, i);
                System.out.println(sequenceToString(sequence));
            }
        }
        
        System.out.println(nonCrossedOutSubseqToString(sequence));

        input.close();
    }
}