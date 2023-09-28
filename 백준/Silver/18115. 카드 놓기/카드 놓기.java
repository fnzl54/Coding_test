import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[] num = new int[N];
    int[] res = new int[N+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }

    int number = N;
    int idx1 = 0, idx2 = 1, idx3 = N-1;
    for(int i = 0; i < N; i++) {
      int inst = num[i];
      if(inst == 1) {
        res[idx1] = number;
        if(res[idx1 + 1] == 0) idx1 += 1;
        else idx1 = idx2 + 1;
      } else if(inst == 2) {
        if(res[idx1+1] == 0) idx2 = idx1 + 1;
        else idx2 += 1;
        res[idx2] = number;
      } else {
        res[idx3] = number;
        idx3 -= 1;
      }
      number -= 1;
    }

    for(int i = 0; i < N; i++) sb.append(res[i] + " ");
    System.out.println(sb.toString());

  }
}