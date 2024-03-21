import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int totalHeight = 0, oneCount = 0, twoCount = 0;
  static String answer = "YES";
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      int input = Integer.parseInt(st.nextToken());
      totalHeight += input;
      oneCount += input % 2;
      twoCount += input / 2;
    }

    if (totalHeight % 3 > 0 || oneCount > twoCount) {
      answer = "NO";
    }

    System.out.println(answer);
  }
  
}
