import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] developer = new int[N];
    for(int n = 0; n<N; n++) {
      developer[n] = Integer.parseInt(st.nextToken());
    }

    int left = 0, right = N-1, answer = 0;
    while(left <= right) {
      int min = Math.min(developer[left],developer[right]);
      answer = Math.max((right - left - 1) * min, answer);

      if(developer[left] < developer[right]) {
        left++;
      } else {
        right--;
      }

    }

    System.out.println(answer);
  }
}