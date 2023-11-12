// 수식의 길이 최대 200 - String
// 괄호 - 10개 경우의수 2^10 - 1024
// 예외 - https://www.acmicpc.net/board/view/129131

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  static List<int[]> bracket = new ArrayList<>();
  static List<Integer> check = new ArrayList<>();
  static List<String> answer = new ArrayList<>();
  static String input;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Set<String> set;
    StringBuilder sb = new StringBuilder();
    Stack<Integer> st = new Stack<>();

    input = br.readLine();

    for(int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if(c == '(') {
        st.push(i);
      } else if(c == ')'){
        bracket.add(new int[] {st.pop(), i});
      }
    }
    checkBracket(0);
    answer.remove(answer.size()-1);
    set = new HashSet<>(answer);
    answer = new ArrayList<>(set);
    Collections.sort(answer);
    for (String s : answer) {
      sb.append(s).append("\n");
    }
    System.out.println(sb);
  }

  public static void checkBracket(int n) {
    if (n == bracket.size()) {
      ArrayList<Integer> removePoint = new ArrayList<>();
      StringBuilder sb = new StringBuilder(input);
      for (int i = 0; i < check.size(); i++) {
        removePoint.add(bracket.get(check.get(i))[0]);
        removePoint.add(bracket.get(check.get(i))[1]);
      }

      Collections.sort(removePoint, Collections.reverseOrder());
      for (int p :  removePoint) {
        sb.deleteCharAt(p);
      }
      answer.add(sb.toString());
      return;
    }

    check.add(n);
    checkBracket(n+1);
    check.remove(check.size()-1);
    checkBracket(n+1);
  }
}