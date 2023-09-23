import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] case_list = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      case_list[i] = Integer.parseInt(st.nextToken());
    }

    int x = Integer.parseInt(br.readLine());

    Arrays.sort(case_list);

    int start = 0, end = n-1;
    int answer = 0, sum = 0;

    while (start < end) {
      sum = case_list[start] + case_list[end];

      if (sum == x) {
        answer++;
      }

      if (sum <= x) {
        start++;
      } else {
        end--;
      }
    }

    System.out.println(answer);
  }
}