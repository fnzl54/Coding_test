import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int L, C;
  static char[] input, arr;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    input = new char[C];
    st = new StringTokenizer(br.readLine());
    for (int c = 0; c < C; c++) {
      input[c] = st.nextToken().charAt(0);
    }

    Arrays.sort(input);

    arr = new char[L];
    dfs(0, 0);

    System.out.println(sb);

  }

  static void dfs(int depth, int start) {
    if (depth == L) {
      if (checkType(arr)) {
        for (char c : arr) {
          sb.append(c);
        }
        sb.append("\n");
      }
      // System.out.println(Arrays.toString(arr));
      return;
    }

    for (int i = start; i < C; i++) {
      arr[depth] = input[i];
      dfs(depth + 1, i + 1);
    }

  }

  static boolean checkType(char[] cherList) {
    int countVowel = 0;
    for (char c : cherList) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        countVowel++;
      }
    }

    if (1 <= countVowel && countVowel <= L - 2) {
      return true;
    } else {
      return false;
    }

  }

}