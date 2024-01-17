import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        String input = br.readLine();
        List<Character> operator = Arrays.asList(new Character[] {'+', '-', '*', '/'});


        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now == '(') {
                st.add(now);
            } else if (now == ')') {
                while(!st.isEmpty()) {
                    if(st.peek() == '(') {
                        st.pop();
                        break;
                    }
                    sb.append(st.pop());
                }
            } else if (operator.contains(now)) {
                while(!st.isEmpty() && priority(st.peek()) >= priority(now)) {
                    sb.append(st.pop());
                }
                st.add(now);
            } else {
                sb.append(now);
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        System.out.printf(sb.toString());
    }

    public static int priority (char op) {
        if (op == '(') {
            return 0;
        } else if (op == '+' || op == '-') {
            return 1;
        } else {
            return 2;
        }
    }

}