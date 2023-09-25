import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = 0, temp_add = 0;

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    Integer[] money_list = new Integer[N];
    for (int i = 0; i < N; i++) {
      money_list[i] = Integer.parseInt(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());

    Arrays.sort(money_list);
    int start = 0, end = money_list[N-1];

    while(start <= end) {
      int middle = ( start + end ) / 2;
      temp_add = 0;

      for (int n = 0; n < N; n++) {
        if (money_list[n] < middle) {
          temp_add += money_list[n];
        } else {
          temp_add += middle;
        }
      }

      if (temp_add > M) {
        end = middle - 1;
      } else {
        start = middle + 1;
        answer = Math.max(answer, middle);
      }
    }

    System.out.println(answer);
  }
}
