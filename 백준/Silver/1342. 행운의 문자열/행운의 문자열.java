import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

  static int[] alphabet = new int[27];
  static int answer = 0;
  static String input;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    input = br.readLine();

    for (int i = 0; i < input.length(); i++) {
      alphabet[input.charAt(i) - 'a']++;
    }

    dfs(0, ' ');

    System.out.println(answer);
  }

  private static void dfs(int depth, char pre) {
    if (depth == input.length()) {
      answer++;
      return;
    }

    for (int i = 0; i < 27; i++) {
      if (alphabet[i] != 0) {
        char nowAlphabet = (char) (i + 'a');
        if (pre != nowAlphabet) {
          alphabet[i]--;
          dfs(depth+1, nowAlphabet);
          alphabet[i]++;
        }

      }
    }
  }
}