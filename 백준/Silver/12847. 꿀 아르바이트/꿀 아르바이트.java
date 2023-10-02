import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Long[] moneyList = new Long[N];
    long sum = 0, max = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      moneyList[i] = Long.parseLong(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      sum += moneyList[i];
    }
    max = sum;

    for (int i = M; i < N; i++) {
      sum += moneyList[i] - moneyList[i-M];
      max = Math.max(max, sum);
    }

    System.out.println(max);
  }
}