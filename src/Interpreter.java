import java.util.Scanner;

public class Interpreter {
    public static void main(String[] args) {
        int[] cells = new int[30000];
        int ptr = 0;
        Scanner sc = new Scanner(System.in);
        String program = sc.nextLine();
        for (int i = 0; i < program.length(); i++) {
            switch (program.charAt(i)) {
                case '>':
                    ptr++;
                    break;
                case '<':
                    ptr--;
                    break;
                case '+':
                    cells[ptr]++;
                    break;
                case '-':
                    cells[ptr]--;
                    break;
                case '.':
                    System.out.print((char) cells[ptr]);
                    break;
                case ',':
                    cells[ptr] = sc.nextInt();
                    break;
                case '[':
                    if (cells[ptr] == 0)
                        i = findRightBracket(program, i);
                    break;
                case ']':
                    i = findLeftBracket(program, i) - 1;
                    break;
            }
        }
    }

    /**
     * @param program the string
     * @param i point to the current bracket
     * @return point to the target bracket
     */
    private static int findRightBracket(String program, int i) {
        int count = 1;
        i++;
        while(count > 0) {
            i++;
            if (program.charAt(i) == '[')
                count++;
            if (program.charAt(i) == ']')
                count--;
        }
        return i;
    }
    private static int findLeftBracket(String program, int i) {
        int count = 1;
        i--;
        while(count > 0) {
            i--;
            if (program.charAt(i) == '[')
                count--;
            if (program.charAt(i) == ']')
                count++;
        }
        return i;
    }
}
