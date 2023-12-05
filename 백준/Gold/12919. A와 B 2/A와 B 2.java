import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static StringBuilder S, T;
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    S = new StringBuilder(br.readLine());
    T = new StringBuilder(br.readLine());

    dfs(T);
    System.out.println(answer);
  }

  static void dfs (StringBuilder str) {
    if (str.length() == S.length()) {
      if (str.toString().equals(S.toString())) {
        answer = 1;
      }
      return;
    }

    if (str.charAt(str.length()-1) == 'A') {
      str.deleteCharAt(str.length()-1);
      dfs(str);
      str.append("A");
    }

    if (str.charAt(0) == 'B') {
      str.deleteCharAt(0);
      str.reverse();
      dfs(str);
      str.append("B");
      str.reverse();
    }

  }
}
