import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    Stack<Character> st = new Stack<>();
    Stack<Integer> stNum = new Stack<>();
    int tempNum = 0;

    // 올바른 입력인지 확인
    if (input.equals("")) {
      System.out.println("0");
      return;
    }
    for (char c : input.toCharArray()) {
      if (c == ')') {
        if (st.isEmpty() || st.pop() != '(') {
          System.out.println("0");
          return;
        }
      } else if (c == ']') {
        if (st.isEmpty() || st.pop() != '[') {
          System.out.println("0");
          return;
        }
      } else {
        st.add(c);
      }
    }

    if (!st.isEmpty()) {
      System.out.println("0");
      return;
    }

    // 계산 진행
    st.clear();

    for (char c : input.toCharArray()) {
      if (c == ')') {
        if (st.peek() == '(') {
          st.pop();
          st.add('n');
          stNum.add(2);
        } else {
          st.pop();
          st.pop();
          tempNum = stNum.pop();
          tempNum *= 2;
          st.add('n');
          stNum.add(tempNum);
        }
      } else if (c == ']') {
        if (st.peek() == '[') {
          st.pop();
          st.add('n');
          stNum.add(3);
        } else {
          st.pop();
          st.pop();
          tempNum = stNum.pop();
          tempNum *= 3;
          st.add('n');
          stNum.add(tempNum);
        }
      } else {
        st.add(c);
      }

      if (st.size() >= 2) {
        if (st.get(st.size()-1) == 'n' && st.get(st.size()-2) == 'n') {
          st.pop();
          st.pop();
          tempNum = stNum.pop() + stNum.pop();
          st.add('n');
          stNum.add(tempNum);
        }
      }
    }

    System.out.println(stNum.pop());
  }
}