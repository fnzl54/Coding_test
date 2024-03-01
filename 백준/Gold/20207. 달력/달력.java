import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

  public static int N, answer = 0, height = 0, width = 0;
  public static int[] day;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    day = new int[366];
    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      for (int i = start; i <= end; i++) {
        day[i] += 1;
      }
    }

    for (int n = 1; n <= 365; n++) {
      if (day[n] == 0) {
        answer += height * width;
        height = 0;
        width = 0;
      } else {
        width += 1;
        height = Math.max(height, day[n]);
      }
    }

    answer += height * width;

    System.out.println(answer);
  }

}
