import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int[] water = new int[N];
    int answer = 0, start = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      water[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(water);

    if (L == 1) {
      answer = N;
    } else {
      for (int i = 1; i < N; i++) {
        if (water[i] - water[start] >= L) { // 넘어간 경우
          start =  i;
          answer++;
        }
      }
      if (start < N) {
        answer++;
      }
    }

    System.out.println(answer);
  }
}