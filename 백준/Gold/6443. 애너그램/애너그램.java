import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  static int N, dfsNumber;
  static String dfsString;
  static String[] input;
  static int[] check;
  static Set<String> tempAnswer = new TreeSet<>();
  static StringBuilder sb;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder answer = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    input = new String[N];
    for (int n = 0; n < N; n++) {
      input[n] = br.readLine();
    }

    for (String inputString : input) {
      check = new int[26];
      sb = new StringBuilder();
      dfsString = inputString;
      dfsNumber = inputString.length();

      for (char c : dfsString.toCharArray()) {
        check[c - 'a'] += 1;
      }

      dfs(0);

      for (String answerString : tempAnswer) {
        answer.append(answerString).append("\n");
      }
      tempAnswer.clear();
    }

    System.out.println(answer);

  }

  static void dfs(int depth) {
    if (depth == dfsNumber) {
      tempAnswer.add(sb.toString());
      return;
    }

    for (int i = 0; i < 26; i++) {
      if(check[i]>0){
        check[i]--;
        sb.append((char)(i+'a'));
        dfs(depth + 1);
        check[i]++;
        sb.deleteCharAt(sb.length() - 1);
      }

    }
  }

}
