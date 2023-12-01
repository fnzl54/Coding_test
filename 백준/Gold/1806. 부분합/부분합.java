import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int answer = Integer.MAX_VALUE;
    int left = 0, right = 0, addNumber = 0;

    st = new StringTokenizer(br.readLine());
    int[] input = new int[N];
    for (int n = 0; n < N; n++) {
      input[n] = Integer.parseInt(st.nextToken());
    }

    while(true) {
      if (addNumber >= S) {
        addNumber -= input[left];
        left++;
      } else if (right == N) {
        break;
      } else {
        addNumber += input[right];
        right++;
      }

      if (addNumber >= S) {
        answer = Math.min(answer, right - left);
      }
    }

    if (answer == Integer.MAX_VALUE) {
      System.out.println("0");
    } else {
      System.out.println(answer);
    }
  }

}