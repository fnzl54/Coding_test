import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int left = 0, answer = 0, count = 0;

    int[] food = new int[N];
    int[] eat = new int[d+1];
    for (int n = 0; n < N; n++) {
      food[n] = Integer.parseInt(br.readLine());
    }

    for (int i = 0; i < k; i++) {
      if (eat[food[i]] == 0) {
        count++;
      }

      eat[food[i]]++;
    }

    answer = count;

    for (int i = 1; i <= N; i++) {

      if (answer <= count) {
        if(eat[c] == 0) {
          answer = count + 1;
        } else {
          answer = count;
        }
      }

      int right = (i + k - 1) % N ;
      if (eat[food[right]] == 0) {
        count++;
      }
      eat[food[right]]++;

      eat[food[i-1]]--;
      if (eat[food[i-1]] == 0) {
        count--;
      }

    }

    System.out.println(answer);
  }
}